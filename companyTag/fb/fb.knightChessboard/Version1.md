



```
class Solution {

    private int[][] dirs = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};


    public double knightProbability(int N, int K, int r, int c) {
        
        double[][][] dp = new double[2][N][N];
        
        dp[0][r][c] = 1;
        
        for(int i = 1; i <= K; i ++){
            
            // clear all the value
            for(int x = 0; x < N; x ++){
                Arrays.fill(dp[i%2][x], 0);
            }
            
            
            for(int x = 0; x < N; x ++){
                
                
                for(int y = 0; y < N; y ++){
                    
                    double prevP = dp[(i-1)%2][x][y];
                    
                    for(int[] d : dirs){
                        
                        int a = x + d[0];
                        int b = y + d[1];
                        
                        if(isValid(a, b, N)){
                            
                            dp[(i)%2][a][b] += prevP * 0.125;
                            
                        }
                    }
                    
                }
            }
            
        }
        
        double result = 0;
        
        for(int x = 0; x < N; x ++){
            for(int y = 0; y < N; y ++){
                
                result += dp[(K)%2][x][y];
                
            }
        }
        
        
        return result;
        
    }

    private boolean isValid(int i, int j, int N){
        if(i < 0 || j < 0 || i >= N || j >= N){
            return false;
        }
        return true;
    }
}