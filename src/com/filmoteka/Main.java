package com.filmoteka;

import com.filmoteka.FilmItem;
import com.filmoteka.FilmsList;
import com.filmoteka.filmsWindow;

import javax.swing.*;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException, CloneNotSupportedException{

        filmsWindow frame = new filmsWindow();
        frame.setVisible(true);
    }
}

