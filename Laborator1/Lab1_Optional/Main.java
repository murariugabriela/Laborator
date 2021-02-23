package com.company;

public class Main {
    public static void validareArgument(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Este nevoie de un argument la linia de comanda");

        } else {
            try {
                int numar = Integer.parseInt(args[0]);
            } catch (NumberFormatException notANumber) {
                System.err.println("Argumentul trebuie sa fie de tip int");
            }
        }
    }

    public static void printMatrix(int[][] matrix, int n) {
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void partialTree(int[][] matrix, int n) {
        boolean[] visited = new boolean[n];
        int[][] treeMatrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                treeMatrix[i][j] = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                for (int j = 0; j < n; j++)
                    if (matrix[i][j] == 1) {
                        visited[j] = true;
                        treeMatrix[i][j] = 1;
                        treeMatrix[j][i] = 1;
                    }
            }
        }
        System.out.println("Matricea corespunzatoare arborelui");
        if (n < 30_000)
            printMatrix(treeMatrix, n);
    }

    public static boolean isGraphConnected(int[][] matrix, int n) {
        boolean[] visited = new boolean[n];
        int numberUnvisitedVertices = 0;
        visited[0] = true;
        for (int i = 0; i < n; i++) {
            if (visited[i])
                for (int j = 0; j < n; j++)
                    if (matrix[i][j] == 1)
                        visited[j] = true;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                numberUnvisitedVertices++;
        }
        return numberUnvisitedVertices == 0;
    }

    public static void printConnectedComponents(int[][] matrix, int n) {
        boolean[] visited = new boolean[n];
        int numberUnvisitedVertices = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                numberUnvisitedVertices++;
        }
        while (numberUnvisitedVertices != 0) {
            numberUnvisitedVertices = 0;
            for (int i = 0; i < n; i++)
                if (!visited[i]) {
                    visited[i] = true;
                    System.out.print(i + ": ");
                    break;
                }
            for (int i = 0; i < n; i++) {
                if (visited[i])
                    for (int j = 0; j < n; j++)
                        if (matrix[i][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            System.out.print(j + " ");
                        }
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                if (!visited[i])
                    numberUnvisitedVertices++;
            }
        }
    }

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        validareArgument(args);
        int n = Integer.parseInt(args[0]);
        int[][] matrix = new int[n][n];
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (i != j) {
                    matrix[i][j] = (int) Math.round(Math.random());
                    matrix[j][i] = matrix[i][j];
                } else
                    matrix[i][j] = 0;
            }
        }
        if (n < 30_000)
            printMatrix(matrix, n);
        if (isGraphConnected(matrix, n)) {
            System.out.println("the graphs is connected");
            partialTree(matrix, n);
        } else
            printConnectedComponents(matrix, n);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

    }
}
