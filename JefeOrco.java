public class JefeOrco extends Orco {
    private boolean gritoUsado = false;

    public JefeOrco(String nombre) {
        super(nombre);
        this.puntosDeVida = 200;
        this.puntosDeVidaMaximos = 200;
        this.poderDeAtaqueBase = 35;
    }

    /**
     * Habilidad especial del Jefe Orco: Grito de guerra que aumenta su 
     * poder de ataque en 15 puntos.
     * @return Un string describiendo la habilidad y su efecto.
     */
    public String habilidadJefe() {
        if (!gritoUsado) {
            this.gritoUsado = true;
            this.poderDeAtaqueBase += 15;
            return this.nombre + " lanza un grito de guerra, aumentando su poder de ataque a " 
            + this.poderDeAtaqueBase + "!";
        }
        else {
            return this.nombre + " ya ha usado su grito de guerra y no puede usarlo de nuevo.";
        }
    }

    /**
     * El jefe orco elige aleatoriamente entre atacar, usar su habilidad especial
     * o usar su habilidad de jefe en su turno.
     * @param objetivo El combatiente objetivo del jefe orco.
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
                return habilidadJefe();
            default:
                return atacar(objetivo);
        }
    }
}
