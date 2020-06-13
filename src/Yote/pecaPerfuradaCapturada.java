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
class pecaPerfuradaCapturada extends peca{
    private pecaPerfuradaCapturada next;
    public pecaPerfuradaCapturada(Posicao pos, String nome) {
        super(pos, nome);
    }
     public pecaPerfuradaCapturada( pecaLisaCapturada next){
        super(next);
      
    }
     public pecaPerfuradaCapturada( String nome){
        super(nome);
      
    }
    public pecaPerfuradaCapturada getNext(){
        return next;
    }
    
    public void setNext(pecaPerfuradaCapturada c){
        next = c;
    }
}
