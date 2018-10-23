package structures;
/**
 * Class for AVL Tree
 * @author Daniel
 *
 */

public class AVL implements IAVL {
	
	
		 
	    NodeAVL root;
	    int size;
	 
	   
	    @Override
	    public boolean insert(int key) {
	    	if (root == null) {
	            root = new NodeAVL(key, null);
	            size++;
	            return true;
	        }
	 
	        NodeAVL n = root;
	        while (true) {
	            if (n.key == key)
	                return false;
	 
	            NodeAVL parent = n;
	 
	            boolean goLeft = n.key > key;
	            n = goLeft ? n.left : n.right;
	 
	            if (n == null) {
	                if (goLeft) {
	                    parent.left = new NodeAVL(key, parent);
	                } else {
	                    parent.right = new NodeAVL(key, parent);
	                }
	                rebalance(parent);
	                break;
	            }
	        }
	        size++;
	        return true;
	    }
	    
	    
	    private void delete(NodeAVL node) {
	        if (node.left == null && node.right == null) {
	            if (node.parent == null) {
	                root = null;
	            } else {
	            	NodeAVL parent = node.parent;
	                if (parent.left == node) {
	                    parent.left = null;
	                } else {
	                    parent.right = null;
	                }
	                rebalance(parent);
	            }
	            return;
	        }
	 
	        if (node.left != null) {
	        	NodeAVL child = node.left;
	            while (child.right != null) child = child.right;
	            node.key = child.key;
	            delete(child);
	        } else {
	        	NodeAVL child = node.right;
	            while (child.left != null) child = child.left;
	            node.key = child.key;
	            delete(child);
	        }
	    }
	 
	    @Override
	    public void delete(int delKey) {
	        if (root == null)
	            return;
	 
	        NodeAVL child = root;
	        while (child != null) {
	        	NodeAVL node = child;
	            child = delKey >= node.key ? node.right : node.left;
	            if (delKey == node.key) {
	                delete(node);
	                size--;
	                return;
	            }
	        }
	    }
	    
	    @Override
	    public void rebalance(NodeAVL n) {
	        setBalance(n);
	 
	        if (n.balance == -2) {
	            if (height(n.left.left) >= height(n.left.right))
	                n = rotateRight(n);
	            else
	                n = rotateLeftThenRight(n);
	 
	        } else if (n.balance == 2) {
	            if (height(n.right.right) >= height(n.right.left))
	                n = rotateLeft(n);
	            else
	                n = rotateRightThenLeft(n);
	        }
	 
	        if (n.parent != null) {
	            rebalance(n.parent);
	        } else {
	            root = n;
	        }
	    }
	    
	    @Override
	    public NodeAVL rotateLeft(NodeAVL a) {
	 
	    	NodeAVL b = a.right;
	        b.parent = a.parent;
	 
	        a.right = b.left;
	 
	        if (a.right != null)
	            a.right.parent = a;
	 
	        b.left = a;
	        a.parent = b;
	 
	        if (b.parent != null) {
	            if (b.parent.right == a) {
	                b.parent.right = b;
	            } else {
	                b.parent.left = b;
	            }
	        }
	 
	        setBalance(a, b);
	 
	        return b;
	    }
	    
	    
	    @Override
	    public NodeAVL rotateRight(NodeAVL a) {
	 
	    	NodeAVL b = a.left;
	        b.parent = a.parent;
	 
	        a.left = b.right;
	 
	        if (a.left != null)
	            a.left.parent = a;
	 
	        b.right = a;
	        a.parent = b;
	 
	        if (b.parent != null) {
	            if (b.parent.right == a) {
	                b.parent.right = b;
	            } else {
	                b.parent.left = b;
	            }
	        }
	 
	        setBalance(a, b);
	 
	        return b;
	    }
	 
	    private NodeAVL rotateLeftThenRight(NodeAVL n) {
	        n.left = rotateLeft(n.left);
	        return rotateRight(n);
	    }
	 
	    private NodeAVL rotateRightThenLeft(NodeAVL n) {
	        n.right = rotateRight(n.right);
	        return rotateLeft(n);
	    }
	 
	    private int height(NodeAVL n) {
	        if (n == null)
	            return -1;
	        return n.height;
	    }
	 
	    private void setBalance(NodeAVL... nodes) {
	        for (NodeAVL n : nodes) {
	            reheight(n);
	            n.balance = height(n.right) - height(n.left);
	        }
	    }
	 
	    public void printBalance() {
	        printBalance(root);
	    }
	 
	    private void printBalance(NodeAVL n) {
	        if (n != null) {
	            printBalance(n.left);
	            System.out.printf("%s ", n.balance);
	            printBalance(n.right);
	        }
	    }
	 
	    private void reheight(NodeAVL node) {
	        if (node != null) {
	            node.height = 1 + Math.max(height(node.left), height(node.right));
	        }
	    }
	    
	    @Override
	    public NodeAVL find(int id) {
	    	NodeAVL current = root;
			while(current!=null){
				if(current.key==id){
					return current;
				}else if(current.key>id){
					current = current.getLeft();
				}else{
					current = current.getRight();
				}
			}
			return current;
	    }
	 
	    public static void main(String[] args) {
	    	AVL tree = new AVL();
	   	 
	        System.out.println("Inserting values 1 to 10");
	        for (int i = 1; i < 10; i++)
	            tree.insert(i);
	 
	        System.out.print("Printing balance: ");
	        tree.printBalance();
	        
	        System.out.println(+tree.find(7).getKey());
		}


		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return root == null;
		}
	

	
	
}

