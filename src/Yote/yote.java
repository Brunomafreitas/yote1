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

    public static void lisasprimeiro() {

    }

    public static void menu() {
        boolean turno = true;
        peca[] pecas = new peca[2];
        lista l = new lista();
        String lePeca2;
        String lePeca;
        int x;
        Jogador j1;
        Jogador j2;

        System.out.println("------Saudações!-------");
        int op = -1;
        Jogador[] jogadores = new Jogador[2];
        System.out.println("Insira o nome do jogador 1");
        String player1 = Le.umaString();

        System.out.println("Insira o nome do jogador 2");
        String player2 = Le.umaString();

        System.out.println(player1 + " qual as peças que escolhe?");
        lePeca = Le.umaString();

        if (lePeca.equals("Lisas")) {
            lePeca2 = "Perfuradas";

        } else {
            lePeca2 = "Lisas";
        }

        j1 = new Jogador(player1, lePeca);
        j2 = new Jogador(player2, lePeca2);
        jogadores[0] = j1;
        jogadores[1] = j2;
        //-----------------------------------------------------------------------------
        peca p1 = new peca("Lisas");
        peca p2 = new peca("Lisas");
        peca p3 = new peca("Lisas");
        peca p4 = new peca("Lisas");
        peca p5 = new peca("Lisas");
        peca p6 = new peca("Lisas");
        peca p7 = new peca("Lisas");
        peca p8 = new peca("Lisas");
        peca p9 = new peca("Lisas");
        peca p10 = new peca("Lisas");
        peca p11 = new peca("Lisas");
        peca p12 = new peca("Lisas");
        l.insereIni(p1);
        l.insereIni(p2);
        l.insereIni(p3);
        l.insereIni(p4);
        l.insereIni(p5);
        l.insereIni(p6);
        l.insereIni(p7);
        l.insereIni(p8);
        l.insereIni(p9);
        l.insereIni(p10);
        l.insereIni(p11);
        l.insereIni(p12);

        peca p13 = new peca("Perfuradas");
        peca p14 = new peca("Perfuradas");
        peca p15 = new peca("Perfuradas");
        peca p16 = new peca("Perfuradas");
        peca p17 = new peca("Perfuradas");
        peca p18 = new peca("Perfuradas");
        peca p19 = new peca("Perfuradas");
        peca p20 = new peca("Perfuradas");
        peca p21 = new peca("Perfuradas");
        peca p22 = new peca("Perfuradas");
        peca p23 = new peca("Perfuradas");
        peca p24 = new peca("Perfuradas");

        l.insereIniPerfura(p13);
        l.insereIniPerfura(p14);
        l.insereIniPerfura(p15);
        l.insereIniPerfura(p16);
        l.insereIniPerfura(p17);
        l.insereIniPerfura(p18);
        l.insereIniPerfura(p19);
        l.insereIniPerfura(p20);
        l.insereIniPerfura(p21);
        l.insereIniPerfura(p22);
        l.insereIniPerfura(p23);
        l.insereIniPerfura(p24);

        System.out.println("");
        System.out.println("");
        System.out.println(j2.getNome() + " Você ficou com as peças " + lePeca2);
        System.out.println("");
        System.out.println("");
        System.out.println(j1.getNome() + " Você ficou com as peças " + lePeca);

        while (op != 0) {
            for (int c = 0; c < 2; c++) {
                System.out.println(jogadores[c].getPeca());
                System.out.println("Seu turno!   " + jogadores[c].getNome() + " ");
                System.out.println("");
                System.out.println("");
                System.out.println("-----------Insira uma opção -----------");
                System.out.println(" 1 - Jogar peça");
                System.out.println(" 2 - Mover peça");
                System.out.println(" 0 - Sair");
                op = Le.umInt();

                //----------------------asddsaasddasdas-----------------------------------------------------------------------------------------------------
                switch (op) {

                    case 1:

                        System.out.println("Em que casa deseja colocar a peça");
                        System.out.println("X----");
                        int leCasa = Le.umInt();
                        System.out.println("Y----");
                        int leCasaY = Le.umInt();
                        l.inserirPeca(leCasa, leCasaY, jogadores[c].getPeca());
                        l.printTabuleiro();
                        System.out.println("");
                        if (jogadores[c].getPeca() == "Lisas") {
                            l.printPecasLisas();
                        } else {
                            l.printPecasPerfuradas();
                        }
                        if (l.printPecasLisas() == 0) {
                            System.out.println("Não há mais peças Lisas para jogar, só pode fazer movimentos agora!");
                        }
                        if (l.printPecasPerfuradas() == 0) {
                            System.out.println("Não há mais peças Perfuradas para jogar, só pode fazer movimentos agora!");
                        }

                        break;

                    case 2:

                        System.out.println("Que peça deseja mover(indique a casa)");
                        System.out.println("---------X----------");
                        int escolha = Le.umInt();
                        System.out.println("--------Y----------");
                        int escolhaY = Le.umInt();
                        System.out.println("Para que casa ( Use A W S D)");
                        String l1 = Le.umaString();

                        l.movePeca(escolha, escolhaY, jogadores[c].getPeca(), l1);
                            if(l.printPecasLisasCapturadas()>=2){
                                 if(jogadores[c].getPeca().equals("Perfuradas")){
                                 System.out.println(jogadores[c].getNome() + "Ganhou!");
                                 System.exit(0);
                                 }
                             }else if(l.printPecasPerfuradasCapturadas() >= 2){
                                 if(jogadores[c].getPeca().equals("Perfuradas")){
                                 System.out.println(jogadores[c].getNome() + "Ganhou!");
                                 System.exit(0);
                                 }
                             }
                        l.printTabuleiro();

                    case 0:
                        turno = false;

                        if (l.printPecasLisas() == 0) {

                        }
                }

               
                //---------------------------------------------------------------------------------------------------------------------------
            }
        }

    }

    public static void main(String[] args) {

        menu();

    }
}
