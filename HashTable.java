import java.util.LinkedList;

public class HashTable<K,V>{
  private LinkedList<HashEntry>[] hashArray;
  private int size; // number of elements
  private double loadFactor;


  public HashTable(){
    hashArray = new LinkedList[11];
      for(int i = 0; i < 11; i++) {
        hashArray[i] = new LinkedList();
      }
    }

  public HashTable(int len){
    hashArray = new LinkedList[len];
    for(int i = 0; i < len; i++) {
      hashArray[i] = new LinkedList();
    }
  }

  public void clear(){
    hashArray = new LinkedList[11];
    for(int i = 0; i < 11; i++) {
      hashArray[i] = new LinkedList();
    }
  }

  public int getSize(){
    return this.size;
  }

  private LinkedList<HashEntry>[] getTable(){
    return this.hashArray;
  }

  public void put(K key, V value){
    HashEntry pair = new HashEntry(key, value);

    this.loadFactor = size / hashArray.length;


    if(loadFactor >= .70){
      // reHash
      this.reHash();
    }

    int hashedIndex = Math.abs(key.hashCode() % hashArray.length);
    hashArray[hashedIndex].add(pair);
    size++;
  }

  public HashEntry get(K key){
    int findIndex = Math.abs(key.hashCode() % hashArray.length);

    for(HashEntry pair: hashArray[findIndex]){
      if(pair.getKey() == key){
        return pair;
      }
  }
  return null;
 }

 public boolean exists(K key){
   int findIndex = Math.abs(key.hashCode() % hashArray.length);

   for(HashEntry pair: hashArray[findIndex]){
     if(pair.getKey() == key){
       return true;
     }
 }
 return false;
 }


  public void remove(K key){
    int findIndex = Math.abs(key.hashCode() % hashArray.length);
    int i = 0;
    for(HashEntry element: hashArray[findIndex]){
      if(element.getKey() == key){
        hashArray[findIndex].remove(i);
        size--;
        this.loadFactor = size / hashArray.length;;
      }
      i++;
    }
  }

  public void reHash(){
    HashTable biggerTable = new HashTable(hashArray.length * 2);
    // go through current hashtable and reIndex everything

    for(LinkedList tableList: hashArray){
      for(int i = 0; i < tableList.size(); i++){
        HashEntry pair = (HashEntry) tableList.get(i);
        biggerTable.put(pair.getKey(), pair.getValue());

      }
    }
    this.size = biggerTable.getSize();
    this.hashArray = biggerTable.getTable();
  }



  public String toString(){
    String myTable = "HashTable  \n";

    for(LinkedList chain: hashArray){
      for(int i = 0; i < chain.size(); i++){

      myTable += "[";
      myTable += chain.get(i).toString();
      myTable += "]\n";
    }
  }
    return myTable;

}





}
