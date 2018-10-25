package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import structures.BST;
import structures.NodeBST;

class BSTTest {
	
	private BST<Integer> arbol;
	
	
	private void setupStage1() {
		arbol = new BST();

	}
	
	private void setupStage2() {
		setupStage1();
		arbol.insert(5); arbol.insert(4); arbol.insert(6); arbol.insert(3); arbol.insert(7);
		
	}
	
	@Test
	public void insertTest() {
		setupStage1();
		arbol.insert(3);
		assertTrue(arbol.getRoot()!=null);
	}
	
	@Test
	public void findTest() {
		setupStage2();
		assertTrue(arbol.find(7).getData() == 7 );
	}
	
	@Test
	public void deleteTest() {
		setupStage2();
		arbol.delete(7);
		assertTrue(arbol.find(7) == null);
	}
	
//	@Test
//	public void getPredecessorTest() {
//		setupStage2();
//		assertTrue(arbol.getPredecessor(arbol.find(5)).getData() == 4);
//	}
	
	@Test
	public void getSuccessorTest() {
		setupStage2();
		assertTrue(arbol.getSuccessor(arbol.find(5)).getData() == 6);
	}

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}
