package com.example.richie.mywebviewscreen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Richie on 06-04-2015.
 */
public class HttpManager {

public static String getData(String uri){

    BufferedReader br=null;

    try{

        URL url= new URL(uri);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        StringBuilder buuld = new StringBuilder();
        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String  line;
        while((line = br.readLine())!=null){
            buuld.append(line+"\n");
        }
        return buuld.toString();
    }catch (Exception e){
e.printStackTrace();
        return null;
    }finally{
        if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}



