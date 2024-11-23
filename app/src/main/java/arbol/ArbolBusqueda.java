package arbol;

import javax.swing.JTextArea;

public class ArbolBusqueda {

    private Nodo raiz;

    // Agregar un libro al árbol, devuelve true si se agrego correctamente
    public Boolean agregar(Libro libro) {
        if(buscarRecursivo(raiz, libro.getIsbn()) != null){
            return false;
        }else{
            raiz = agregarRecursivo(raiz, libro);
            return true;
        }
    }

    private Nodo agregarRecursivo(Nodo actual, Libro libro) {
        if (actual == null) {
            return new Nodo(libro);
        }

        if (libro.getIsbn() < actual.libro.getIsbn()) {
            actual.izquierdo = agregarRecursivo(actual.izquierdo, libro);
        } else if (libro.getIsbn() > actual.libro.getIsbn()) {
            actual.derecho = agregarRecursivo(actual.derecho, libro);
        }
        return actual;
    }

    // Buscar un libro por ISBN
    public Libro buscar(int isbn) {
        return buscarRecursivo(raiz, isbn);
    }

    private Libro buscarRecursivo(Nodo actual, int isbn) {
        if (actual == null) {
            return null;
        }
        if (isbn == actual.libro.getIsbn()) {
            return actual.libro;
        }
        return isbn < actual.libro.getIsbn()
                ? buscarRecursivo(actual.izquierdo, isbn)
                : buscarRecursivo(actual.derecho, isbn);
    }

    // Eliminar un libro por ISBN
    public boolean eliminar(int isbn) {
        if (buscarRecursivo(raiz, isbn) != null) {
            raiz = eliminarRecursivo(raiz, isbn);
            return true;
        } else {
            return false;
        }
    }

    private Nodo eliminarRecursivo(Nodo actual, int isbn) {
        if (actual == null) {
            return null;
        }

        if (isbn == actual.libro.getIsbn()) {
            // Nodo sin hijos o con un solo hijo
            if (actual.izquierdo == null) {
                return actual.derecho;
            }
            if (actual.derecho == null) {
                return actual.izquierdo;
            }

            // Nodo con dos hijos: buscar el sucesor más pequeño
            Libro menor = encontrarMenor(actual.derecho);
            actual.libro = menor;
            actual.derecho = eliminarRecursivo(actual.derecho, menor.getIsbn());
        } else if (isbn < actual.libro.getIsbn()) {
            actual.izquierdo = eliminarRecursivo(actual.izquierdo, isbn);
        } else {
            actual.derecho = eliminarRecursivo(actual.derecho, isbn);
        }
        return actual;
    }

    private Libro encontrarMenor(Nodo actual) {
        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }
        return actual.libro;
    }

    // Mostrar libros en orden (menor a mayor ISBN)
    public void mostrarEnOrden(JTextArea area) {
        mostrarEnOrdenRecursivo(area, raiz);
    }

    private void mostrarEnOrdenRecursivo(JTextArea area, Nodo actual) {
        if (actual != null) {
            mostrarEnOrdenRecursivo(area, actual.izquierdo);
            area.append("" + actual.libro +"\n");
            mostrarEnOrdenRecursivo(area, actual.derecho);
        }
    }
}
