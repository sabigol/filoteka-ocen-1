package com.filmoteka;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by BartDukes on 24.01.2017.
 */
public abstract class Film implements Cloneable, Serializable {
    public static enum Rate {
        Good, Enought, Bad;
        public static int count = Rate.values().length;
    }

    private String name;
    private Date productionDate;
    private String createDate;
    private Rate rate;
    private ArrayList<Actor> actors;

    public Film() {
        name = null;
        productionDate = null;
        createDate = null;
        rate = null;
        actors = null;
    }

    public Film(String name, String productionDate) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();

        this.name = name;
        this.productionDate = dateFormat.parse(productionDate);
        this.createDate = dateTimeFormat.format(currentDate);
    }

    public Film(String name, String productionDate, Rate rate) throws ParseException {
        this(name, productionDate);
        this.rate = rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public Rate getRate() {
        return this.rate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setProductionDate(String productionDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.productionDate = dateFormat.parse(productionDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getProductionDate(){
        return this.productionDate;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }
}
