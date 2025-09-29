public class Item {
    private String nombre;
    private int cantidad;
    private int puntosDeVidaRestaurados;
    private int aumentoDeAtaque;

    public Item(String nombre, int cantidad, int puntosDeVidaRestaurados, int aumentoDeAtaque) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.puntosDeVidaRestaurados = puntosDeVidaRestaurados;
        this.aumentoDeAtaque = aumentoDeAtaque;
    }

    public String usar(Combatiente objetivo) {
        if (this.cantidad <= 0) {
            return "No quedan " + this.nombre + " disponibles.";
        }

        this.cantidad--;
        String resultado = objetivo.getNombre();

        if (puntosDeVidaRestaurados > 0) {
            resultado += objetivo.recibirCuracion(puntosDeVidaRestaurados);
        }
        if (aumentoDeAtaque > 0) {
            objetivo.aplicarAumentoAtaque(aumentoDeAtaque);
            resultado += "\n" + objetivo.getNombre() + " ha aumentado su ataque";
        }
        return "Se ha usado " + this.nombre + " en " + objetivo.getNombre() + ".\n" + resultado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    /**
     * Representa el item en formato de cadena.
     * @return Una cadena con el nombre del item y la cantidad disponible.
     */
    @Override
    public String toString() {
        return nombre + " (x" + cantidad + ")";
    }
}
