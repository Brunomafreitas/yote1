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
    
    private int noMaxNavios;

    public Porto() {
     navio = new ArrayList<>();
    }

    public int getNoMaxNavios() {
        return noMaxNavios;
    }

    

    public void addNavio(Navio n) {

       if(!procura(n)){
               System.out.println("Esse navio já existe!");
       }
           else{
               
           }
       }

    private boolean procura(Navio n) {
       for(Navio p : navio){
           if(n.getMatricula().equals(p.getMatricula()))
                return true;
       } 
            return false;
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

    public float getCapacidadeDeCarga() {
        float total = 0;
        for (Navio p : navio) {
            if (p instanceof NavioPortaContentores) {
                total += ((NavioPortaContentores) p).getNoMaxContentores() * 10f;
            }
            if (p instanceof NavioPetroleiro) {
                total += ((NavioPetroleiro) p).getCapacidadeCarga() * 10f;
            }
        }
        return total;
    }
    
    public void ListNavios(){
        for(Navio n : navio){
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        Porto porto = new Porto();

        Navio n = new Navio("1");
        NavioPetroleiro nP = new NavioPetroleiro("2");
        NavioPortaContentores nC = new NavioPortaContentores("3");
        
        n.setNome("n1");
        nP.setNome("N2"); nP.setCapacidadeCarga(10);
        nC.setNome("n3"); nC.setNoMaxContentores(10);
        
        porto.addNavio(n);
        porto.addNavio(nP);
        porto.addNavio(nC);
        
        porto.ListNavios();
        
            System.out.println("Total de carga = "+porto.getCapacidadeDeCarga());
    }

}
