public class Orco extends Enemigo {
    public Orco(String nombre) {
        super(nombre, 80, 20);
    }

    /**
     * Golpe Brutal: Un ataque poderoso que inflige 1.5 veces el daño base.
     * @param objetivo El combatiente que recibirá el ataque especial.
     * @return Un string describiendo el ataque y el daño infligido.
     */
    @Override
    public String habilidadEspecial(Combatiente objetivo) {
        int danoEspecial = (int)(this.poderDeAtaqueBase * 1.5);
        String resultado = "¡" + this.nombre + " usa Golpe Brutal contra " + objetivo.getNombre() + "!";
        resultado += "\n" + objetivo.recibirDaño(danoEspecial);
        return resultado;
    }

    /**
     * El orco elige aleatoriamente entre atacar o usar su habilidad especial en su turno.
     * @param objetivo El combatiente objetivo del orco.
     * @return Un string describiendo la acción realizada.
     */
    public String ejecutarTurnoAutomatico(Combatiente objetivo) {
        int eleccion = random.nextInt(3);
        
        switch (eleccion) {
            case 0:
                return atacar(objetivo);
            case 1:
                return habilidadEspecial(objetivo);
            default:
                return atacar(objetivo);
        }
    }
}
