package app;

public class Robot {

    private int[] koordinat = new int[2];
    private int[] eskiKoordinat = new int[2];

    public int[] getKoordinat() {
        return koordinat;
    }

    public void setKoordinat(int rowNo, int columnNo) {
        this.koordinat[0] = rowNo;
        this.koordinat[1] = columnNo;
    }

    public int[] getEskiKoordinat() {
        return eskiKoordinat;
    }

    public void setEskiKoordinat(int[] eskiKoordinat) {
        this.eskiKoordinat = eskiKoordinat;
    }

    public void hareketEt(Hucre[][] hucres, Uygulama uygulama) {

        uygulama.setAdimSayisi(uygulama.getAdimSayisi() + 1);

        int rowSize = hucres[0].length;
        int columnSize = hucres.length;

        this.setEskiKoordinat(this.getKoordinat());

        int rowNo = this.getKoordinat()[0];
        int columnNo = this.getKoordinat()[1];

        int cellOnRightX = rowNo + 1;
        int cellOnBelowY = columnNo + 1;
        int cellOnLeftX = rowNo - 1;
        int cellOnAboveY = columnNo - 1;

        if ((cellOnRightX < rowSize) && !hucres[columnNo][cellOnRightX].isEngel() && !hucres[columnNo][cellOnRightX].isYanlisYol()) {

            this.setKoordinat(cellOnRightX, columnNo);
            hucres[columnNo][cellOnRightX].setVisited(true);
        } else if ((cellOnBelowY < columnSize) && !hucres[cellOnBelowY][rowNo].isEngel() && !hucres[cellOnBelowY][rowNo].isYanlisYol()) {

            this.setKoordinat(rowNo, cellOnBelowY);
            hucres[cellOnBelowY][rowNo].setVisited(true);
        } else if (!hucres[columnNo][cellOnLeftX].isEngel() && !hucres[columnNo][cellOnLeftX].isYanlisYol()) {

            this.setKoordinat(cellOnLeftX, columnNo);
            hucres[columnNo][cellOnLeftX].setVisited(true);
            hucres[columnNo][rowNo].setYanlisYol(true);
        } else {

            this.setKoordinat(rowNo, cellOnAboveY);
            hucres[cellOnAboveY][rowNo].setVisited(true);
            hucres[columnNo][rowNo].setYanlisYol(true);
        }

        rowNo = this.getKoordinat()[0];
        columnNo = this.getKoordinat()[1];

        cellOnRightX = rowNo + 1;
        cellOnBelowY = columnNo + 1;
        cellOnLeftX = rowNo - 1;
        cellOnAboveY = columnNo - 1;

        if (cellOnRightX < rowSize) hucres[columnNo][cellOnRightX].setVisible(true);
        if (cellOnBelowY < columnSize) hucres[cellOnBelowY][rowNo].setVisible(true);
        if (cellOnLeftX >= 0) hucres[columnNo][cellOnLeftX].setVisible(true);
        if (cellOnAboveY >= 0) hucres[cellOnAboveY][rowNo].setVisible(true);
    }
}
