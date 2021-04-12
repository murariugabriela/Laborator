package com.company;

import javafx.util.Pair;

import java.util.Vector;

public class Player{
    private String name;
    private Vector<Pair<Integer, Integer>> tokenSequence = new Vector<>();
    private int playerNumber;
    private int playerScore;

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

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
                ", tokenSequence=" + tokenSequence +
                ", playerScore=" + playerScore +
                '}';
    }

    public void addTokenToASequence(Pair<Integer, Integer> newToken, Vector<Pair<Integer, Integer>> sequence) {
        sequence.add(newToken);
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public String getName() {
        return name;
    }

    public Vector<Pair<Integer, Integer>> getTokenSequence() {
        return tokenSequence;
    }

//    @Override
//    public void run() {
//    }
}
