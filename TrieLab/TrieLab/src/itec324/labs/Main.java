package itec324.labs;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	
		 ArrayList<String> lines = FileUtility.readFileResouurce("/words.txt");	
		 MyTrie trie = new MyTrie();
		 // cool lambda you should use these
		 lines.forEach(n -> trie.insert(n));
		 Scanner sc = new Scanner(System.in); 
		 String word = "";
		// 2 Get sort to work (this is a inorder traversal)
		 //ArrayList<String> fulllist = trie.getSorted();
		 //fulllist.forEach(System.out::println);
		 do{
		     word = sc.nextLine();  
		     if (word.length() > 0) {
		    	 // 1 Get insert and contains to work
		    	 //System.out.printf("%s exist in trie: %b", word,trie.contains(word));
		    	 
		    	 // 3 Get startsWith to work
		    	 ArrayList<String> prefixList = trie.startsWith(word);
		    	 prefixList.forEach(System.out::println);
		       
		     } 
		     
		 } while(word.length() != 0); // and keep repeating
		 System.out.println("Have a great day!");
		 sc.close();

	}
	
	
}
