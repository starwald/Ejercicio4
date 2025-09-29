public class Explorador extends Jugador {
    public Explorador(String nombre) {
        super(nombre, 100, 15);
        this.agregarItem(new Item("Pocion Curativa", 6, 40, 0));
        this.agregarItem(new Item("Pocion de Fuerza", 2, 0, 15));
    }
}
