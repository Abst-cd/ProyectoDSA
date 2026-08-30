public class mainPruebas {
    public static void main(String[] args){
        PriorityQueue<String> cola = new PriorityQueue<>();
cola.enqueue("ataque corazon", 1);
cola.enqueue("pierna rota", 2);
cola.enqueue("dolor cabeza", 3);
cola.enqueue("pierna rota", 2);
cola.enqueue("ataque corazon", 1);
cola.enqueue("ataque corazon", 1);
cola.enqueue("ataque corazon", 1);
cola.enqueue("pierna rota", 2);
cola.enqueue("dolor cabeza", 3);
cola.verTodaQueue();


    }
}
