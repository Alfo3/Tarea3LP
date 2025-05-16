public class Planta extends Javaling{

    public Planta(String nombre){
        super(nombre);

        inicializarStats();
        }
    
    @Override
    public void inicializarStats() {
        this.setHpBase(60 + (int)(Math.random() * 11) );
        this.setVelocidad(1 + (int)(Math.random() * 398));
        Movimiento[] movi = new Movimiento[4];
        movi[0] = new Movimiento("Hoja afilada", 100, 95, Tipo.PLANTA, false);
        movi[1] = new Movimiento("Golpe floral", 50, 100, Tipo.PLANTA, false);
        movi[2] = new Movimiento("Overgrowth", 0, 100, Tipo.PLANTA, true);

        if(getNivel() < 7){
            int chance = 1 + (int)(Math.random() * 100);
            if(chance > 50){
                movi[3] = new Movimiento("Hoja sagrada", 100, 85, Tipo.DRAGON, false);
            }
        }
        setMovimientos(movi);
        setMovimientos(movi);
        setNivel(5);
        setHpTotal(getHpBase());
        setHpActual(getHpTotal());
        setTipo(Tipo.PLANTA);
    }
}
