class Solution {
    public boolean validator(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        int nrow = row - row % 3;
        int ncol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[nrow + i][ncol + j] == num) {
                    return false;
                }
            }
        } 
        return true;
    }
    public boolean solve(char[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }
        if (col == 9) {
            return solve(board, row + 1, 0);
        }
        if (board[row][col] != '.') {
            return solve(board, row, col + 1);
        }
        for (char num = '1'; num <= '9'; num++) {
            if (validator(board, row, col, num)) {
                board[row][col] = num;
                if (solve(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
}