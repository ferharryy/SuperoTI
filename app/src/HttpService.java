package com.com.superoti.superoti.service;

import android.os.AsyncTask;

import com.com.superoti.superoti.models.ArquivoModel;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.Gson;

public class HttpService extends AsyncTask<Void, Void, ArquivoModel>{

    public HttpService() { }

    @Override
    protected ArquivoModel doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();

            try {
                URL url = new URL("https://api.github.com/search/repositories?q=language:Java&sort=stars)");

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);
                connection.setConnectTimeout(5000);
                connection.connect();

                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    resposta.append(scanner.next());
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        return new Gson().fromJson(resposta.toString(), ArquivoModel.class);
    }
}
