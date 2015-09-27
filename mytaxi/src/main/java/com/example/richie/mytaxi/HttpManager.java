package com.example.richie.mytaxi;

import com.squareup.okhttp.OkHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Richie on 19-03-2015.
 */

public class HttpManager {

    public static String getData(String uri) {

        BufferedReader reader = null;
        try {
            URL url = new URL(uri);
//            OkHttpClient ok_Client = new OkHttpClient();
            HttpURLConnection con_Url = (HttpURLConnection) url.openConnection();

            StringBuilder builder = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(con_Url.getInputStream()));
            String line;
            while((line = reader.readLine())!=null){

                builder.append(line+"\n");
            }

            return builder.toString();

        } catch (Exception e) {
            e.printStackTrace();
           return null;
        } finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
/*
    public static String getData(RequestMethod p) {

        BufferedReader br = null;
        String uri = p.getUrl();

        if (p.getMethod().equals("GET")) {
            uri += "?" + p.getEncodedParams();
        }
        try {

            URL url = new URL(uri);
//		   OkHttpClient ok_Client = new OkHttpClient();
//ok_client.Open(url);
            HttpURLConnection con_Url = (HttpURLConnection) url.openConnection();
            con_Url.setRequestMethod(p.getMethod());

            if (p.getMethod().equals("POST")) {
                con_Url.setDoOutput(true);
                OutputStreamWriter writer = new OutputStreamWriter(
                        con_Url.getOutputStream());
                writer.write(p.getEncodedParams());
                writer.flush();
            }

			*/
/*it is used to access the data from the web url link.*//*

            StringBuilder builder = new StringBuilder();
            br = new BufferedReader(new InputStreamReader(con_Url.getInputStream()));


			*/
/*this line code tells us that line variable is used to read the url
			 * and display the content until the line doesn't reads null.
			 *
			 * *//*

            String line;

            while ((line = br.readLine()) != null) {
                builder.append(line + "\n");
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;

                }
            }
        }

    }
*/
