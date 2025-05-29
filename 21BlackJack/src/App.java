import game.Principal;
import interfaces.Command;
import java.util.HashMap;
import java.util.Map;
import utils.Input;


public class App {
    // deifición del mapeador para el menú
    private static final Map<Integer, Command> menuOptions = new HashMap<>();
    // definición de variable de verificación para la entrada
    static boolean entradaValida = false;

    // agregación de opciones en el menú
    static {
        menuOptions.put(0, () -> Salir());
        menuOptions.put(1, () -> Principal.inicio());
    }

    public static void main(String[] args) throws Exception {
        while (!entradaValida) {
            mostrarMenu();
            int opcion = Input.getInt("Opcion: ");

            if (opcion <= 4) {
                entradaValida = false;
                ejecutarOpcion(opcion);
            } else {
                System.out.println("\nOpcion no definida\n");
            }
        }
    }

    private static void Salir() {
        System.out.println("""
                =====================================================
                ================== Gracias por Jugar ================
                ===================== Hasta luego ===================
                =====================================================
                """);
        System.exit(0);
    }

    // Definición del método que contiene el menú
    private static void mostrarMenu() {
        System.out.print("""
                =====================================================
                ==================== Bienvenido a ===================
                =================== 21 Black Jack ===================
                =============== Ingenieria Informatica ==============
                ====================== Grupo SENA ===================
                ================= Cristian S. Narvaez ===============
                =================== Alvaro J. Lopez =================
                ================== J. Aldair Torres =================
                ================== J. Luis Martinez =================
                ================= Ruben D. Velasco B. ===============
                =====================================================
                Menú de Opciones:
                0. Salir
                1. Jugar
                =====================================================
                """);
    }

    // definición del método para ejecutar la opción seleccionada
    private static void ejecutarOpcion(int opcion) {
        Command command = menuOptions.getOrDefault(opcion,
                () -> {
                    // en caso no ser una opción valida, muestra de nuevo el menú de opciones
                    entradaValida = false;
                });
        // ejecuta la opción
        command.execute();
    }
}
