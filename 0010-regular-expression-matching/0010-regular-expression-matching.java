class Solution {
    public boolean isMatch(String s, String p) {
        int a = s.length();
        int b = p.length();

        boolean[][] dp = new boolean[a+1][b+1];
        dp[0][0] = true;

        for(int i=2; i<=b;i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }
        for(int i=1; i<=a; i++){
            for(int j=1; j<=b; j++){
                char sch = s.charAt(i-1);
                char pch = p.charAt(j-1);

                if(pch == sch || pch =='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pch == '*'){
                    dp[i][j] = dp[i][j-2];

                    char prev = p.charAt(j-2);
                    if(prev == sch || prev == '.'){
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }
            }
        
        }

        return dp[a][b];
    }
}