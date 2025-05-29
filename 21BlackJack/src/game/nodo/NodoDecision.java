package game.nodo;
public class NodoDecision {
    int umbral;
    String accion;
    public NodoDecision izquierda, derecha;

    public NodoDecision(int umbral, String accion) {
        this.umbral = umbral;
        this.accion = accion;
    }

    public String decidir(int puntaje) {
        if (puntaje < umbral && izquierda != null)
            return izquierda.decidir(puntaje);
        else if (derecha != null)
            return derecha.decidir(puntaje);
        return accion;
    }
}