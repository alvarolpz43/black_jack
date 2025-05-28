class Carta {
    String numero;
    String palo;
    Carta siguiente;

    Carta(String numero, String palo) {
        this.numero = numero;
        this.palo = palo;
        this.siguiente = null;
    }

    int obtenerValor() {
        switch (numero) {
            case "A": return 11;
            case "J": case "Q": case "K": return 10;
            default: return Integer.parseInt(numero);
        }
    }

    public String toString() {
        return numero + " de " + palo;
    }
}
