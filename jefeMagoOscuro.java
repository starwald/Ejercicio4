public class jefeMagoOscuro extends MagoOscuro {
    public jefeMagoOscuro(String nombre) {
        super(nombre);
        this.puntosDeVida = 150;
        this.puntosDeVidaMaximos = 150;
        this.poderDeAtaqueBase = 40;
    }

    /**
     * Habilidad especial del jefe mago oscuro: Maldición Debilitante que reduce
     * el poder de ataque del objetivo en 10 puntos.
     * @param objetivo El combatiente que recibirá la maldición.
     * @return Un string describiendo la habilidad y su efecto.
     */
    public String habilidadJefe(Combatiente objetivo) {
        String resultado = "¡" + this.nombre + " lanza una Maldición Debilitante sobre "
        + objetivo.getNombre() + "!";
        resultado += "\n" + objetivo.recibirReduccionAtaque(10);
        return resultado;
    }

    /**
     * El jefe mago oscuro elige aleatoriamente entre atacar, usar su habilidad especial
     * o usar su habilidad de jefe en su turno.
     * @param objetivo El combatiente objetivo del jefe mago oscuro.
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
