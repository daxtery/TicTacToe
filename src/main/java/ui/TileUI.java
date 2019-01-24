package ui;

import game.Game;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public final class TileUI extends StackPane {

    private Text text;
    private Rectangle border;

    public TileUI(double width, double height, double translateX, double translateY, Color strokeColor, int fontSize,
            Game game) {

        border = new Rectangle(width, height);
        border.setFill(null);
        border.setStroke(strokeColor);

        text = new Text();
        text.setFont(Font.font(fontSize));

        getChildren().addAll(border, text);

        setTranslateX(translateX);
        setTranslateY(translateY);

        setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                game.OnClickedTile(this);
            }
        });
    }

    public void draw(String newText, Color color) {
        text.setFill(color);
        text.setText(newText);
    }

    public double getCenterX() {
        return getTranslateX() + border.getWidth() / 2;
    }

    public double getCenterY() {
        return getTranslateY() + border.getHeight() / 2;
    }

}