package com.company;

public class Aliment {
    public String numeAliment;
    public short gramaj;
    public short valoareNutritiva;
    public short proteine;
    public short carbohidrati;
    public short grasimi;

    public Aliment(String numeAliment, short gramaj, short valuareNutritiva, short proteine, short carbohidrati, short grasimi) {
        this.numeAliment = numeAliment;
        this.gramaj = gramaj;
        this.valoareNutritiva = valuareNutritiva;
        this.proteine = proteine;
        this.carbohidrati = carbohidrati;
        this.grasimi = grasimi;
    }
}

