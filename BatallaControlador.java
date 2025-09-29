// Archivo: src/BatallaControlador.java
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BatallaControlador {
    // CAMBIO: De un solo jugador a una lista de jugadores
    private List<Jugador> jugadores;
    private List<Enemigo> enemigos;
    private List<Combatiente> ordenDeTurno;
    private int turnoActual = 0;

    /**
     * CAMBIO: El constructor ahora acepta una lista de jugadores.
     */
    public BatallaControlador(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.enemigos = new ArrayList<>();
        this.ordenDeTurno = new ArrayList<>();
        
        int numEnemigos = 3;
        Random random = new Random();
        for (int i = 0; i < numEnemigos; i++) {
            // ... (lógica de creación de enemigos sin cambios)
            int tipoEnemigo = random.nextInt(3);
            switch (tipoEnemigo) {
                case 0: enemigos.add(new Orco("Orco #" + (i + 1))); break;
                case 1: enemigos.add(new MagoOscuro("Mago Oscuro #" + (i + 1))); break;
                case 2: enemigos.add(new Dragon("Dragón #" + (i + 1))); break;
            }
        }
        
        // CAMBIO: Añadimos a todos los jugadores al orden de turno
        ordenDeTurno.addAll(jugadores);
        ordenDeTurno.addAll(enemigos);
    }

    /**
     * El turno del enemigo ahora elige un objetivo aleatorio de los jugadores vivos.
     */
    public String ejecutarTurnoEnemigo() {
        Enemigo enemigoActual = (Enemigo) getCombatienteActual();

        // CAMBIO: Lógica para elegir un objetivo
        List<Jugador> jugadoresVivos = jugadores.stream().filter(Combatiente::estaVivo).collect(Collectors.toList());
        if (jugadoresVivos.isEmpty()) {
            return enemigoActual.getNombre() + " no tiene a quién atacar.";
        }
        Jugador objetivo = jugadoresVivos.get(new Random().nextInt(jugadoresVivos.size()));
        
        String resultado = enemigoActual.ejecutarTurnoAutomatico(objetivo);
        
        siguienteTurno();
        return resultado;
    }

    /**
     * La condición de fin de batalla ahora comprueba si todo el equipo ha caído.
     */
    public boolean batallaTerminada() {
        // La batalla termina si no quedan jugadores vivos o no quedan enemigos
        boolean jugadoresDerrotados = jugadores.stream().noneMatch(Combatiente::estaVivo);
        return jugadoresDerrotados || enemigos.isEmpty();
    }

    // --- Métodos sin cambios mayores ---
    
    public String ejecutarAccionJugador(int accion, int objetivoIdx, int itemIdx) {
        // La lógica interna sigue siendo válida porque opera sobre el 'combatienteActual'
        String resultado = "";
        Jugador j = (Jugador) getCombatienteActual();
        List<Combatiente> objetivosEnemigos = new ArrayList<>(this.enemigos);
        
        switch(accion){
            case 1:
                if (objetivoIdx >= 0 && objetivoIdx < objetivosEnemigos.size()) {
                    resultado = j.atacar(objetivosEnemigos.get(objetivoIdx));
                } else { resultado = "Objetivo inválido."; }
                break;
            case 2:
                if (itemIdx >= 0 && itemIdx < j.getInventario().size()) {
                    Item item = j.getInventario().get(itemIdx);
                    resultado = item.usar(j); 
                } else { resultado = "Item inválido."; }
                break;
            case 3:
                resultado = j.getNombre() + " pasa el turno.";
                break;
            default:
                resultado = "Acción desconocida. Se pasa el turno.";
                break;
        }
        siguienteTurno();
        return resultado;
    }
    
    private void siguienteTurno() {
        this.jugadores.removeIf(p -> !p.estaVivo());
        this.enemigos.removeIf(e -> !e.estaVivo());
        this.ordenDeTurno.removeIf(c -> !c.estaVivo());
        
        if (!ordenDeTurno.isEmpty()) {
            turnoActual = (turnoActual + 1) % ordenDeTurno.size();
        }
    }
    
    public Combatiente getCombatienteActual() { return ordenDeTurno.get(turnoActual); }
    public String getResultadoFinal() { if (enemigos.isEmpty()) return "¡VICTORIA!"; else return "TU EQUIPO HA SIDO DERROTADO."; }
    public List<Combatiente> getListaJugadores() { return new ArrayList<>(jugadores); }
    public List<Combatiente> getListaEnemigos() { return new ArrayList<>(enemigos); }
}