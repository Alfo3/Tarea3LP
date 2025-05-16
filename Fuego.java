public class Fuego extends Javaling{    
    private int enLlamas; // al llegar a 3 ataques de potencia > 0 se activa el boost de ataque


    public Fuego(String nombre){ 
        super(nombre);
        inicializarStats();
        }

    public int getEnLlamas() {
        return enLlamas;
    }

    public void setEnLlamas(int enLlamas) {
        this.enLlamas = enLlamas;
    }

    @Override
    public void inicializarStats(){
        this.setHpBase(55 + (int)(Math.random() * 11) );
        this.setVelocidad(1 + (int)(Math.random() * 398));
        Movimiento[] movi = new Movimiento[4];
        movi[0] = new Movimiento("Lanzallamas", 100, 95, Tipo.FUEGO, false);
        movi[1] = new Movimiento("Quemadura", 50, 100, Tipo.FUEGO, false);
        movi[2] = new Movimiento("Giro fuego", 0, 100, Tipo.FUEGO, true);

        if (getNivel() < 7){
            int chance = 1 + (int)(Math.random() * 100);
            if(chance > 50){
                movi[3] = new Movimiento("Fuego sagrado", 100, 85, Tipo.DRAGON, false);
            }
        }
        setMovimientos(movi);
        setMovimientos(movi);
        setNivel(5);
        setHpTotal(getHpBase());
        setHpActual(getHpTotal());
        setTipo(Tipo.FUEGO);

    }
    
}
