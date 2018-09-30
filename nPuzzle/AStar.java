package nPuzzle;

public class AStar {


    public Node raiz;
    public Matriz estadoFinal;
    public Util util;

    public AStar(Matriz estadoInicial,Matriz estadoFinal){
        this.raiz=new Node();
        this.estadoFinal=estadoFinal;
        this.raiz.setMatriz(estadoInicial);
        this.util = new Util();
    }

    public void aStar(Node aux){
        float nos=0,rami=0,prof1=0,prof2=0;
        long tempoInicio = System.currentTimeMillis();
        int cima=0,baixo=0, direita=0,esquerda=0,v=0;
        while (aux!=null) {
            if (aux.getMatriz()==null){
                System.out.println();
            }
            if (util.verifica(aux.getMatriz().getEstado(), this.estadoFinal.getEstado())) {
                System.out.println("Tempo Total AStar: "+(System.currentTimeMillis()-tempoInicio));
                System.out.println("Nos:"+nos);
                System.out.println("Ramificação:"+(rami/nos));
                System.out.println("Profundidade:"+prof2);
                break;
            }

            cima=baixo=direita=esquerda=v= (int) ((3*this.estadoFinal.getEstado().length)*(Math.pow(this.estadoFinal.getEstado().length,2)));
            Node noCima= new Node(),noBaixo = new Node(),noDireita = new Node(),noEsquerda = new Node();
            if (aux.getMatriz().getLinha() > 0 && aux.getCima()==null) {
                Matriz m = shuffle(aux.getMatriz(), "cima");
                noCima = new Node(null, null, null, null, aux, m);
                nos++;
                if (!verifica(noCima)) {
                    cima = util.manhattan(m,this.estadoFinal);
                }else {
                    rami++;
                    aux.setCima(new Node());
                }
            }if (aux.getMatriz().getLinha() < this.estadoFinal.getEstado().length - 1 && aux.getBaixo()==null) {
                Matriz m = shuffle(aux.getMatriz(), "baixo");
                noBaixo = new Node(null, null, null, null, aux, m);
                nos++;
                if (!verifica(noBaixo)) {
                    baixo = util.manhattan(m,this.estadoFinal);
                }else {
                    rami++;
                    aux.setBaixo(new Node());
                }
            }if (aux.getMatriz().getColuna() > 0 && aux.getEsquerda()==null) {
                Matriz m = shuffle(aux.getMatriz(), "esquerda");
                noEsquerda = new Node(null, null, null, null, aux, m);
                nos++;
                if (!verifica(noEsquerda)) {
                    esquerda = util.manhattan(m,this.estadoFinal);
                }else {
                    rami++;
                    aux.setEsquerda(new Node());
                }
            }if (aux.getMatriz().getColuna() < this.estadoFinal.getEstado().length - 1 && aux.getDireita()==null) {
                Matriz m = shuffle(aux.getMatriz(), "direita");
                noDireita = new Node(null, null, null, null, aux, m);
                nos++;
                if (!verifica(noDireita)) {
                    direita = util.manhattan(m,this.estadoFinal);
                }else {
                    aux.setDireita(new Node());
                    rami++;
                }
            }
            if (cima==v && baixo==v && direita==v && esquerda==v){
                aux=aux.getPai();
                prof2=prof1;
                prof1--;
            }else {
                if (cima <= baixo && cima <= direita && cima <= esquerda) {
                    aux.setCima(noCima);
                    aux=noCima;
                    if (prof1==prof2){
                        prof1++;
                        prof2++;
                    }else {
                        prof1++;
                    }rami++;
                }else
                if (baixo <= cima && baixo <= direita && baixo <= esquerda) {
                    aux.setBaixo(noBaixo);
                    aux=noBaixo;
                    if (prof1==prof2){
                        prof1++;
                        prof2++;
                    }else {
                        prof1++;
                    }rami++;
                }else
                if (direita <= cima && direita <= baixo && direita <= esquerda) {
                    aux.setDireita(noDireita);
                    aux=noDireita;
                    if (prof1==prof2){
                        prof1++;
                        prof2++;
                    }else {
                        prof1++;
                    }rami++;
                }else
                if (esquerda <= cima && esquerda <= direita && esquerda <= direita) {
                    aux.setEsquerda(noEsquerda);
                    aux=noEsquerda;
                    if (prof1==prof2){
                        prof1++;
                        prof2++;
                    }else {
                        prof1++;
                    }rami++;
                }
            }
        }
    }

    public boolean verifica(Node no){
        Node aux=no.getPai();
        while (aux!=null){
            if (util.verifica(no.getMatriz().getEstado(),aux.getMatriz().getEstado())){
                return true;
            }
            aux=aux.getPai();
        }
        return false;
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

    public Node getRaiz() {
        return raiz;
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }
}
