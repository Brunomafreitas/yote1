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
        
        for( apt=inicio; apt != null && apt.getTipo() == "Lisas"; apt = apt.getNext()){
            if(apt.getTipo() == "Lisas"){
            ct++;           
            }
        }   
        System.out.println("Número de peças Lisas restantes " + ct);
        return ct;
    }
    public int  printPecasPerfuradas(){
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
    
    
    public void printTabuleiro(){
        int linhas = 0;
        int colunas = 0;
       for (int x=0; x < 6; x++) {

            System.out.print("|");
        for (int y=0; y < tabuleiro[x].length; y++) {
              
            System.out.print (tabuleiro[x][y]);
            if (y!=tabuleiro[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
}
    
    }
 
    
     public boolean inserirPeca(int x, int y,String tipo){
         
        int ctMaximo = 0;
        String verificaTipo = " ";
        
         System.out.println(tipo);
        if(tabuleiro[x][y]== "L" || tabuleiro[x][y]== "P"){
        System.out.println("Escolha outra posição!");
        }
        try{
            if(tipo.equals("Lisas")){
            verificaTipo = "L";
        }else{
            verificaTipo = "P";
        }
        for(int l = 0; l<tabuleiro.length; l++){ //percorre as linhas
            
            for(int c = 0; c < tabuleiro[l].length; c++){ //percorre as colunas
                
                if(tabuleiro[x][y]=="-"){ //verifica se aquele índice esta vazio
                    
                    tabuleiro[x][y] = verificaTipo; //define a posicao [n][y] como L
                    ctMaximo++;
                    System.out.println(ctMaximo);
                    if(verificaTipo=="L"){
                    inicio = inicio.getNext();
                    }else{
                    inicioPerfurada = inicioPerfurada.getNext();
                    }
                }}
                
            }
        
        }catch(ArrayIndexOutOfBoundsException e ){
            e.getMessage().toString();
                    System.out.println("Posição inválida!");
                }
        
        
        return true;
     }
     
     
     public int movePeca(int posAtualX, int posAtualY, String tipo, String posSeguinte){
         
         int countPecaCapturadaL = 0;
         int countPecaCapturadaP = 0;
         String tipo1;
         String tipo2;
         String leOp = " ";
         
         if(tipo.equals("Lisas")){
             tipo1 = "L";
             tipo2 = "P";
         }else{
             tipo1 = "P";
             tipo2 = "L";
         }
         
         if(posSeguinte.equals("A") || posSeguinte.equals("a")){
             if(tabuleiro[posAtualX][posAtualY-1].equals(tipo2)){
                 tabuleiro[posAtualX][posAtualY-1] = "-";
                 tabuleiro[posAtualX][posAtualY-2] = tipo1;
                 tabuleiro[posAtualX][posAtualY] = "-";
                 printTabuleiro();
                 System.out.println("Quer capturar outra peça?");
                leOp = Le.umaString();
                 if(leOp.equals("S") || leOp.equals("s")){
                     System.out.println("De qual posição?");
                     System.out.println("X----");
                     int leCaptura2X = Le.umInt();
                     System.out.println("Y----");
                     int leCaptura2Y = Le.umInt();
                     if(tabuleiro[leCaptura2X][leCaptura2Y].equals(tipo2)){
                         tabuleiro[leCaptura2X][leCaptura2Y] = "-";
                         if(tipo2 == "L"){
                     countPecaCapturadaL++;
                     System.out.println("Você já capturou "+countPecaCapturadaL+" peças Lisas" );
                            }else{
                     countPecaCapturadaP++;
                     System.out.println("Você já capturou "+countPecaCapturadaP+" peças Perfuradas" );
                            }
                     } 
                 }else{
                     System.out.println("Okapa");
                 }
                 if(tipo2 == "L"){
                     countPecaCapturadaL++;
                     System.out.println("Você já capturou "+countPecaCapturadaL+" peças Lisas" );
                 }else{
                     countPecaCapturadaP++;
                     System.out.println("Você já capturou "+countPecaCapturadaP+" peças Perfuradas" );
                 }
             }else{
             tabuleiro[posAtualX][posAtualY-1] = tipo1;
             tabuleiro[posAtualX][posAtualY] = "-";
             }
             
         }
         
         
  
         if(posSeguinte.equals("W") || posSeguinte.equals("w")){
             if(tabuleiro[posAtualX-1][posAtualY].equals(tipo2)){
                 tabuleiro[posAtualX-1][posAtualY] = "-";
                 tabuleiro[posAtualX-2][posAtualY] = tipo1;
                 tabuleiro[posAtualX][posAtualY]="-";
                  printTabuleiro();
                 System.out.println("Quer capturar outra peça?");
                leOp = Le.umaString();
                 if(leOp.equals("S") || leOp.equals("s")){
                     System.out.println("De qual posição?");
                     System.out.println("X----");
                     int leCaptura2X = Le.umInt();
                     System.out.println("Y----");
                     int leCaptura2Y = Le.umInt();
                     if(tabuleiro[leCaptura2X][leCaptura2Y].equals(tipo2)){
                         tabuleiro[leCaptura2X][leCaptura2Y] = "-";
                         if(tipo2 == "L"){
                     countPecaCapturadaL++;
                     System.out.println("Você já capturou "+countPecaCapturadaL+" peças Lisas" );
                            }else{
                     countPecaCapturadaP++;
                     System.out.println("Você já capturou "+countPecaCapturadaP+" peças Perfuradas" );
                            }
                     } 
                 }else{
                     System.out.println("Okapa");
                 }
                 if(tipo2 == "L"){
                     countPecaCapturadaL++;
                     System.out.println("Você já capturou "+countPecaCapturadaL+" peças Lisas" );
                 }else{
                     countPecaCapturadaP++;
                     System.out.println("Você já capturou "+countPecaCapturadaP+" peças Perfuradas" );
                 }
             }else{
             tabuleiro[posAtualX-1][posAtualY] = tipo1;
             tabuleiro[posAtualX][posAtualY] = "-";
             }
             
             }
         
         
         
         
         if(posSeguinte.equals("S") || posSeguinte.equals("s")){
             if(tabuleiro[posAtualX+1][posAtualY].equals(tipo2)){
                 tabuleiro[posAtualX+1][posAtualY] = "-";
                 tabuleiro[posAtualX+2][posAtualY] = tipo1;
                 tabuleiro[posAtualX][posAtualY]="-";
                  printTabuleiro();
                 System.out.println("Quer capturar outra peça?");
                leOp = Le.umaString();
                 if(leOp.equals("S") || leOp.equals("s")){
                     System.out.println("De qual posição?");
                     System.out.println("X----");
                     int leCaptura2X = Le.umInt();
                     System.out.println("Y----");
                     int leCaptura2Y = Le.umInt();
                     if(tabuleiro[leCaptura2X][leCaptura2Y].equals(tipo2)){
                         tabuleiro[leCaptura2X][leCaptura2Y] = "-";
                         if(tipo2 == "L"){
                     countPecaCapturadaL++;
                     System.out.println("Você já capturou "+countPecaCapturadaL+" peças Lisas" );
                            }else{
                     countPecaCapturadaP++;
                     System.out.println("Você já capturou "+countPecaCapturadaP+" peças Perfuradas" );
                            }
                     } 
                 }else{
                     System.out.println("Okapa");
                 }
                 if(tipo2 == "L"){
                     countPecaCapturadaL++;
                     System.out.println("Você já capturou "+countPecaCapturadaL+" peças Lisas" );
                 }else{
                     countPecaCapturadaP++;
                     System.out.println("Você já capturou "+countPecaCapturadaP+" peças Perfuradas" );
                 }
             }else{            
             tabuleiro[posAtualX+1][posAtualY] = tipo1;
             tabuleiro[posAtualX][posAtualY] = "-";
             }
         }
         
         
         
         
         
         
         if(posSeguinte.equals("D") || posSeguinte.equals("d")){ 
             if(tabuleiro[posAtualX][posAtualY+1].equals(tipo2)){
                 tabuleiro[posAtualX][posAtualY+1] = "-";
                 tabuleiro[posAtualX][posAtualY+2] = tipo1;
                 tabuleiro[posAtualX][posAtualY] = "-";
                  printTabuleiro();
                 System.out.println("Quer capturar outra peça?");
                leOp = Le.umaString();
                 if(leOp.equals("S") || leOp.equals("s")){
                     System.out.println("De qual posição?");
                     System.out.println("X----");
                     int leCaptura2X = Le.umInt();
                     System.out.println("Y----");
                     int leCaptura2Y = Le.umInt();
                     if(tabuleiro[leCaptura2X][leCaptura2Y].equals(tipo2)){
                         tabuleiro[leCaptura2X][leCaptura2Y] = "-";
                         if(tipo2 == "L"){
                     countPecaCapturadaL++;
                     System.out.println("Você já capturou "+countPecaCapturadaL+" peças Lisas" );
                            }else{
                     countPecaCapturadaP++;
                     System.out.println("Você já capturou "+countPecaCapturadaP+" peças Perfuradas" );
                            }
                     } 
                 }else{
                     System.out.println("Okapa");
                 }
                 if(tipo2 == "L"){
                     countPecaCapturadaL++;
                     System.out.println("Você já capturou "+countPecaCapturadaL+" peças Lisas" );
                 }else{
                     countPecaCapturadaP++;
                     System.out.println("Você já capturou "+countPecaCapturadaP+" peças Perfuradas" );
                 }
             }else{
             tabuleiro[posAtualX][posAtualY+1] = tipo1;
             tabuleiro[posAtualX][posAtualY] = "-";
         }
         }  
         
         
         
        
         if(countPecaCapturadaL == 12 ||countPecaCapturadaP == 12 ){
             System.out.println("Parabéns você ganhou!");
             
             System.exit(0);
         }
         
         
         
         
         
         
         if(countPecaCapturadaL == 12) return countPecaCapturadaL;
         else return countPecaCapturadaP;
         
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    
   
     
       }
    

