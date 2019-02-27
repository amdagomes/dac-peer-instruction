package com.ifpb.persist;

import com.ifpb.interfaces.FilmeInterface;
import com.ifpb.model.Filme;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Amanda
 */
public class PersistArquivo implements FilmeInterface {

    @Override
    public void adiconar(Filme filme) {
        File file = new File("filme.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
                output.writeObject(filme.toString());
                output.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
   

}
