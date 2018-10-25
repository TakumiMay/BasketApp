package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import structures.NodeRBT;
import structures.RBT;

class AVLTest {

private AVL<Integer> tree;
	
	
	private void setupStage1() {
		tree = new RBT<Integer>();

	}
	
	private void setupStage2() {
		setupStage1();
		tree.insert(5); tree.insert(4); tree.insert(6); tree.insert(3); tree.insert(7);
		
	}
	
	@Test
	public void insertTest() {
		setupStage2();
		tree.insert(8);
		assertTrue(tree.find(7).getColor() == RBT.BLACK);
		assertTrue(tree.find(7).getLeft().getKey() == 6 );
		assertTrue(tree.find(7).getRight().getKey() == 8);
		
	}
	
	@Test
	public void findTest() {
		setupStage2();
		assertTrue(tree.find(3).getKey() == 3);
	}
	
	@Test
	public void deleteTest() {
		setupStage2();
		tree.insert(8);
		tree.delete(7);
		assertTrue(tree.find(7)== null && tree.getRoot().getLeft().getKey() == 4);
		assertTrue(tree.getRoot().getRight().getKey()==8 && tree.find(8).getColor() == RBT.BLACK);
	}
	

	
	@Test
	public void getSuccessorTest() {
		setupStage2();
		NodeRBT<Integer> node = tree.getRoot();
		assertTrue(tree.getSuccessor(node.getRight()).getKey() == 6);
	}

}
