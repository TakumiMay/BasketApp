package structures;

/**
 * Árbol ABB / Binary Search Tree
 * @author Daniel
 *
 * @param <T>
 */

public interface IBST <T>{
	
	public void insert(int id);
	
	public NodeBST<T> find(int value);
	
	public boolean delete(int value);
	
	public NodeBST<T> getSuccessor(NodeBST<T> node);
	
	public NodeBST<T> getPredecessor(NodeBST<T> node);
	
	public int getSize();

}
