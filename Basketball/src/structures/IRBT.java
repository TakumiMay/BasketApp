package structures;

/**
 * This interface is for Red Black Trees
 * @author Daniel
 *
 */

public interface IRBT <T>{
	
	public void leftRotate(T x);
	
	public void leftRotateFixup(T y);
	
	public void rightRotate(T x);
	
	public void rightRotateFixup(T y);
	
	public void insert(T node);
	
	public void insertFixup(T node);
	
	public T smallestChild(T node);
	
	public T successor(T node);
	
	public void remove(T node);
	
	public void fixNodeData(T x, T y);
	
	public void removeFixup(T sonOfParentRemoved);
	
	public T search(T key);

}
