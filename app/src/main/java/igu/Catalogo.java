package igu;

import arbol.ArbolBusqueda;
import arbol.Libro;
import javax.swing.JTextArea;

public class Catalogo {

    ArbolBusqueda arbol = new ArbolBusqueda();
    Libro[] libros = {
        new Libro("El señor de los anillos", "J.R.R. Tolkien", 1001),
        new Libro("Cien años de soledad", "Gabriel García Márquez", 1002),
        new Libro("1984", "George Orwell", 1003),
        new Libro("El código Da Vinci", "Dan Brown", 1004),
        new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 1005),
        new Libro("Crónica de una muerte anunciada", "Gabriel García Márquez", 1006),
        new Libro("Orgullo y prejuicio", "Jane Austen", 1007),
        new Libro("El principito", "Antoine de Saint-Exupéry", 1008),
        new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", 1009),
        new Libro("Los juegos del hambre", "Suzanne Collins", 1010),
        new Libro("Fahrenheit 451", "Ray Bradbury", 1011),
        new Libro("Matar a un ruiseñor", "Harper Lee", 1012),
        new Libro("El alquimista", "Paulo Coelho", 1013),
        new Libro("Juego de tronos", "George R.R. Martin", 1014),
        new Libro("La sombra del viento", "Carlos Ruiz Zafón", 1015),
        new Libro("El nombre del viento", "Patrick Rothfuss", 1016),
        new Libro("La casa de los espíritus", "Isabel Allende", 1017),
        new Libro("La chica del tren", "Paula Hawkins", 1018),
        new Libro("La historia interminable", "Michael Ende", 1019),
        new Libro("Divergente", "Veronica Roth", 1020)
    };

    public Catalogo() {
        for(Libro libro : libros){
            arbol.agregar(libro);
        }
    }
    
    public Boolean agregarLibro(Libro libro){
        return arbol.agregar(libro);
    }
    
    public Libro buscarLibro(int isbn){
        return arbol.buscar(isbn);
    }
    
    public void mostrarLibros(JTextArea area){
        arbol.mostrarEnOrden(area);
    }
    
    public boolean eliminarLibro(int isbn){
        return arbol.eliminar(isbn);
    }
}
