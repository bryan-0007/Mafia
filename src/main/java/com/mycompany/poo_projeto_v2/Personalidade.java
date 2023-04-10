package com.mycompany.poo_projeto_v2;
import java.util.Random;


public class Personalidade {
    private int lealdade,musculo,inteligencia,estratega,carisma;//personalidades das pessoas
    private Random rand= new Random();//invocação da classe random para obtermos um numero random
    
    public Personalidade(){
        this.lealdade=rand.nextInt(101);
        this.musculo=rand.nextInt(101);
        this.inteligencia=rand.nextInt(101);
        this.estratega=rand.nextInt(101);
        this.carisma=rand.nextInt(101);
    }
    
    ///////////////////////////////GETTER E SETTERS ///////////////////////////////////

    public void setLealdade(int lealdade) {
        this.lealdade = lealdade;
    }

    public void setMusculo(int musculo) {
        this.musculo = musculo;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void setEstratega(int estratega) {
        this.estratega = estratega;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }
    
    public int getLealdade() {
        return lealdade;
    }
    public int getMusculo() {
        return musculo;
    }
    public int getInteligencia() {
        return inteligencia;
    }
    public int getEstratega() {
        return estratega;
    }
    public int getCarisma() {
        return carisma;
    }
 /////////////////////////////////////////////////////////////////////////////////////////////////////////   
    public String toString(){//retorna ao utilizador cada um dos traços de personalidade da pessoa
        String texto;
        texto="\nLealdade:"+lealdade+"\n";
        texto+="Musculo:"+musculo+"\n";
        texto+="Inteligencia:"+inteligencia+"\n";
        texto+="Estratega:"+estratega+"\n";
        texto+="Carisma:"+carisma+"\n";
        return texto;
    } 
}
