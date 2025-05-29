package game.jugador;

import game.cartas.Carta;
import java.util.ArrayList;

public class Jugador {
    public String nombre;

    ArrayList<Carta> mano = new ArrayList<>();

    public void agregarCarta(Carta carta) {
        if (carta != null) {
            mano.add(carta);
        } else {
            System.out.println("Se intentó agregar una carta nula.");
        }
    }

    public int calcularPuntaje() {
        int suma = 0;
        for (Carta carta : mano) {
            if (carta != null) {
                suma += carta.obtenerValor();
            }
        }
        return suma;
    }

    public void mostrarMano() {
        for (Carta carta : mano) {
            System.out.println("  " + carta);
        }
        System.out.println("Puntaje total: " + calcularPuntaje()+"\n");
    }

}