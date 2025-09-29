public abstract class Combatiente {
    protected String nombre;
    protected int puntosDeVida;
    protected int puntosDeVidaMaximos;
    protected int poderDeAtaqueBase;
    protected int aumentoAtaqueTemporal;

    public Combatiente(String nombre, int puntosDeVida, int poderDeAtaque) {
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
        this.puntosDeVidaMaximos = puntosDeVida;
        this.poderDeAtaqueBase = poderDeAtaque;
        this.aumentoAtaqueTemporal = 0;
    }

    public String atacar(Combatiente objetivo) {
        int ataqueTotal = this.poderDeAtaqueBase + this.aumentoAtaqueTemporal;
        String resultadoAtaque = this.nombre + " ataca a " + objetivo.getNombre() + ".";
        String resultadoDaño = objetivo.recibirDaño(ataqueTotal);
        this.aumentoAtaqueTemporal = 0;
        return resultadoAtaque + "\n" + resultadoDaño;
    }

    public String recibirDaño(int daño) {
        this.puntosDeVida -= daño;
        if (this.puntosDeVida < 0) this.puntosDeVida = 0;
        return this.nombre + " recibe " + daño + " puntos de daño.";
    }

    public String recibirCuracion(int curacion) {
        this.puntosDeVida += curacion;
        if (this.puntosDeVida > this.puntosDeVidaMaximos) this.puntosDeVida = this.puntosDeVidaMaximos;
        return this.nombre + " recupera " + curacion + " puntos de vida.";
    }

    public void aplicarAumentoAtaque(int aumento) {
        this.aumentoAtaqueTemporal += aumento;
    }

    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    public int getPoderDeAtaque() {
        return poderDeAtaqueBase + aumentoAtaqueTemporal;
    }

    public String recibirReduccionAtaque(int reduccion) {
        this.poderDeAtaqueBase -= reduccion;
        if (this.poderDeAtaqueBase < 0) {
            this.poderDeAtaqueBase = 0;
        }
        return this.nombre + " siente como su poder de ataque disminuye";
    }


    /**
     * Representación en cadena del combatiente, mostrando su nombre, 
     * puntos de vida actuales y poder de ataque.
     * @return Una cadena con el nombre, puntos de vida y poder de ataque del combat
     */
    @Override
    public String toString() {
        return nombre + " (HP: " + puntosDeVida + "/" + puntosDeVidaMaximos + ", ATK: "
        + getPoderDeAtaque() + ")";
    }
}
