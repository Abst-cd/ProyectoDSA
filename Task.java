public class Task {
    public enum Prioridad {
        ALTA, MEDIA, BAJA //enum para tener distintos tipos de prioridad
    }

    int id;
    String descripcionCorta; //atributos
    Prioridad prioridad;

    public Task(int id, String descripcionCorta,  Prioridad prioridad) {
        this.id = id;
        this.descripcionCorta = descripcionCorta;
        this.prioridad = prioridad;
    } //constructor
    @Override 
    public String toString(){
        return id + " - " + descripcionCorta + " - " + prioridad;
    }
}