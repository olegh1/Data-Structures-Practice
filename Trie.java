import java.util.LinkedList;

public class Trie {
  private TrieNode root;

  public Trie(){
    root = new TrieNode();
    root.setWord(false);
    root.setValue(null);
  }



  public void insert(String word){
    TrieNode current = root;
    TrieNode next;

    for(int i = 0; i < word.length(); i++){

      next = new TrieNode();

      if(current.getChildren().exists(word.charAt(i))){


      HashEntry pair = (HashEntry) current.getChildren().get(word.charAt(i));
      current = (TrieNode) pair.getValue();


      }
      else {

        next.setValue(word.charAt(i));
        next.setWord(false);
        current.getChildren().put(word.charAt(i), next);
        current = next;

      }


  }
    current.setWord(true);
  }

  public boolean search(String word){
    // returns if word is in trie
    TrieNode current = root;


    for(int i = 0; i < word.length(); i++){
    HashEntry pair = (HashEntry) current.getChildren().get(word.charAt(i));
    if(pair == null){
      return false;
    }
    current = (TrieNode) pair.getValue();
    System.out.println(current.getValue());

    }


    return current.isWord();
  }

  public void delete(String word){

    TrieNode current = root;
    LinkedList deleteChars = new LinkedList();


    for(int i = 0; i < word.length(); i++){
    HashEntry pair = (HashEntry) current.getChildren().get(word.charAt(i));

    current = (TrieNode) pair.getValue();
    current.setWord(false);
    if(current.getChildren().getSize() == 1){
      deleteChars.add(current);
    }
    }
    TrieNode temp = (TrieNode) deleteChars.get(0);
    HashTable tempTable = (HashTable) temp.getChildren();
    tempTable.clear();
    temp.setValue(null);


  }

  public String toString(){
    return root.toString();
  }



  public static void main(String[] args){

    Trie mytrie = new Trie();
    mytrie.insert("cat");
    mytrie.insert("can");
    mytrie.insert("call");
    mytrie.insert("canada");
    mytrie.insert("vsegda");
    mytrie.insert("vstrecha");
    mytrie.insert("california");

    System.out.println(mytrie.search("vsegda"));
    mytrie.delete("vsegda");
    System.out.println(mytrie.search("vsegda"));

    System.out.println(mytrie);


}
}
