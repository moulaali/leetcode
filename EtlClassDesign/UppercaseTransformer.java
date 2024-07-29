package EtlClassDesign;

public class UppercaseTransformer implements Transformer<String, String> {
    @Override
    public String transform(String input) {
        return input.toUpperCase();
    }
}

