package com.syscho.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {

        NQueen nQueen = new NQueen();
        List<List<String>> solveNQueens = nQueen.solveNQueens(4);
        System.out.println(solveNQueens);

    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> allBoard = new ArrayList<>();

        char[][] board = new char[n][n];
        int startCol = 0;

        populateBoard(allBoard, board, startCol);


        return allBoard;

    }

    private void populateBoard(List<List<String>> allBoard, char[][] board, int col) {
        int boardLength = board.length;
        //BASE Cond
        if (boardLength == col) {
            saveBoard(allBoard, board);
            return;
        }

        for (int row = 0; row < boardLength; row++) {

            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                populateBoard(allBoard, board, col + 1);
                board[row][col] = '.';
            }

        }
    }

    private boolean isSafe(int row, int col, char[][] board) {
        //horizontal
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        //vertical
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //Upper left
        int r = row;
        for (int c = col; c >= 0 && r >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        //Upper right
        r = row;
        for (int c = col; c < board.length && r >= 0; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        //Lower left
        r = row;
        for (int c = col; c >= 0 && r < board.length; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        //Lower right
        r = row;
        for (int c = col; c < board.length && r < board.length; r++, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private void saveBoard(List<List<String>> allBoard, char[][] board) {

        String row = "";
        List<String> newBoard = new ArrayList<>();

        int length = board.length;
        int colLength = board[0].length;
        for (int i = 0; i < length; i++) {
            row = "";
            for (int j = 0; j < colLength; j++) {
                if (board[i][j] == 'Q')
                    row += 'Q';
                else
                    row += '.';
            }
            newBoard.add(row);
        }

        allBoard.add(newBoard);
    }

}