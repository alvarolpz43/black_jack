package game;

import game.cartas.Baraja;
import game.cartas.Carta;
import game.cola.ColaTurnos;
import game.jugador.Jugador;
import game.nodo.NodoDecision;
import game.pila.PilaCartas;
import game.tablaHash.TablaHashJugadores;
import utils.Input;

public class Principal {

    public static void inicio() {

        try {

            String nombre = Input.getString("Ingrese su nombre: ");

            // Inicializar estructuras
            Baraja baraja = new Baraja();

            PilaCartas historial = new PilaCartas();
            ColaTurnos turnos = new ColaTurnos();
            TablaHashJugadores jugadores = new TablaHashJugadores();

            // Crear jugador y dealer
            Jugador jugador = new Jugador();
            jugador.nombre = nombre;
            Jugador dealer = new Jugador();
            dealer.nombre = "Dealer";
            jugadores.agregar(jugador);
            jugadores.agregar(dealer);

            // Gestión de turnos
            turnos.encolar(jugador.nombre);
            turnos.encolar("Dealer");

            // Repartir cartas iniciales
            for (int i = 0; i < 2; i++) {
                jugador.agregarCarta(baraja.robarCarta());
                dealer.agregarCarta(baraja.robarCarta());
            }

            // Turno del jugador
            System.out.println("\nTurno de: " + jugador.nombre);
            jugador.mostrarMano();
            while (true) {
                String opcion = Input.getString("¿Desea otra carta? (s/n): ");
                if (opcion.equals("s")) {
                    Carta nueva = baraja.robarCarta();
                    jugador.agregarCarta(nueva);
                    historial.push(nueva);
                    jugador.mostrarMano();
                    if (jugador.calcularPuntaje() > 21)
                        break;
                } else
                    break;
            }

            // Turno del dealer
            System.out.println("\nTurno de: Dealer");
            NodoDecision decision = new NodoDecision(17, "plantarse");
            decision.izquierda = new NodoDecision(0, "pedir");
            while (true) {
                dealer.mostrarMano();
                String accion = decision.decidir(dealer.calcularPuntaje());
                if (accion.equals("pedir")) {
                    System.out.println("\nEl dealer toma una carta...");
                    Carta nueva = baraja.robarCarta();
                    dealer.agregarCarta(nueva);
                    historial.push(nueva);
                } else {
                    System.out.println("El dealer se planta.\n");
                    break;
                }
            }

            // Resultado
            int pj = jugador.calcularPuntaje();
            int pd = dealer.calcularPuntaje();
            System.out.println("""
                    =====================================================
                    ====================== RESULTADOS ===================
                    =====================================================
                    """);

            System.out.println(jugador.nombre + " tiene:");
            jugador.mostrarMano();
            System.out.println("\nDealer tiene:");
            dealer.mostrarMano();

            if ((pj > pd && pj <= 21) || (pd > 21 && pj <= 21)) {
                System.out.println("=====================================================");
                System.out.println("====================== "+jugador.nombre+" ========================");
                System.out.println("====================== ¡GANA! =======================");
                System.out.println("=====================================================\n");
            } else if (pj == pd || (pj > 21 && pd > 21)) {
                System.out.println("""
                    =====================================================
                    ====================== EMPATE =======================
                    =====================================================
                    """);
            } else {
                System.out.println("""
                    =====================================================
                    ====================== DEALER =======================
                    ====================== ¡GANA! =======================
                    =====================================================
                    """);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
