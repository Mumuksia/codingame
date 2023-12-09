package advent_23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day_9 {

    public long sensor(List<String> input) {
        return input.stream().map(s -> Arrays.stream(s.split(" ")).map(sa->sa.replaceAll("\r",""))
                        .map(Integer::valueOf).collect(Collectors.toList()))
                .mapToLong(this::sensorNewSequence)
                .sum();
    }

    private long sensorNewSequence(List<Integer> seq){
        if(seq.stream().allMatch(n -> n == 0)){
            return 0;
        } else {
            List<Integer> newSeq = IntStream.range(0, seq.size() - 1)
                    .mapToObj(i -> seq.get(i + 1) - seq.get(i))
                    .collect(Collectors.toList());
            return seq.get(0) - sensorNewSequence(newSeq);
        }
    }
}
