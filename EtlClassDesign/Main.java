package EtlClassDesign;

public class Main {
    public static void main(String[] args) {
        try {
            // Create file reader instance
            Reader<String> reader = new FileReader("/tmp/input.txt");

            // Create uppercase transformer instance
            Transformer<String, String> transformer = new UppercaseTransformer();

            // Create file writer instance
            Writer<String> writer = new FileWriter("output.txt");

            // Create processor instance
            EtlManager<String, String> etlManager = new EtlManager<>(reader, transformer, writer);

            // Execute the process
            etlManager.process();

            System.out.println("File transformation completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

