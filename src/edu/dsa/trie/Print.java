package edu.dsa.trie;

import java.util. * ;
class Print {
  public static void printState(TrieNode trieNode, String indent) {
    Stack < TrieNode > stack = new Stack < TrieNode > ();
    Stack < Character > keys = new Stack < Character > ();
    TrieNode temp = trieNode;
    for (Character i: temp.children.keySet()) {
      stack.push(temp.children.get(i));
      keys.push(i);
    }
    while (!stack.isEmpty()) {
      System.out.print(indent);
      System.out.print(keys.pop());
      indent += "   ";
      temp = stack.pop();
      if (temp.isWord == true) System.out.print("*");
      while (!temp.children.isEmpty()) {
        for (Character i: temp.children.keySet()) {
          System.out.print(indent);
          System.out.print(i);
          temp = temp.children.get(i);
          if (temp.isWord == true) System.out.print("*");
          indent += "   ";

        }

      }
      indent = "\n\t\t\t";

    }
  }
}