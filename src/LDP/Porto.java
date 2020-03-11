/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LDP;

import comum.Le;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author senho
 */
public class Porto {

    ArrayList<Navio> navio;
    Navio[] navios;
    private int ct;
    private int noMaxNavios;

    public Porto(int noMaxNavios) {
        ct = 0;
        this.noMaxNavios = noMaxNavios;
        navios = new Navio[noMaxNavios];
        navio = new ArrayList<Navio>(noMaxNavios);
    }

    public int getNoMaxNavios() {
        return noMaxNavios;
    }

    public Navio[] getNavios() {
        return navios;
    }

    public void addNavio(Navio n) {

        if (ct == noMaxNavios) {
            System.out.println("Número máximo de navios (" + noMaxNavios + ") Atingido!!");
        }
        boolean confirma = false;
        for (Navio nave : navio) {
            if (n.equals(nave.getMatricula())) {
                System.out.println("Navio já existe!!");
                confirma = true;
            }

            if (!confirma) {
                navio.add(nave);
                ct++;
            }

        }

    }

    public int getCapacidadeTotalContentores() {

        int total = 0;
        for (Navio p : navio) {
            if (p instanceof NavioPortaContentores) {
                total += ((NavioPortaContentores) p).getNoMaxContentores();
            }
        }

        return total;
    }

    public int getCapacidadeDeCarga() {
        int total = 0;
        for (Navio p : navio) {
            if (p instanceof NavioPortaContentores) {
                total += ((NavioPortaContentores) p).getNoMaxContentores() * 10;
            }
            if (p instanceof NavioPetroleiro) {
                total += ((NavioPetroleiro) p).getCapacidadeCarga() * 10;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Porto porto = new Porto(3);

        NavioPetroleiro petro1 = new NavioPetroleiro("1234");
        petro1.setCapacidadeCarga(200);
        petro1.setComprimento(100);
        NavioPortaContentores contenta = new NavioPortaContentores("12312");
        contenta.setNoMaxContentores(100);
        porto.addNavio(petro1);
        porto.addNavio(contenta);
        System.out.println(porto.getCapacidadeTotalContentores());
        System.out.println("-------------------------------------------------");
        Navio n = new Navio("666");
        n.setComprimento(1000);
            System.out.println("");
            
    }

}
