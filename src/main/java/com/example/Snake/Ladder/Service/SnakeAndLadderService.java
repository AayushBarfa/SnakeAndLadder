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
    private Queue<Player> playersTurn=new LinkedList<Player>();
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
    private List<Player> play = new ArrayList<Player>();
    public void setPlay(){

        this.play=database.getPlayers();
    }
    public void setPlayersTurn() {

        for(int i=0;i<this.play.size();i++){
            this.playersTurn.add(this.play.get(i));
        }

    }
    public int checkSnakeLadder(int p){
        if(snakes.containsKey(p)){
            System.out.println("Are Biti Chod");
            return checkSnakeLadder(snakes.get(p));
        }
        if(ladders.containsKey(p)){
            System.out.println("Machod diye bhaiya ji aapto");
            return checkSnakeLadder(ladders.get(p));
        }
        return p;
    }

    public void playerMove(Player p,int diceValue){
        int temp=p.getPosition();
        if(temp+diceValue<=100){
            int pos=checkSnakeLadder(temp+diceValue);
            p.setPosition(pos);
        }
    }
    public void printMove(){
        for(int i=0;i<this.play.size();i++){
            System.out.println(play.get(i).getName()+" is at position:- "+ play.get(i).getPosition());
        }
        System.out.println("");
    }
    public boolean check(Player p) {
        if (p.getPosition() == 100) return false;
        return true;
    }

    DiceRoll diceRoll = new DiceRoll();
    public void gameLogic() {
        while (check(playersTurn.peek())) {
            Player temp=playersTurn.remove();
            playersTurn.add(temp);
            Player chal=playersTurn.peek();
            System.out.println("Turn of "+chal.getName()+" Press enter to roll the Dice");
            String x=input.nextLine();
            int diceValue=diceRoll.roll();
            //System.out.println(diceValue+" "+ chal.getPosition());
            playerMove(chal,diceValue);
            printMove();
        }
        System.out.println("Congratualation to "+playersTurn.peek().getName()+" Chalo ghar ghar khelo");
    }



}
