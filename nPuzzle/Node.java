package nPuzzle;

public class Node {

    private Node cima;
    private Node baixo;
    private Node direita;
    private Node esquerda;
    private Node pai;
    private Matriz matriz;
    private boolean visitado;
    private Node prox,ante;

    public Node(Node cima, Node baixo, Node direita, Node esquerda, Node pai, Matriz estado) {
        this.cima = cima;
        this.baixo = baixo;
        this.direita = direita;
        this.esquerda = esquerda;
        this.pai = pai;
        this.matriz = estado;
    }

    public Node(Matriz matriz,Node ante, Node prox) {
        this.matriz = matriz;
        this.prox = prox;
        this.ante = ante;
    }

    public Node(Matriz matriz, Node prox) {
        this.matriz = matriz;
        this.prox = prox;
    }

    public Node(){};

    public Node getCima() {
        return cima;
    }

    public void setCima(Node cima) {
        this.cima = cima;
    }

    public Node getBaixo() {
        return baixo;
    }

    public void setBaixo(Node baixo) {
        this.baixo = baixo;
    }

    public Node getDireita() {
        return direita;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public Node getPai() {
        return pai;
    }

    public void setPai(Node pai) {
        this.pai = pai;
    }

    public Matriz getMatriz() {
        return matriz;
    }

    public void setMatriz(Matriz matriz) {
        this.matriz = matriz;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public Node getProx() {
        return prox;
    }

    public void setProx(Node prox) {
        this.prox = prox;
    }

    public Node getAnte() {
        return ante;
    }

    public void setAnte(Node ante) {
        this.ante = ante;
    }
}
