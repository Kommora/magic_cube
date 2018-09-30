package nPuzzle;

public class BFS {


    public Fifo fila;
    public Matriz estadoFinal;
    public Util util;

    public BFS(Matriz estadoInicial,Matriz estadoFinal){
        this.fila=new Fifo();
        this.estadoFinal=estadoFinal;
        this.fila.setMatriz(estadoInicial);
        this.util = new Util();
    }

    public void bfs(){
        float nos=0,rami=0,prof1=0,prof2=0;
        long tempoInicio = System.currentTimeMillis();
        Fifo aux = this.fila;
        Fifo fim = new Fifo();
        aux.setProx(fim);
        while (!util.verifica(aux.getMatriz().getEstado(), this.estadoFinal.getEstado())) {
            if (aux.getMatriz().getLinha() > 0) {
                Matriz m = shuffle(aux.getMatriz(), "cima");
                Fifo fifo = new Fifo(null, m);
                nos++;
                if (!verifica(fifo)) {
                    fim.setMatriz(m);
                    fim.setProx(new Fifo());
                    fim = fim.getProx();
                    if (prof1==prof2){
                        prof1++;
                        prof2++;
                    }else {
                        prof1++;
                    }rami++;
                }
            }
            if (aux.getMatriz().getLinha() < this.estadoFinal.getEstado().length - 1) {
                Matriz m = shuffle(aux.getMatriz(), "baixo");
                Fifo fifo = new Fifo(null, m);
                nos++;
                if (!verifica(fifo)) {
                    fim.setMatriz(m);
                    fim.setProx(new Fifo());
                    fim = fim.getProx();
                    if (prof1==prof2){
                        prof1++;
                        prof2++;
                    }else {
                        prof1++;
                    }rami++;
                }
            }
            if (aux.getMatriz().getColuna() > 0) {
                Matriz m = shuffle(aux.getMatriz(), "esquerda");
                Fifo fifo = new Fifo(null, m);
                nos++;
                if (!verifica(fifo)) {
                    fim.setMatriz(m);
                    fim.setProx(new Fifo());
                    fim = fim.getProx();
                    if (prof1==prof2){
                        prof1++;
                        prof2++;
                    }else {
                        prof1++;
                    }rami++;
                }
            }
            if (aux.getMatriz().getColuna() < this.estadoFinal.getEstado().length - 1) {
                Matriz m = shuffle(aux.getMatriz(), "direita");
                Fifo fifo = new Fifo(null, m);
                nos++;
                if (!verifica(fifo)) {
                    fim.setMatriz(m);
                    fim.setProx(new Fifo());
                    fim = fim.getProx();
                    if (prof1==prof2){
                        prof1++;
                        prof2++;
                    }else {
                        prof1++;
                    }rami++;
                }
            }
            aux=aux.getProx();
        }
        System.out.println("Tempo Total DFS: "+(System.currentTimeMillis()-tempoInicio));
        System.out.println("Nos:"+nos);
        System.out.println("Ramificação:"+(rami/nos));
        System.out.println("Profundidade:"+prof2);
    }


    public Matriz shuffle(Matriz matriz, String direcao){
        switch (direcao){
            case "cima":
                int[][] m = util.clone(matriz.getEstado());
                int i=matriz.getLinha()-1,j=matriz.getColuna();
                m[matriz.getLinha()][matriz.getColuna()]=m[i][j];
                m[i][j]=0;
                return new Matriz(m,i,j);
            case "baixo":
                int[][] m1 = util.clone(matriz.getEstado());
                int i1=matriz.getLinha()+1,j1=matriz.getColuna();
                m1[matriz.getLinha()][matriz.getColuna()]=m1[i1][j1];
                m1[i1][j1]=0;
                return new Matriz(m1,i1,j1);
            case "direita":
                int[][] m2 = util.clone(matriz.getEstado());
                int i2=matriz.getLinha(),j2=matriz.getColuna()+1;
                m2[matriz.getLinha()][matriz.getColuna()]=m2[i2][j2];
                m2[i2][j2]=0;
                return new Matriz(m2,i2,j2);
            case "esquerda":
                int[][] m3 = util.clone(matriz.getEstado());
                int i3=matriz.getLinha(),j3=matriz.getColuna()-1;
                m3[matriz.getLinha()][matriz.getColuna()]=m3[i3][j3];
                m3[i3][j3]=0;
                return new Matriz(m3,i3,j3);
        }
        return null;
    }

    public boolean verifica(Fifo aux){
        Fifo aux2 = this.fila;
        while (aux2!=null && aux2.getMatriz()!=null){
            if (util.verifica(aux.getMatriz().getEstado(),aux2.getMatriz().getEstado())){
                return true;
            }
            aux2 = aux2.getProx();
        }
        return false;
    }

    public Fifo getFila() {
        return fila;
    }

    public void setFila(Fifo fila) {
        this.fila = fila;
    }
}
