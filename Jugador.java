import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private List<Objeto> bolsa;
    private Javaling[] equipo;
    private Piso pisoActual;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.bolsa = new ArrayList<>();
        this.equipo = new Javaling[6];
        this.pisoActual = new Piso();
    }

    public void usarObjeto(Objeto item) {
        if (bolsa.contains(item)) {
            System.out.println("Has usado el objeto: " + item);
            bolsa.remove(item);

        }
        else {
            System.out.println("No tienes este objeto en tu bolsa.");
        }

    }
    
    public void mostrarStats(int Indice){
        Javaling javaling = equipo[Indice];
        if (javaling != null) {
            System.out.println("Nombre: " + javaling.getNombre());
            System.out.println("HP Total: " + javaling.getHpTotal());
            System.out.println("Velocidad: " + javaling.getVelocidad());
            System.out.println("Movimientos: ");
            for (Movimiento movimiento : javaling.getMovimientos()) {
                if (movimiento != null) {
                    System.out.println("- " + movimiento.getNombre() + " (Potencia: " + movimiento.getPotencia() + ", Tipo: " + movimiento.getTipo() + ")");
                }
            }
        } else {
            System.out.println("No tienes un Javaling en esta posición.");
        }
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Objeto> getBolsa() {
        return bolsa;
    }

    public void setBolsa(List<Objeto> bolsa) {
        this.bolsa = bolsa;
    }

    public Javaling[] getEquipo() {
        return equipo;
    }

    public void setEquipo(Javaling[] equipo) {
        this.equipo = equipo;
    }

    public Piso getPisoActual() {
        return pisoActual;
    }

    public void setPisoActual(Piso pisoActual) {
        this.pisoActual = pisoActual;
    }

}
