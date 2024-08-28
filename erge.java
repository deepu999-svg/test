package Test;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class Merge {
    public Node merging(Node[] lists) {
        PriorityQueue<Node> min = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        
        // adding all heads to minheapp
        for (Node head : lists) {
            if (head != null) {
                min.offer(head);
            }
        }
        
        Node dummy = new Node(-1);
        Node current = dummy;
        
        // Pop the smallest element from the min-heap and append to the merged list
        while (!min.isEmpty()) {
            Node smallest = min.poll();
            current.next = smallest;
            current = current.next;
            
            if (smallest.next != null) {
                min.offer(smallest.next);
            }
        }
        
        return dummy.next;
    }

    // Example usage
    public static void main(String[] args) {
        // Create sample linked lists
        Node list1 = new Node(1);
        list1.next = new Node(4);
        list1.next.next = new Node(5);

        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(4);

        Node list3 = new Node(2);
        list3.next = new Node(6);

        Node[] lists = {list1, list2, list3};

        Merge merger = new Merge();
        Node mergedList = merger.merging(lists);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
