import java.util.ArrayList;
import java.util.List;

public class WorkShop<T extends Vehicle> implements Storage<T> {
    private final int capacity;
    private final List<T> vehicles;

    public WorkShop(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    @Override
    public void load(T vehicle) {
        if (this.isFull()) {
            throw new IllegalStateException("AutoShop is full");
        }
        vehicles.add(vehicle);
    }

    @Override
    public T unload() {
        if (this.isEmpty()) {
            throw new IllegalStateException("No vehicles in shop");
        }
        return this.vehicles.remove(this.vehicles.size() - 1);
    }

    public boolean isEmpty() {
        return this.vehicles.isEmpty();
    }

    public boolean isFull() {
        return this.vehicles.size() >= this.capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getNumberOfVehicles() {
        return this.vehicles.size();
    }
}