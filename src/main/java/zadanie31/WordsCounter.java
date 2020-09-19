package zadanie31;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordsCounter {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./src/main/resources/file1.txt");
        List<String> stringList = Files.readAllLines(path);

        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (String word : stringList) {
            if (!stringIntegerMap.containsKey(word)) {
                stringIntegerMap.put(word, 1);
            } else {
                stringIntegerMap.put(word, stringIntegerMap.get(word) + 1);
            }
        }
        Path path1 = Paths.get("./src/main/resources/file1000.txt");
        List<String> newList = stringIntegerMap.entrySet().stream()
                .map(stringIntegerEntry -> stringIntegerEntry.getKey()+ " "+stringIntegerEntry.getValue())
                .collect(Collectors.toList());
        Files.write(path1,newList);
    }
}
