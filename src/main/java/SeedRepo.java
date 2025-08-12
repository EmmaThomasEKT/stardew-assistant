import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeedRepo {
    private final Path seedListFile;

    public SeedRepo(String fileName) {
        this.seedListFile = Paths.get(fileName); // turns string into a path object
    }

    public List<String> loadSeedList() {
        try {
            if (!Files.exists(seedListFile)) return List.of(); // checks if file exists
            return Files.readAllLines(seedListFile); // reads and returns as a List<String>
        } catch (IOException e) {
            throw new RuntimeException("Error reading seed list", e);
        }
    } // each line corresponds to one saved seed entry

    public void clearSeedList() {
        try {
            Files.write(seedListFile, new byte[0]); // replace with an empty array (prevents having to delete+remake each time
        } catch (IOException e) {
            throw new RuntimeException("Error clearing seed list", e);
        }
    }

    public void addSeed(String seedName, int quantity) {
        try {
            Files.write(seedListFile, List.of(seedName + " " + quantity), // write input as seedName quantity with a space in the middle
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND); // create file if doesnt exist / append to end instead of overwriting
        } catch (IOException e) {
            throw new RuntimeException("Error adding seed", e);
        }
    }

    public Map<String, Integer> getSeedQuantities() {
        Map<String, Integer> result = new HashMap<>(); // storing in hashmap... key:seedName Value:quantity
        for (String line : loadSeedList()) { // load seed list from file
            String[] parts = line.split("\\s+"); // split line into "words" by whitespace
            if (parts.length >= 2) {
                String name = String.join(" ", Arrays.copyOf(parts, parts.length - 1));
                int qty = Integer.parseInt(parts[parts.length - 1]); // converting last element to int
                result.put(name, qty);
            }
        }
        return result;
    }

}
