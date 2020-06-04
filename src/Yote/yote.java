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
        boolean turno = true;
        lista l = new lista();
        String lePeca2 = " ";
        String lePeca = " ";
        int x;
        boolean currentPlayer = false;
        System.out.println("------Saudações!-------");
        int op = -1;
        System.out.println("Insira o nome do jogador 1");
        String player1 = Le.umaString();
        System.out.println("Insira o nome do jogador 2");
        String player2 = Le.umaString();
        Jogador j1 = new Jogador(player1, lePeca);
        System.out.println(j1.nome + " qual as peças que escolhe?");
        lePeca = Le.umaString();

        Jogador j2 = new Jogador(player2, lePeca2);
        if (lePeca.equals("Lisas")) {
            lePeca2 = "Perfuradas";
        } else {
            lePeca2 = "Lisas";
        }
        System.out.println(j2.nome + " Você ficou com as peças " + lePeca2);
        currentPlayer = true;
        if(currentPlayer==true){
        while (op != 0  ) {
           
            System.out.println("-------------Seu turno!---------------");
            System.out.println("-----------Insira uma opção -----------");
            System.out.println(" 1 - Jogar peça");
            System.out.println(" 2 - Mover peça");            
            System.out.println(" 0 - Sair");
            op = Le.umInt();
            switch (op) {

                case 1:
                    System.out.println("Em que casa deseja colocar a peça");
                    System.out.println("X----");
                    int leCasa = Le.umInt();
                    System.out.println("Y----");
                    int leCasaY = Le.umInt();
                    if (lePeca2 == "Perfuradas") {
                        l.inserePecaLisa(leCasa, leCasaY);
                    } else {
                        l.inserePecaPerfurada(leCasa, leCasaY);
                    }
                    l.printTabuleiro();
                    currentPlayer = false;
                    break;

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
                    if (lePeca2 == "Perfuradas") {
                        l.movePecaLisa(vePeca, vePeca1, escolha, escolhaY);
                    } else {
                        l.movePecaPerfurada(vePeca, vePeca1, escolha, escolhaY);
                    }
                    l.printTabuleiro();
                    ;
                    currentPlayer = false;
                    break;
                   
                
                case 0:
                    turno = false;
            }
        }
    }
    else{
    menu();
}}

    public static void main(String[] args) {

        menu();
    }
}
