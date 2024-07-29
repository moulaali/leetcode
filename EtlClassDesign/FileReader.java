package EtlClassDesign;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class FileReader implements Reader<String> {
    private final Path filePath;

    public FileReader(String filePath) {
        this.filePath = Paths.get(filePath);
    }

    @Override
    public String read() throws IOException {
        return new String(Files.readAllBytes(filePath));
    }
}
