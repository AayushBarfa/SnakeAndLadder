package com.example.Snake.Ladder.Module;
import com.example.Snake.Ladder.Module.HeadTail;

import java.util.HashMap;


public class Ladder extends HeadTail{


    public Ladder(int a, int b, int c, int d, Pair head, Pair tail) {
        super(a, b, c, d, head, tail);
    }
    HashMap<Pair,Pair> ladder=new HashMap<Pair,Pair>();

}
