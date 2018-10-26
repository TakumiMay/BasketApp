package model;

import java.util.Hashtable;

import structures.AVL;
import structures.BST;
import structures.RBT;

public class FIBA {
	 
	
	AVL<Hashtable<Integer, String>> avl_points = new AVL<>();
	BST<Hashtable<Integer, String>> bst_points = new BST<>();
	
	BST<Hashtable<Integer, String>> bst_assists = new BST<>();
	RBT<Hashtable<Integer, String>> rbt_assists = new RBT<>();
	
	AVL<Hashtable<Integer, String>> avl_thefts = new AVL<>();
	
	RBT<Hashtable<Integer, String>> rbt_locks = new RBT<>();
	
	
	
	public Hashtable searchPlayersByPoints(int value) {
		return null;
	}
	
	public Hashtable searchPlayersByAssists(int value) {
		return null;
	}
	
	public Hashtable searchPlayersByThefts(int value) {
		return null;
	}
	
	public Hashtable searchPlayersByLocks(int value) {
		return null;
	}
	
	public double compareAVLAndBSTByTime() {
		return 0;
	}
	
	public double compareRBTAndBSTByTime() {
		return 0;
	}
	
	public double compareRBTandAVLByTime() {
		return 0;
	}
	
	
	
	

}
