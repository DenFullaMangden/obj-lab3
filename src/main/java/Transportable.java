public interface Transportable<T extends Vehicle> {

    boolean isBeingTransported();

    void transportedBy(T vehicle);

    void untransport();

    T getCurrentTransport();
}