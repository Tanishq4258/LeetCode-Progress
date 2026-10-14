class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (solve(board, word, i, j, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean solve(char[][] board, String word,int i, int j,boolean[][] visited, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        boolean found = solve(board, word, i + 1, j, visited, index + 1) ||
                        solve(board, word, i - 1, j, visited, index + 1) ||
                        solve(board, word, i, j + 1, visited, index + 1) ||
                        solve(board, word, i, j - 1, visited, index + 1);
        visited[i][j] = false;
        return found;
    }
}