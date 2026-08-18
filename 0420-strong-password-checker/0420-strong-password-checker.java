class Solution {
    public int strongPasswordChecker(String password) {
        boolean ucase = false, lcase = false, digit = false;
        StringBuilder sb = new StringBuilder(password);
        int n = password.length();
        for(int i=0;i<n;i++){
            char c = sb.charAt(i);
            if(Character.isUpperCase(c)) ucase = true;
            if(Character.isLowerCase(c)) lcase = true;
            if(Character.isDigit(c)) digit = true;
        }

        int steps = 0;
        if(!ucase) steps++;
        if(!lcase) steps++;
        if(!digit) steps++;

        if(n<6){
            return Math.max(6-n, steps);
        }

        int replace = 0;
        int[] subs = new int[3];

        for(int i=0;i<n; ){
            int j=i;
            while(j<n && sb.charAt(j)== sb.charAt(i)){
                j++;
            }
            int length = j-i;
            if(length>=3){
                replace += length/3;
                subs[length%3]++;
            }
            i=j;
        }

        if(n<=20){
            return Math.max(replace, steps);
        }

        int del = n-20;
        int d = del;

        if(d>0 && subs[0]>0){
            int use = Math.min(d, subs[0]);
            replace -= use;
            d-=use;
        }
        if(d>0 && subs[1]>0){
            int use = Math.min(d, subs[1]*2);
            replace-=use/2;
            d-=use;
        }
        if(d>0 && replace>0){
            int use = Math.min(d, replace*3);
            replace -= use/3;
        }
        return del + Math.max(replace, steps);
        

    }
}