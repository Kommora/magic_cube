package nPuzzle;

import java.util.Stack;

public class Npuzzle {

    public static void main(String[] args) {
          Util util = new Util();
        int [][]m2 = {{1,2},{3,0}};
        int [][]m3 = {{1,2,3},{4,5,6},{7,8,0}};
        int [][]m4 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
        int [][]m5 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,0}};
        Matriz matrizFinal2 = util.shuffleMatrix(util.clone(m2),1,1);
        Matriz matrizFinal3 = util.shuffleMatrix(util.clone(m3),2,2);
        Matriz matrizFinal4 = util.shuffleMatrix(util.clone(m4),3,3);
        Matriz matrizFinal5 = util.shuffleMatrix(util.clone(m5),4,4);
        Matriz matrizInicial2 = util.shuffleMatrix(util.clone(matrizFinal2.getEstado()),matrizFinal2.getLinha(),matrizFinal2.getColuna());
        Matriz matrizInicial3 = util.shuffleMatrix(util.clone(matrizFinal3.getEstado()),matrizFinal3.getLinha(),matrizFinal3.getColuna());
        Matriz matrizInicial4 = util.shuffleMatrix(util.clone(matrizFinal4.getEstado()),matrizFinal4.getLinha(),matrizFinal4.getColuna());
        Matriz matrizInicial5 = util.shuffleMatrix(util.clone(matrizFinal5.getEstado()),matrizFinal5.getLinha(),matrizFinal5.getColuna());

//        System.out.println("Matriz de 2x2 inicial");
//        util.exibe(matrizInicial2.getEstado());
//        System.out.println("Matriz de 2x2 final");
//        util.exibe(matrizFinal2.getEstado());
//        IDAStar idaStar = new IDAStar(matrizInicial2,matrizFinal2);
//        idaStar.idaStar(idaStar.getRaiz());
//        DFS dfs = new DFS(matrizInicial2,matrizFinal2);
//        BFS bfs = new BFS(matrizInicial2,matrizFinal2);
//        AStar aStar = new AStar(matrizInicial2,matrizFinal2);
//        System.out.println("DFS");
//        dfs.dfs();
//        System.out.println("BFS");
//        bfs.bfs();
//        System.out.println("A*");
//        aStar.aStar(aStar.raiz);
//        System.out.println();


        System.out.println("\nMatriz de 3x3 inicial");
        util.exibe(matrizInicial3.getEstado());
        System.out.println("Matriz de 3x3 final");
        util.exibe(matrizFinal3.getEstado());
        DFS dfs3 = new DFS(matrizInicial3,matrizFinal3);
        BFS bfs3 = new BFS(matrizInicial3,matrizFinal3);
        AStar aStar3 = new AStar(matrizInicial3,matrizFinal3);
//        System.out.println("IDAStar");
//        IDAStar idaStar3 = new IDAStar(matrizInicial3,matrizFinal3);
//        idaStar3.idaStar(idaStar3.getRaiz());
        System.out.println("DFS");
        dfs3.dfs();
        System.out.println("BFS");
        bfs3.bfs();
        System.out.println("A*");
        aStar3.aStar(aStar3.raiz);
        System.out.println();

//
//        System.out.println("\nMatriz de 4x4 inicial");
//        util.exibe(matrizInicial4.getEstado());
//        System.out.println("Matriz de 4x4 final");
//        util.exibe(matrizFinal4.getEstado());
//        DFS dfs4 = new DFS(matrizInicial4,matrizFinal4);
//        BFS bfs4 = new BFS(matrizInicial4,matrizFinal4);
//        AStar aStar4 = new AStar(matrizInicial4,matrizFinal4);
//        System.out.println("DFS");
//        dfs4.dfs();
//        System.out.println("BFS");
//        bfs4.bfs();
//        System.out.println("A*");
//        aStar4.aStar(aStar4.raiz);
//        System.out.println();

//        System.out.println("Matriz de 5x5 inicial");
//        util.exibe(matrizInicial5.getEstado());
//        System.out.println("Matriz de 5x5 final");
//        util.exibe(matrizFinal5.getEstado());
//        DFS dfs5 = new DFS(matrizInicial5,matrizFinal5);
//        BFS bfs5 = new BFS(matrizInicial5,matrizFinal5);
//        AStar aStar5 = new AStar(matrizInicial5,matrizFinal5);
//        System.out.println("DFS");
//        dfs5.dfs();
//        System.out.println("BFS");
//        bfs5.bfs();
//        System.out.println("A*");
//        aStar5.aStar(aStar5.raiz);
//        System.out.println();

//        Matriz do CAPETA
//        int[][] m1 = {{0,2,4},{8,1,3},{7,5,6}};//ESTADO INICIAL
//        int[][] m2 = {{3,7,6},{1,5,4},{2,8,0}};//ESTADO META
//
//        Matriz matrizInicial = new Matriz(m1,0,0);
//        Matriz matrizFinal = new Matriz(m2,3,3);
//
//        System.out.println("\nMatriz de 3x3 inicial");
//        util.exibe(matrizInicial.getEstado());
//        System.out.println("Matriz de 3x3 final");
//        util.exibe(matrizFinal.getEstado());
//        AStar aStar = new AStar(matrizInicial,matrizFinal);
//        aStar.aStar(aStar.raiz);
//        DFS dfs = new DFS(matrizInicial,matrizFinal);
//        dfs.dfs();

    }
}
