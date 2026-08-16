class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int m = targetSeconds/60;
        int s = targetSeconds%60;
        int mincost = Integer.MAX_VALUE;
        if(m<=99){
            mincost = Math.min(mincost, getCost(m,s,startAt, moveCost, pushCost));
        }

        if(m>0 && s+60 <= 99){
            mincost = Math.min(mincost, getCost(m-1,s+60, startAt, moveCost, pushCost));
        }
        return mincost;

    }
    private int getCost(int m, int s, int startAt, int moveCost, int pushCost){
        String digits = String.format("%02d%02d", m, s);
        int i = 0;
        while (i < digits.length() && digits.charAt(i) == '0'){
            i++;
        }
        digits = digits.substring(i);
        int cost = 0;
        int curr = startAt;
        for (char ch : digits.toCharArray()){
            int digit = ch - '0';
            if (digit != curr){
                cost += moveCost;
                curr = digit;
            }
            cost += pushCost;
        }

        return cost;
    }
}