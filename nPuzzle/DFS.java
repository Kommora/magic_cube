package nPuzzle;

import java.sql.Time;

public class DFS {

    public Node raiz;
    public Matriz estadoFinal;
    public Util util;
//    public Node fila;

    public DFS(Matriz estadoInicial,Matriz estadoFinal){
        this.raiz=new Node();
        this.util = new Util();
        this.estadoFinal=estadoFinal;
        this.raiz.setMatriz(estadoInicial);
//        this.fila=this.raiz;
    }

    public void dfs(){
        float nos=0,rami=0,prof1=0,prof2=0;
        long tempoInicio = System.currentTimeMillis();
        Node aux = this.raiz;
//        Node fim = new Node();
        while (aux!=null) {
            if (util.verifica(aux.getMatriz().getEstado(), this.estadoFinal.getEstado())) {
                System.out.println("Tempo Total DFS: "+(System.currentTimeMillis()-tempoInicio));
                System.out.println("Nos:"+nos);
                System.out.println("Ramificação:"+(rami/nos));
                System.out.println("Profundidade:"+prof2);
                break;
            }
            if (aux.getMatriz().getLinha() > 0 && aux.getCima()==null) {
                Matriz m = util.shuffle(aux.getMatriz(), "cima");
                Node no = new Node(null,null,null,null,aux,m);
                nos++;
                if (!verifica(no)) {
                    if (prof1==prof2){
                        prof1++;
                        prof2++;
                    }else {
                        prof1++;
                    }
                    aux.setCima(no);
                    aux=no;
                    rami++;
                }else {
                    aux.setCima(new Node());
                }
            }else if (aux.getMatriz().getLinha() < this.estadoFinal.getEstado().length - 1 && aux.getBaixo()==null) {
                Matriz m = util.shuffle(aux.getMatriz(), "baixo");
                Node no = new Node(null, null, null, null, aux, m);
                nos++;
                if (!verifica(no)) {
                    if (prof1==prof2){
                        prof1++;
                        prof2++;
                    }else {
                        prof1++;
                    }
//                    fim.setMatriz(m);
//                    fim.setProx(new Node());
//                    fim = fim.getProx();
                    aux.setBaixo(no);
                    aux=no;
                    rami++;
                }else {
                    aux.setBaixo(new Node());
                }
            }else if (aux.getMatriz().getColuna() > 0 && aux.getEsquerda()==null) {
                Matriz m = util.shuffle(aux.getMatriz(), "esquerda");
                Node no = new Node(null, null, null, null, aux, m);
                nos++;
                if (!verifica(no)) {
                    if (prof1==prof2){
                        prof1++;
                        prof2++;
                    }else {
                        prof1++;
                    }
//                    fim.setMatriz(m);
//                    fim.setProx(new Node());
//                    fim = fim.getProx();
                    aux.setEsquerda(no);
                    aux=no;
                    rami++;
                }else {
                    aux.setEsquerda(new Node());
                }
            }else if (aux.getMatriz().getColuna() < this.estadoFinal.getEstado().length - 1 && aux.getDireita()==null) {
                Matriz m = util.shuffle(aux.getMatriz(), "direita");
                Node no = new Node(null, null, null, null, aux, m);
                nos++;
                if (!verifica(no)) {
                    if (prof1==prof2){
                        prof1++;
                        prof2++;
                    }else {
                        prof1++;
                    }
//                    fim.setMatriz(m);
//                    fim.setProx(new Node());
//                    fim = fim.getProx();
                    aux.setDireita(no);
                    aux=no;
                    rami++;
                }else {
                    aux.setDireita(new Node());
                }
            }else {
                prof2=prof1;
                prof1--;
                aux=aux.getPai();
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

//    public boolean verifica2(Node no){
//        Node aux = this.raiz;
//        while (aux!=null){
//            if (aux.getCima()!=null && aux.isVisitado()==false){
//                aux.setVisitado(true);
//                if (util.verifica(no.getMatriz().getEstado(),aux.getMatriz().getEstado())){
//                    return true;
//                }else {
//                    aux = aux.getCima();
//                }
//            }else if (aux.getBaixo()!=null && aux.isVisitado()==false && util.verifica(no.getMatriz().getEstado(),aux.getMatriz().getEstado())){
//                aux.setVisitado(true);
//                if (util.verifica(no.getMatriz().getEstado(),aux.getMatriz().getEstado())){
//                    return true;
//                }else {
//                    aux = aux.getBaixo();
//                }
//            }else if (aux.getDireita()!=null && aux.isVisitado()==false && util.verifica(no.getMatriz().getEstado(),aux.getMatriz().getEstado())){
//                aux.setVisitado(true);
//                if (util.verifica(no.getMatriz().getEstado(),aux.getMatriz().getEstado())){
//                    return true;
//                }else {
//                    aux = aux.getDireita();
//                }
//            }else if (aux.getEsquerda()!=null && aux.isVisitado()==false && util.verifica(no.getMatriz().getEstado(),aux.getMatriz().getEstado())){
//                aux.setVisitado(true);
//                if (util.verifica(no.getMatriz().getEstado(),aux.getMatriz().getEstado())){
//                    return true;
//                }else {
//                    aux = aux.getEsquerda();
//                }
//            }else {
//                aux=aux.getPai();
//            }
//        }
//        return false;
//    }

    public Node getRaiz() {
        return raiz;
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }
}
