public class PriorityQueue<T> {
    private Node<T> front;
    private Node<T> tail;
    private int size;

    public PriorityQueue() {
        this.front = null;
        this.tail = null;
        this.size = 0;

    }
    //se definen variables y creamos el constructor de la cola

    public boolean isEmpty() {
        return this.front == null;
    }

    public void enqueue(T data, int priority) {
        Node<T> nodoToInsert = new Node<>(data, null, priority);
        if (this.isEmpty()) {
            this.front = nodoToInsert;
            this.tail = nodoToInsert;
        } else {
            this.tail.setNext(nodoToInsert);
            this.tail = nodoToInsert;
        }
        size++;

        int posActual;
        int posPadre;
       
        
        posActual = size;
        while (posActual > 1){
          
            posPadre = getPadre(posActual);
            Node<T> actual = getPositionNode(posActual);
            Node<T> padre = getPositionNode(posPadre);
  
            if (actual.getPriority() < padre.getPriority()) {
                T temp = actual.getData();
                actual.setData(padre.getData());
                padre.setData(temp);

                int pActual = actual.getPriority();
                int pPadre = padre.getPriority();
                
                actual.setPriority(pPadre);
                padre.setPriority(pActual);

                posActual = posPadre;
        } else {
            break;
        }
            
        }
    }
    //metodo para meterle nodos a la cola
    //se crea el nodo para instertar y basicamente dice:
    //"si no hay nada, define como el frente y atras el nodo que vamos a insertar porque sera el unico que hay,
    //si ya existe, la tail sera definida al nodo que estamos insertando
    //--
    //para que funcione la priority queue, se crean nodos temporables para sacar la posicion comparando el nodo actual con el padre
    //si el actual es de mayor prioridad, se intercambia para que el nodo suba lo necesario

    public void verTodaQueue(){
        Node actual = front;
            System.out.println("[");

        while(actual != null){
            System.out.println(actual.getData());
            actual = actual.getNext();

        }
            System.out.println("]");

    }
    //metodo agregado por mi (no siento este los metodos predeterminados de una Queue), para asegurar que la cola este funcionando,
    //el metodo recorre la cola con la variable "actual" y va imprimiendo sus valores, haciendo que se muestre la cola

    public T dequeue() {
        if (this.isEmpty()) {
            return null;
        }
        T result = this.front.getData();
        this.front = this.front.getNext();
        size--;
        if (this.isEmpty()) {
            this.tail = null;
        }
        return result;
    }
    //metodo de tipo T, basicamente lo que hace es saltarse un nodo para eliminarlo y le resta a la variable de size

    public T peek() {
        

        if (this.isEmpty()) {
            return null;
        }
        

        return front.getData();
        

    }
    //muestra el frente de la cola

    public int size() {
        return size;
    }

//metodo para saber la posicion del nodo, se crea un nodo temporal en el que recorre la cola hasta
//llegar a la posicion que se tiene y devuelve la posicion en la que se queda

    public Node<T> getPositionNode(int pos){
        Node<T> actual = front;
        int posicion = 1;

        while(actual != null && posicion < pos ){
            actual = actual.getNext();
            posicion++;

        }
        return actual;
    }

    //estos metodos para la comparacion
    public int getHijoIzq(int n){
        return 2 * n;
    }
      public int getHijoDerecho(int n){
        return 2 * n +1;
    }
      public int getPadre(int n){
        return n / 2;
    }

   @Override
public String toString() {
    if (isEmpty()) {
        return "[]";
    }

    StringBuilder sb = new StringBuilder();
    Node<T> actual = front;

    while (actual != null) {
        sb.append(actual.getData());

        if (actual.getNext() != null) {
            sb.append(" -> ");
        }

        actual = actual.getNext();
    }

    return "Queue [" + sb.toString() + "]";
}
}