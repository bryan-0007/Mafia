package com.mycompany.poo_projeto_v2;

import com.mycompany.poo_projeto_v2.Personalidade;

public class Pessoa extends Personalidade{
    private String nome;//nome da pessoa
    private int ccid;//ccid da pessoa
    
    public Pessoa(String nome,int ccid){   
        this.nome=nome;
        this.ccid=ccid; 
    }
    
    //////////////////////////////GETTER E SETTERS///////////////////////////////////////////
    public String getNome() {
        return nome;
    }

    public int getCcid() {
        return ccid;
    }
 
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public String toString(){//retorna o nome da pessoa e o seu ccid
        String texto;
        texto=super.toString();//vai buscar os traços de personalidade da super class do metodo toString
        texto+="\nO nome é: "+nome+"\n";
        texto+="O ccid é: "+ccid+"\n";
        return texto;
    }

    //metodo que vê se dois objetos da classe pessoa sao iguais consoante o seu ccid
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.ccid != other.ccid) {
            return false;
        }
        return true;
    }

    
}
