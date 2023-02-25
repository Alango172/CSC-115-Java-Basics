import java.util.*;

 /*
 * An implementation of a binary search tree.
 *
 * This tree stores both keys and values associated with those keys.
 *
 * More information about binary search trees can be found here:
 *
 * http: *en.wikipedia.org/wiki/Binary_search_tree
 *
 * Note: Wikipedia is using a different definition of
 *       depth and height than we are using.  Be sure
 *       to read the comments in this file for the
 *          height function.
 */
public class BinarySearchTree <K extends Comparable<K>, V>  {

    public static final int BST_PREORDER  = 1;
    public static final int BST_POSTORDER = 2;
    public static final int BST_INORDER   = 3;

    // These are package friendly for the TreeView class
    BSTNode<K,V>  root;
    int           count;


    public BinarySearchTree () {
        root = null;
        count = 0;
    }


    /*
     * Purpose:
     *
     * Insert a new Key:Value Entry into the tree.  If the Key
     * already exists in the tree, update the value stored at
     * that node with the new value.
     *
     * Pre-Conditions:
     *     the tree is a valid binary search tree
    */
    public void insert (K k, V v) {
        root = insert(root, k, v);
    }

    private BSTNode<K,V> insert (BSTNode<K, V> node, K k, V v) {
        if (node == null) {
            count++;
            return new BSTNode<K,V>(k, v);
        } 
        if (k.compareTo(node.key) == 0) {
            node.setValue(v);
        } else if (k.compareTo(node.key) < 0){
            node.left = insert(node.left, k, v);
        } else { 
            node.right = insert(node.right, k, v);
        }
        return node;
    }
    /*
     * Purpose:
     *
     * Return the value stored at key.  Throw a KeyNotFoundException
     * if the key isn't in the tree.
     *
     * Pre-conditions:
     *    the tree is a valid binary search tree and k is not null
     *
     * Returns:
     *    the value stored at key
     *
     * Throws:
     *    KeyNotFoundException if key isn't in the tree
     */
    public V find (K key) throws KeyNotFoundException {
        return contains(root, key);
    }

    private V contains(BSTNode<K,V> node, K k) throws KeyNotFoundException{
        if (node == null) {
            throw new KeyNotFoundException();
        }

        if (k.compareTo(node.key) == 0){
            return node.value;
        } else if (k.compareTo(node.key) > 0) {
            return contains(node.right, k);
        } else {
            return contains(node.left, k);
        } 
    }

    

    /*
     * Purpose:
     *
     * Return the number of nodes in the tree.
     *
     * Returns:
     *    the number of nodes in the tree.
     */
    public int size() {
        return count;
    }

    /*
     * Purpose:
     *    Remove all nodes from the tree.
     */
    public void clear() {
        this.count = 0;
        this.root = null;
    }

    /*
     * Purpose:
     *
     * Return the height of the tree.  We define height
     * as being the number of nodes on the path from the root
     * to the deepest node.
     *
     * This means that a tree with one node has height 1.
     *
     * Examples:
     *    See the assignment PDF and the test program for
     *    examples of height.
     */
    public int height() {
        
        return height(root);
    }
     
    private int height(BSTNode<K,V> t) {
        if (t==null) {
            return 0;
        }
        int highest = Math.max(height(t.getLeft()), height(t.getRight()));
        return 1 + highest;
    }


    /*
     * Purpose:
     *
     * Return a list of all the key/value Entrys stored in the tree
     * The list will be constructed by performing a level-order
     * traversal of the tree.  If the tree is empty, the returned list is empty.
     *
     * A level order traversal of a tree cannot be done without the help
     *  of a secondary data structure
     *
     * It is commonly implemented using a queue of nodes as the secondary
     *  data structure.
     *  You will still be adding the "visited" elements to l as you do in the other
     *  traversal methods but you will create an additional q to hold nodes still to visit
     *
     *  From wikipedia (they call it breadth-first), the algorithm for level order is:
     *
     *    levelorder()
     *        q = empty queue
     *        q.enqueue(root)
     *        while not q.empty do
     *            node := q.dequeue()
     *            visit(node)
     *            if node.left != null then
     *                  q.enqueue(node.left)
     *            if node.right != null then
     *                  q.enqueue(node.right)
     *
     * Note that you can use the Java LinkedList as a Queue
     *  and then use only the removeFirst() and addLast() methods on q
     *
     * Parameters: None
     *
     * Returns: List< Entry<K,V> > - list of all key/value Entrys in the tree
     *  in a levelorder traversal
     */
    public List< Entry<K,V> >  entryList() {
        List< Entry<K,V> > l = new LinkedList< Entry<K,V> >();  // hold traversal elements
        LinkedList<BSTNode<K,V>> queue = new LinkedList<BSTNode<K,V>>();

		if (root != null) {
			queue.add(root); // at the root to the queue
			while (!queue.isEmpty()) {
				BSTNode<K,V> n = queue.removeFirst();
				l.add(new Entry<K,V>(n.key, n.value));
				if (n.left != null) {
					queue.add(n.left);
				}
				if (n.right != null) {
					queue.add(n.right);
				}
			}
		}
        return l;
    }

    /*
     * Purpose:
     *
     * Return a list of all the key/value Entrys stored in the tree
     * The list will be constructed by performing a traversal
     * specified by the parameter which.
     *
     * If which is:
     *    BST_PREORDER    perform a pre-order traversal
     *    BST_POSTORDER    perform a post-order traversal
     *    BST_INORDER    perform an in-order traversal
     * Parameters: int which
     *
     * Precondition: which is one of BST_PREORDER, BST_POSTORDER or BST_INORDER
     *
     * Returns: List< Entry<K,V> > - list of all key/value Entrys in the tree
     */
    public List< Entry<K,V>> entryList (int which) {
        List< Entry<K,V>> l = new LinkedList< Entry<K,V> >();

        if (which == BST_PREORDER) {
			doPreOrder(root, l);
		} else if (which == BST_INORDER) {
			doInOrder(root, l);
		} else if (which == BST_POSTORDER) {
			doPostOrder(root, l);
		}
        return l;
    }

    /*
     * Your instructor had the following private methods in their solution:
     * private void doInOrder (BSTNode<K,V> n, List <Entry<K,V> > l);
     * private void doPreOrder (BSTNode<K,V> n, List <Entry<K,V> > l);
     * private void doPostOrder (BSTNode<K,V> n, List <Entry<K,V> > l);
     * private int doHeight (BSTNode<K,V> t)
     */

    private void doInOrder (BSTNode<K,V> n, List <Entry<K,V> > l){
        if (n == null) {
            return;
        }
        doInOrder(n.left, l);
        l.add(new Entry<K,V>(n.key, n.value));
        doInOrder(n.right, l);
    }


    private void doPreOrder (BSTNode<K,V> n, List <Entry<K,V> > l){
        if (n == null) {
            return;
        }
        l.add(new Entry<K,V>(n.key, n.value));
        doPreOrder(n.left, l);
        doPreOrder(n.right, l);
    }


    private void doPostOrder (BSTNode<K,V> n, List <Entry<K,V> > l){
        if (n == null){
            return;
        }
        doPostOrder(n.left, l);
        doPostOrder(n.right, l);
        l.add(new Entry<K,V>(n.key, n.value));
    }
    
    
    private int doHeight (BSTNode<K,V> t){
        return -1;
    }

}
