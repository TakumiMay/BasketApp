package structures;

/**
 * This interface is for AVL Trees
 * @author Daniel
 *
 */

public interface IAVL<T> {
	
	public NodeAVL<T> rotateRight(NodeAVL<T> node);
	
	public NodeAVL<T> rotateLeft(NodeAVL<T> node);
	
	public void delete (int node);
	
	public void rebalance(NodeAVL<T> node);
	
	public NodeAVL<T> find(int key);
	
	public boolean isEmpty();
	
	public boolean insert(int data);

}
