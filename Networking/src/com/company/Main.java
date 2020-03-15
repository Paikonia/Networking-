package com.company;
import java.net.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        String ab = "https://darksky.net/forecast/40.7127,-74.0059/us12/en";
        try {
            URL url = new URL(ab);
            url.openConnection();
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            System.out.println(connect.getRequestMethod());
            System.out.println(connect.getResponseCode());
            System.out.println(connect.getPermission());
            System.out.println(connect.getContentType());
            System.out.println(connect.getDoInput());

            InputStream input = url.openStream();
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader reader1 = new BufferedReader(reader);

            String gettter = null;
            while((gettter = reader1.readLine()) != null){
                System.out.println(gettter);
            }


            DatagramSocket data = new DatagramSocket();
            data.getInetAddress();
            System.out.println(data);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch(IOException ee){
            ee.printStackTrace();
        }

    }
}
