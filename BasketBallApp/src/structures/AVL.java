package structures;
/**
 * Class for AVL Tree
 * @author Daniel
 *
 */

public class AVL<T> implements IAVL<T> {
	
	
		 
	    NodeAVL<T> root;
	    int size;
	 
	   
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
	 
	    public void printBalance() {
	        printBalance(root);
	    }
	 
	    private void printBalance(NodeAVL<T> n) {
	        if (n != null) {
	            printBalance(n.left);
	            System.out.printf("%s ", n.balance);
	            printBalance(n.right);
	        }
	    }
	 
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
	    
	    public void printTree(NodeAVL<T> node) {
	        if (node == null) {
	            return;
	        }
	        printTree(node.left);
	        System.out.print(" "+node.key+" ");
	      //  System.out.print(((node.color==RED)?"Color: Red ":"Color: Black ")+"Key: "+node.key+" Parent: "+node.parent.key+"\n");
	        printTree(node.right);
	    }
	 
//	    public static void main(String[] args) {
//	    	AVL tree = new AVL();
//	   	 
//	        System.out.println("Inserting values 1 to 10");
//	        for (int i = 1; i < 10; i++)
//	            tree.insert(i);
//	 
//	        System.out.print("Printing balance: ");
//	        tree.printBalance();
//	        
//	        System.out.println(+tree.find(7).getKey());
//		}
	    
	    public static void main(String arg[]){
			AVL<Integer> b = new AVL<Integer>();
//			b.insert(new NodeRBT(3));b.insert(new NodeRBT(8));
//			b.insert(new NodeRBT(1));b.insert(new NodeRBT(4));b.insert(new NodeRBT(6));b.insert(new NodeRBT(2));b.insert(new NodeRBT(10));b.insert(new NodeRBT(9));
//			b.insert(new NodeRBT(20));b.insert(new NodeRBT(25));b.insert(new NodeRBT(15));b.insert(new NodeRBT(61));
			b.insert(5);b.insert(4);
			b.insert(6);b.insert(3);b.insert(7);//b.insert(8);
			System.out.println("Original Tree : ");
			b.printTree(b.root);	
			System.out.println("");
			System.out.println("Check whether Node with value 4 exists : " + b.find(4).key);
		//	System.out.println("Check whether Node with value 4 exists : " + b.findNode(new NodeRBT(4), b.root).key);
			//System.out.println("Delete Node with no children (2) : " + b.delete(new NodeRBT(2)));		
			//b.printTree(b.root);
			//System.out.println("\n Delete Node with one child (4) : " + b.delete(new NodeRBT(4)));		
			//b.printTree(b.root);
			//System.out.println("\n Delete Node with Two children (5) : " + b.getSuccessor(b.root.getRight()).key);		
			b.printTree(b.root);
			
			//System.out.println("\n Color of 8 and children : " +b.find(8).left.key);
			System.out.println("\n Hijo derecho raiz : " +b.root.key);
			
		}


		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return root == null;
		}
	

	
	
}

