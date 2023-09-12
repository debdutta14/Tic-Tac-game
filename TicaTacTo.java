package com.mycompany.ticatacto;

import java.util.Scanner;

public class TicaTacTo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[3][3];
        int row;
        int col;
        int move = 0;
        //Initial Board
        PrintBoard(board);
        boolean over = false;
        while (!over) {
            //Player One:-
            System.out.println("Enter move 1st player: ");
            row = sc.nextInt();
            col = sc.nextInt();
            while (row > 3 || row < 0 || col > 3 || col < 0 || board[row][col] != 0) {
                System.out.println("Already filled, choose another cell or your inputs are invalid");
                row = sc.nextInt();
                col = sc.nextInt();
            }
            board[row][col] = 1;
            move++;
            over = isOver(board, row, col);
            PrintBoard(board);
            if (over) {
                System.out.println("1st player win!!!");
                return;
            }
            if (move == 9) {
                System.out.println("Game draw");
                return;
            }
            //Player 2: 
            System.out.println("Enter move 2nd player: ");
            row = sc.nextInt();
            col = sc.nextInt();
            while (row > 3 || row < 0 || col > 3 || col < 0 || board[row][col] != 0) {
                System.out.println("Already filled, choose another cell");
                row = sc.nextInt();
                col = sc.nextInt();
            }
            board[row][col] = 2;
            move++;
            over = isOver(board, row, col);
            PrintBoard(board);
            if (over) {
                System.out.println("2nd player win!!!");
            }
        }//end of while
    }

    public static void PrintBoard(int[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isOver(int[][] board, int row, int col) {
        //int val = board[row][col];
        //for row
        for (int i = 0; i < 3; i++) {
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                return true;
            }
            if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return true;
            }
        }
        if (row == col) {
            return board[0][0] == board[1][1] && board[1][1] == board[2][2];
        }
        int val = row - col;
        if (Math.abs(val) == 2) {
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                return true;
            }
        }

        return false;
    }

}
