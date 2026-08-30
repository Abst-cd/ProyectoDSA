public class Node<T>{

    public T data;
    public  Node<T> next;
    public int priority;


    public Node(T data, Node<T> nx, int priority){
        this.data = data;
        this.next = nx;
        this.priority = priority;
      
    }

    
    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

   
    public void setData(T d) {
        this.data = d;
    }

    public void setNext(Node<T> nx) {
        this.next = nx;
    }

    public int getPriority(){
        return priority;
    }
    public void setPriority(int priority){
        this.priority = priority;
    }


}