package gois.study.tdjdconnect4;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Connect4TDD {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final String EMPTY = " ";
    private static final String RED = "R";
    private static final String GREEN = "G";
    private static final String DELIMITER = "|";

    private String currentPlayer = RED;
    private String[][] board = new String[ROWS][COLUMNS];
    private PrintStream outputChannel;


    public Connect4TDD() {
        for (String[] row : board) Arrays.fill(row, EMPTY);
    }

    public Connect4TDD(PrintStream out) {
        outputChannel = out;
        for (String[] row : board) Arrays.fill(row, EMPTY);
    }

    public String getCurrentPlayer() {
        outputChannel.printf("Player %s turn%n", currentPlayer);
        return currentPlayer;
    }

    private void printBoard() {
        for (int row = ROWS - 1; row >= 0; row--) {
            StringJoiner stringJoiner = new StringJoiner(DELIMITER, DELIMITER, DELIMITER);
            Stream.of(board[row]).forEachOrdered(stringJoiner::add);
            outputChannel.println(stringJoiner.toString());
        }
    }

    private void switchPlayer() {
        if (RED.equals(currentPlayer)) currentPlayer = GREEN;
        else currentPlayer = RED;
    }

    public int getNumberOfDiscs() {
        return IntStream
                .range(0, COLUMNS)
                .map(this::getNumberOfDiscsInColumn)
                .sum();
    }

    private int getNumberOfDiscsInColumn(int column) {
        return (int) IntStream
                .range(0, ROWS)
                .filter(row -> !EMPTY.equals(board[row][column]))
                .count();
    }

    public int putDiscInColumn(int column) {
        checkColumn(column);
        int row = getNumberOfDiscsInColumn(column);
        checkPositionToInsert(row, column);
        board[row][column] = currentPlayer;
        printBoard();
        switchPlayer();
        return row;
    }

    private void checkColumn(int column) {
        if (column < 0 || column >= COLUMNS)
            throw new RuntimeException("Invalid column " + column);
    }

    private void checkPositionToInsert(int row, int column) {
        if (row == ROWS)
            throw new RuntimeException("No more room in column " + column);
    }
}
