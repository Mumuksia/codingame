package leet;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j< strs[0].length(); j++){
            for (int i = 1; i< strs.length; i++){
                if(j==strs[i].length()){
                    return sb.toString();
                }
                if (strs[0].toCharArray()[j] != strs[i].toCharArray()[j]){
                    return sb.toString();
                }
            }
            sb.append(strs[0].toCharArray()[j]);
        }
        return sb.toString();
    }
}
