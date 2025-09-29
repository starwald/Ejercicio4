public class Guerrero extends Jugador {
    public Guerrero(String nombre) {
        super(nombre, 150, 25);
        this.agregarItem(new Item("Pocion Curativa", 5, 40, 0));
    }
}
