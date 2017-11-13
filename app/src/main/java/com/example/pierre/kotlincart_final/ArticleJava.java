package com.example.pierre.kotlincart_final;


public class ArticleJava {

    private int prix;

    private String name;

    private Type type;


    public ArticleJava(int prix, String name, Type type) {
        this.prix = prix;
        this.name = name;
        this.type = type;
    }

    public int getPrix() {
        return this.prix;
    }

    public void setPrix(int prix){
        this.prix = prix;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Type getType(){
        return this.getType();
    }

    public void setType(Type type){
        this.type = type;
    }

}
