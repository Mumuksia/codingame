package advent_23;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day_5 {

    public long findLowest(String path, String seeds) throws IOException, URISyntaxException {
        Long[] seedArray = Arrays.stream(seeds.split(" ")).mapToLong(Long::parseLong).boxed().toArray(Long[]::new);
        Long[] parsedSeeds = readConversionMaps(Paths.get(getClass().getResource(path).toURI()), seedArray);

        return Arrays.stream(parsedSeeds).min(Long::compareTo).get();}

    public static Long[] readConversionMaps(Path filePath, Long[] seeds) throws IOException {
        List<Map<Integer, Integer>> conversionMaps = new ArrayList<>();

        List<String> lines = Files.readAllLines(filePath);
        int index = 0;

        while (index < lines.size()) {
            String line = lines.get(index);
            if (line.endsWith("map:")) {
                Map<Long, Long> conversionMap = readSingleConversionMap(lines, index + 1);
                for (int i = 0; i < seeds.length; i++) {
                    System.out.println("round done");
                    if (conversionMap.containsKey(seeds[i])) {
                        seeds[i] = conversionMap.get(seeds[i]);
                    }
                }
            }

            index++;
        }

        return seeds;
    }

    private static Map<Long, Long> readSingleConversionMap(List<String> lines, int startIndex) {
        Map<Long, Long> conversionMap = new HashMap<>();

        int index = startIndex;
        while (index < lines.size() && !lines.get(index).isEmpty()) {
            String[] values = lines.get(index).split(" ");
            long destStart = Long.parseLong(values[0]);
            long sourceStart = Long.parseLong(values[1]);
            long length = Long.parseLong(values[2]);

            for (int i = 0; i < length; i++) {
                conversionMap.put(sourceStart + i, destStart + i);
            }

            index++;
        }

        return conversionMap;
    }
}
