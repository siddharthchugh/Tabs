package com.example.richie.mytasks;

import  org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Richie on 28-04-2015.
 */
public class HttpManager  {

    public static String getData(RequestManager p){

        BufferedReader reader=null;
        String uri = p.getUri();
if(p.getMethod().equals("GET")){
    uri+="?"+p.getEncodedParams();
}
       try{
            URL url = new URL(uri);
//            OkHttpClient ok = new OkHttpClient();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(p.getMethod());

           JSONObject json = new JSONObject(p.getParams());
           String params  = "params="+ json.toString();


           if(p.getMethod().equals("POST")){

       con.setDoOutput(true);
       OutputStreamWriter write = new OutputStreamWriter(con.getOutputStream());
       write.write(p.getEncodedParams());
       //write.write(params);
               write.flush();
   }
            StringBuilder build = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;

            while((line = reader.readLine())!=null){
                build.append(line+"\n");
            }

            return build.toString();
        }catch (Exception e){
            e.printStackTrace();
        return null;
        }finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

    }

}
