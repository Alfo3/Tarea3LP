public class Piso {
    private boolean centroSansanito;
    private int decision;
    public int numPiso;

    public void curarJugador(Jugador jugador){
        if (centroSansanito){
            for (int i = 0; i < jugador.getEquipo().length; i++) {
                if (jugador.getEquipo()[i] != null) {
                    jugador.getEquipo()[i].setHpActual(jugador.getEquipo()[i].getHpTotal());
                }
            }
            System.out.println("Has curado a todos tus Javaling.");
        } else {
            System.out.println("No hay un centro Sansanito aquí.");
        }
    }

    public void ejecutarDecision(Jugador jugador){
        if (decision == 1){
            System.out.println("Has decidido descansar.");
            curarJugador(jugador);
        } else if (decision == 2){
            System.out.println("Has decidido continuar tu aventura.");
        } else {
            System.out.println("Decisión no válida.");
        }
    }
    
}
