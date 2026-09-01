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
            System.out.println("Prioridad de la tarea: " + actual.getPriority());
            actual = actual.getNext();

        }
            System.out.println("]");

    }
    //metodo agregado por mi (no siento este los metodos predeterminados de una Queue), para asegurar que la cola este funcionando,
    //el metodo recorre la cola con la variable "actual" y va imprimiendo sus valores, haciendo que se muestre la cola

    public T dequeue() {
        if (this.isEmpty()) { //si esta vacia, no regresa nada
            return null;
        } 
    
        T result = this.front.getData(); //agarramos lo que hay en el frente y lo llamamos como result, generico

        if (size ==1){
            front = null;
            tail = null; //si el tamano es 1, se elimina
            size--;

            return result;
        }

        Node<T> ultimo = getPositionNode(size); //definimos un nodo como ultimo 

        front.setData(ultimo.getData());
        front.setPriority(ultimo.getPriority()); //definimos misma info y prioridad al fron que del ultimo

        Node<T> newTail = getPositionNode(size - 1);
        newTail.setNext(null);
        tail = newTail;//definimos nueva tail y desconectamos nodo para eliminarlo
        size --;

        int posActual = 1;
        while (getHijoIzq(posActual) <= size){
            int posHijoIzq = getHijoIzq(posActual);//definiendo para comparar
            int posHijoDer = getHijoDerecho(posActual);
            Node<T> posPadre = getPositionNode(posActual);
            Node<T> HijoIzq = getPositionNode(posHijoIzq);

            if (posHijoDer <= size) {

    Node<T> hijoDer = getPositionNode(posHijoDer);

    if (HijoIzq.getPriority() < hijoDer.getPriority()) {

        if (HijoIzq.getPriority() < posPadre.getPriority()) {

            T tempData = posPadre.getData();
            int tempPrio = posPadre.getPriority();

            posPadre.setData(HijoIzq.getData());
            posPadre.setPriority(HijoIzq.getPriority());

            HijoIzq.setData(tempData);
            HijoIzq.setPriority(tempPrio);
            posActual = posHijoIzq;
        } else {
            break; //salir del while si no se cambia
        }
        
    } else {

        if (hijoDer.getPriority() < posPadre.getPriority()) {

            T tempData = posPadre.getData();
            int tempPrio = posPadre.getPriority();

            posPadre.setData(hijoDer.getData());
            posPadre.setPriority(hijoDer.getPriority());

            hijoDer.setData(tempData);
            hijoDer.setPriority(tempPrio);
            posActual = posHijoDer;
        } else {
            break;
        }
        
    }
} else {
    if (HijoIzq.getPriority() < posPadre.getPriority()) {

        T tempData = posPadre.getData();
        int tempPrio = posPadre.getPriority();

        posPadre.setData(HijoIzq.getData());
        posPadre.setPriority(HijoIzq.getPriority());

        HijoIzq.setData(tempData);
        HijoIzq.setPriority(tempPrio);

        posActual = posHijoIzq;

    } else {

        break;

    }
    
}
                
            } 
            
        


        return result ;
     
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