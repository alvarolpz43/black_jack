class NodoDecision {
    int umbral;
    String accion;
    NodoDecision izquierda, derecha;

    NodoDecision(int umbral, String accion) {
        this.umbral = umbral;
        this.accion = accion;
    }

    String decidir(int puntaje) {
        if (puntaje < umbral && izquierda != null)
            return izquierda.decidir(puntaje);
        else if (derecha != null)
            return derecha.decidir(puntaje);
        return accion;
    }
}