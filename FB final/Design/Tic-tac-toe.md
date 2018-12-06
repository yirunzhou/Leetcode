

Mistakes:

	anti diagnal is col + row == n-1


```

class TicTacToe {
    
    private int[] row;
    
    private int[] col;
    
    private int di;
    
    private int antiDi;
    
    private int n;
    
    private int win;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        row = new int[n];
        col = new int[n];
        di = 0;
        antiDi = 0;
        
        this.n = n;
        win = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        
        if(win != 0){
            return win;
        }
        
        int sign = player == 1? 1 : -1;
        
        this.row[row] += sign;
        
        this.col[col] += sign;
        
        if(row + col == n-1){
            antiDi += sign;
        }
        
        if(row == col){
            di += sign;
        }
        
        
        if(this.row[row] == sign * n||
           this.col[col] == sign * n||
            di == sign * n ||
            antiDi == sign * n){
            
            win = player;
            
        }
        
        return win;
    }
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */