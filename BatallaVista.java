import java.util.List;

public class BatallaVista {
    public String generarEstado(List<Combatiente> jugadores, List<Combatiente> enemigos) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Estado de la Batalla ---\n");
        sb.append("== Jugadores ==\n");
        for (Combatiente j : jugadores) sb.append(j.toString()).append("\n");
        sb.append("\n== Enemigos ==\n");
        for (Combatiente e : enemigos) sb.append(e.toString()).append("\n");
        sb.append("----------------------------\n");
        return sb.toString();
    }

    public String generarMenuAcciones(String nombreCombatiente, boolean esJugador) {
        StringBuilder sb = new StringBuilder();
        sb.append("Turno de: ").append(nombreCombatiente).append("\n");
        sb.append("Seleccione una acción:\n");
        sb.append("1. Atacar\n");
        if (esJugador) {
            sb.append("2. Usar Item\n");
        } else {
            sb.append("2. Habilidad Especial\n");
        }
        sb.append("3. Pasar Turno\n");
        return sb.toString();
    }

    public String generarListaObjetivos(List<Combatiente> posiblesObjetivos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < posiblesObjetivos.size(); i++) {
            sb.append((i + 1)).append(". ").append(posiblesObjetivos.get(i).getNombre()).append("\n");
        }
        return sb.toString();
    }

    public String generarListaItems(List<Item> items) {
        if (items.isEmpty()) return "No tienes items disponibles. \n";
        StringBuilder sb = new StringBuilder("Elige un item:\n");
        for (int i = 0; i < items.size(); i++) {
            sb.append((i + i)).append(". ").append(items.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}
