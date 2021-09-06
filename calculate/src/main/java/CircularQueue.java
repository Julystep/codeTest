package calculate.src.main.java;

/**
 * 循环队列会相应的消耗一个空间
 */
public class CircularQueue {

    private int[] queue;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        queue = new int[capacity + 1];
        n = capacity + 1;
    }

    public void enqueue(int item) {
        if ((tail + 1) % n == head) {
            System.out.println("队列已满");
            return;
        }
        queue[tail] = item;
        tail = (++tail) % n;
    }

    public int dequeue() {
        if (head == tail) {
            return -1;
        }
        int item =  queue[head];
        head = (++head) % n;
        return item;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);
        circularQueue.enqueue(5);
        circularQueue.enqueue(6);
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);
        circularQueue.enqueue(5);
        circularQueue.enqueue(6);

    }


}
