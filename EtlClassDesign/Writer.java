package EtlClassDesign;

public interface Writer<T> {
    void write(T data) throws Exception;
}
