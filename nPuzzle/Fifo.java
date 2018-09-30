package nPuzzle;

public class Fifo {

    private Fifo prox,ante;
    private Matriz matriz;

    public Fifo(Fifo prox, Matriz matriz) {
        this.prox = prox;
        this.matriz = matriz;
    }

    public Fifo(Fifo prox,Fifo ante, Matriz matriz) {
        this.prox = prox;
        this.ante=ante;
        this.matriz = matriz;
    }

    public Fifo(){}

    public Fifo getProx() {
        return prox;
    }

    public void setProx(Fifo prox) {
        this.prox = prox;
    }

    public Fifo getAnte() {
        return ante;
    }

    public void setAnte(Fifo ante) {
        this.ante = ante;
    }

    public Matriz getMatriz() {
        return matriz;
    }

    public void setMatriz(Matriz matriz) {
        this.matriz = matriz;
    }
}
