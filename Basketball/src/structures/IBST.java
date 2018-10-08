package structures;

public interface IBST <T>{
	
	public void insert(T element);
	
	public T find(int value);
	
	public void delete(int value);
	
	public T getSuccessor(T node);

}
