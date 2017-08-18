package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

final class AI {

    private TicTacToe game;

    AI(TicTacToe _game){
        game = _game;
    }

    void play(){
        int [] choices = getPossibleMoves();
        int index = chooseARandomIndex(choices);
        claim(index);
    }

    int[] getPossibleMoves(){
        List<Integer> freeTiles = new ArrayList<>();
        Tile[] tiles = game.getTiles();
        int i = 0;
        for ( Tile t : tiles){
            if(!t.isCaptured()){
                freeTiles.add(i);
            }
            i++;
        }
        return freeTiles.stream().mapToInt(ii -> ii).toArray();
    }

    int chooseARandomIndex(int[] choices){
        int index = new Random().nextInt(choices.length);
        return choices[index];
    }

    void claim(int index){
        game.claim(index);
    }
}
