package com.mycompany.poo_projeto_v2;
import com.mycompany.poo_projeto_v2.Consiglieri;
import com.mycompany.poo_projeto_v2.Familia;
import com.mycompany.poo_projeto_v2.Caporegime;
import java.util.*;


public class Mafioso extends Pessoa{
    
    private int prob_preso;//probabilidade de um mafioso ir preso
    private boolean informador;//probabilidade de um mafioso ser um informador
    
    public Mafioso(String name,int ccid){
        super(name,ccid);//buscar o nome e o ccid da super clasee
        this.prob_preso = 0;//inicializaçao da variavel de ir preso
        this.informador=false;//inicializa a varaivel ser informador
    }
    
    ///////////////////////////////////////////////GETTER E SETTER /////////////////////////

    public boolean isInformador() {//devolve se é informador ou nao
        return informador;
    }

    public void setInformador(boolean informador){//muda o estado de ser informador
        this.informador = informador;
    }
    

    public int getProb_preso() {//devolve a probabiliade de ir preso
        return prob_preso;
    }

    public void setProb_preso(int prob_preso) {//da uma valor a probabilidade de ser preso
        this.prob_preso = prob_preso;
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////
    
    public void probIrPreso(ArrayList<Mafioso> mafiosos, Familia familia){ // Aumenta a probabibilidade de ir preso de cada soldier ou caporegime e consoante a personalidade do soldier ou do caporegime
        for(Mafioso m : mafiosos){ // percorre um loop for na ArrayLis<Mafioso> mafiosos
            if(m.getInteligencia() < 35 && m.getMusculo() < 35 && ((m instanceof Caporegime)||(m instanceof Soldier)) ){ // Se o objeto percorrido for uma instância de soldier ou caporegime e tiver inteligência e músculo abaixo de 35 
                int media = (m.getInteligencia() + m.getMusculo()) / 2; // a media do valor inteligencia e do valor musculo do objeto percorrido
                m.setProb_preso(getProb_preso() + inversamenteProporcional(media)); // inverter proporcionalmente o valor da media e somar o valor de getProb_preso(), de modo a redifnir o prob_preso
                if(prob_preso >= 65){ // Se o prob_preso for maior que 65
                    familia.addEncarcerados(m); // então adicionar esse objeto que foi percorrido no loop à ArrayList<Mafioso> encarcerados
                }
            }
        } 
    }
        
  
    
    public void serInformador(ArrayList<Mafioso>mafiosos,Familia familia){
        for(Mafioso m :mafiosos){//corre a arraylist mafioso na classe familia e se a lealdade do caporegime, ou de um soldier ou de um consiglier for menor do que 40 vais tranformar esse mafioso num informador e adiciona lo a arraylist obrituario na classe familia
            if(m.getLealdade()<40 && ((m instanceof Caporegime)|| (m instanceof Soldier)||(m instanceof Consiglieri))){
                m.setInformador(true);
                familia.addObituario(m);
            }
        }
        
    }

    private int inversamenteProporcional(int n){//inverse propocionalmente o valor
        int y = 100 - n;
        return y;
    }
    
    
    @Override
    public String toString(){//devolve a probabilidade de ir preso e se é mafioso ou nao
        String texto = "";
        texto += "\nProbabilidade de ir preso: " + getProb_preso();
        texto+="\n Informador: "+ isInformador();
        return texto;
    }
} 
