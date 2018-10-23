package structures;
/**
 * Node for Binary Searh Tree
 * @author Danés
 *
 * @param <K>
 */

public class NodeBST <K>{
	
	private int data;
	private NodeBST<K>left;
	private NodeBST<K> right;
	
	public NodeBST(int data){
		this.data = data;
		left = null;
		right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public NodeBST<K> getLeft() {
		return left;
	}

	public void setLeft(NodeBST<K> left) {
		this.left = left;
	}

	public NodeBST<K> getRight() {
		return right;
	}

	public void setRight(NodeBST<K> right) {
		this.right = right;
	}
	
	

}
