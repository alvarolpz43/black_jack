class Jugador {
    String nombre;
    Carta[] mano = new Carta[10];
    int cartasEnMano = 0;

    void agregarCarta(Carta carta) {
        mano[cartasEnMano++] = carta;
    }

    int calcularPuntaje() {
        int total = 0, ases = 0;
        for (int i = 0; i < cartasEnMano; i++) {
            int valor = mano[i].obtenerValor();
            total += valor;
            if (mano[i].numero.equals("A")) ases++;
        }
        while (total > 21 && ases > 0) {
            total -= 10;
            ases--;
        }
        return total;
    }

    void mostrarMano() {
        for (int i = 0; i < cartasEnMano; i++) {
            System.out.println("  " + mano[i]);
        }
        System.out.println("Puntaje: " + calcularPuntaje());
    }
}