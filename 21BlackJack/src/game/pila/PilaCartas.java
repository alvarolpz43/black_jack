package game.pila;

import game.cartas.Carta;

public class PilaCartas {
    private NodoCarta cima;

    class NodoCarta {
        public Carta carta;
        public NodoCarta siguiente;
        NodoCarta(Carta carta) { this.carta = carta; }
    }

    public void push(Carta carta) {
        NodoCarta nodo = new NodoCarta(carta);
        nodo.siguiente = cima;
        cima = nodo;
    }

    public Carta peek() {
        return cima != null ? cima.carta : null;
    }
}