class PilaCartas {
    private NodoCarta cima;

    class NodoCarta {
        Carta carta;
        NodoCarta siguiente;
        NodoCarta(Carta carta) { this.carta = carta; }
    }

    void push(Carta carta) {
        NodoCarta nodo = new NodoCarta(carta);
        nodo.siguiente = cima;
        cima = nodo;
    }

    Carta peek() {
        return cima != null ? cima.carta : null;
    }
}