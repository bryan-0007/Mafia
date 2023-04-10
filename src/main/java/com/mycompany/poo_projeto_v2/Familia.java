package com.mycompany.poo_projeto_v2;

import com.mycompany.poo_projeto_v2.Caporegime;
import com.mycompany.poo_projeto_v2.Associate;
import java.util.*;
import java.io.*;

public class Familia {

    Random rand = new Random();
    private String nome_fam;//nome da familia
    private Consiglieri consiglieri;//objeto do tipo consiglier para o podermos usar na funçao nomeia consiglier no main

    private ArrayList<Mafioso> obituario;//arraylist onde contem todos os mortos da familia
    private ArrayList<Mafioso> encarcerados;//arraylst onde contem todos os membros da familia preso
    private ArrayList<Mafioso> mafiosos;//arraylist onde contem todos os membros da familia
    private ArrayList<Negocio> negocios;//arraylist onde contem todos os negocios da familia
    private ArrayList<Associate> associados;//arraylist onde contem todos os associados da familia
    private ArrayList<Associate> associados_sem_linhagem;//arraylist onde contem todos os associados sem linhagem
    private HashMap<Negocio, ArrayList<Caporegime>> caponegocios;//uma hash map onde um negocio vai ter varios caporegimes da familia
    private HashMap<Negocio, ArrayList<Associate>> assonegocios;//hashmap  onde um negocio vai ter varios associates da familia

    private int riqueza_acumulada;//riqueza total da familia
    private int custos_preso;//preço para retirar da prisao um membro da familia

    public Familia(String nome_fam) {//inicializaçao no construtor
        this.nome_fam = nome_fam;
        this.custos_preso = 100;
        consiglieri = null;
        obituario = new ArrayList<Mafioso>();
        encarcerados = new ArrayList<Mafioso>();
        mafiosos = new ArrayList<Mafioso>();
        negocios = new ArrayList<Negocio>();
        riqueza_acumulada = rand.nextInt(5001) + 5000;
        caponegocios = new HashMap<Negocio, ArrayList<Caporegime>>();
        assonegocios = new HashMap<Negocio, ArrayList<Associate>>();
        associados_sem_linhagem = new ArrayList<Associate>();
        associados = new ArrayList<Associate>();
    }

    ////////////////////////////////////GETTERS E SETTERS /////////////////////////////////////////////
    public ArrayList<Associate> getAssociados() {
        return associados;
    }

    public HashMap<Negocio, ArrayList<Caporegime>> getCaponegocios() {
        return caponegocios;
    }

    public HashMap<Negocio, ArrayList<Associate>> getAssonegocios() {
        return assonegocios;
    }

    public Consiglieri getConsiglieri() {
        return consiglieri;
    }

    public void setConsiglieri(Consiglieri consiglieri) {
        this.consiglieri = consiglieri;
    }

    public ArrayList<Associate> getAssociados_sem_linhagem() {
        return associados_sem_linhagem;
    }

    public int getRiqueza_acumulada() {
        return riqueza_acumulada;
    }

    public void setRiqueza_acumulada(int riqueza_acumulada) {
        this.riqueza_acumulada = riqueza_acumulada;
    }

    public ArrayList<Negocio> getNegocios() {
        return negocios;
    }

    public String getNome_fam() {
        return nome_fam;
    }

    public ArrayList<Mafioso> getObituario() {
        return obituario;
    }

    public ArrayList<Mafioso> getEncarcerados() {
        return encarcerados;
    }

    public ArrayList<Mafioso> getMafiosos() {
        return mafiosos;
    }

    public int getCustos_preso() {
        return custos_preso;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int getCustoPoliciaTotal(ArrayList<Negocio> negocios) {//vai percorrer todos os negocios da familia pelo arraylist negocios buscando o custo policial em cada negocio retornando no final o valor total dos custos policiais de todos os negocios
        int custos_policial_total = 0;
        for (int i = 0; i < getNegocios().size(); i++) {
            custos_policial_total = getNegocios().get(i).getCustos_policia();
        }
        return custos_policial_total;
    }

    public void addAssociados(Associate assoc) {//adiciona um associado á arraylist associados
        associados.add(assoc);
    }

    public void addAssociadosSemLinhagem(Associate assoc) {//adicionar um associado sem linhagem a arryalist sem lingaem
        associados_sem_linhagem.add(assoc);
    }

    public void addNegocios(Negocio negocio) {//adiciona um negocio a arraylist negocios 
        negocios.add(negocio);
    }

    public void addObituario(Mafioso mafioso) {//adiciona um mafioso a arraylist obituario
        obituario.add(mafioso);
    }

    public void addEncarcerados(Mafioso mafioso) {//adiciona um mafioso a arraylist encarcerados
        encarcerados.add(mafioso);
    }

    public void addMafiosos(Mafioso mafioso) {//adiciona um mafioso a arraylist mafiosos
        mafiosos.add(mafioso);
    }

    @Override
    public String toString() {//retorna o nome da familia, o obituario da familia,os encarcerados da familia,a riqueza acumulada da familia,todos os negocios da familia e todos os mafiosos da familia
        String texto = "";
        texto += "\nNome da familia: " + getNome_fam();
        texto += "\nObituario: " + getObituario() + "\nEncarcerados: " + getEncarcerados();
        texto += "\nRiqueza acumulada: " + getRiqueza_acumulada() + "\nNegocios: " + getNegocios() + "\nMafiosos da familia: " + getMafiosos();
        return texto;
    }
}
