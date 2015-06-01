import java.util.HashMap;
import java.util.Map;

/**
 * Created by jakubnarloch on 09.04.15.
 */
public class CopyListwithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {

        // input: the head of list
        // output: the head of copy list
        // edge cases: the list is null, list contains one element
        // assumptions: all random pointers will be initialized, use extra memory, modify the input list
        // approaches:

        if (head == null) {
            return null;
        }

        final Map<RandomListNode, RandomListNode> nodeMap = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode dummy = new RandomListNode(0);

        RandomListNode original = head;
        RandomListNode copy = dummy;

        while(original != null) {
            RandomListNode tmp = new RandomListNode(original.label);
            copy.next = tmp;
            nodeMap.put(original, tmp);

            original = original.next;
            copy = copy.next;
        }

        original = head;
        copy = dummy;

        while(original != null) {

            copy.next.random = nodeMap.get(original.random);

            original = original.next;
            copy = copy.next;
        }
        return dummy.next;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    ;
}
