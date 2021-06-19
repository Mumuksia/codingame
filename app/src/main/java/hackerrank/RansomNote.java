package hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RansomNote {
    public static void checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Integer> words = new HashMap<>();


        for (String word : magazine){
            if (!words.containsKey(word)){
                words.put(word, 0);
            }
            words.put(word, words.get(word) +1);
        }

        for (String nw: note){
            if (!words.containsKey(nw) || words.get(nw) <= 0){
                System.out.println("No");
                return;
            }
            words.put(nw, words.get(nw) -1);
        }

        System.out.println("Yes");
    }
}
