package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class URLReader {

    public String[][] readTxt(String requestUrl) throws IOException {

        URL url = new URL(requestUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;

        ArrayList<char[]> lines = new ArrayList<>();
        while ((inputLine = in.readLine()) != null) {

            lines.add(inputLine.toCharArray());
        }

        in.close();
        con.disconnect();

        String[][] matrix = new String[lines.size()][lines.get(0).length];

        for (int i = 0; i < lines.size(); i++) {

            for (int j = 0; j < lines.get(i).length; j++) {

                matrix[i][j] = String.valueOf(lines.get(i)[j]);
            }
        }

        return matrix;
    }
}
