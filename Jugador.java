import java.util.ArrayList;
import java.util.List;

public abstract class Jugador extends Combatiente {
    protected List<Item> inventario;

    public Jugador(String nombre, int puntosDeVida, int poderDeAtaque) {
        super(nombre, puntosDeVida, poderDeAtaque);
        this.inventario = new ArrayList<>();
    }

    protected void agregarItem(Item item) {
        this.inventario.add(item);
    }

    public List<Item> getInventario() {
        return inventario;
    }
}
