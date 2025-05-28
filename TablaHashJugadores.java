class TablaHashJugadores {
    Jugador[] tabla = new Jugador[10];

    int hash(String nombre) {
        int h = 0;
        for (char c : nombre.toCharArray()) h += c;
        return h % tabla.length;
    }

    void agregar(Jugador jugador) {
        int idx = hash(jugador.nombre);
        tabla[idx] = jugador;
    }

    Jugador obtener(String nombre) {
        return tabla[hash(nombre)];
    }
}
