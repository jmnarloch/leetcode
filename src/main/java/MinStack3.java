/**
 * Created by jakubnarloch on 13.03.15.
 */
public class MinStack3 {

    // the memory optimized version of min stack

    private int[] values = new int[1];
    private int[] mins = new int[1];

    private int size = 0;
    private int minSize = 0;

    public void push(int x) {

        if(size == values.length) {
            resize(2 * size);
        }
        values[size] = x;
        if(minSize == 0 || mins[minSize - 1] >= x) {
            mins[minSize] = x;
            minSize++;
        }
        size++;
    }

    public void pop() {

        if(size > 0 && values[size - 1] == mins[minSize - 1]) {
            minSize--;
        }
        size--;
        if(size > 0 && size == values.length / 4) {
            resize(values.length / 4);
        }
    }

    public int top() {

        return values[size - 1];
    }

    public int getMin() {

        return mins[minSize - 1];
    }

    private void resize(int capacity) {
        int[] tmpValue = new int[capacity];
        int[] tmpMins = new int[capacity];
        for(int ind = 0; ind < size; ind++) {
            tmpValue[ind] = values[ind];
            tmpMins[ind] = mins[ind];
        }

        values = tmpValue;
        mins = tmpMins;
    }
}
