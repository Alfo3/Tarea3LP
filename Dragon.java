public class Dragon extends Javaling{

    public Dragon(String nombre){
        super(nombre);
        inicializarStats();
    }

    @Override
    public void inicializarStats(){
        this.setHpBase(65 + (int)(Math.random() * 11) );
        this.setVelocidad(1 + (int)(Math.random() * 398));
        Movimiento[] movi = new Movimiento[4];
        movi[0] = new Movimiento("Cola dragón", 100, 95, Tipo.DRAGON, false);
        movi[1] = new Movimiento("Aguijón dragón", 50, 100, Tipo.DRAGON, false);
        movi[2] = new Movimiento("Danza dragón", 0, 100, Tipo.DRAGON, true);

        if(getNivel() < 7){
            int chance = 1 + (int)(Math.random() * 100);
            if(chance > 50){
                movi[3] = new Movimiento("Draco Meteor", 120, 80, Tipo.DRAGON, false);
            }
        }
        setMovimientos(movi);
        setMovimientos(movi);
        setNivel(5);
        setHpTotal(getHpBase());
        setHpActual(getHpTotal());
        setTipo(Tipo.DRAGON);
    }
}
