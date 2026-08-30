import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class mainPruebas {
    public static void main(String[] args) throws IOException{
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));   

        PriorityQueue<Task> cola = new PriorityQueue<>();

                System.out.println("Tarea a realizar: ");
                String tareaPrioridad = entrada.readLine();

                System.out.println("Prioridad (1 ALTA, 2 MEDIA, 3 BAJA)");
                int opcionPrioridad = Integer.parseInt(entrada.readLine());

                System.out.println("Tarea a realizar: ");
                String tareaPrioridad2 = entrada.readLine();

                System.out.println("Prioridad (1 ALTA, 2 MEDIA, 3 BAJA)");
                int opcionPrioridad2 = Integer.parseInt(entrada.readLine());

                Task.Prioridad prioridad;

                if (opcionPrioridad == 1) {
                    prioridad = Task.Prioridad.ALTA;
                } else if (opcionPrioridad == 2) {
                    prioridad = Task.Prioridad.MEDIA;
                } else {
                    prioridad = Task.Prioridad.BAJA;
                }

                Task tarea = new Task(1, tareaPrioridad, prioridad);
                cola.enqueue(tarea, opcionPrioridad);


                // SEGUNDA TAREA
                Task.Prioridad prioridad2;

                if (opcionPrioridad2 == 1) {
                    prioridad2 = Task.Prioridad.ALTA;
                } else if (opcionPrioridad2 == 2) {
                    prioridad2 = Task.Prioridad.MEDIA;
                } else {
                    prioridad2 = Task.Prioridad.BAJA;
                }

                Task tarea2 = new Task(2, tareaPrioridad2, prioridad2);
                cola.enqueue(tarea2, opcionPrioridad2);


                cola.verTodaQueue();

                System.out.println("------------------");

                Task eliminada = cola.dequeue();

                System.out.println("Se eliminó: " + eliminada);

                System.out.println("------------------");

                cola.verTodaQueue();

    }
}
