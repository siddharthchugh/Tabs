package com.example.richie.mytasks;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Richie on 12-05-2015.
 */
public class StudentJSON {

    public static List<Student> parseFeed(String content){
        try {

            JSONArray ar = new JSONArray(content);
        List<Student> studdata = new ArrayList<>();
        for(int i =0;i<ar.length();i++){
            JSONObject obj = null;
                obj = ar.getJSONObject(i);
            Student st_Info = new Student();
            st_Info.setId(obj.getString("id"));
//            st_Info.setId(obj.getString("dateOfbirth"));
              studdata.add(st_Info);
        }
        return studdata;
        } catch (JSONException e) {
            e.printStackTrace();
        return null;
        }

    }
}
