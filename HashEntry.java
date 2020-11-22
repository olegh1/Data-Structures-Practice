public class HashEntry<K,V>{

  private K key;
  private V value;

  public HashEntry(K key, V value){
    this.key = key;
    this.value = value;
  }

  public K getKey(){
    return this.key;
  }

  public V getValue(){
    return this.value;
  }

  public String toString(){
    return key.toString() + "," + value.toString();
  }

  }
