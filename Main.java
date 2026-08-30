import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static PriorityQueue<Task> tareasPrioridadesInsertar = new PriorityQueue<>();
    static Stack<String> listaBasicaPila = new Stack<>();
    static LinkedList<String> listaAleatoriaT = new LinkedList<>();
    static int siguienteTaskid = 1;

    //que siempre sea accesible

    public static void main(String[] args) throws IOException  {
    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));   
        Byte opcionPrincipal;
        do {
        System.out.println("| -- MENU RECURSOS HUMANOS GOOGLE -- |\n");
        System.out.println("Cosas que hacer:");
        System.out.println("1. Asignacion tareas prioridad.");
        System.out.println("2. Consulta tareas de prioridad");
        System.out.println("3. Asignacion tareas del diario");
        System.out.println("4. Consulta tareas del diario");
        System.out.println("5. Asignacion tareas pendientes");
        System.out.println("6. Consulta tareas pendientes");
        System.out.println("7. Salir");
        System.out.println("------------------------------------\n");
        System.out.println("Que quiere hacer?");
        opcionPrincipal = Byte.parseByte(entrada.readLine());

        menuPrincipal(opcionPrincipal, entrada);

        }while (opcionPrincipal != 7);
        }


public static void menuPrincipal(int opcion, BufferedReader entrada) throws IOException {
                    

        switch(opcion){
            case 1:
                System.out.println("Tarea a realizar: ");

                String tareaPrioridad = entrada.readLine();

                System.out.println("Prioridad (1 ALTA, 2 MEDIA, 3 BAJA)");

                int opcionPrioridad = Integer.parseInt(entrada.readLine());

                Task.Prioridad prioridad;

                if (opcionPrioridad == 1) {
                    prioridad = Task.Prioridad.ALTA;
                } else if (opcionPrioridad == 2) {
                    prioridad = Task.Prioridad.MEDIA;
                } else {
                    prioridad = Task.Prioridad.BAJA;
                }

                Task tarea = new Task(siguienteTaskid, tareaPrioridad, prioridad);

                tareasPrioridadesInsertar.enqueue(tarea, opcionPrioridad);
                siguienteTaskid++;

                tareasPrioridadesInsertar.verTodaQueue();

                break;

            case 2:
                System.out.println("Tareas:");
                tareasPrioridadesInsertar.verTodaQueue();

                break;
            case 3:
                
                System.out.println("1. Insertar tarea");
                System.out.println("2. Eliminar Tarea");
                System.out.println("3.  Ver ultima tarea agregada");
                System.out.println("4. Regresar");

                System.out.println("Que desea hacer?");
                Byte opcionPila = Byte.parseByte(entrada.readLine());
                MenuColaTBasicas(opcionPila, entrada);
                break;
            case 4:
                System.out.println("Tareas:");
                listaBasicaPila.displayStack();
                break;
            case 5:
                System.out.println("1. Insertar tarea");
                System.out.println("2. Eliminar Tarea");
                System.out.println("3.  Ver ultima tarea agregada");
                System.out.println("4. Regresar");
                Byte opcionLista = Byte.parseByte(entrada.readLine());

                MenuListaTBasicas(opcionLista, entrada);
                break;
            case 6:
                System.out.println("Tareas pendientes de Recursos Humanos: ");
                listaAleatoriaT.display();
                break;

            
        }
    }

    public static void MenuColaTBasicas(Byte opcionPila,  BufferedReader entrada) throws IOException{
        
        switch (opcionPila){
            case 1:
                System.out.println("Tarea a insertar:");
                String tareaI = entrada.readLine();
                listaBasicaPila.push(tareaI);
                break;
            case 2:
                System.out.println("Eliminando tarea...");
                listaBasicaPila.pop();
                System.out.println("Done.");
                break;
            case 3:
                System.out.println("Ultima tarea agregada: ");
                listaBasicaPila.peek();
                break;
            case 4:
                return;
        }
       


    }

    public static void MenuListaTBasicas(Byte opcionLista, BufferedReader entrada) throws IOException {
        switch(opcionLista){
        case 1:
            System.out.println("Tarea a instertar: ");
            String insertarLista = entrada.readLine();
            listaAleatoriaT.insert(insertarLista);

            break;
        case 2:
            System.out.println("Eliminando tarea...");
        
            listaAleatoriaT.delete();
            break;
        case 3:
            System.out.println("Tareas agregadas:");
            listaAleatoriaT.display();
            break;
        case 4:
            return;
        }
    }
}
