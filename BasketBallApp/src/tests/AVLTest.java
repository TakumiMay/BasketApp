package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import structures.AVL;
import structures.NodeRBT;
import structures.RBT;

class AVLTest {

private AVL<Integer> tree;
	
	
	private void setupStage1() {
		tree = new AVL<Integer>();
		tree.insert(5); tree.insert(4); tree.insert(6); tree.insert(3); tree.insert(7);

	}
	
	private void setupStage2() {
		setupStage1();
		tree.insert(8);
		
	}
	
	@Test
	public void insertTest() {
		setupStage1();
		tree.insert(8);
		assertTrue(tree.find(7).getBalance()==0);
		assertTrue(tree.getRoot().getBalance() == 0);
		assertTrue(tree.find(7).getRight().getKey() == 8);
		assertTrue(tree.find(7).getLeft().getKey() == 6);
		
	}
	
	@Test
	public void findTest() {
		setupStage1();
		assertTrue(tree.find(7).getKey() == 7);
	}
	
	@Test
	public void deleteTest() {
		setupStage2();
		tree.delete(7);
		assertTrue(tree.find(7)== null && tree.getRoot().getBalance() == 0);
		assertTrue(tree.getRoot().getRight().getBalance()==1 && tree.getRoot().getLeft().getBalance()==-1);
	}
	

}
