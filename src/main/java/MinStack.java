/**
 * Created by jakubnarloch on 05.03.15.
 */
class MinStack {

    private int[] values = new int[1];
    private int[] mins = new int[1];

    private int size = 0;

    public void push(int x) {

        if(size == values.length) {
            resize(2 * size);
        }
        values[size] = x;
        if(size == 0 || mins[size - 1] >= x) {
            mins[size] = x;
        } else {
            mins[size] = mins[size - 1];
        }
        size++;
    }

    public void pop() {

        size--;
        if(size > 0 && size == values.length / 4) {
            resize(values.length / 2);
        }
    }

    public int top() {

        return values[size - 1];
    }

    public int getMin() {

        return mins[size - 1];
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

    public static void main(String[] args) {

        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);

        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
