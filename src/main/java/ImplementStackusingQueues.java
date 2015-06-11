import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class ImplementStackusingQueues {

    private Queue<Integer> full = new LinkedList<>();
    private Queue<Integer> empty = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {

        full.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {

        copyAllButOne();
        full.remove();
        swap();
    }

    // Get the top element.
    public int top() {

        copyAllButOne();
        final int result = full.remove();
        empty.offer(result);
        swap();
        return result;
    }

    // Return whether the stack is empty.
    public boolean empty() {

        return full.isEmpty();
    }

    private void copyAllButOne() {
        while(full.size() > 1) {
            empty.offer(full.remove());
        }
    }

    private void swap() {
        Queue<Integer> tmp = full;
        full = empty;
        empty = tmp;
    }
}
