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
public class yote {

    public static void menu() {
         boolean turno = false;
        lista l = new lista();
       String lePeca2 = " ";
        int x;
        System.out.println("------Saudações!-------");
        
        System.out.println("Insira o nome do jogador 1");
        String player1 = Le.umaString();
        System.out.println("Insira o nome do jogador 2");
        String player2 = Le.umaString();
        System.out.println(player1 + " qual as peças que escolhe?");
        String lePeca = Le.umaString();
        Jogador j1 = new Jogador(player1, lePeca);
        
        if(lePeca.equals("Lisas")){
            lePeca2 = "Perfuradas";
        }else{
            lePeca2 = "Lisas";
        }
        System.out.println(player2 + " Você ficou com as peças "+ lePeca2);

        System.out.println("-------------Seu turno!---------------");
        System.out.println("-----------Insira uma opção -----------");
        System.out.println(" 1 - Jogar peça");
        System.out.println(" 2 - Mover peça");
        System.out.println(" 3 - Adicionar peça");
        System.out.println(" 4 - Mostrar tabuleiro");
        System.out.println(" 5 - Acabar turno");
        System.out.println(" 0 - Sair");
        int op = Le.umInt();
        while (op != 0) {
            
            switch (op) {
                case 1:
                    System.out.println("Em que casa deseja colocar a peça");
                    System.out.println("X----");
                    int leCasa = Le.umInt();
                    System.out.println("Y----");
                    int leCasaY = Le.umInt();
                    if(lePeca2 == "Perfuradas"){
                    l.inserePecaLisa(leCasa, leCasaY);}else{
                        l.inserePecaPerfurada(leCasa, leCasaY);
                    }
                    l.printTabuleiro();
                   
                   
                case 2:
                    System.out.println("Que peça deseja mover(indique a casa)");
                    System.out.println("---------X----------");
                    int escolha = Le.umInt();
                    System.out.println("--------Y----------");
                    int escolhaY = Le.umInt();
                    System.out.println("Para que casa?");
                    System.out.println("--------X-------");
                    int vePeca = Le.umInt();
                    System.out.println("-----------Y--------");
                    int vePeca1 = Le.umInt();
                    if(lePeca2=="Perfuradas"){
                    l.movePecaLisa(vePeca, vePeca1, escolha, escolhaY);
                    }else{
                        l.movePecaPerfurada(vePeca, vePeca1, escolha, escolhaY);
                    }
                    l.printTabuleiro();
                    ; 
                    
                case 3:
                    System.out.println("------------- Insira as coordenadas ------ ");
                    System.out.println("X --");
                    int p = Le.umInt();
                    System.out.println("Y ---");
                    int t = Le.umInt();
                    l.inserePecaLisa(p, t);

                    ;
                  
                case 4:
                    l.printTabuleiro();
                    ;
                 
                case 5: 
                    ;
                    
                case 0:
            }
        }
    }

    public static void main(String[] args) {
        
        
        menu();
    }
}
