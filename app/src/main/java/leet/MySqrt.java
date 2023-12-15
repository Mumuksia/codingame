package leet;

public class MySqrt {

    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int min = 1;
        for (int i =1; i<x;i++){
            if (i*(long)i <= x){
                min = i;
            } else {
                return min;
            }
        }
        return min;
    }
}
