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
public class pecaLisaCapturada extends peca{
    private pecaLisaCapturada next;
    public pecaLisaCapturada(Posicao pos, String nome) {
        super(pos, nome);
    }
     public pecaLisaCapturada( pecaLisaCapturada next){
        super(next);
      
    }
     public pecaLisaCapturada( String nome){
        super(nome);
      
    }
    public pecaLisaCapturada getNext(){
        return next;
    }
    
    public void setNext(pecaLisaCapturada c){
        next = c;
    }
    
}
