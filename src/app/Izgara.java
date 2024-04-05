package app;

import java.io.IOException;

public class Izgara {

    public Hucre[][] izgaraOlustur(String url) throws IOException {

        var reader = new URLReader();
        String[][] matrix = reader.readTxt(url);

        return new Engel().engelOlustur(matrix);
    }
}
