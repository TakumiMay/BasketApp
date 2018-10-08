package structures;

/**
 * This interface is for AVL Trees
 * @author Daniel
 *
 */

public interface IAVL <T>{
	
	public void rotateRight(T node);
	
	public boolean isEmpty();
	
	public void insert(T data);

}
