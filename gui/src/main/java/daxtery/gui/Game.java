package daxtery.gui;

import daxtery.logic.AI;
import daxtery.logic.Board;
import daxtery.logic.Mark;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Game extends Application {

    private Mark current;
    private Board board;
    private boolean vsAI = true;

    private List<TileUI> tiles;
    private Pane root;
    private boolean canPlay;

    public static void main(String[] args) {
        launch(args);
    }

    private Parent createContent() {

        root = new Pane();

        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        double tile_width = width / 3.01;
        double tile_height = height / 3.01;
        int fontSize = (int) Math.round(tile_height * 0.9);

        root.setPrefSize(width, height);

        for (int i = 0; i < Board.LINES; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                TileUI tile = new TileUI(tile_width, tile_height, j * tile_width, i * tile_height,
                        GameUI.TILE_STROKE_COLOR, fontSize, this);

                tiles.add(i * Board.LINES + j, tile);

                root.getChildren().addAll(tile);
            }
        }

        Menu playMenu = new Menu("Play");
        MenuItem vsAiMenuItem = new MenuItem("VS AI");
        vsAiMenuItem.setOnAction((event) -> {
            vsAI = true;
            reset();
        });
        MenuItem vsHumanMenuItem = new MenuItem("VS Human");
        vsHumanMenuItem.setOnAction((event) -> {
            vsAI = false;
            reset();
        });
        playMenu.getItems().addAll(vsAiMenuItem, vsHumanMenuItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(playMenu);
        root.getChildren().add(menuBar);

        return root;
    }

    private boolean canPlayIn(int index) {
        return board.get(index).isEmpty();
    }

    public void OnClickedTile(TileUI tile) {
        if (!canPlay)
            return;
        int index = tiles.indexOf(tile);
        if (canPlayIn(index)) {
            playIn(index);

            if (canPlay && vsAI) {
                var aiMove = AI.getBestMove(board, current);
                playIn(aiMove.index());
            }
        }
    }

    private void playIn(int index) {
        board.set(index, current);
        tiles.get(index).draw(GameUI.getText(current), GameUI.getTextColor(current));
        checkState();
        current = current.getOpposite();
    }

    private void reset() {
        for (TileUI t : tiles) {
            t.draw("", Color.TRANSPARENT);
        }

        canPlay = true;

        board.reset();
    }

    private void checkState() {
        var result = board.getWinningConfiguration(current);
        if (!result.isEmpty()) {
            playWinningAnimation(result);
            canPlay = false;
        } else if (board.allFull()) {
            OnGameEnd();
        }
    }

    private void playWinningAnimation(List<Integer> winningWay) {
        Line line = new Line();

        TileUI first = tiles.get(winningWay.get(0));
        TileUI last = tiles.get(winningWay.get(2));

        line.setStartX(first.getCenterX());
        line.setStartY(first.getCenterY());
        line.setEndX(first.getCenterX());
        line.setEndY(first.getCenterY());

        root.getChildren().addAll(line);

        Timeline timeline = new Timeline();
        timeline.getKeyFrames()
                .add(new KeyFrame(Duration.seconds(1.2), new KeyValue(line.endXProperty(), last.getCenterX()),
                        new KeyValue(line.endYProperty(), last.getCenterY())));

        timeline.play();
        timeline.setOnFinished((event) -> {
            root.getChildren().remove(line);
            Platform.runLater(this::OnGameEnd);
        });
    }

    public void OnGameEnd() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Play again?");
        alert.setHeaderText("Do you want to play again?");
        alert.setContentText("Choose what to play next(or not)");

        ButtonType buttonTypeOne = new ButtonType("VS AI");
        ButtonType buttonTypeTwo = new ButtonType("VS Human");
        ButtonType buttonTypeThree = new ButtonType("Quit", ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == buttonTypeOne) {
                vsAI = true;
                reset();
            } else if (result.get() == buttonTypeTwo) {
                vsAI = false;
                reset();
            } else {
                Platform.exit();
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        current = new Random().nextInt(100) > 50 ? Mark.O : Mark.X;
        board = new Board();
        canPlay = true;
        tiles = new ArrayList<>(Board.SIZE);
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

}