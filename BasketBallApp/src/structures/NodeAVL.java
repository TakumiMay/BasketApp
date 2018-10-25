package structures;

public class NodeAVL<T> {
    protected int key;
    int balance;
    int height;
    NodeAVL<T> left;
    NodeAVL<T> right;
    NodeAVL<T> parent;

    NodeAVL(int key, NodeAVL<T> parent) {
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

	public NodeAVL<T> getLeft() {
		return left;
	}

	public void setLeft(NodeAVL<T> left) {
		this.left = left;
	}

	public NodeAVL<T> getRight() {
		return right;
	}

	public void setRight(NodeAVL<T> right) {
		this.right = right;
	}

	public NodeAVL<T> getParent() {
		return parent;
	}

	public void setParent(NodeAVL<T> parent) {
		this.parent = parent;
	}
    
    
}
