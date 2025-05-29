package game.cartas;

import java.util.ArrayList;
import java.util.Collections;

public final class Baraja {
    private Carta cabeza;
    private Carta cola;

    public Baraja() {
        crearBaraja();
        System.out.println("\n(Se terminó de crear la baraja)");
    }

    public void imprimirBaraja() {
        Carta actual = cabeza;
        int contador = 0;
        while (actual != null) {
            System.out.println("[" + (++contador) + "] " + actual);
            actual = actual.siguiente;
        }
    }

    public void crearBaraja() {
        String[] palos = { "Corazones", "Diamantes", "Tréboles", "Picas" };
        String[] valores = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

        for (String palo : palos) {
            for (String valor : valores) {
                Carta nueva = new Carta(valor, palo);
                agregarCartaAlFinal(nueva);
            }
        }

        barajar(); // Si quieres barajar luego
    }

    private void agregarCartaAlFinal(Carta carta) {
        if (carta == null)
            return;

        if (cabeza == null) {
            cabeza = carta;
            cola = carta;
        } else {
            cola.siguiente = carta;
            carta.anterior = cola;
            cola = carta;
        }
    }

    public Carta robarCarta() {
        if (cabeza == null) {
            System.out.println("No hay cartas para robar.");
            return null;
        }
        Carta robada = cabeza;
        cabeza = cabeza.siguiente;
        if (cabeza != null) {
            cabeza.anterior = null;
        } else {
            cola = null; // La lista quedó vacía
        }
        return robada;
    }

    public void barajar() {
        ArrayList<Carta> cartas = new ArrayList<>();
        Carta actual = cabeza;
        while (actual != null) {
            cartas.add(actual);
            actual = actual.siguiente;
        }

        Collections.shuffle(cartas);

        // Reconstruir la lista doblemente enlazada
        cabeza = null;
        cola = null;
        for (Carta c : cartas) {
            c.siguiente = null;
            c.anterior = null;
            agregarCartaAlFinal(c);
        }
    }

}
