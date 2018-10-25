package structures;

/**
 * This interface is for Red Black Trees
 * @author Daniel
 *
 */

public interface IRBT <T>{
	
	public void rotateLeft(NodeRBT<T> x);
	
	//public void leftRotateFixup(NodeRBT<T> y);
	
	public void rotateRight(NodeRBT<T> x);
	
	//public void rightRotateFixup(NodeRBT<T> y);
	
	public void insert(int id);
	
	public void fixUp(NodeRBT<T> node);
	
	//public NodeRBT<T> getPredecessor(NodeRBT<T> node);
	
	public NodeRBT<T> getSuccessor(NodeRBT<T> node);
	
	public boolean delete(int id);
	
	//public void fixNodeData(NodeRBT<T> x, NodeRBT<T> y);
	
	public void deleteFixup(NodeRBT<T> sonOfParentRemoved);
	
	public NodeRBT<T> find(int key);

}
