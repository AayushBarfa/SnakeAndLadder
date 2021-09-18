package com.example.Snake.Ladder.Handler;
import com.example.Snake.Ladder.Module.Ladder;
import com.example.Snake.Ladder.Module.Player;
import com.example.Snake.Ladder.Module.Snake;
import com.example.Snake.Ladder.Service.SnakeAndLadderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartGame {
    public static void main(String arg[]){
        int noOfPlayers=0,noOfSnakes=0,noOfLadders=0;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the number of players:- ");
        noOfPlayers=input.nextInt();
        List<Player> players=new ArrayList<Player>();
        System.out.println("Enter the names of Each player");

        for(int i=0;i<noOfPlayers;i++){
            players.add(new Player(input.next(),i,0));
        }
        System.out.println("Enter the number of Snakes:- ");
        noOfSnakes=input.nextInt();
        System.out.println("Enter the Starting and ending positions of snake ");
        List<Snake> snakes=new ArrayList<Snake>();
        for(int i=0;i<noOfSnakes;i++){
            snakes.add(new Snake(input.nextInt(),input.nextInt()));
        }

        System.out.println("Enter the number of Ladders");
        noOfLadders=input.nextInt();
        System.out.println("Enter the Starting and ending positions of Ladder ");
        List<Ladder> ladder=new ArrayList<Ladder>();
        for(int i=0;i<noOfLadders;i++){
            ladder.add(new Ladder(input.nextInt(),input.nextInt()));
        }
        SnakeAndLadderService game=new SnakeAndLadderService();

        game.setPlayers(players);
        game.setSnakes(snakes);
        game.setLadders(ladder);
        game.setPlay();
        game.set();
        game.setPlayersTurn();


        game.gameLogic();

    }
}
