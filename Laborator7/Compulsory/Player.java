package com.company;

import javafx.util.Pair;

import java.util.Vector;

public class Player {
    private String name;
    private Vector<Pair<Integer, Integer>> tokenSequence = new Vector<>();
    private int playerNumber;

    public void setName(String name) {
        this.name = name;
    }

    public void setTokenSequence(Vector<Pair<Integer, Integer>> tokenSequence) {
        this.tokenSequence = tokenSequence;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", tokensSequences=" + tokenSequence +
                '}';
    }

    public void addTokenToASequence(Pair<Integer, Integer> newToken, Vector<Pair<Integer, Integer>> sequence) {
        sequence.add(newToken);
    }

    public String getName() {
        return name;
    }

    public Vector<Pair<Integer, Integer>> getTokenSequence() {
        return tokenSequence;
    }
}
