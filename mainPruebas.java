public class mainPruebas {
    public static void main(String[] args){
        PriorityQueue<String> cola = new PriorityQueue<>();
cola.enqueue("corazon abierto", 1);
cola.enqueue("cabeza", 3);
cola.enqueue("pierna", 2);
cola.verTodaQueue();
cola.dequeue();
System.out.println("---------------");
cola.verTodaQueue();


    }
}
