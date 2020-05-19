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
    public Posicao pos;
    public peca(Posicao pos, String nome){
        this.nome = nome;
        this.pos = pos;
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

    public void setPos(Posicao pos) {
        this.pos = pos;
    }
    
    
}
