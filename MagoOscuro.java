public class MagoOscuro extends Enemigo {
    public MagoOscuro(String nombre) {
        super(nombre, 60, 25);
    }

    /**
     * Habilidad especial del Mago Oscuro: Drenaje de Vida
     * Drena vida del objetivo y se cura a sí mismo con la mitad del daño infligido.
     * @param objetivo El combatiente que recibirá el ataque especial.
     * @return Un string describiendo el ataque, el daño infligido y la curación recibida.
     */
    @Override
    public String habilidadEspecial(Combatiente objetivo) {
        int danoDrenaje = this.poderDeAtaqueBase;
        String resultado = "¡" + this.nombre + " usa Drenaje de Vida sobre " + objetivo.getNombre() + "!";
        resultado += "\n" + objetivo.recibirDaño(danoDrenaje);
        resultado += "\n" + this.recibirCuracion(danoDrenaje / 2);
        return resultado;
    }

    /**
     * El mago oscuro elige aleatoriamente entre atacar o usar su habilidad especial en su turno.
     * @param objetivo El combatiente objetivo del mago oscuro.
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
