package com.filmoteka;

import java.io.Serializable;
import java.text.ParseException;

/**
 * Created by BartDukes on 24.01.2017.
 */
public class FilmItem extends Film implements Serializable {

    public FilmItem(String name, String productionDate, Rate rate) throws ParseException {
        super(name, productionDate, rate);
    }

    public FilmItem(String name, String productionDate) throws ParseException {
        super(name, productionDate);
    }

    public FilmItem() {
        super();
    }
}
