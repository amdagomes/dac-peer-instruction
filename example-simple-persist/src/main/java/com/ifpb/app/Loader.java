package com.ifpb.app;

import com.ifpb.interfaces.FilmeInterface;
import com.ifpb.model.Filme;
import com.ifpb.persist.PersistArquivo;
import com.ifpb.persist.PersistSGBD;
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

        FilmeInterface persistSGBD = new PersistSGBD();
        FilmeInterface persistArquivo = new PersistArquivo();

        persistSGBD.adiconar(filme);
        persistArquivo.adiconar(filme);
    }
}
