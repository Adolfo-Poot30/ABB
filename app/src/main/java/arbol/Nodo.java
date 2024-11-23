package arbol;

public class Nodo {
    Libro libro;
    Nodo izquierdo, derecho;
    
    public Nodo(Libro libro){
        this.libro = libro;
        this.izquierdo = null;
        this.derecho = null;
    }
}
