public class RecursiveIntegerLinkedList implements IntegerList {

    private IntegerNode    head;
    private IntegerNode    tail;
    private int	count;


    // TODO: add implementations for methods specified in IntegerList interface
    

    // DO NOT CHANGE THIS METHOD - the tester depends on it
    public String toString() {
        return toString(head);
    }

    // DO NOT CHANGE THIS METHOD - the tester depends on it
    private String toString(IntegerNode n) {
        if (n==null) {
           return "";
       } else {
           if (n.next!=null) {
               return n.getElement() + " " + toString(n.next);
           } else {
               return n.getElement() + toString(n.next);
           }
       }
    }

    // DO NOT CHANGE THIS METHOD - the tester depends on it
    public String reverse() {
        return reverse(tail);
    }

    // DO NOT CHANGE THIS METHOD - the tester depends on it
    private String reverse(IntegerNode n) {
        if (n==null) {
           return "";
       } else {
           if (n.prev!=null) {
               return n.getElement() + " " + reverse(n.prev);
           } else {
               return n.getElement() + reverse(n.prev);
           }
       }
    }

    public void addFront (int val) {
        IntegerNode n = new IntegerNode(val);
        if (head == null) {
            tail = n;
        } else {
            this.head.prev = n;
        }
        n.next = head;
        head = n;
        count++;
    }

    public void addBack (int val) {
        IntegerNode n = new IntegerNode(val);
        if (head == null) {
            head = n;
        } else {
            this.tail.next = n;
            n.prev = tail;
        }
        tail = n;
        count++;
    }

    public int size () {
        return count;
    }

    public int getAtPosition (int position) {
        int i = 0;
        return getAtPositionHelper(head, position, i);
    }

    private int getAtPositionHelper(IntegerNode n, int position, int i){
        if (i == position){
            return n.getElement();
        }
        i++;
        return getAtPositionHelper(n.next, position, i);
    }

    public void removeAtPosition (int position) {
        int i = 0;
        removeAtPositionHelper(head, position, i);
        count--;
    }

    private void removeAtPositionHelper(IntegerNode n, int position, int i) {
        if (n == null){
            return;
        }
        if(i == position) {
            if (i == 0){
                removeFIrst();
            } else if (i == count - 1) {
                removeLast();
            } else {
                n.next.prev = n.prev;
                n.prev.next = n.next;
            }
        }
        i++;
        removeAtPositionHelper(n.next, position, i);
    }

    public int sumMultiplesOf (int n) {
        return sumOf(head, n);
    }

    private int sumOf(IntegerNode node, int n) {
        int firstSum = 0;
        if (node == null || n == 0) {
            return 0;
        } else {
            if (node.getElement() % n == 0) {
                firstSum += node.getElement();
            }
            int restSum = sumOf(node.next, n);
            return firstSum + restSum;
        }
    }


    public void multiplyBy (int n){
        multiplyByHelper(head, n);
    }

    private void multiplyByHelper(IntegerNode node, int n) {
        if (node == null) {
            return;
        } else {
            int newValue = node.getElement() * n;
            node.setElement(newValue);
            multiplyByHelper(node.next, n);

        }
    }

    public void removeValue(int val) {
        int i = 0;
        removeValueHelper (head, val, i);
    }

    private void removeValueHelper(IntegerNode n, int val, int i) {
        if (n == null) {
            return;
        }
        if(n.getElement()== val) {
            removeAtPosition(i);
            removeValueHelper(n.next, val, i);
        } else {
            i++;
            removeValueHelper(n.next, val, i);
        }
    }

    public int getMax() {
        return getMaxHelper(head);
    }

    private int getMaxHelper(IntegerNode n) {
        if (n == null) {
            return 0;
        }
        int i = getMaxHelper(n.next);
        return (i > n.getElement() ? i : n.getElement());
    } 

    private void removeFIrst() {
        if (head.next == null){
            tail = null;
        } else {
            head.next.prev = null;
        }
        head = head.next;
    }

    private void removeLast() {
        if (head.next == null) {    
            head = null;
        } else {
            tail.prev.next = null;
        }
        tail = tail.prev;
    }

    public void duplicateNegative () {
        if (head == null) {
            return;
        }
        IntegerNode cur = head;
        for (int i = 0; i < count; i++) {
            if (cur.getElement() < 0) {
                IntegerNode n = new IntegerNode(cur.getElement());
                n.next = cur.next;
                n.prev = cur;
                cur.next = n;
                cur= cur.next.next;
            } else {
            cur = cur.next;
            }
        }

    }

}
