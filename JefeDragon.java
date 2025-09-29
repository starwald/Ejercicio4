public class JefeDragon extends Dragon {
    public JefeDragon(String nombre) {
        super(nombre);
        this.puntosDeVida = 400;
        this.puntosDeVidaMaximos = 400;
        this.poderDeAtaqueBase = 55;
    }

    /**
     * Habilidad especial del jefe dragón que inflige un daño catastrófico al objetivo.
     * @param objetivo El combatiente que recibirá el ataque especial.
     * @return Un string describiendo el ataque y el daño infligido.
     */
    public String habilidadJefe(Combatiente objetivo) {
        int danoCatastrofico = (int)(this.poderDeAtaqueBase * 2.5);
        String resultado = "¡" + this.nombre + " invoca una tormenta de fuego sobre "
        + objetivo.getNombre() + "!";
        resultado += "\n" + objetivo.recibirDaño(danoCatastrofico);
        return resultado;
    }


    /**
     * El jefe dragón elige aleatoriamente entre atacar, usar su habilidad especial
     * o usar su habilidad de jefe en su turno.
     * @param objetivo El combatiente objetivo del jefe dragón.
     * @return Un string describiendo la acción realizada.
     */
    @Override
    public String ejecutarTurnoAutomatico(Combatiente objetivo) {
        int eleccion = random.nextInt(3);
        
        switch (eleccion) {
            case 0:
                return atacar(objetivo);
            case 1:
                return habilidadEspecial(objetivo);
            case 2:
                return habilidadJefe(objetivo);
            default:
                return atacar(objetivo);
        }
    }
}
