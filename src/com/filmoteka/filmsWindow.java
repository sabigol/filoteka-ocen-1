package com.filmoteka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BartDukes on 25.01.2017.
 */
public class filmsWindow extends JFrame {
    private JPanel _firstPanel;
    private JPanel _listFilmsPanel;
    private JScrollPane _listFilmsPane;
    public JList<String> _listFilms;
    private JPanel _addFilmPanel;
    private JButton _addFilm;
    public FilmsList films;

    public DefaultListModel<String> listModel;


    public filmsWindow() throws ParseException {
        setSize(400, 400);
        setTitle("Filmoteka");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // init

        FilmItem film1 = new FilmItem("Interstellar", "2014-12-06");
        FilmItem film2 = new FilmItem("Czlowiek ktory poznal nieskonczonosc", "2016-02-12");
        FilmItem film3 = new FilmItem("Slumdog", "2010-04-03");
        films = new FilmsList("Moje filmy");
        films.addFilm(film1);
        films.addFilm(film2);
        films.addFilm(film3);

        films.saveFile("filmsList.bin");

        JPanel _firstPanel = new JPanel();
        add(_firstPanel);

        // Films list

        JPanel _listFilmsPanel = new JPanel();
        _firstPanel.add(_listFilmsPanel);

        JScrollPane _listFilmsPane = new JScrollPane();
        _firstPanel.add(_listFilmsPane);

        JList _listFilms = new JList();
        _firstPanel.add(_listFilms);
        _listFilmsPane.setViewportView(_listFilms);


        // Button

        films = FilmsList.readFile();
        listModel = new DefaultListModel<>();

        for(FilmItem item:films.getFilms()) {
            listModel.addElement( item.getName() + " (" + item.getProductionDate().getYear() + ")" );
        }
        _listFilms.setModel( listModel );

        JPanel _addFilmPanel = new JPanel();
        _firstPanel.add(_addFilmPanel);

        JButton _addFilm = new JButton("Dodaj film");
        _addFilmPanel.add(_addFilm);

        _addFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFilmDialog newFilm = new newFilmDialog((FilmItem) -> films.addFilm(FilmItem));
                newFilm.setVisible(true);

            }
        });
    }

}
