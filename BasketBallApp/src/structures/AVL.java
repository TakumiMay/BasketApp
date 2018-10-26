package structures;

public class AVL<T> implements IAVL<T> {
	
	
		 
	   private NodeAVL<T> root;
	   private int size;
	    
	    
	    public NodeAVL<T> getRoot() {
			return root;
		}


		public void setRoot(NodeAVL<T> root) {
			this.root = root;
		}


		public int getSize() {
			return size;
		}


		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return root == null;
		}
	 
	   
	    @Override
	    public boolean insert(int key) {
	    	if (root == null) {
	            root = new NodeAVL<T>(key, null);
	            size++;
	            return true;
	        }
	 
	    	NodeAVL<T> n = root;
	        while (true) {
	            if (n.getKey() == key)
	                return false;
	 
	            NodeAVL<T> parent = n;
	 
	            boolean goLeft = n.getKey() > key;
	            n = goLeft ? n.left : n.right;
	 
	            if (n == null) {
	                if (goLeft) {
	                    parent.left = new NodeAVL<T>(key, parent);
	                } else {
	                    parent.right = new NodeAVL<T>(key, parent);
	                }
	                rebalance(parent);
	                break;
	            }
	        }
	        size++;
	        return true;
	    }
	    
	    
	    private void delete(NodeAVL<T> node) {
	        if (node.left == null && node.right == null) {
	            if (node.parent == null) {
	                root = null;
	            } else {
	            	NodeAVL<T> parent = node.parent;
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
	        	NodeAVL<T> child = node.left;
	            while (child.right != null) child = child.right;
	            node.key = child.getKey();
	            delete(child);
	        } else {
	        	NodeAVL<T> child = node.right;
	            while (child.left != null) child = child.left;
	            node.key = child.getKey();
	            delete(child);
	        }
	    }
	 
	    @Override
	    public void delete(int delKey) {
	        if (root == null)
	            return;
	 
	        NodeAVL<T> child = root;
	        while (child != null) {
	        	NodeAVL<T> node = child;
	            child = delKey >= node.getKey() ? node.right : node.left;
	            if (delKey == node.getKey()) {
	                delete(node);
	                size--;
	                return;
	            }
	        }
	    }
	    
	    @Override
	    public void rebalance(NodeAVL<T> n) {
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
	    public NodeAVL<T> rotateLeft(NodeAVL<T> a) {
	 
	    	NodeAVL<T> b = a.right;
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
	    public NodeAVL<T> rotateRight(NodeAVL<T> a) {
	 
	    	NodeAVL<T> b = a.left;
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
	 
	    private NodeAVL<T> rotateLeftThenRight(NodeAVL<T> n) {
	        n.left = rotateLeft(n.left);
	        return rotateRight(n);
	    }
	 
	    private NodeAVL<T> rotateRightThenLeft(NodeAVL<T> n) {
	        n.right = rotateRight(n.right);
	        return rotateLeft(n);
	    }
	 
	    private int height(NodeAVL<T> n) {
	        if (n == null)
	            return -1;
	        return n.height;
	    }
	 
	    private void setBalance(NodeAVL<T>... nodes) {
	        for (NodeAVL n : nodes) {
	            reheight(n);
	            n.balance = height(n.right) - height(n.left);
	        }
	    }
	 
//	    public void printBalance() {
//	        printBalance(root);
//	    }
//	 
//	    private void printBalance(NodeAVL<T> n) {
//	        if (n != null) {
//	            printBalance(n.left);
//	            System.out.printf("%s ", n.balance);
//	            printBalance(n.right);
//	        }
//	    }
	 
	    private void reheight(NodeAVL<T> node) {
	        if (node != null) {
	            node.height = 1 + Math.max(height(node.left), height(node.right));
	        }
	    }
	    
	    @Override
	    public NodeAVL<T> find(int id) {
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
	    



		


		
	

	
	
}

