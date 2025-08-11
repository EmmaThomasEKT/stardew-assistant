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
        this.seedListFile = Paths.get(fileName);
    }

    public List<String> loadSeedList() {
        try {
            if (!Files.exists(seedListFile)) return List.of();
            return Files.readAllLines(seedListFile);
        } catch (IOException e) {
            throw new RuntimeException("Error reading seed list", e);
        }
    }

    public void clearSeedList() {
        try {
            Files.write(seedListFile, new byte[0]);
        } catch (IOException e) {
            throw new RuntimeException("Error clearing seed list", e);
        }
    }

    public void addSeed(String seedName, int quantity) {
        try {
            Files.write(seedListFile, List.of(seedName + " " + quantity),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Error adding seed", e);
        }
    }

    public Map<String, Integer> getSeedQuantities() {
        Map<String, Integer> result = new HashMap<>();
        for (String line : loadSeedList()) {
            String[] parts = line.split("\\s+");
            if (parts.length >= 2) {
                String name = String.join(" ", Arrays.copyOf(parts, parts.length - 1));
                int qty = Integer.parseInt(parts[parts.length - 1]);
                result.put(name, qty);
            }
        }
        return result;
    }

}
