package example.micronaut;

import io.micronaut.core.annotation.Introspected;
import java.util.Objects;

@Introspected
public class Pair<T, U> {

    private final T left;

    private final U right;

    public T getLeft() {
        return left;
    }

    public U getRight() {
        return right;
    }

    public Pair(T left, U right) {
        this.left = left;
        this.right = right;
    }

    public static <X, Y> Pair<X, Y> create(X left, Y right) {
        return new Pair(left, right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(left, pair.left) && Objects.equals(right, pair.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", left, right);
    }
}
