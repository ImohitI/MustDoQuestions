package edu.dsa.trie;
import java.util.*;

class Trie {
  TrieNode root;
  // Constructor to create a trie node.
  public Trie() {
      this.root = new TrieNode();
  }

  // A function to insert a word in trie.
  public void insert(String word) {
      TrieNode trieNode = this.root;

      for (int i = 0; i < word.length(); i++) {
          char c = word.charAt(i);
          if (!trieNode.children.containsKey(c)) {
            trieNode.children.put(c, new TrieNode());
          }
          trieNode = trieNode.children.get(c);
      }

      trieNode.isWord = true;
  }

  // A function to search for a word in the trie.
  public boolean search(String word) {
      TrieNode trieNode = this.root;
      
      for (int i = 0; i < word.length(); i++) {
          char c = word.charAt(i);
          if (!trieNode.children.containsKey(c)) {
            return false;
          }
          
        trieNode = trieNode.children.get(c);
      }

      return trieNode.isWord; 
  }

  // A function to search for a prefix of a word in the trie.
  public boolean searchPrefix(String prefix) {
      TrieNode trieNode = this.root;
      
      for (int i = 0; i < prefix.length(); i++) {
          char c = prefix.charAt(i);
          
          if (!trieNode.children.containsKey(c)) {
            return false;
          }
          else 
          trieNode = trieNode.children.get(c); 
      }

      return true;
  }
  
  // Driver Code
  public static void main(String args[]) {
      List < String > keys = Arrays.asList("the", "a", "there", "answer");
      Trie trieOfKeys = new Trie();
      int num = 1;
      for (String x: keys) {
          System.out.println(num + ".\tInserting key: '" + x + "'");
          trieOfKeys.insert(x);
          num += 1;
          System.out.println(new String(new char[100]).replace('\0', '-'));
      }
      List < String > search = Arrays.asList("a", "answer", "xyz", "an");
      for (String y: search) {
          System.out.println(num + ".\tSearching key: '" + y + "'");
          System.out.println("\tKey found? " + trieOfKeys.search(y));
          num += 1;
          System.out.println(new String(new char[100]).replace('\0', '-'));
      }
      List < String > searchPrefix = Arrays.asList("b", "an");
      for (String z: search) {
          System.out.println(num + ".\tSearching prefix: '" + z + "'");
          System.out.println("\tPrefix found? " + trieOfKeys.searchPrefix(z));
          num += 1;
          System.out.println(new String(new char[100]).replace('\0', '-'));
      }
  }
}