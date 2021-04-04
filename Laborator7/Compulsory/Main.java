package com.company;

import java.util.Arrays;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        Board board = new Board();
        game.setBoard(board);
        Player player1 = new Player();
        player1.setName("Paul");
        Player player2 = new Player();
        player2.setName("David");
        Player player3 = new Player();
        player3.setName("Jane");
        board.setNumberOfTokens(5);
        board.setTokens(board.getNumberOfTokens());
        game.setPlayers(new Vector<>(Arrays.asList(player1, player2, player3)));
        game.actualGame(game.getPlayers());
    }
}
