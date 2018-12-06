RangeSumQuery.md


Mistakes:

	
	sum[i][j]:
		sum from [0, 0] to [i, j]

	calculation of initialization, 


```
class NumMatrix {
    
    private int[][] sum;
    
    public NumMatrix(int[][] matrix) {
        
        if(matrix.length == 0 || matrix[0].length == 0){
            sum = new int[0][0];
            return;
        }
        
        sum = new int[matrix.length][matrix[0].length];
        
        int firstRow = 0;
        
        for(int j = 0; j < matrix[0].length; j++){
            firstRow += matrix[0][j];
            sum[0][j] = firstRow;
        }
        
        int firstCol = 0;
        
        for(int i = 0; i < matrix.length; i ++){
            firstCol += matrix[i][0];
            sum[i][0] = firstCol;
        }
        
        for(int i = 1; i < matrix.length; i ++){
            for(int j = 1; j < matrix[0].length; j ++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i][j];
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        /**
            row1 ≤ row2 and col1 ≤ col2
            
            r1  c1
            a,  b
            
            r2  c2
            c,  d
            = 
                
    0,0                
                d == 0
                
            c-1,d-1         c-1,b
                    c,d     c,b
                            
            a,d-1   a,d     a,b
                  

            sum[a][b] - sum[a][d-1] - sum[c-1][b] + 

            if(c == d == 0){
                
                sum[a][b]

            } else if c == 0:

                sum[a][b] - sum[a][d-1]

            else if d == 0: 
                sum[a][b] - s



            0   1   1   1
            1   1   1   1
            0   0   1   0
            1   1   1   1
            0   0   0   1
    
            0   1   2   3

       0    0   1   2   3   
       1    1   3   5   7      
       2    1   3   6   8
       3    2   5   9   
       4    2
                
                

                
                sum[a][b] - sum[a][d-1] - sum[c-1][b] + sum[c-1][d-1]
   
            col1 == col2

        */
        
        int a = row2;
        int b = col2;
        
        int c = row1;
        int d = col1;
        
        int result = 0;
        
        if(c == 0 && d == 0){
            
            result = sum[a][b];
            
        } else if(c == 0){
            
            result = sum[a][b] - sum[a][d-1];
            
        } else if(d  == 0){
            
            result = sum[a][b] - sum[c-1][b];
            
        } else {
            
            result = sum[a][b] - sum[a][d-1] - sum[c-1][b] + sum[c-1][d-1];
            
        }
        
        return result;
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */