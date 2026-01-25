import java.util.Objects;

public class Sample {
    
    int id;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sample)) return false;
        Sample sample = (Sample) o;
        return id == sample.id && Objects.equals(name, sample.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
