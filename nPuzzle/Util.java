package nPuzzle;

import java.util.Random;

public class Util {

    public boolean verifica(int[][] m1, int[][]m2){

        for(int k=0,i=0,j=0;k<(m1.length*m1.length);k++,j++){
            if (m1[i][j]!=m2[i][j]){
                return false;
            }
            if (((k+1)%m1.length)==0){
                j=-1;
                i++;
            }
        }
        return true;
    }

    public void exibe(int[][] m1){
        for(int k=0,i=0,j=0;k<(m1.length*m1.length);k++,j++){
            System.out.printf("%d\t|",m1[i][j]);
            if (((k+1)%m1.length)==0){
                j=-1;
                i++;
                System.out.println("");
            }
        }
    }

    public Matriz shuffleMatrix(int[][] m, int i, int j){
        Random r = new Random();
        for (int k=0;k<=50;k++){
            int d = r.nextInt(4);
            //0=cima
            //1=baixo
            //2=direita
            //3=esquerda
            if(d==0 && i>0){
                m[i][j]=m[i-1][j];
                m[i-1][j]=0;
                i--;
            }else if(d==1 && i<(m.length-1)){
                m[i][j]=m[i+1][j];
                m[i+1][j]=0;
                i++;
            }else if (d==3 && j>0){
                m[i][j]=m[i][j-1];
                m[i][j-1]=0;
                j--;
            }else if(d==2 && j<(m.length-1)){
                m[i][j]=m[i][j+1];
                m[i][j+1]=0;
                j++;
            }
        }
        return new Matriz(m,i,j);
    }

    public int[] procurar(int m1[][]){
        int[] aux = new int[2];
        for(int k=0,i=0,j=0;k<(m1.length*m1.length);k++,j++){
            if (m1[i][j]==0){
                aux[0]=i;
                aux[1]=j;
                break;
            }
            if (((k+1)%m1.length)==0){
                j=-1;
                i++;
            }
        }
        return aux;
    }

    public int[][] clone(int [][]m1){
        int[][] m2 = new int[m1.length][m1.length];
        for(int k=0,i=0,j=0;k<(m1.length*m1.length);k++,j++){
            m2[i][j]=m1[i][j];
            if (((k+1)%m1.length)==0){
                j=-1;
                i++;
            }
        }
        return m2;
    }

    public int manhattan(Matriz m1,Matriz m2){
        int mh=0;
        for(int i=0,j=0,k=0,l=0,m=0,n=0;l<(m2.getEstado().length*m2.getEstado().length);k++,j++){
            if(m1.getEstado()[m][n]==m2.getEstado()[i][j]) {
                mh = mh + (int) (Math.sqrt(Math.pow((m - i), 2)) + Math.sqrt(Math.pow((n - j), 2)));
                if (((l + 1) % m1.getEstado().length) == 0) {
                    i = n = 0;
                    k = j = -1;
                    m++;
                    l++;
                } else {
                    i = 0;
                    k = j = -1;
                    n++;
                    l++;
                }
            }else if ((k+1)==Math.pow(m2.getEstado().length,2)){
                k=i=j=0;
                l++;
            }else if (((k+1)%m2.getEstado().length)==0){
                j=-1;
                i++;
            }
        }
        return mh;
    }

    public Matriz shuffle(Matriz matriz, String direcao){
        switch (direcao){
            case "cima":
                int[][] m = clone(matriz.getEstado());
                int i=matriz.getLinha()-1,j=matriz.getColuna();
                m[matriz.getLinha()][matriz.getColuna()]=m[i][j];
                m[i][j]=0;
                return new Matriz(m,i,j);
            case "baixo":
                int[][] m1 = clone(matriz.getEstado());
                int i1=matriz.getLinha()+1,j1=matriz.getColuna();
                m1[matriz.getLinha()][matriz.getColuna()]=m1[i1][j1];
                m1[i1][j1]=0;
                return new Matriz(m1,i1,j1);
            case "direita":
                int[][] m2 = clone(matriz.getEstado());
                int i2=matriz.getLinha(),j2=matriz.getColuna()+1;
                m2[matriz.getLinha()][matriz.getColuna()]=m2[i2][j2];
                m2[i2][j2]=0;
                return new Matriz(m2,i2,j2);
            case "esquerda":
                int[][] m3 = clone(matriz.getEstado());
                int i3=matriz.getLinha(),j3=matriz.getColuna()-1;
                m3[matriz.getLinha()][matriz.getColuna()]=m3[i3][j3];
                m3[i3][j3]=0;
                return new Matriz(m3,i3,j3);
        }
        return null;
    }

}
