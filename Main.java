import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Stack<String> tareaInsertar = new Stack<>(); //instancia de stack aqui para
    static PriorityQueue<String> tareasPrioridadesInsertar = new PriorityQueue<>();
    //que siempre sea accesible

    public static void main(String[] args) throws IOException  {
    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));   
        int opcionPrincipal;
        do {
        System.out.println("MENU RECURSOS HUMANOS GOOGLE");
        System.out.println("Cosas que hacer:");
        System.out.println("1. Asignacion tareas prioridad.");
        System.out.println("2. Consulta tareas de prioridad");
        System.out.println("3. Asignacion tareas del diario");
        System.out.println("4. Consulta tareas del diario");
        System.out.println("5. Asignacion tareas aleatorias");
        System.out.println("6. Consulta tareas pendientes");
        System.out.println("7. Salir");

        System.out.println("Que quiere hacer?");
        opcionPrincipal = Integer.parseInt(entrada.readLine());

        menuPrincipal(opcionPrincipal, entrada);

        }while (opcionPrincipal != 7);
        }


public static void menuPrincipal(int opcion, BufferedReader entrada) throws IOException {
                    

        switch(opcion){
            case 1:
                System.out.println("Tarea a realizar: ");
                String tareaPrioridad = entrada.readLine();
                System.out.println("Prioridad (1 ALTA, 2 MEDIA, 3 BAJA) ");
                int opcionPrioridad = Integer.parseInt(entrada.readLine());

                tareasPrioridadesInsertar.enqueue(tareaPrioridad, opcionPrioridad);
                tareasPrioridadesInsertar.verTodaQueue();

            case 2:
            System.out.println("Tareas:");
           tareasPrioridadesInsertar.verTodaQueue();

                break;
            case 3:
                System.out.println("- Agregar tarea -");
                System.out.println("Tarea a agregar: ");
                String nombreT = entrada.readLine();
                tareaInsertar.push(nombreT);


                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;

            
        }
    }
}
