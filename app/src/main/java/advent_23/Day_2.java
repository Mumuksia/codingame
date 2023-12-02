package advent_23;

import java.util.HashMap;
import java.util.Map;

public class Day_2 {

    public int calculate(String input){
        String[] lines = input.split("\n");
        int result = 0;
        Map<String, Integer> bags = createBag();
        for (String line : lines) {
            String[] parts = line.split(":");
            result += parseGame(parts[1], bags, Integer.parseInt(parts[0].replaceAll("Game","").trim()));
        }
        return result;
    }

    private Map<String, Integer> createBag(){
        Map<String, Integer> result = new HashMap<>();
        result.put("red", 12);
        result.put("green", 13);
        result.put("blue", 14);
        return result;
    }

    private int parseGame(String line, Map<String, Integer> bag, int gameNumber){
        String[] tries = line.split(";");
        for (String try_ : tries) {
            String[] parts = try_.split(",");
            for (String part : parts) {
                part = part.trim();
                String[] subParts = part.split(" ");
                if (!bag.containsKey(subParts[1]) || bag.get(subParts[1]) < Integer.parseInt(subParts[0])) {
                    return 0;
                }
            }
        }
        return gameNumber;
    }

    public int calculate_2(String input){
        String[] lines = input.split("\n");
        int result = 0;
        for (String line : lines) {
            String[] parts = line.split(":");
            result += parseGame_2(parts[1]);
        }
        return result;
    }
    private int parseGame_2(String line){
        String[] tries = line.split(";");
        Map<String, Integer> gameCubes = new HashMap<>();
        for (String try_ : tries) {
            String[] parts = try_.split(",");
            for (String part : parts) {
                part = part.trim();
                String[] subParts = part.split(" ");
                if (!gameCubes.containsKey(subParts[1]) || gameCubes.get(subParts[1]) < Integer.parseInt(subParts[0])) {
                    gameCubes.put(subParts[1], Integer.parseInt(subParts[0]));
                }
            }
        }
        return gameCubes.values().stream().mapToInt(Integer::intValue).reduce(1, (a, b) -> a * b);
    }
}
