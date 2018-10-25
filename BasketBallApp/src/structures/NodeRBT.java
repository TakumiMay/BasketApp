package structures;



public class NodeRBT<T> {

	
	int key = -1, color = RBT.BLACK;
	NodeRBT left = RBT.nil, right = RBT.nil, parent = RBT.nil;

    NodeRBT(int key) {
        this.key = key;
    }

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public NodeRBT getLeft() {
		return left;
	}

	public void setLeft(NodeRBT left) {
		this.left = left;
	}

	public NodeRBT getRight() {
		return right;
	}

	public void setRight(NodeRBT right) {
		this.right = right;
	}

	public NodeRBT getParent() {
		return parent;
	}

	public void setParent(NodeRBT parent) {
		this.parent = parent;
	}
    
    
    
}
