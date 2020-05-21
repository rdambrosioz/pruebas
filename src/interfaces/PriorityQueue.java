package interfaces;

public interface PriorityQueue<T> extends Queue<T> {

    void enqueueWithPriority(T element, int prioridad);
}
