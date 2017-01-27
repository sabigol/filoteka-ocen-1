package com.filmoteka;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by BartDukes on 24.01.2017.
 */
public class FilmsList implements Cloneable, Serializable {
    private int filmsCount;
    private String name;
    private ArrayList<FilmItem> films;

    public FilmsList() {
        this.filmsCount = 0;
        this.name = null;
        this.films = new ArrayList<>();
    }

    public FilmsList(String name) {
        this();
        this.name = name;
    }

    public FilmsList(String name, ArrayList<FilmItem> films) {
        this(name);
        this.films = films;
    }

    public ArrayList<FilmItem> getFilms() {
        return films;
    }

    public void setFilms(ArrayList<FilmItem> films) {
        this.films = films;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFilmsCount() {
        return filmsCount;
    }

    public void addFilm(FilmItem film) {
        this.films.add(film);
        this.filmsCount++;
    }

    public static FilmsList readFile(String name){
        FilmsList list = null;
        try (FileInputStream file = new FileInputStream(name)) {
            ObjectInputStream in = new ObjectInputStream(file);
            list = (FilmsList)in.readObject();
            in.close();
        }
        catch(IOException e){
            System.out.println("Serialization Error");
        }
        catch(ClassNotFoundException  e){
            System.out.println("Serialization Error");
        }
        finally {
            return list;
        }
    }

    public static FilmsList readFile(){
        return readFile("filmsList.bin");
    }


    public void saveFile(String nazwa){
        try (FileOutputStream file = new FileOutputStream(nazwa)) {
            ObjectOutputStream outputObject = new ObjectOutputStream(file);
            outputObject.writeObject(this);
            outputObject.close();
        }
        catch(IOException  e){
            System.out.println("Serialization Error");
        }
    }
}
