package com.company;

import java.util.Vector;

public class Game {
    private Board board;
    private Vector<Player> players = new Vector<>();
    private int playersInTheGame = 0;
    private int turn = 1;

    public int getTurn() {
        return turn;
    }

    public void setPlayersInTheGame(int playersInTheGame) {
        this.playersInTheGame = playersInTheGame;
    }

    public int getPlayersInTheGame() {
        return playersInTheGame;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(Vector<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void actualGame(Vector<Player> players) {
        setPlayersInTheGame(players.size());
        Thread timeKeeper = new Thread();
        for (Player player : players) {
            Thread t = new Thread(() -> {
//                System.out.println("joaca");
                synchronized (player) {
                    try {
                        while (true) {
                            while (player.getPlayerNumber() != turn) {
                                player.wait();
                            }
                            int availableTokens = 0;
                            for (Integer integer : board.getAvailability()) {
                                availableTokens = availableTokens + integer;
                            }
                            if (availableTokens > 0) {
                                player.addTokenToASequence(board.getTokenFromSequence(), player.getTokenSequence());
                                player.setPlayerScore(player.getTokenSequence().size());
                            } else {
                                System.out.println("Game over " + player.getName());
                                setPlayersInTheGame(getPlayersInTheGame() - 1);
                                if (getPlayersInTheGame() == 0)
                                    printPlayers();
                                break;
                            }
                            turn = turn % playersInTheGame;
                            player.notifyAll();
//                            Thread.sleep(10);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
            t.start();
        }
    }

    @Override
    public String toString() {
        return "players=" + players.toString();
    }

    public void printPlayers() {
        System.out.println("Jucatorii sunt:");
        System.out.println(this.toString());
        System.out.println("and the winner is...");
        Player winner = new Player();
        int maximumNOTokens = 0;
        for (Player player : players) {
            if (player.getPlayerScore() > maximumNOTokens) {
                maximumNOTokens = player.getPlayerScore();
                winner = player;
            }
        }
        System.out.println(winner);
    }

    public Vector<Player> getPlayers() {
        return players;
    }
}
