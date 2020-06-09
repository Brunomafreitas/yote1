/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yote;

import comum.Le;

/**
 *
 * @author senho
 */
public class lista {
    public String [][] tabuleiro;
    private peca inicio;
    private peca inicioPerfurada;
    
    
      public void insereIni(peca p){
       
            peca nova = new peca("Lisas");
            nova.setNext(inicio);
            inicio = nova;
        }
      public void insereIniPerfura(peca p){
       
            peca nova = new peca("Perfuradas");
            nova.setNext(inicioPerfurada);
            inicioPerfurada = nova;
        }
    
    
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
    public int  printPecasLisas(){
        int ct = 0;
        peca apt;
        
        for( apt=inicioPerfurada; apt != null && apt.getTipo() == "Perfuradas"; apt = apt.getNext()){
            if(apt.getTipo() == "Perfuradas"){
            ct++;           
            }
        }   
        System.out.println("Número de peças Perfuradas restantes " + ct);
        return ct;
    }
    public int  printPecasPerfuradas(){
        int ct = 0;
        peca apt;
        
        for( apt=inicio; apt != null && apt.getTipo() == "Lisas"; apt = apt.getNext()){
            if(apt.getTipo() == "Lisas"){
            ct++;           
            }
        }   
        System.out.println("Número de peças Lisas restantes " + ct);
        return ct;
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
    public boolean inserePecaLisa(int n, int y){
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
                    
                    inicio = inicio.getNext();
                    
                }}
                
            }
        }catch(NullPointerException e ){
                    System.out.println("Posição inválida!");
                }
        
        return true;
    }
     public boolean inserePecaPerfurada(int n, int y){
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
                    
                    inicioPerfurada = inicioPerfurada.getNext();
                    
                }}
                
            }
        }catch(NullPointerException e ){
                    System.out.println("Posição inválida!");
                }
        
        return true;
    }
    
    public void movePecaLisa(String op, int casaAtualX, int casaAtualY){
        
        
        Posicao p1 = new Posicao(casaAtualX, casaAtualY);
        peca p = new peca(p1,"Lisa");
        boolean mexeuMal = true;
       if(tabuleiro[casaAtualX][casaAtualY] == "-"){
            System.out.println("Não tem peça nessa casa");
        
        }else{
        
        try{
            
            while(mexeuMal == true){
                 //para a esquerda--------------------------------------------
                  if(op.equals("A") || op.equals("a")){
                         if(tabuleiro[casaAtualX][casaAtualY+1].equals("L")){
                          System.out.println("Escolha outra casa");
                          String escolherOutra = Le.umaString();
                          mexeuMal = false;
                      }else{
                      if(tabuleiro[casaAtualX][casaAtualY-1] == "P"){
                      p1.setY(casaAtualY + 2);
                      tabuleiro[casaAtualX][casaAtualY+2] = "L";
                      tabuleiro[casaAtualX][casaAtualY] = "-";
                      tabuleiro[casaAtualX][casaAtualY+1] = "-";
                      mexeuMal = false; 
                      
                      
                      }else{
                          p1.setY(casaAtualX -1 );
                          tabuleiro[casaAtualX][casaAtualY-1] = "L";
                          tabuleiro[casaAtualX][casaAtualY] = "-";
                          mexeuMal = false;
                      }
                     
                  }
                      
                  }
                  //---------------Para a direita
                  if(op.equals("D") || op.equals("d")){
                       if(tabuleiro[casaAtualX][casaAtualY+1].equals("L")){
                          System.out.println("Escolha outra casa");
                          String escolherOutra = Le.umaString();
                          mexeuMal = false;
                      }else{
                      if(tabuleiro[casaAtualX][casaAtualY+1] == "P"){
                      p1.setY(casaAtualY + 2);
                      tabuleiro[casaAtualX][casaAtualY+2] = "L";
                      tabuleiro[casaAtualX][casaAtualY] = "-";
                      tabuleiro[casaAtualX][casaAtualY+1] = "-";
                      mexeuMal = false; 
                      
                      
                      }else{
                          p1.setY(casaAtualX -1 );
                          tabuleiro[casaAtualX][casaAtualY+1] = "L";
                          tabuleiro[casaAtualX][casaAtualY] = "-";
                          mexeuMal = false;
                      }
                     
                  }
                  }
                  
                  
                  //------------------- PARA CIMA------------------------
                 if(op.equals("W") || op.equals("w")){
                       if(tabuleiro[casaAtualX-1][casaAtualY].equals("L")){
                          System.out.println("Escolha outra casa");
                          String escolherOutra = Le.umaString();
                          mexeuMal = false;
                      }else{
                      if(tabuleiro[casaAtualX-1][casaAtualY] == "P"){
                      p1.setY(casaAtualX - 2);
                      tabuleiro[casaAtualX+2][casaAtualY] = "L";
                      tabuleiro[casaAtualX][casaAtualY] = "-";
                      tabuleiro[casaAtualX-1][casaAtualY] = "-";
                      mexeuMal = false; 
                      
                      
                      }else{
                          p1.setY(casaAtualX -1 );
                          tabuleiro[casaAtualX-1][casaAtualY] = "L";
                          tabuleiro[casaAtualX][casaAtualY] = "-";
                          mexeuMal = false;
                      }
                     
                  }
                  }
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
 //------------------------------Para baixo                 
                  
                  
                  
                  
                  if(op.equals("S") || op.equals("s")){
                      if(tabuleiro[casaAtualX+1][casaAtualY].equals("L")){
                          System.out.println("Escolha outra casa");
                          String escolherOutra = Le.umaString();
                          mexeuMal = false;
                      }else{
                      if(tabuleiro[casaAtualX+1][casaAtualY] == "P"){
                      p1.setY(casaAtualX + 2);
                      tabuleiro[casaAtualX+2][casaAtualY] = "L";
                      tabuleiro[casaAtualX][casaAtualY] = "-";
                      tabuleiro[casaAtualX+1][casaAtualY] = "-";
                      mexeuMal = false; 
                      
                      
                      }else{
                          p1.setY(casaAtualX +1 );
                          tabuleiro[casaAtualX+1][casaAtualY] = "L";
                          tabuleiro[casaAtualX][casaAtualY] = "-";
                          mexeuMal = false;
                      }
                     
                  }}
            }
            
                      
}
            
            
            
    
            
        catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Posição inválida!");
    }}
    
    }
    public void movePecaPerfurada(String op, int casaAtualX, int casaAtualY){
          Posicao p1 = new Posicao(casaAtualX, casaAtualY);
        peca p = new peca(p1,"Perfurada");
        boolean mexeuMal = true;
       if(tabuleiro[casaAtualX][casaAtualY] == "-"){
            System.out.println("Não tem peça nessa casa");
        
        }else{
        
        try{
            
            while(mexeuMal == true){
                 //para a esquerda--------------------------------------------
                  if(op.equals("A") || op.equals("a")){
                         if(tabuleiro[casaAtualX][casaAtualY+1].equals("P")){
                          System.out.println("Escolha outra casa");
                          String escolherOutra = Le.umaString();
                          mexeuMal = false;
                      }else{
                      if(tabuleiro[casaAtualX][casaAtualY-1] == "L"){
                      p1.setY(casaAtualY + 2);
                      tabuleiro[casaAtualX][casaAtualY+2] = "P";
                      tabuleiro[casaAtualX][casaAtualY] = "-";
                      tabuleiro[casaAtualX][casaAtualY+1] = "-";
                      mexeuMal = false; 
                      
                      
                      }else{
                          p1.setY(casaAtualX -1 );
                          tabuleiro[casaAtualX][casaAtualY-1] = "P";
                          tabuleiro[casaAtualX][casaAtualY] = "-";
                          mexeuMal = false;
                      }
                     
                  }
                      
                  }
                  //---------------Para a direita
                  if(op.equals("D") || op.equals("d")){
                       if(tabuleiro[casaAtualX][casaAtualY+1].equals("P")){
                          System.out.println("Escolha outra casa");
                          String escolherOutra = Le.umaString();
                          mexeuMal = false;
                      }else{
                      if(tabuleiro[casaAtualX][casaAtualY+1] == "L"){
                      p1.setY(casaAtualY + 2);
                      tabuleiro[casaAtualX][casaAtualY+2] = "P";
                      tabuleiro[casaAtualX][casaAtualY] = "-";
                      tabuleiro[casaAtualX][casaAtualY+1] = "-";
                      mexeuMal = false; 
                      
                      
                      }else{
                          p1.setY(casaAtualX -1 );
                          tabuleiro[casaAtualX][casaAtualY+1] = "P";
                          tabuleiro[casaAtualX][casaAtualY] = "-";
                          mexeuMal = false;
                      }
                     
                  }
                  }
                  
                  
                  //------------------- PARA CIMA------------------------
                 if(op.equals("W") || op.equals("w")){
                       if(tabuleiro[casaAtualX-1][casaAtualY].equals("P")){
                          System.out.println("Escolha outra casa");
                          String escolherOutra = Le.umaString();
                          mexeuMal = false;
                      }else{
                      if(tabuleiro[casaAtualX-1][casaAtualY] == "L"){
                      p1.setY(casaAtualX - 2);
                      tabuleiro[casaAtualX+2][casaAtualY] = "P";
                      tabuleiro[casaAtualX][casaAtualY] = "-";
                      tabuleiro[casaAtualX-1][casaAtualY] = "-";
                      mexeuMal = false; 
                      
                      
                      }else{
                          p1.setY(casaAtualX -1 );
                          tabuleiro[casaAtualX-1][casaAtualY] = "P";
                          tabuleiro[casaAtualX][casaAtualY] = "-";
                          mexeuMal = false;
                      }
                     
                  }
                  }
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
 //------------------------------Para baixo                 
                  
                  
                  
                  
                  if(op.equals("S") || op.equals("s")){
                      if(tabuleiro[casaAtualX+1][casaAtualY].equals("P")){
                          System.out.println("Escolha outra casa");
                          String escolherOutra = Le.umaString();
                          mexeuMal = false;
                      }else{
                      if(tabuleiro[casaAtualX+1][casaAtualY] == "L"){
                      p1.setY(casaAtualX + 2);
                      tabuleiro[casaAtualX+2][casaAtualY] = "P";
                      tabuleiro[casaAtualX][casaAtualY] = "-";
                      tabuleiro[casaAtualX+1][casaAtualY] = "-";
                      mexeuMal = false; 
                      
                      
                      }else{
                          p1.setY(casaAtualX +1 );
                          tabuleiro[casaAtualX+1][casaAtualY] = "P";
                          tabuleiro[casaAtualX][casaAtualY] = "-";
                          mexeuMal = false;
                      }
                     
                  }}
            }
            
                      
}
            
            
            
    
            
        catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Posição inválida!");
    }}
    }
    
     
       }
    

