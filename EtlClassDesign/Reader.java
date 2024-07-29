package EtlClassDesign;

public interface Reader<T> {
    T read() throws Exception;
}

