package com.company;

import javafx.util.Pair;

import java.util.Vector;

public class Board {
    private int numberOfTokens;
    private Vector<Pair<Integer, Integer>> tokens = new Vector<>();
    private Vector<Integer> availability = new Vector<>();

    public void setNumberOfTokens(int numberOfTokens) {
        this.numberOfTokens = numberOfTokens;
    }

    public synchronized Vector<Integer> getAvailability() {
        return availability;
    }

    public void setTokens(int numberOfTokens) {
        for (int i = 0; i < numberOfTokens * (numberOfTokens - 1); i++) {
            tokens.add(new Pair<Integer, Integer>(i, (int) (Math.random() * numberOfTokens * (numberOfTokens - 1))));
            availability.add(1);
        }
    }

    public synchronized Pair<Integer, Integer> getTokenFromSequence() {
        while (true) {
            Integer position = (int) (Math.random() * numberOfTokens * (numberOfTokens - 1));
            if (availability.get(position) == 1) {
                availability.set(position, 0);
                return tokens.get(position);
            }
        }
    }

    public int getNumberOfTokens() {
        return numberOfTokens;
    }

    public Vector<Pair<Integer, Integer>> getTokens() {
        return tokens;
    }
}
