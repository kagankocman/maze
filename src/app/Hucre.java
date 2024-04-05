package app;

public class Hucre {

    private int koordinatX;
    private int koordinatY;
    private boolean isEngel;
    private boolean isYanlisYol;
    private boolean isVisited;
    private boolean isVisible;


    public boolean isEngel() {
        return isEngel;
    }

    public void setEngel(boolean engel) {
        isEngel = engel;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getKoordinatX() {
        return koordinatX;
    }

    public void setKoordinatX(int koordinatX) {
        this.koordinatX = koordinatX;
    }

    public int getKoordinatY() {
        return koordinatY;
    }

    public void setKoordinatY(int koordinatY) {
        this.koordinatY = koordinatY;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public boolean isYanlisYol() {
        return isYanlisYol;
    }

    public void setYanlisYol(boolean yanlisYol) {
        isYanlisYol = yanlisYol;
    }
}
