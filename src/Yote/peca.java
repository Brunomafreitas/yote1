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
public class peca {
    
    private String nome;
    private Posicao pos;
    private peca next;
    public peca(Posicao pos, String nome){
        this.nome = nome;
        this.pos = pos;
    }
    public peca( String nome){
        this.nome = nome;
      
    }
    
    public peca( peca next){
        this.next = next;
      
    }
    
    

    public String getTipo() {
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public Posicao getPos() {
        return pos;
    }
    public peca getNext(){
        return next;
    }
    
    public void setNext(peca c){
        next = c;
    }

    public void setPos(Posicao pos) {
        this.pos = pos;
    }
    
    
}
