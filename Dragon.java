public class Dragon extends Enemigo {
    public Dragon(String nombre) {
        super(nombre, 100, 35);
    }

    /**
     * El dragón utiliza su aliento para atacar a un objetivo, 
     * infligiendo daño igual a su poder de ataque base.
     * @param objetivo El combatiente que recibirá el ataque especial.
     * @return Un string describiendo el ataque y el daño infligido.
     */
    @Override
    public String habilidadEspecial(Combatiente objetivo) {
        int danoEspecial = this.poderDeAtaqueBase * 2;
        String resultado = "¡" + this.nombre + " desata un torrente de fuego sobre " + objetivo.getNombre() + "!";
        resultado += "\n" + objetivo.recibirDaño(danoEspecial);
        return resultado;
    }

    /**
     * El dragón elige aleatoriamente entre atacar o usar su habilidad especial en su turno.
     * @param objetivo El combatiente objetivo del dragón.
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
