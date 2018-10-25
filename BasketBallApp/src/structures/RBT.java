package structures;

import java.util.Scanner;

/**
 * Red Black Tree
 * @author Daniel
 *
 * @param <T>
 */
public class RBT<T> implements IRBT<T> {

	public final static int RED = 0;
    public final static int BLACK = 1;

    

    public final static NodeRBT nil = new NodeRBT(-1); 
    private NodeRBT<T> root = nil;
    

    public NodeRBT<T> getRoot() {
		return root;
	}

	public void setRoot(NodeRBT root) {
		this.root = root;
	}

	public  NodeRBT<T> getNil() {
		return nil;
	}

	public void printTree(NodeRBT node) {
        if (node == nil) {
            return;
        }
        printTree(node.left);
        System.out.print(" "+node.key+" ");
        printTree(node.right);
    }
    
    public NodeRBT<T> find(int id) {
    	NodeRBT<T> current = root;
		while(current!=null){
			if(current.key==id){
				return current;
			}else if(current.key>id){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return current;
	}

//    private NodeRBT<T> findNode(NodeRBT findNode, NodeRBT node) {
//        if (root == nil) {
//            return null;
//        }
//
//        if (findNode.key < node.key) {
//            if (node.left != nil) {
//                return findNode(findNode, node.left);
//            }
//        } else if (findNode.key > node.key) {
//            if (node.right != nil) {
//                return findNode(findNode, node.right);
//            }
//        } else if (findNode.key == node.key) {
//            return node;
//        }
//        return null;
//    }

    public void insert(int id) {
    	NodeRBT<T> node = new NodeRBT<T>(id);
    	NodeRBT<T> temp = root;
        if (root == nil) {
            root = node;
            node.color = BLACK;
            node.parent = nil;
        } else {
            node.color = RED;
            while (true) {
                if (node.key < temp.key) {
                    if (temp.left == nil) {
                        temp.left = node;
                        node.parent = temp;
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else if (node.key >= temp.key) {
                    if (temp.right == nil) {
                        temp.right = node;
                        node.parent = temp;
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
            fixUp(node);
        }
    }

    /**
     * Fix the balance at insert a new node
     * @param node - newly node inserted
     */
    public void fixUp(NodeRBT<T> node) {
        while (node.parent.color == RED) {
        	NodeRBT<T> uncle = nil;
            if (node.parent == node.parent.parent.left) {
                uncle = node.parent.parent.right;

                if (uncle != nil && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                } 
                if (node == node.parent.right) {
                    //Double rotation needed
                    node = node.parent;
                    rotateLeft(node);
                } 
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation 
                rotateRight(node.parent.parent);
            } else {
                uncle = node.parent.parent.left;
                 if (uncle != nil && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                }
                if (node == node.parent.left) {
                    //Double rotation needed
                    node = node.parent;
                    rotateRight(node);
                }
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation
                rotateLeft(node.parent.parent);
            }
        }
        root.color = BLACK;
    }

   public void rotateLeft(NodeRBT<T> node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
            node.right.parent = node.parent;
            node.parent = node.right;
            if (node.right.left != nil) {
                node.right.left.parent = node;
            }
            node.right = node.right.left;
            node.parent.left = node;
        } else {//Need to rotate root
        	NodeRBT<T> right = root.right;
            root.right = right.left;
            right.left.parent = root;
            root.parent = right;
            right.left = root;
            right.parent = nil;
            root = right;
        }
    }

    public void rotateRight(NodeRBT<T> node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }

            node.left.parent = node.parent;
            node.parent = node.left;
            if (node.left.right != nil) {
                node.left.right.parent = node;
            }
            node.left = node.left.right;
            node.parent.right = node;
        } else {//Need to rotate root
        	NodeRBT<T> left = root.left;
            root.left = root.left.right;
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = nil;
            root = left;
        }
    }


    
    //Deletion Code .
    
    //This operation doesn't care about the new Node's connections
    //with previous node's left and right. The caller has to take care
    //of that.
    void transplant(NodeRBT<T> target, NodeRBT<T> with){ 
          if(target.parent == nil){
              root = with;
          }else if(target == target.parent.left){
              target.parent.left = with;
          }else
              target.parent.right = with;
          with.parent = target.parent;
    }
    
    public boolean delete(int id){
    	NodeRBT<T> z = new NodeRBT<T>(id);
        //if((z = findNode(z, root))==null)return false;
    	if((z = find(z.key))==null)return false;
        NodeRBT<T> x;
        NodeRBT<T> y = z; // temporary reference y
        int y_original_color = y.color;
        
        if(z.left == nil){
            x = z.right;  
            transplant(z, z.right);  
        }else if(z.right == nil){
            x = z.left;
            transplant(z, z.left); 
        }else{
            y = getSuccessor(z.right);
            y_original_color = y.color;
            x = y.right;
            if(y.parent == z)
                x.parent = y;
            else{
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color; 
        }
        if(y_original_color==BLACK)
            deleteFixup(x);  
        return true;
    }
    
    public void deleteFixup(NodeRBT<T> x){
        while(x!=root && x.color == BLACK){ 
            if(x == x.parent.left){
            	NodeRBT w = x.parent.right;
                if(w.color == RED){
                    w.color = BLACK;
                    x.parent.color = RED;
                    rotateLeft(x.parent);
                    w = x.parent.right;
                }
                if(w.left.color == BLACK && w.right.color == BLACK){
                    w.color = RED;
                    x = x.parent;
                    continue;
                }
                else if(w.right.color == BLACK){
                    w.left.color = BLACK;
                    w.color = RED;
                    rotateRight(w);
                    w = x.parent.right;
                }
                if(w.right.color == RED){
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.right.color = BLACK;
                    rotateLeft(x.parent);
                    x = root;
                }
            }else{
            	NodeRBT w = x.parent.left;
                if(w.color == RED){
                    w.color = BLACK;
                    x.parent.color = RED;
                    rotateRight(x.parent);
                    w = x.parent.left;
                }
                if(w.right.color == BLACK && w.left.color == BLACK){
                    w.color = RED;
                    x = x.parent;
                    continue;
                }
                else if(w.left.color == BLACK){
                    w.right.color = BLACK;
                    w.color = RED;
                    rotateLeft(w);
                    w = x.parent.left;
                }
                if(w.left.color == RED){
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.left.color = BLACK;
                    rotateRight(x.parent);
                    x = root;
                }
            }
        }
        x.color = BLACK; 
    }
    
    /**
     * This method return the successor of a node
     * @param rightChild - is the right child of the node who are going to search its successor
     */
    public NodeRBT<T> getSuccessor(NodeRBT<T> rightChild){
    	
        while(rightChild.left!=nil){
            rightChild = rightChild.left;
        }
        return rightChild;
    }
    
    
    

    
	
    }