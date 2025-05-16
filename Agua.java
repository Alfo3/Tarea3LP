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
        this.setHpBase(50 + (int)(Math.random() * 11) );
        this.setVelocidad(1 + (int)(Math.random() * 398));
        Movimiento[] movi = new Movimiento[4];
        movi[0] = new Movimiento("Pistola agua", 100, 95, Tipo.AGUA, false);
        movi[1] = new Movimiento("Aqua jet", 50, 100, Tipo.AGUA, false);
        movi[2] = new Movimiento("Refugio", 0, 100, Tipo.AGUA, true);

        if(getNivel() < 7){
            int chance = 1 + (int)(Math.random() * 100);
            if(chance > 50){
                movi[3] = new Movimiento("Surging strike", 100, 85, Tipo.DRAGON, false);
            }
        }
        setMovimientos(movi);
        setNivel(5);
        setHpTotal(getHpBase());
        setHpActual(getHpTotal());
        setTipo(Tipo.AGUA);


    }
}
