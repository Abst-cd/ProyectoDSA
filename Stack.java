import java.util.EmptyStackException;;
public class Stack<T> {
    private int size;
    public Node<T> top;

    public Stack(){
        this.top =null;
        this.size = 0;
    }
//creacion constructor stack

    public void displayStack(){
        Node<T> nodoVer = top;
         System.out.println("[");
        while(nodoVer !=null){
           
            System.out.println(nodoVer.getData());
            nodoVer = nodoVer.next;
            
        }
        System.out.println("]");

    }
    //se muesta la pila sacando la data de los nodos

    public boolean isEmpty(){
        return this.top == null;
    }

    void push(T data){
        Node<T> nodoaInsertar = new Node<>(data, null, 0);
        nodoaInsertar.next = top;
        top = nodoaInsertar;
        size++;
    }

    //metodo push en el cual se crea el nodo que se va a insertarar, algo como:
    // "el siguiente nodo que voy a insertar definelo como el top de la lista y agregale a la variable size"
     T peek(){
        if(top == null){
            throw new EmptyStackException();
        }
        return (T) top.getData();
    }
    //se muestra el top de la pila

     T pop(){
       T nodoaQuitartop = (T)top.getData();
       top = top.getNext();
       size--;
       return nodoaQuitartop;
    }
    //se elimina el top de la pila

@Override
public String toString() {
    String resultado = "";

    Node<T> actual = top;

    while (actual != null) {
        resultado += actual.getData() + " ";
        actual = actual.getNext();
    }

    return resultado;
}
}
