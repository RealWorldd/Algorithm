import java.util.*;
import java.io.*;

public class q1158 {
    static int N, K;
    static class Node {
        int value;
        boolean isRemoved;
        Node next;
        public Node(int value) {
            this.value = value;
            this.isRemoved = false;
            this.next = null;
        }
    }
    static class CircularLinkedList {
        private Node head = null;
        private Node tail = null;

        public void add(int value) {
            Node newNode = new Node(value);
            if(head == null) {
                    head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            tail.next = head;
        }
        public Node front() {
            if(head != null) return head;
            return null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        CircularLinkedList cll = new CircularLinkedList();
        for(int i = 1; i <= N; i++) {
            cll.add(i);
        }
        int total = 0;
        Node curNode = cll.front();
        for(int i = 0; i < K - 1; i++) {
            curNode = curNode.next;
        }
        int count = K;
        System.out.print("<");
        while(true) {
            if(total >= N) {
                System.out.println(">");
                return;
            }
            if(count != K) {
                if(!curNode.next.isRemoved) {
                    count++;
                }
                curNode = curNode.next;
                continue;
            }
            if(total + 1 == N) {
                System.out.print(curNode.value);
            } else {
                System.out.print(curNode.value + ", ");
            }
            curNode.isRemoved = true;
            count = 0;
            total++;
        }
    }
}