class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int total = 0;
        for(int[] box:boxTypes){
            int b = box[0];
            int units = box[1];
            int take = Math.min(truckSize, b);
            total+= take*units;
            truckSize-=take;
            if(truckSize==0) break;
        }
        return total;
    }
}