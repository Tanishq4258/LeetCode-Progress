class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int totalfuel=0, totalgas = 0;
        int currtank = 0;
        int totalcost = 0;
        for(int i=0;i<gas.length;i++){
            totalgas += gas[i];
            totalcost +=cost[i];

            currtank+=gas[i]-cost[i];

            if(currtank<0){
                start = i+1;
                currtank = 0;
            }
        }
        return (totalgas>=totalcost)?start:-1;
    }
}