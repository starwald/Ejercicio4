// Archivo: src/Principal.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        
        List<Jugador> equipoJugadores = new ArrayList<>();
        System.out.println("¡Forma tu equipo de 3 héroes!");

        for (int i = 0; i < 3; i++) {
            System.out.println("\n--- Configurando Héroe " + (i + 1) + " ---");
            System.out.println("Elige una clase:\n1. Guerrero\n2. Explorador\n3. Arquero");
            int clase = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println("Ingresa el nombre del héroe:");
            String nombre = scanner.nextLine();
            
            Jugador nuevoJugador;
            switch (clase) {
                case 1: nuevoJugador = new Guerrero(nombre); break;
                case 2: nuevoJugador = new Explorador(nombre); break;
                case 3: nuevoJugador = new Arquero(nombre); break;
                default:
                    System.out.println("Opción no válida. Se asignará Guerrero por defecto.");
                    nuevoJugador = new Guerrero(nombre);
                    break;
            }
            equipoJugadores.add(nuevoJugador);
        }

        BatallaControlador controlador = new BatallaControlador(equipoJugadores);
        BatallaVista vista = new BatallaVista();
        System.out.println("\n¡QUE COMIENCE LA BATALLA!\n");

        while (!controlador.batallaTerminada()) {
            System.out.println(vista.generarEstado(controlador.getListaJugadores(), controlador.getListaEnemigos()));
            
            Combatiente combatienteActual = controlador.getCombatienteActual();
            String resultadoDeAccion = "";
            
            if (combatienteActual instanceof Jugador) {
                System.out.println(vista.generarMenuAcciones(combatienteActual.getNombre(), true));
                int accion = scanner.nextInt();
                
                int objetivoIdx = 0;
                int itemIdx = 0;

                if (accion == 1) {  
                    System.out.println(vista.generarListaObjetivos(controlador.getListaEnemigos()));
                    objetivoIdx = scanner.nextInt() - 1;
                } else if (accion == 2) {
                    System.out.println(vista.generarListaItems(((Jugador) combatienteActual).getInventario()));
                    itemIdx = scanner.nextInt() - 1;
                }
                
                resultadoDeAccion = controlador.ejecutarAccionJugador(accion, objetivoIdx, itemIdx);
                
            } else {
                System.out.println("Turno de: " + combatienteActual.getNombre());
                Thread.sleep(1000); 
                resultadoDeAccion = controlador.ejecutarTurnoEnemigo();
            }
            
            System.out.println("\n" + resultadoDeAccion + "\n");
            Thread.sleep(1500); 
        }

        System.out.println("===== FIN DE LA BATALLA =====");
        System.out.println(controlador.getResultadoFinal());
        scanner.close();
    }
}