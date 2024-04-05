package app;

public class Engel {

    public Hucre[][] engelOlustur(String[][] matrix) {

        Hucre[][] hucreler = new Hucre[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                hucreler[i][j] = new Hucre();
            }
        }

        hucreler[0][0].setVisible(true);
        hucreler[1][0].setVisible(true);
        hucreler[0][1].setVisible(true);
        hucreler[1][1].setVisible(true);

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                hucreler[i][j].setVisited(false);
                hucreler[i][j].setKoordinatX(i);
                hucreler[i][j].setKoordinatY(j);
                hucreler[i][j].setYanlisYol(false);

                int number = Integer.parseInt(matrix[i][j]);
                if (number > 0) hucreler[i][j].setEngel(true);
            }
        }
        return hucreler;
    }
}
