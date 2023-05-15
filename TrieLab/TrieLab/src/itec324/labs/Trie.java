package itec324.labs;

import java.util.ArrayList;

public interface Trie {

	
	
	/**
	adds a new string to the trie.

	@param insert the string to add to the trie.
	@return No return value
	*/
	void insert(String insert);
	
	
	/**
	returns a list containing all the strings in the trie.This is an inorder traversal
	@return An ArrayList that contains the strings in the trie.
	*/
	 ArrayList<String> getSorted( ); 

	/**
	returns a list with all the possible words
	that start with prefix
	@param prefix the string to look for in the trie.
	@return list with the strings in it.
	*/
	 ArrayList<String> startsWith(String prefix);

	/**
	returns true if the string is in the trie.
	@param find the string to look for in the trie.
	@return true if the strings in the trie.
	*/
	boolean contains(String find);
}
