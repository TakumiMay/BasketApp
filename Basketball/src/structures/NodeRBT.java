package structures;



public class NodeRBT {

	
	int key = -1, color = RBT.BLACK;
	NodeRBT left = RBT.nil, right = RBT.nil, parent = RBT.nil;

    NodeRBT(int key) {
        this.key = key;
    }
    
}
