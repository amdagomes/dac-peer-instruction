package com.ifpb.app;

import com.ifpb.model.Filme;
import com.ifpb.persist.FilmeDAO;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Amanda
 */
public class Loader {

    public static void main(String[] args) {
        Filme filme = new Filme(
                "Harry Potter",
                "Harry Potter e seus amigos seguem à procura das horcruxes...",
                "Fantasia",
                Date.valueOf(LocalDate.of(2011, 7, 15))
        );

        Filme filme2 = new Filme(
                "Harry Potter e as reliquias da morte",
                "Harry Potter e seus amigos seguem à procura das horcruxes...",
                "Fantasia",
                Date.valueOf(LocalDate.of(2011, 7, 15))
        );

        FilmeDAO filmeDAO = new FilmeDAO();

        filmeDAO.create(filme);
        filmeDAO.create(filme2);
        filmeDAO.list().forEach(
                f -> System.out.println(f.getTitulo())
        );
        System.out.println("------------------------------");

        filme.setTitulo("Harry Potter e a pedra filosofal");
        filmeDAO.update(filme);
        filmeDAO.list().forEach(
                f -> System.out.println(f.getTitulo())
        );
        System.out.println("------------------------------");

        filmeDAO.remove(filme);
        filmeDAO.list().forEach(
                f -> System.out.println(f.getTitulo())
        );
    }
}
