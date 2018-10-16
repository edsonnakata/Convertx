package convertx.ic.ufmt.br.convertx;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class HTTPService extends AsyncTask<Void, Void, Moeda> {


    @Override
    protected Moeda doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();

        try {
            URL url = new URL("http://data.fixer.io/api/latest?access_key=b5dc31fca4e81a03e1062a30c7b5bd33&symbols=USD,BRL,GBP,CHF,JPY,AUD,ARS,CLP,CAD,EUR");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setConnectTimeout(5000);
            connection.connect();


            Scanner scanner = new Scanner(url.openStream());
            while(scanner.hasNext()){
                resposta.append(scanner.next());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Gson().fromJson(resposta.toString(), Moeda.class);
    }
}
