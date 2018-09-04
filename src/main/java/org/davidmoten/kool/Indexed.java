package org.davidmoten.kool;

public final class Indexed<T> {

    private final T t;
    private final int index;

    private Indexed(T t, int index) {
        this.t = t;
        this.index = index;
    }

    public static <T> Indexed<T> create(T t, int index) {
        return new Indexed<T>(t, index);
    }

    public T value() {
        return t;
    }

    public int index() {
        return index;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + index;
        result = prime * result + ((t == null) ? 0 : t.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Indexed<?> other = (Indexed<?>) obj;
        if (index != other.index)
            return false;
        if (t == null) {
            if (other.t != null)
                return false;
        } else if (!t.equals(other.t))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Indexed [value=" + t + ", index=" + index + "]";
    }

}
