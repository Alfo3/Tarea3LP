public class Agua extends Javaling{
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
        this.setHpTotal(50 + (int)(Math.random() * 11) );
        this.setVelocidad(1 + (int)(Math.random() * 398));
        Movimiento[] movi = new Movimiento[4];
        movi[0] = new Movimiento("Burbuja", 20, 100, "AGUA", false);
        setMovimientos(movi);
    }
}
