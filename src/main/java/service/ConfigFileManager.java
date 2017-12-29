package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConfigFileManager {

    private ConfigFileManager() {
    }

    public static List<String> loadConfigFile(String configFileName) {
        try (Stream<String> stream = Files.lines(Paths.get(configFileName))) {
            List<String> result = stream.collect(Collectors.toList());
//            Delete BOM from UTF-8 with BOM encoding (Windows file)
            if (!result.isEmpty()) {
                result.set(0, replaceUTF8BOM(result.get(0)));
            }
            return result;
        } catch (IOException e) {
            System.out.println("Can't read config file " + configFileName);
            return new ArrayList<>();
        }
    }

    private static String replaceUTF8BOM(String string) {
        return string.replace("\uFEFF", "");
    }

}
