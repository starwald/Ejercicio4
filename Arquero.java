public class Arquero extends Jugador {
    public Arquero(String nombre) {
        super(nombre, 80, 15);
        this.agregarItem(new Item("Pocion Curativa", 3, 40, 0));
        this.agregarItem(new Item("Flecha de Fuego", 5, 0, 20));
    }
}
