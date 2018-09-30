package nPuzzle;

public class Matriz {

    private int estado[][];
    private int linha,coluna;

    public Matriz(int[][] estado, int linha, int coluna) {
        this.estado = estado;
        this.linha = linha;
        this.coluna = coluna;
    }

    public Matriz(){}

    public int[][] getEstado() {
        return estado;
    }

    public void setEstado(int[][] estado) {
        this.estado = estado;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
}
