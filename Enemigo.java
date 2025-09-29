import java.util.Random;

public abstract class Enemigo extends Combatiente {
    protected Random random = new Random();
    public Enemigo(String nombre, int puntosDeVida, int poderDeAtaque) {
        super(nombre, puntosDeVida, poderDeAtaque);
    }

    public abstract String habilidadEspecial(Combatiente objetivo);

    /**
     * Ejecuta el turno del enemigo de manera automática.
     * @param objetivo El combatiente objetivo del enemigo.
     * @return Un string describiendo la acción realizada (ataque normal o habilidad especial).
     */
    public String ejecutarTurnoAutomatico(Combatiente objetivo) {
        if (random.nextDouble() < 0.3) {
            return habilidadEspecial(objetivo);
        } else {
            return atacar(objetivo);
        }
    }
}
