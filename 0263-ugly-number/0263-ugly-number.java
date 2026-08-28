class Solution {
    public boolean isUgly(int n) {
        if(n<=0) return false;
        if(n==1) return true;
        int[] prime = {2,3,5};

        for(int num: prime){
            while(n%num == 0){
                n/=num;
            }
        }
        return n==1;
    }
}