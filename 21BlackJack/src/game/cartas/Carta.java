package game.cartas;

public class Carta {
    private String numero;
    private String palo;
    public Carta siguiente;
    public Carta anterior;

    public Carta(String numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public int obtenerValor() {
        return switch (numero) {
            case "A" -> 11;
            case "J", "Q", "K" -> 10;
            default -> Integer.parseInt(numero);
        };
    }

    @Override
    public String toString() {
        return numero + " de " + palo;
    }
}
