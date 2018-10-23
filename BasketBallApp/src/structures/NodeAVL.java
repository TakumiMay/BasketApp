package structures;

public class NodeAVL {
    int key;
    int balance;
    int height;
    NodeAVL left;
    NodeAVL right;
    NodeAVL parent;

    NodeAVL(int key, NodeAVL parent) {
        this.key = key;
        this.parent = parent;
    }

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public NodeAVL getLeft() {
		return left;
	}

	public void setLeft(NodeAVL left) {
		this.left = left;
	}

	public NodeAVL getRight() {
		return right;
	}

	public void setRight(NodeAVL right) {
		this.right = right;
	}

	public NodeAVL getParent() {
		return parent;
	}

	public void setParent(NodeAVL parent) {
		this.parent = parent;
	}
    
    
}
