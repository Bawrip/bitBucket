package utils;

public interface ComparatorUtils<T extends Comparable<? super T>> {
    int compare(T arg1, T arg2);
}
