package com.example.Snake.Ladder.Module;

import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class SnakeAndLadderBoardDB {

    public int[][] board;
    public SnakeAndLadderBoardDB(int size){
        this.board=new int[size][size];
            int counter = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    counter++;
                    this.board[i][j] = counter;
                }
            }

    }


    private List<Player> players=new ArrayList<Player>();


    private List<Snake> snakes=new ArrayList<Snake>();

    private List<Ladder> ladders=new ArrayList<Ladder>();



    //    public void setPlayers(List<Player> players){
//        this.players=players;
//    }
//
//    public void setLadders(List<Ladder> ladders) {
//        this.ladders=ladders;
//    }
//    public void setSnakes(List<Snake> snakes) {
//        this.snakes=snakes;
//    }

}
