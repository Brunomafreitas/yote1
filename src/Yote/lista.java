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
    private pecaPerfurada inicioPerfurada;
    private pecaLisaCapturada inicioLisasCapturas;
    private pecaPerfuradaCapturada inicioPerfuradasCapturas;
      public void insereIni(peca p){
       
            peca nova = new peca("Lisas");
            nova.setNext(inicio);
            inicio = nova;
        }
      public void insereIniPerfura(peca p){
       
            pecaPerfurada nova = new pecaPerfurada("Perfuradas");
            nova.setNext(inicioPerfurada);
            inicioPerfurada = nova;
        }
     public void insereIniPecaLisaCapturada(pecaLisaCapturada p){
       
            pecaLisaCapturada nova = new pecaLisaCapturada("Lisas");
            nova.setNext(inicioLisasCapturas);
            inicioLisasCapturas = nova;
        }
    public void insereIniPecaPerfuradaCapturada(pecaPerfuradaCapturada p){
       
            pecaPerfuradaCapturada nova = new pecaPerfuradaCapturada("Perfuradas");
            nova.setNext(inicioPerfuradasCapturas);
            inicioPerfuradasCapturas = nova;
        }
    private int countPerfuradas, countLisas;
    public lista(){
        inicio = null;
      inicioLisasCapturas = null;
      inicioPerfuradasCapturas = null;
      inicioPerfurada = null;
        tabuleiro = new String[6][5];
        countPerfuradas = 0;
        countLisas = 0;
         for (int x=0; x < 6; x++) {
             
              for (int y=0; y < tabuleiro[x].length; y++) {
                  tabuleiro[x][y] = "-";
              }
         }
    }
     
    
  public int  printPecasLisasCapturadas(){
        int ct = 0;
        peca apt;
        
        for( apt=inicioLisasCapturas; apt != null && apt.getTipo() == "Lisas"; apt = apt.getNext()){
            if(apt.getTipo() == "Lisas"){
            ct++;           
            }
        }   
        System.out.println("Número de peças Lisas capturadas " + ct);
        return ct;
    }
    public int  printPecasPerfuradasCapturadas(){
        int ct = 0;
        pecaPerfuradaCapturada apt;
        
        for( apt=inicioPerfuradasCapturas; apt != null && apt.getTipo() == "Perfuradas"; apt = apt.getNext()){
            if(apt.getTipo() == "Perfuradas"){
            ct++;           
            }
        }   
        System.out.println("Número de peças Perfuradas capturadas " + ct);
        return ct;
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
        pecaPerfurada apt;
        
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
 
    
     public void inserirPeca(int x, int y,String tipo){
        
        int ctMaximo = 0;
        
        int ctTentativa = 2;
        String verificaTipo = " ";
        boolean jatem=false ;
        
         try{
       do{
             
            
            
            if(tipo.equals("Lisas")){
            verificaTipo = "L";
        }else{
            verificaTipo = "P";
        }
            if(tabuleiro[x][y]== "L" || tabuleiro[x][y]== "P"){
                do{
                System.out.println("Escolha outra casa!");
                System.out.println("");
                System.out.println("Tentativas restantes "+ctTentativa);
                System.out.println("");
                System.out.println("X---");
                int novaCasaX = Le.umInt();
                System.out.println("");
                System.out.println("Y----");
                int novaCasaY = Le.umInt();
                ctTentativa--;
                if(tabuleiro[novaCasaX][novaCasaY] == "-"){
                    ctTentativa = 0;
                    if(verificaTipo=="Lisas" && printPecasLisas()>0){
                    tabuleiro[novaCasaX][novaCasaY] = verificaTipo;
                    }
                    if(verificaTipo=="Perfuradas" && printPecasPerfuradas()>0){
                        tabuleiro[novaCasaX][novaCasaY] = verificaTipo;
                    }
                }
                jatem = true;
                }while(ctTentativa > 0);
        }else{
            if(tipo.equals("Lisas")){
            if(inicio != null){
                tabuleiro[x][y] = verificaTipo;
                inicio = inicio.getNext();
        jatem=false;
            }else if(inicio == null){
                tabuleiro[x][y] = "-";
                System.out.println("Não há peças Lisas para jogar!");
              
            }
            }else{
                if(inicioPerfurada != null){
                    tabuleiro[x][y] = verificaTipo;
                    inicioPerfurada = inicioPerfurada.getNext();
                    jatem=false;
                }else if(inicioPerfurada ==null){
                    tabuleiro[x][y] = "-";
                    System.out.println("Não há peças Perfuradas para jogar!");
                   jatem=false;
                }
            }}
       
         }while(jatem=false);
        }catch(ArrayIndexOutOfBoundsException e ){
         
                    System.out.println("Posição inválida!");
                }
     }
     
     
     public int movePeca(int posAtualX, int posAtualY, String tipo, String posSeguinte){
        pecaLisaCapturada nova = new pecaLisaCapturada("Lisas") ;
        pecaPerfuradaCapturada novaPerfurada = new pecaPerfuradaCapturada("Perfuradas");
         int countPecaCapturadaL = 0;
         int countPecaCapturadaP = 0;
          int lePecaY = 0;
           int lePecaX = 0;
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
         int perfuradascap=0;
       int lisascap=0;
        int l=0;
        int p=0;
        int f=0;
        String lePeca;
  //Movimentar para cima!
         if(posSeguinte.equals("W") || posSeguinte.equals("w")){
            if(tabuleiro[posAtualX-1][posAtualY].equals(tipo2) && tabuleiro[posAtualX][posAtualY] != "-"){
                 if(tabuleiro[posAtualX-2][posAtualY].equals("-")){
                 tabuleiro[posAtualX-1][posAtualY] = "-";
                 tabuleiro[posAtualX-2][posAtualY] = tipo1;
                 tabuleiro[posAtualX][posAtualY] = "-";
                if(tipo2.equals("P")){
                   novaPerfurada.setNext(inicioPerfuradasCapturas);
                    inicioPerfuradasCapturas = novaPerfurada;
                    tabuleiro[posAtualX-2][posAtualY] = tipo1;
                    printPecasPerfuradasCapturadas();
                      }
                      
                else if(tipo2.equals("L")){
                    nova.setNext(inicioLisasCapturas);
                    inicioLisasCapturas = nova;
                    tabuleiro[posAtualX-2][posAtualY] = tipo1;
                    printPecasLisasCapturadas();
                 }
                 
                    
                     System.out.println("Quer capturar outra peça?");
                      lePeca = Le.umaString();
                    if(lePeca.equals("S") || lePeca.equals("s")){
                         System.out.println("De que posição?");
                         System.out.println("");
                         System.out.println("X----");
                        lePecaX = Le.umInt();
                         System.out.println("Y----");
                        lePecaY = Le.umInt();                         
                         
                       tabuleiro[lePecaX][lePecaY] = "-";
                        
                         
                     }else{
                         System.out.println("Fim do turno");
                     }
             }else{
                     System.out.println("Não pode ir para essa direção!");
                 }
             }else if(tabuleiro[posAtualX][posAtualY]!="-"){
             tabuleiro[posAtualX-1][posAtualY] = tipo1;
             tabuleiro[posAtualX][posAtualY] = "-";
              System.out.println(perfuradascap);
                System.out.println("--------------------------------------------------------------------------------");
             }
         }
          //Movimentar para baixo!
         if(posSeguinte.equals("S") || posSeguinte.equals("s")){
            if(tabuleiro[posAtualX+1][posAtualY].equals(tipo2) && tabuleiro[posAtualX][posAtualY] != "-"){
                 if(tabuleiro[posAtualX+2][posAtualY].equals("-")){
                 tabuleiro[posAtualX+1][posAtualY] = "-";
                 tabuleiro[posAtualX+2][posAtualY] = tipo1;
                 tabuleiro[posAtualX][posAtualY] = "-";
                             if(tipo2.equals("P")){
                   novaPerfurada.setNext(inicioPerfuradasCapturas);
                    inicioPerfuradasCapturas = novaPerfurada;
                    tabuleiro[posAtualX+2][posAtualY] = tipo1;
                    printPecasPerfuradasCapturadas();
                      }
                      
                else if(tipo2.equals("L")){
                    nova.setNext(inicioLisasCapturas);
                    inicioLisasCapturas = nova;
                    tabuleiro[posAtualX+2][posAtualY] = tipo1;
                    printPecasLisasCapturadas();
                 }
                         
                
                     System.out.println("Quer capturar outra peça?");
                    lePeca = Le.umaString();
                     
                     if(lePeca.equals("S") || lePeca.equals("s")){
                         System.out.println("De que posição?");
                         System.out.println("");
                         System.out.println("X----");
                        lePecaX = Le.umInt();
                         System.out.println("Y----");
                         lePecaY = Le.umInt();
                        
                     
                     tabuleiro[lePecaX][lePecaY] = "-";
               
                     
                         
                     }else{
                         System.out.println("Fim do turno");
                     }
             }else{
                     System.out.println("Não pode ir para essa direção!");
                 }
             }else if(tabuleiro[posAtualX][posAtualY]!="-"){
             tabuleiro[posAtualX+1][posAtualY] = tipo1;
             tabuleiro[posAtualX][posAtualY] = "-";
             }
         }
          //Movimentar para esquerda!
         if(posSeguinte.equals("A") || posSeguinte.equals("a")){
            if(tabuleiro[posAtualX][posAtualY-1].equals(tipo2) && tabuleiro[posAtualX][posAtualY]!="-"){
                 if(tabuleiro[posAtualX][posAtualY-2].equals("-")){
                 tabuleiro[posAtualX][posAtualY-1] = "-";
                 tabuleiro[posAtualX][posAtualY-2] = tipo1;
                 tabuleiro[posAtualX][posAtualY] = "-";
                     if(tipo2.equals("P")){
                   novaPerfurada.setNext(inicioPerfuradasCapturas);
                    inicioPerfuradasCapturas = novaPerfurada;
                    tabuleiro[posAtualX][posAtualY-2] = tipo1;
                    printPecasPerfuradasCapturadas();
                      }
                      
                else if(tipo2.equals("L")){
                    nova.setNext(inicioLisasCapturas);
                    inicioLisasCapturas = nova;
                    tabuleiro[posAtualX-2][posAtualY] = tipo1;
                    printPecasLisasCapturadas();
                 }
                 printTabuleiro();
                     System.out.println("Quer capturar outra peça?");
                     lePeca = Le.umaString();
                     
                     if(lePeca.equals("S") || lePeca.equals("s")){
                         System.out.println("De que posição?");
                         System.out.println("");
                         System.out.println("X----");
                        lePecaX = Le.umInt();
                         System.out.println("Y----");
                        lePecaY = Le.umInt();
                         
                         tabuleiro[lePecaX][lePecaY] = "-";
                         
                     }else{
                         System.out.println("Fim do turno");
                     }
             }else{
                     System.out.println("Não pode ir para essa direção!");
                 }
             }else if(tabuleiro[posAtualX][posAtualY]!="-"){
             tabuleiro[posAtualX][posAtualY-1] = tipo1;
             tabuleiro[posAtualX][posAtualY] = "-";
             }
         }
          //Movimentar para direita!
         if(posSeguinte.equals("D") || posSeguinte.equals("d")){
            if(tabuleiro[posAtualX][posAtualY+1].equals(tipo2) && tabuleiro[posAtualX][posAtualY]!="-"){
                 if(tabuleiro[posAtualX][posAtualY+2].equals("-")){
                 tabuleiro[posAtualX][posAtualY+1] = "-";
                 tabuleiro[posAtualX][posAtualY+2] = tipo1;
                 tabuleiro[posAtualX][posAtualY] = "-";
                      if(tipo2.equals("P")){
                   novaPerfurada.setNext(inicioPerfuradasCapturas);
                    inicioPerfuradasCapturas = novaPerfurada;
                    tabuleiro[posAtualX][posAtualY+2] = tipo1;
                    printPecasPerfuradasCapturadas();
                      }
                      
                else if(tipo2.equals("L")){
                    nova.setNext(inicioLisasCapturas);
                    inicioLisasCapturas = nova;
                    tabuleiro[posAtualX-2][posAtualY] = tipo1;
                    printPecasLisasCapturadas();
                 }
                 printTabuleiro();
                     
                     System.out.println("Quer capturar outra peça?");
                    lePeca = Le.umaString();
                     
                     if(lePeca.equals("S") || lePeca.equals("s")){
                         System.out.println("De que posição?");
                         System.out.println("");
                         System.out.println("X----");
                        lePecaX = Le.umInt();
                         System.out.println("Y----");
                       lePecaY = Le.umInt();
                         
                         tabuleiro[lePecaX][lePecaY] = "-";
                         
                     }else{
                         System.out.println("Fim do turno");
                     }
             }else{
                     System.out.println("Não pode ir para essa direção!");
                 }
             }else if(tabuleiro[posAtualX][posAtualY]!="-"){
             tabuleiro[posAtualX][posAtualY+1] = tipo1;
             tabuleiro[posAtualX][posAtualY] = "-";
             }
         }
        
        if(perfuradascap==2){
            f=2;
           }
        else if(lisascap==2) {
              f=3;  
                   }
        
         
         
         
         
         
    return f;
     
     }  
     
     
     
  
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    
   
     
       }
    

