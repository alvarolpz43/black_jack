package game.cola;
public class ColaTurnos {
    
    class NodoTurno {
        String nombre;
        NodoTurno siguiente;
        NodoTurno(String nombre) { this.nombre = nombre; }
    }

    private NodoTurno frente, fin;

    public void encolar(String nombre) {
        NodoTurno nuevo = new NodoTurno(nombre);
        if (fin != null) fin.siguiente = nuevo;
        fin = nuevo;
        if (frente == null) frente = nuevo;
    }

    public String desencolar() {
        if (frente == null) return null;
        String nombre = frente.nombre;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        return nombre;
    }
}