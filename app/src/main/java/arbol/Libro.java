package arbol;

public class Libro {

    private String nombre;
    private String autor;
    private int isbn;

    public Libro(){
        
    }
    public Libro(String nombre, String autor, int isbn) {
        this.nombre = nombre;
        this.autor = autor;
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "{"
                + "nombre='" + nombre + '\''
                + ", autor='" + autor + '\''
                + ", isbn=" + isbn
                + '}';
    }
}
