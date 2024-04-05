package app;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static final String url1 = "http://bilgisayar.kocaeli.edu.tr/prolab2/url1.txt";
    static final String url2 = "http://bilgisayar.kocaeli.edu.tr/prolab2/url2.txt";

    public static void main(String[] args) throws IOException {

        int secim = 0;
        Scanner key = new Scanner(System.in);
        String requestedUrl = url1;
        boolean next = false;
        for (;!next;) {
            System.out.print("Secili url: " + requestedUrl + "\n" +
                    "1- Url degistir\n" +
                    "2- Calistir\n" +
                    "3- Cikis\n" +
                    "Yapacaginiz islemi seciniz: ");
            secim = key.nextInt();
            System.out.println();
            if (secim == 1 ) {
                requestedUrl = urlDegistir(requestedUrl);
            } else if (secim == 2) {

                Hucre[][] hucres = new Izgara().izgaraOlustur(requestedUrl);
                Robot robot = new Robot();
                robot.setKoordinat(0, 0);
                Uygulama uygulama = new Uygulama();
                uygulama.setAdimSayisi(0);
                uygulama.setBaslamaZamani(System.currentTimeMillis());
                boolean devam = true;
                while(devam) {
                    robot.hareketEt(hucres, uygulama);
                    if (robot.getKoordinat()[0] == hucres[0].length-1 && robot.getKoordinat()[1] == hucres.length-1) devam = false;
                }
                yazdir(hucres);
                uygulama.setBitisZamani(System.currentTimeMillis());
                uygulama.setGecenSure((int) (uygulama.getBitisZamani() - uygulama.getBaslamaZamani()));
                uygulama.adimSayisiniGoster();
                uygulama.gecenSureyiGoster();

            } else if (secim == 3) {
                next = true;
            }
        }
        System.out.println("Cikis yapildi!\n");
    }

    public static String urlDegistir(String url) {

        if(!(url.equalsIgnoreCase(url1))) {
            return url1;
        }
        else return url2;
    }

    public static void yazdir(Hucre[][] hucres) {

        JFrame frame;
        Button[][] grid = new Button[hucres.length][hucres[0].length];

        frame = new JFrame("Problem1");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(hucres.length, hucres[0].length));

        for (int i = 0; i < hucres.length; i++) {
            for (int j = 0; j < hucres[i].length; j++) {

                Button cell = new Button(i, j);
                frame.add(cell);
                grid[i][j] = cell;

                if (hucres[i][j].isVisible()) {
                    if (hucres[i][j].isYanlisYol()) {
                        grid[i][j].setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\" +
                                "GezginRobot\\src\\app\\images\\yanlisyol.png"));
                    } else if (hucres[i][j].isEngel()) {
                        grid[i][j].setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\" +
                                "GezginRobot\\src\\app\\images\\duvar.png"));
                    } else if (hucres[i][j].isVisited()) {
                        grid[i][j].setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\" +
                                "GezginRobot\\src\\app\\images\\robot.png"));
                    }
                } else {
                    grid[i][j].setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\" +
                            "GezginRobot\\src\\app\\images\\graycolor.png"));
                }
            }
        }
        grid[0][0].setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\" +
                "GezginRobot\\src\\app\\images\\start.png"));
        grid[grid.length-1][grid.length-1].setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\" +
                "GezginRobot\\src\\app\\images\\finish.png"));
        frame.setVisible(true);
    }
}