package com.ifpb.app;

import com.ifpb.model.Filme;
import com.ifpb.persist.ContextoEstendido;
import com.ifpb.persist.ContextoTransacao;
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

        ContextoEstendido estendido = new ContextoEstendido();
        ContextoTransacao transacao = new ContextoTransacao();

        estendido.persistir(filme);
        transacao.persistir(filme2);

    }
}
