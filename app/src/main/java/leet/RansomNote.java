package leet;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        for (Character c: ransomNote.toCharArray()){
            if (magazine.contains(String.valueOf(c))){
                magazine = magazine.replaceFirst(String.valueOf(c), "");
            } else {
                return false;
            }
        }
        return true;
    }
}
