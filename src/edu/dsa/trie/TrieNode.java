package edu.dsa.trie;

import java.util. * ;

class TrieNode {
  boolean isWord;
  HashMap <Character, TrieNode> children;

  public TrieNode() {
    this.children = new HashMap <Character, TrieNode> ();
    this.isWord = false;
  }
}