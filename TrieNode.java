public class TrieNode {
    private boolean isCompleteWord;
    private Object value;
    private HashTable myTable;

    public TrieNode(){
      myTable = new HashTable();
    }

    public HashTable getChildren(){
      return this.myTable;
    }

    public Object getValue(){
      return this.value;
    }
    public void setValue(Object o){
      this.value = o;
    }
    public boolean isWord(){
      return this.isCompleteWord;
    }
    public void setWord(boolean value){
      this.isCompleteWord = value;
    }
    public String toString(){
      return value + " " + myTable.toString();
    }
}
