package program.day0918_night;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class GetJson {
    public static String getJson(String str){
        BufferedReader br=null;
        HttpURLConnection con=null;
        StringBuilder result=new StringBuilder();
        try {
            URL url=new URL(str);
            con= (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(3000);
            if(con.getResponseCode()==200){
                br=new BufferedReader(new InputStreamReader(con.getInputStream()));
                String st="";
                while ((st=br.readLine())!=null){
                    result.append(st);
                }
                return result.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
