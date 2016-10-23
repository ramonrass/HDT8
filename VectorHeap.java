import java.util.Vector;

/**
 *Vector-Based Heaps
 * @param <E>
 */

/* 	
 *  Diego Rivera 15085
 *  Ramon Samayoa 15497
 *  Metodos obtenidos del libro de texto Java Structures.
*/

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>{

    /**
     *
     */
    protected Vector<E> data; // the data, kept in heap order

    /**
     * Constructor
     */
    public VectorHeap()
	// post: constructs a new priority queue
	{
		data = new Vector<E>();
	}

    /**
     * Constructor
     * @param v
     */
    public VectorHeap(Vector<E> v)
	// post: constructs a new priority queue from an unordered vector
	{
		int i;
		data = new Vector<E>(v.size()); // we know ultimate size
		for (i = 0; i < v.size(); i++)
		{ // add elements to heap
			add(v.get(i));
		}
	}

    /**
     * @param i
     *    devuelve el nodo padre
     * @return int
     */
    protected static int parent(int i)
	// pre: 0 <= i < size
	// post: returns parent of node at location i
	{
		return (i-1)/2;
	}

    /**
     *    devuelve el nodo izquierdo
     * @param i
     * @return int
     */
    protected static int left(int i)
	// pre: 0 <= i < size
	// post: returns index of left child of node at location i
	{
		return 2*i+1;
	}

    /**
     *    devuelve el nodo derecho
     * @param i
     * @return int
     */
    protected static int right(int i)
	// pre: 0 <= i < size
	// post: returns index of right child of node at location i
	{
		return (2*i+1) + 1;
	}

    /**
     *    insercion de nodo comparando el nodo padre
     * @param leaf
     */
    protected void percolateUp(int leaf)
	// pre: 0 <= leaf < size
	// post: moves node at index leaf up to appropriate position
	{
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 &&
		(value.compareTo(data.get(parent)) < 0))
		{
			data.set(leaf,data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf,value);
	}

    /**
     *    insertar nodo
     */
    public void add(E value)
	// pre: value is non-null comparable
	// post: value is added to priority queue
	{
		data.add(value);
		percolateUp(data.size()-1);
	}

    /**
     * @param root
     *    cambio de raiz
     */
    protected void pushDownRoot(int root)
	// pre: 0 <= root < size
	// post: moves node at index root down
	// to appropriate position in subtree
	{
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) &&
				((data.get(childpos+1)).compareTo
				(data.get(childpos)) < 0))
				{
					childpos++;
				}
			// Assert: childpos indexes smaller of two children
			if ((data.get(childpos)).compareTo
				(value) < 0)
			{
				data.set(root,data.get(childpos));
				root = childpos; // keep moving down
			} else { // found right location
				data.set(root,value);
				return;
			}
			} else { // at a leaf! insert and halt
				data.set(root,value);
				return;
			}
		}
	}

    /**
     *    remover ultimo nodo del vector 
     * @return ultimo nodo
     */
    @Override
	public E remove()
	// pre: !isEmpty()
	// post: returns and removes minimum value from queue
	{
		E minVal = getFirst();
		data.set(0,data.get(data.size()-1));
		data.setSize(data.size()-1);
		if (data.size() > 1) pushDownRoot(0);
		return minVal;
	}
    
    /**
     *    deveuelve el nodo prioritario
     * @return el primer nodo
     */
    @Override
    public E getFirst() {
        return data.firstElement();
    }

    /**
     *    programacion defensiva si el vector esta vacio
     */
    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *    devuelve el tamano del vector
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     *    elimina los datos en el vector
     */
    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}