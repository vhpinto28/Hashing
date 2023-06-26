import java.util.Objects;
class Register<E> implements Comparable<Register<E>> {
    protected int key;
    protected E value;

    public Register(int key, E value) {
        this.key = key;
        this.value = value;
    }

    public int compareTo(Register<E> r) {
        return this.key - r.key;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Register<?> register = (Register<?>) o;
        return key == register.key && Objects.equals(value, register.value);
    }

    public int hashCode() {
        return Objects.hash(key, value);
    }

    public int getKey() {
        return this.key;
    }

    public String toString() {
        return this.key + ":" + this.value.toString();
    }
}
