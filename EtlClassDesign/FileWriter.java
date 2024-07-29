package EtlClassDesign;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class FileWriter implements Writer<String> {
    private final Path filePath;

    public FileWriter(String filePath) {
        this.filePath = Paths.get(filePath);
    }

    @Override
    public void write(String data) throws IOException {
        Files.write(filePath, data.getBytes());
    }
}

