public class Agua extends Javaling{
    static{
        Javaling.setHpBase(55 + (int)(Math.random() * 6)); // HP base entre 55 y 60
    }

    private boolean olaje; // True si recibio daño el turno pasado, false si no

    
    public Agua(String nombre){
        super(nombre);
        inicializarStats();
    }

    public boolean isOlaje() {
        return olaje;
    }

    public void setOlaje(boolean olaje) {
        this.olaje = olaje;
    }

    @Override
    public void inicializarStats() {
    }
}
