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
public class Elemento {
    private tabuleiro[][] info;
    private Elemento next;
    
    public Elemento(tabuleiro[][] o ){
        info = o;
        next = null;
    }

    public tabuleiro[][] getInfo() {
        return info;
    }

    public Elemento getNext() {
        return next;
    }

    public void setNext(Elemento next) {
        this.next = next;
    }
    
}
