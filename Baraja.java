class Baraja {
    Carta cabeza;

    void agregarCarta(Carta carta) {
        if (cabeza == null) {
            cabeza = carta;
        } else {
            Carta temp = cabeza;
            while (temp.siguiente != null) temp = temp.siguiente;
            temp.siguiente = carta;
        }
    }

    Carta robarCarta() {
        if (cabeza == null) return null;
        Carta robada = cabeza;
        cabeza = cabeza.siguiente;
        return robada;
    }
}