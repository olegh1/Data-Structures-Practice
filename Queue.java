// Example 27
// Queue implementation using a linked list of nodes (see N.java)

public class Queue implements Q {

    // constructor

    public Queue() {}

    // selectors

    public void add(Object o) {

        if (size == 0) {
          front = new N(o, null);
          rear = front;
        }
        else {
          rear.setNext(new N(o, null));
          rear = rear.getNext();
        }
        size++;
    }

    public Object remove() {

        Object answer;

        if (size == 0)
          return null;
        
        answer = front.getData();
        front = front.getNext();
        size--;
        if (size == 0)
          rear = null;
        return answer;
    }

    public int length() {
        return size;
    }

    public String toString(){
        N current = front;
        String s = "";

        while(current.getNext() != null){
           
            s += current.getData();
            current = current.getNext();

        }

        return s;
    }

    private int size;
    private N front;
    private N rear;

}  // Q1 class

