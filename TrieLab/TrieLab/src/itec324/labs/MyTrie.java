package itec324.labs;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unused")
public class MyTrie implements Trie {

	
	private TrieNode root = new TrieNode(false, null);
	
	private class TrieNode
	{
		private boolean validString;
		private TrieNode parent;
		private int currentIndex = 0;
		private TrieNode nodes[] = new TrieNode[26];
				
		public TrieNode(boolean validString, TrieNode parent)
		{
				this.validString = validString;
				this.parent = parent;
		}					

	};
	
	
	@Override
	public void insert(String insert) {
		insert = insert.toLowerCase();
        // Start at the root 
        TrieNode c = root;
        // loop through the entire string
        for (int i = 0; i < insert.length(); i++) {
            // get the index of the current letter
            int index = insert.charAt(i)- 'a';
            // if there isn't a node yet add it
            if(c.nodes[index] == null)    c.nodes[index] = new TrieNode(false, c);
            // move down to this letters node
            c = c.nodes[index];
        }
        // this is the last node
        // set this to indicate it is a word
        c.validString = true;
	
	}
	
	@Override
	public boolean contains(String find) {
		find = find.toLowerCase();
		TrieNode c = root;
		for (int i = 0; i < find.length(); i++) {
			int index = find.charAt(i)- 'a';
			if(c.nodes[index] == null) {
				return false;
			}
			c = c.nodes[index];
		}
		return c.validString;
	}

	@Override
	public ArrayList<String> getSorted() {
		
		return getSubTree(root,"");		
		
	}
	
	// Hint this will make your life easier!
	private ArrayList<String> getSubTree(TrieNode t, String prefix ) {	//Returns list of ALL words under given Node
		System.out.println("getSubTree");
		
		StringBuilder sb = new StringBuilder(prefix);
		ArrayList<String> list = new ArrayList<String>();
		char letter;
		
		TrieNode c = t;
		prefix = prefix.substring(0,prefix.length()-1); //take off last character of prefix
		
		while(!prefix.equals(sb.toString())) {	//while sb != prefix
			
			while ( c.currentIndex < 26 && c.nodes[c.currentIndex] != null) { //Going Down till NULL
				letter = (char) (c.currentIndex+'a'); //ASCII a-z | 97-122 
				sb.append(letter);
				c = c.nodes[c.currentIndex++]; //go down

				if (c.validString && list.contains(sb.toString()) == false) {	//check if valid-string & not already in list
					list.add(sb.toString());
				}
				
			} //END inner while
						
			while(c.currentIndex < 26 && c.nodes[c.currentIndex] == null) { //Go Right till OutOfBounds OR c.nodes isn't NULL
				c.currentIndex++;
			} //End inner while
			
			if (c.currentIndex >= 26) {
				c=c.parent; //go up
				sb.deleteCharAt(sb.length()-1);
			}
			
		} //END outer while
		
		System.out.println("Returning list...");
		
		return list;
		
	}

	@Override
	public ArrayList<String> startsWith(String prefix) { //returns all words that start with the given prefix
		
		prefix = prefix.toLowerCase();
		TrieNode c = root;
		for (int i = 0; i < prefix.length(); i++) {
			int index = prefix.charAt(i)- 'a'; //index-'a' gets num between 0-25
			if(c.nodes[index] == null) {
				return new ArrayList<String>();
			}
			c = c.nodes[index];
		}
		return getSubTree(c,prefix); //root changed to c
		
		//throw new UnsupportedOperationException();
	}
	

}
