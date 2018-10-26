package structures;


public class BST<T> implements IBST<T> {
	
	NodeBST<T> root;
	private int size =0;
	
	
	

	public NodeBST<T> getRoot() {
		return root;
	}



	@Override
	public void insert(int id) {
		NodeBST<T> newNode = new NodeBST<T>(id);
		if(root==null){
			root = newNode;
			size++;
			return;
		}
		NodeBST<T> current = root;
		NodeBST<T> parent = null;
		while(true){
			parent = current;
			if(id<current.getData()){				
				current = current.getLeft();
				if(current==null){
					parent.setLeft(newNode);
					size++;
					return;
				}
			}else{
				current = current.getRight();
				if(current==null){
					parent.setRight(newNode);
					size++;
					return;
				}
			}
		}
	}

	@Override
	public NodeBST<T> find(int id) {
		NodeBST<T> current = root;
		while(current!=null){
			if(current.getData()==id){
				return current;
			}else if(current.getData()>id){
				current = current.getLeft();
			}else{
				current = current.getRight();
			}
		}
		return current;
	}

	@Override
	public boolean delete(int id) {
		NodeBST<T> parent = root;
		NodeBST<T> current = root;
		boolean isLeftChild = false;
		while(current.getData()!=id){
			parent = current;
			if(current.getData()>id){
				isLeftChild = true;
				current = current.getLeft();
			}else{
				isLeftChild = false;
				current = current.getRight();
			}
			if(current ==null){
				return false;
			}
		}
		//if i am here that means we have found the node
		//Case 1: if node to be deleted has no children
		if(current.getLeft()==null && current.getRight()==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.setLeft(null);
			}else{
				parent.setRight(null);
			}
		}
		//Case 2 : if node to be deleted has only one child
		else if(current.getRight()==null){
			if(current==root){
				root = current.getLeft();
			}else if(isLeftChild){
				parent.setLeft(current.getLeft());
			}else{
				parent.setRight(current.getLeft());
			}
		}
		else if(current.getLeft()==null){
			if(current==root){
				root = current.getRight();
			}else if(isLeftChild){
				parent.setLeft(current.getRight());
			}else{
				parent.setRight(current.getRight());
			}
		}else if(current.getLeft()!=null && current.getRight()!=null){
			
			//now we have found the minimum element in the right sub tree
			NodeBST<T> successor = getSuccessor(current.getRight());//----------------------------
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.setLeft(successor);
			}else{
				parent.setRight(successor);
			}			
			successor.setLeft(current.getLeft());
		}		
		return true;
		
	}

	@Override
public NodeBST<T> getSuccessor(NodeBST<T> rightChild){
    	
        while(rightChild.getLeft()!=null){
            rightChild = rightChild.getLeft();
        }
        return rightChild;
    }
//	public NodeBST<T> getSuccessor(NodeBST<T> node) {
//		NodeBST<T> successsor =null;
//		NodeBST<T> successsorParent =null;
//		NodeBST<T> current = node.getRight();
//		while(current!=null){
//			successsorParent = successsor;
//			successsor = current;
//			current = current.getLeft();
//		}
//		//check if successor has the right child, it cannot have left child for sure
//		// if it does have the right child, add it to the left of successorParent.
////		successsorParent
//		if(successsor!=node.getRight()){
//			successsorParent.setLeft(successsor.getRight());
//			successsor.setRight(node.getRight());
//		}
//		return successsor;
//	}

	@Override
	public NodeBST<T> getPredecessor(NodeBST<T> node) {
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}
	
//	public void display(NodeBST<T> root){
//		if(root!=null){
//			display(root.getLeft());
//			System.out.print(" " + root.getData());
//			display(root.getRight());
//		}
//	}
	


}
