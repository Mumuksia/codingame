package leet;

public class LargestOddNumberSubString {
    public String largestOddNumber(String num) {
        if (num.isEmpty()){
            return "";
        }
        char[] digits = num.toCharArray();
        for (int i=digits.length-1;i>-1;i--){
            if (isOdd(digits[i])){
               return num.substring(0, i+1);
            }
        }
        return "";
    }

    private boolean isOdd(char i){
        return i =='1' || i =='3'|| i =='5'|| i =='7'|| i =='9';
    }
}
