import java.util.Scanner;

public class Principal {
    public static void inicio() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a Blackjack versión consola");
        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();

        // Inicializar estructuras
        Baraja baraja = crearBaraja();
        baraja = barajar(baraja);

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
            System.out.print("¿Desea otra carta? (s/n): ");
            String opcion = sc.nextLine();
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
                System.out.println("El dealer toma una carta...");
                Carta nueva = baraja.robarCarta();
                dealer.agregarCarta(nueva);
                historial.push(nueva);
            } else {
                System.out.println("El dealer se planta.");
                break;
            }
        }

        // Resultado
        int pj = jugador.calcularPuntaje();
        int pd = dealer.calcularPuntaje();
        System.out.println("\n--- RESULTADOS ---");
        System.out.println(jugador.nombre + " tiene:");
        jugador.mostrarMano();
        System.out.println("\nDealer tiene:");
        dealer.mostrarMano();

        if ((pj > pd && pj <= 21) || (pd > 21 && pj <= 21)) {
            System.out.println("\n" + jugador.nombre + " gana! 🎉");
        } else if (pj == pd || (pj > 21 && pd > 21)) {
            System.out.println("\nEmpate!");
        } else {
            System.out.println("\nGana el Dealer.");
        }
    }
}
