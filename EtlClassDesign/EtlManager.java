package EtlClassDesign;

public class EtlManager<I, O> {
    private final Reader<I> reader;
    private final Transformer<I, O> transformer;
    private final Writer<O> writer;

    public EtlManager(Reader<I> reader, Transformer<I, O> transformer, Writer<O> writer) {
        this.reader = reader;
        this.transformer = transformer;
        this.writer = writer;
    }

    public void process() throws Exception {
        // Read the data
        I inputData = reader.read();

        // Transform the data
        O outputData = transformer.transform(inputData);

        // Write the transformed data
        writer.write(outputData);
    }
}

