package com.example.Snake.Ladder.Module;
import com.example.Snake.Ladder.Module.Pair;
import com.example.Snake.Ladder.Module.HeadTail;

import java.util.HashMap;


public class Snake extends HeadTail {


    public Snake(int a, int b, int c, int d, Pair head, Pair tail) {
        super(a, b, c, d, head, tail);
    }
    HashMap<Pair,Pair> snake=new HashMap<Pair,Pair>();
}
