package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.Board;
import models.Player;
import ui.GameUI;
import ui.TileUI;

public class Game extends Application {

    private Player current;
    private Board board;
    private List<TileUI> tiles;
    private Pane root;
    private boolean canPlay;

    private Parent createContent() {

        root = new Pane();
        root.setPrefSize(GameUI.PREFERED_WIDTH, GameUI.PREFERED_HEIGHT);

        for (int i = 0; i < Board.LINES; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                TileUI tile = new TileUI(GameUI.TILE_WIDTH, GameUI.TILE_HEIGHT, j * GameUI.TILE_WIDTH,
                        i * GameUI.TILE_HEIGHT, GameUI.TILE_STROKE_COLOR, GameUI.TILE_FONT_SIZE, this);

                tiles.add(i * Board.LINES + j, tile);

                root.getChildren().addAll(tile);
            }
        }

        return root;
    }

    private Player getCurrentPlayer() {
        return current;
    }

    private boolean canPlayIn(int index) {
        return !board.get(index).isCaptured();
    }

    public void OnClickedTile(TileUI tile) {
        if (!canPlay)
            return;
        int index = tiles.indexOf(tile);
        if (canPlayIn(index)) {
            board.set(index, current);
            tile.draw(GameUI.getText(current), GameUI.getTextColor(current));

            if (!checkState()) {
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
        if (board.won(current)) {
            List<Integer> winningway = board.getWinConfiguration(current);
            playWinAnnimation(winningway);
        } else if (board.allFull()) {
            reset();
        }
    }

    private void playWinAnnimation(List<Integer> winningWay) {
        Line line = new Line();

        int[] indexesOfWin = Helper.indexesOfWin(winningWay);

        TileUI first = tiles.get(indexesOfWin[0]);
        TileUI last = tiles.get(indexesOfWin[2]);

        line.setStartX(first.getCenterX());
        line.setStartY(first.getCenterY());
        line.setEndX(first.getCenterX());
        line.setEndY(first.getCenterY());

        root.getChildren().addAll(line);

        canPlay = false;

        Timeline timeline = new Timeline();
        timeline.getKeyFrames()
                .add(new KeyFrame(Duration.seconds(1.2), new KeyValue(line.endXProperty(), last.getCenterX()),
                        new KeyValue(line.endYProperty(), last.getCenterY())));

        timeline.play();
        timeline.setOnFinished((event) -> {
            reset();
            root.getChildren().remove(line);
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        current = new Random().nextInt(100) > 50 ? Player.O : Player.X;
        board = new Board();
        canPlay = true;
        tiles = new ArrayList<TileUI>(Board.SIZE);
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}