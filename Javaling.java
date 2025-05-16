public abstract class Javaling {
    private String nombre;
    private int hpBase;
    private int velocidad;
    private int hpTotal;
    private int hpActual;
    private int nivel;
    private Tipo tipo;
    private Movimiento[] movimientos;

    public enum Tipo {
        AGUA, FUEGO, PLANTA, DRAGON
    }


    public abstract void inicializarStats();

    public Javaling(String nombre){
        this.nombre = nombre;
        this.movimientos = new Movimiento[4];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHpBase() {
        return hpBase;
    }

    public void setHpBase(int hpBase) {
        this.hpBase = hpBase;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getHpTotal() {
        return hpTotal;
    }

    public void setHpTotal(int hpTotal) {
        this.hpTotal = hpTotal;
    }

    public int getHpActual() {
        return hpActual;
    }

    public void setHpActual(int hpActual) {
        this.hpActual = hpActual;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Movimiento[] getMovimientos(){
        return movimientos;
    }
    
    public void setMovimientos(Movimiento[] movimientos) {
        this.movimientos = movimientos;
    }

    public int atacar(Javaling objetivo, int indiceMovimiento){
        int dano = 0;
        Movimiento movi = movimientos[indiceMovimiento];
        
        dano = ((2 * getNivel() + 2) * movi.getPotencia() * (getHpBase() / 100)) / 50 + 2;

        // Same Type Attack Bonus 
        if (movi.getTipo() == getTipo()){
            dano = (int) (dano * 1.5);
        }

        //aca va la logica de debilidades
        if (movi.getTipo() == Tipo.AGUA && objetivo.getTipo() == Tipo.FUEGO){
            dano = (int) (dano * 2);
        } else if (movi.getTipo() == Tipo.FUEGO && objetivo.getTipo() == Tipo.PLANTA){
            dano = (int) (dano * 2);
        } else if (movi.getTipo() == Tipo.PLANTA && objetivo.getTipo() == Tipo.AGUA){
            dano = (int) (dano * 2);
        } else if (movi.getTipo() == Tipo.DRAGON && objetivo.getTipo() == Tipo.DRAGON){
            dano = (int) (dano * 2);
        }
        //aca va la logica de resistencias
        if (movi.getTipo() == Tipo.AGUA && objetivo.getTipo() == Tipo.PLANTA){
            dano = (int) (dano * 0.5);
        } else if (movi.getTipo() == Tipo.FUEGO && objetivo.getTipo() == Tipo.AGUA){
            dano = (int) (dano * 0.5);
        } else if (movi.getTipo() == Tipo.PLANTA && objetivo.getTipo() == Tipo.FUEGO){
            dano = (int) (dano * 0.5);
        } else if (movi.getTipo() == Tipo.AGUA && objetivo.getTipo() == Tipo.DRAGON){
            dano = (int) (dano * 0.5);
        } else if (movi.getTipo() == Tipo.FUEGO && objetivo.getTipo() == Tipo.DRAGON){
            dano = (int) (dano * 0.5);
        } else if (movi.getTipo() == Tipo.PLANTA && objetivo.getTipo() == Tipo.DRAGON){
            dano = (int) (dano * 0.5);
        }
        //aca la logica de las habilidades de agua y fuego
        if (getTipo() == Tipo.AGUA && this instanceof Agua){
            Agua agua = (Agua) this;
            if (agua.isOlaje()){
                dano = (int) (dano * 1.15);
            }
        }

        if (getTipo() == Tipo.FUEGO && this instanceof Fuego){
            Fuego fuego = (Fuego) this;
            if (fuego.getEnLlamas() >= 3){
                dano = (int) (dano * 1.2);
            }
        }
        
        return dano;
    }

    public void subirNivel(int nivel){

    }
}
