/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yote;

/**
 *
 * @author senho
 */
public class lista {
    public String [][] tabuleiro;
    private Elemento inicio;
   
    private int countPerfuradas, countLisas;
    public lista(){
        inicio = null;
        tabuleiro = new String[6][5];
        countPerfuradas = 0;
        countLisas = 0;
         for (int x=0; x < 6; x++) {
              for (int y=0; y < tabuleiro[x].length; y++) {
                  tabuleiro[x][y] = "-";
              }
         }
    }
    
    public void printTabuleiro(){
       for (int x=0; x < 6; x++) {
            System.out.print("|");
        for (int y=0; y < tabuleiro[x].length; y++) {
                
            System.out.print (tabuleiro[x][y]);
            if (y!=tabuleiro[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
}
    
    }
    public void inserePecaLisa(int n, int y){
        Posicao pos = new Posicao(n,y);
        peca p = new peca(pos,"Lisa");
        int ctMaximo = 0;
        if(tabuleiro[n][y]=="L" || tabuleiro[n][y]=="P"){
        System.out.println("Escolha outra posição!");
        }
        try{
            
        for(int l = 0; l<tabuleiro.length; l++){ //percorre as linhas
            
            for(int c = 0; c < tabuleiro[l].length; c++){ //percorre as colunas
                
                if(tabuleiro[n][y]=="-"){ //verifica se aquele índice esta vazio
                    p.setPos(pos); //define a posicao da peça
                    tabuleiro[n][y] = "L"; //define a posicao [n][y] como L
                    ctMaximo++;
                    System.out.println(ctMaximo);
                    
                }}
                
            }
        }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("Posição inválida!");
                }
    }
     public void inserePecaPerfurada(int n, int y){
        Posicao pos = new Posicao(n,y);
        peca p = new peca(pos,"Perfurada");
        int ctMaximo = 0;
        if(tabuleiro[n][y]=="L" || tabuleiro[n][y]=="P"){
        System.out.println("Escolha outra posição!");
        }
        try{
            
        for(int l = 0; l<tabuleiro.length; l++){ //percorre as linhas
            
            for(int c = 0; c < tabuleiro[l].length; c++){ //percorre as colunas
                
                if(tabuleiro[n][y]=="-"){ //verifica se aquele índice esta vazio
                    p.setPos(pos); //define a posicao da peça
                    tabuleiro[n][y] = "P"; //define a posicao [n][y] como L
                    ctMaximo++;
                    System.out.println(ctMaximo);
                    
                }}
                
            }
        }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("Posição inválida!");
                }
    }
    
    public void movePecaLisa(int x, int y, int casaAtualX, int casaAtualY){
        Posicao pos = new Posicao(x,y);
        peca p = new peca(pos,"Lisa");
        if((((casaAtualX + casaAtualY))/(x+y)) > 0.2){
            System.out.println("Não pode mover para ai!!");
        }
        try{
        for(int l = 0; l<tabuleiro.length; l++){ //percorre as linhas
            for(int c = 0; c < tabuleiro[l].length; c++){
                //percorre as colunas
            if(tabuleiro[x][y] == "-"){                
               tabuleiro[x][y]=tabuleiro[casaAtualX][casaAtualY]; 
                tabuleiro[x][y] = "L";
                tabuleiro[casaAtualX][casaAtualY] = "-";
                if(tabuleiro[x-1][y] == "P"){ //verifica se na linha anterior tem alguma peça perfurada
                    tabuleiro[x-1][y] = "-";// se tiver uma peça perfurada, deixa de existir e passa a ter um "-"
                    countPerfuradas++; //incrementa o contador de peças perfuradas
                }
                else if(tabuleiro[x][y-1] == "P"){//verifica se na coluna anterior tem alguma peça perfurada
                    tabuleiro[x][y-1] = "-";
                    countPerfuradas++;
                }
            }               
            
            
            }
    }}catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Posição inválida!");
    }
    }
    
    public void movePecaPerfurada(int x, int y, int casaAtualX, int casaAtualY){
         Posicao pos = new Posicao(x,y);
        peca p = new peca(pos,"Perfurada");
        try{
        for(int l = 0; l<tabuleiro.length; l++){ //percorre as linhas
            for(int c = 0; c < tabuleiro[l].length; c++){ //percorre as colunas
            if(tabuleiro[x][y] == "-"){                
               tabuleiro[x][y]=tabuleiro[casaAtualX][casaAtualY]; 
                tabuleiro[x][y] = "P";
                tabuleiro[casaAtualX][casaAtualY] = "-";
                if(tabuleiro[x-1][y] == "L"){ //verifica se na linha anterior tem alguma peça perfurada
                    tabuleiro[x-1][y] = "-";// se tiver uma peça perfurada, deixa de existir e passa a ter um "-"
                    countLisas++; //incrementa o contador de peças perfuradas
                }
                else if(tabuleiro[x][y-1] == "L"){//verifica se na coluna anterior tem alguma peça perfurada
                    tabuleiro[x][y-1] = "-";
                    countLisas++;
                }
            }
            
            }
    }}catch(ArrayIndexOutOfBoundsException e){
         System.out.println("Posição inválida!");
    }
    }
    
    
    
    
    
    
     
       }
    

