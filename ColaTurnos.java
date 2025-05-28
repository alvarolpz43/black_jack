class ColaTurnos {
    class NodoTurno {
        String nombre;
        NodoTurno siguiente;
        NodoTurno(String nombre) { this.nombre = nombre; }
    }

    private NodoTurno frente, fin;

    void encolar(String nombre) {
        NodoTurno nuevo = new NodoTurno(nombre);
        if (fin != null) fin.siguiente = nuevo;
        fin = nuevo;
        if (frente == null) frente = nuevo;
    }

    String desencolar() {
        if (frente == null) return null;
        String nombre = frente.nombre;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        return nombre;
    }
}