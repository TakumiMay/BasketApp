package structures;

/**
 * This interface is for AVL Trees
 * @author Daniel
 *
 */

public interface IAVL {
	
	public NodeAVL rotateRight(NodeAVL node);
	
	public NodeAVL rotateLeft(NodeAVL node);
	
	public void delete (int node);
	
	public void rebalance(NodeAVL node);
	
	public NodeAVL find(int key);
	
	public boolean isEmpty();
	
	public boolean insert(int data);

}
