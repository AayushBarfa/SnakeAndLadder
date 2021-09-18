package com.example.Snake.Ladder.Service;

import com.example.Snake.Ladder.Module.Ladder;
import com.example.Snake.Ladder.Module.Player;
import com.example.Snake.Ladder.Module.Snake;
import com.example.Snake.Ladder.Module.SnakeAndLadderBoardDB;

import java.util.*;

public class SnakeAndLadderService {
    Scanner input=new Scanner(System.in);

    SnakeAndLadderBoardDB database=new SnakeAndLadderBoardDB(10);

    public void setPlayers(List<Player> players){
        database.setPlayers(players);
    }
    public void setSnakes(List<Snake> snakes){
        database.setSnakes(snakes);
    }
    public void setLadders(List<Ladder> ladders){
        database.setLadders(ladders);
    }

    private Map<Integer,Integer> snakes=new HashMap<Integer,Integer>();
    private Queue<Player> playersTurn=new LinkedList<>();
    private Map<Integer,Integer> ladders=new HashMap<Integer,Integer>();


    public void set(){
        List<Snake> s = new ArrayList<Snake>();
        List<Ladder> l = new ArrayList<Ladder>();
        s=database.getSnakes();
        l=database.getLadders();
        for(int i=0;i<s.size() ;i++){
            this.snakes.put(s.get(i).getA(),s.get(i).getB());
        }
        for(int i=0;i<l.size() ;i++){
            this.ladders.put(l.get(i).getA(),l.get(i).getB());
        }
    }

    public void setPlayersTurn() {
        List<Player> play = new ArrayList<Player>();
        play=database.getPlayers();
        for(int i=0;i<play.size();i++){
            this.playersTurn.add(play.get(i));
        }

    }
    public int checkSnakeLadder(int p){
        if(snakes.containsKey(p)){
            System.out.println("Are Biti Chod");
            checkSnakeLadder(snakes.get(p));
        }
        if(ladders.containsKey(p)){
            System.out.println("Machod diye bhaiya ji aapto");
            checkSnakeLadder(ladders.get(p));
        }
        return p;
    }

    public void playerMove(Player p,int diceValue){
        int temp=p.getPosition();
        if(temp+diceValue<=100){
            int pos=checkSnakeLadder(temp);

            p.setPosition(pos);

        }
    }

    public boolean check(Player p) {
        if (p.getPosition() == 100) return false;
        return true;
    }

    DiceRoll diceRoll = new DiceRoll();
    void GameLogic() {
        while (check(playersTurn.peek())) {
            Player temp=playersTurn.remove();
            playersTurn.add(temp);
            Player chal=playersTurn.peek();
            System.out.println("Turn of "+chal.getName());
            String x=input.next();
            int diceValue=diceRoll.roll();
            playerMove(chal,diceValue);
        }
        System.out.println("Congratualation to "+playersTurn.peek().getName()+"Chalo ghar ghar khelo");
    }



}
