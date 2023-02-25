public class IntegerLinkedList implements IntegerList {


    private IntegerNode head;
    private IntegerNode tail;
    private int count;


    // TODO: add implementations for methods specified in IntegerList interface


    // DO NOT CHANGE THIS METHOD - the tester depends on it
    public String toString() {
        String s = "";
        IntegerNode tmp = head;

        while (tmp != null) {
            s += tmp.e;
            if(tmp.next != null)
                s += " ";
            tmp = tmp.next;
        }

        return s;
    }


    // DO NOT CHANGE THIS METHOD - the tester depends on it
    public String reverse() {
        String s = "";
        IntegerNode tmp = tail;

        while (tmp != null) {
            s += tmp.e;
            if(tmp.prev!=null)
                s += " ";
            tmp = tmp.prev;
        }

        return s;
    }

    public void addFront (int val) {

        IntegerNode value = new IntegerNode (val, head, null);
        
        if (this.head == null) {
            tail = value;
        } else {
            this.head.prev = value;
        }
        value.next = head;
        this.head = value;
        count++;
    }

    public void addBack (int val) {
        IntegerNode cur = this.head;
        IntegerNode value = new IntegerNode(val);

        if (cur == null) {
            this.head = value;
        } else {
            tail.next = value;
            value.prev = tail;
        }
        this.tail = value;
        count++;
    }

    public int size () {
        return count;
    }

    public int getAtPosition (int position) {
        IntegerNode cur = this.head;
        int steps = 0;
        while (cur.next != null && steps < position){
            cur = cur.next;
            steps++;
        }
        int result = cur.getElement();
        return result;
    }

    public void removeAtPosition (int position) {
        IntegerNode cur = this.head;
        if (head == null || position < 0) {
            return;
        } else if (position == 0){
            if (head.next == null){
                tail = null;
            } else {
                head.next.prev = null;
            }
            head = head.next;
        } else if (position == count - 1) {
            if (head.next == null) {    
                head = null;
            } else {
                tail.prev.next = null;
            }
            tail = tail.prev;
        } else {
            for(int i = 0; i < position && cur.next != null; i++){
                cur = cur.next;
            }
            cur.next.prev = cur.prev;
            cur.prev.next = cur.next;
        }
        count--; 
    }

    public int sumMultiplesOf (int n) {
        return sumOf(head, n);
    }
    private int sumOf(IntegerNode inserted, int n) {
        if (inserted == null || n == 0) {
            return 0;
        } else {
            int firstSum = 0;
            if (inserted.getElement() % n == 0){
                firstSum += inserted.getElement();
            }
            int restSum = sumOf(inserted.next, n);
            return firstSum + restSum;
        }
    }

    public void multiplyBy (int n) {
        multiplyByHelp(head, n);
    }
    private void multiplyByHelp (IntegerNode inserted, int n) {
        if (inserted == null) {
            return;
        } else {
            int product = inserted.getElement() * n;
            inserted.setElement(product);
            multiplyByHelp(inserted.next, n);
        }
    }

    public void removeValue(int val) {
        int index = 0;
        IntegerNode cur = this.head;
        if (cur == null) {
            return;
        } else {
            while (cur != null) {
                if(cur.getElement() == val){
                    removeAtPosition(index);
                    cur = cur.next;
                    continue;
                }
                index++;
                cur = cur.next;
            }
        }
    }

    public int getMax() {
        int largest = 0;
        IntegerNode cur = this.head;
        if (count == 1)  {
            return head.getElement();
        } else {
            while (cur != null) {
                if (cur.getElement() > largest){
                    largest = cur.getElement();
                }
                cur = cur.next;
            }
        }
        return largest;
    }

}
