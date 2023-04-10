package com.mycompany.poo_projeto_v2;

import java.util.ArrayList;

public class Boss extends Mafioso {
    private ArrayList<Caporegime> regimes;//lista com todos os caporegimes que o boss possui
     
    public Boss(String nome, int ccid){
        super(nome,ccid);//chamamento da super class para ir buscar o nome e o seu ccid
        regimes=new ArrayList<Caporegime>();//inicialização do arraylist regimes
    }
    
    //////////////////////////////////////////////////GETTER//////////////////////////////

    public ArrayList<Caporegime> getRegimes() { //buscar a arraylist onde esta contido todos os caporegimes do Boss
        return regimes;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////

    public void addRegimes(Caporegime caporegime){//adicionar caporegimes na arraylist regimes
        regimes.add(caporegime);
    }
    
    public String equipaCaporegime(Caporegime capo){ //mostra a equipa de onde o soldier pertence
        int num_equipa = 0;
        for(int i=0; i < regimes.size(); i++){//percorre a arraylist onde onde esta os caporegimes
            num_equipa++;//se nao tiver no primeiro caporegime vai adicionar mais 1 na variavel numero de equipa
            if(capo == regimes.get(i)){//se o caporegime inserido for igual ao que esta a ser percorrido no for o loop acaba e retorna a variavel do num de equipa
                break;
            }
        }
        String texto = "Equipa: ";
        return  texto + num_equipa;
    }

    @Override
    public String toString() { //retorna o nome do boss, o seu respetivo ccid, as suas personalidades e a sua classe
        String texto = "";
        texto += "\nNome: "+ getNome() + "\nCCID= " + getCcid();
        texto += "\nLealdade: "+ getLealdade() + "\nMusculo: " + getMusculo() + "\nInteligencia: " + getInteligencia() + "\nEstratega: " + getEstratega() + "\nCarisma: " + getCarisma();
        texto += "\nInformador: " + isInformador();
        texto += "\nClasse: Boss\n";
        return texto;
    }
   
}
