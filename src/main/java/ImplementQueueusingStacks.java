import java.util.Deque;
import java.util.LinkedList;

/**
 * ImplementQueueusingStacks
 */
public class ImplementQueueusingStacks {

    private Deque<Integer> first = new LinkedList<>();
    private Deque<Integer> second = new LinkedList<>();

    public void push(int x) {
        first.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {

        copyTo();

        second.pop();
    }

    // Get the front element.
    public int peek() {

        copyTo();

        return second.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {

        return first.isEmpty() && second.isEmpty();
    }

    private void copyTo() {
        if(second.isEmpty()) {
            while(!first.isEmpty()) {
                second.push(first.pop());
            }
        }
    }
}
