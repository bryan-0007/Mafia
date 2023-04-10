package com.mycompany.poo_projeto_v2;
import java.util.*;

public class Negocio{
    
    private String nome_negocio;//variavel com o nome do negocio
    private int pagamentos;//variavel com os pagamentos de cada negocio
    private int custos_policia;//variavel com o custo que cada negocio paga a policia
    
    public Negocio(String nome_negocio){
        this.nome_negocio=nome_negocio;
        this.pagamentos = 500;
        this.custos_policia = 100;
    }
    
    //////////////////////////////////////GETTER E SETTER ////////////////////////////7

    public int getCustos_policia() {
        return custos_policia;
    }

    public int getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(int pagamentos) {
        this.pagamentos = pagamentos;
    }
    
    public String getNome_negocio() {
        return nome_negocio;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////
    
    @Override
    public String toString() {// devolve ao utilizador o nome do negocio e quanto o negocio paga a familia
        String texto = "";
        texto += "\nNome de negocios: "+ nome_negocio;
        texto+="\nCusto do negocio: "+pagamentos;
        return texto;
    }
  
}
