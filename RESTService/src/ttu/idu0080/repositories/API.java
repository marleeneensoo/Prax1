package ttu.idu0080.repositories;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import ttu.idu0080.utils.Converter;

public class API {
	public String makeRequest(String url){   //makeRequest vastutab päringute eest ja et saaks stringi vastuse tagasi 
        URLConnection conn;
        String response;
        try {
            conn = new URL(url).openConnection();
            InputStream in = conn.getInputStream();
            Converter converter = new Converter();
            response = converter.convertStreamToString(in);
            return response;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
