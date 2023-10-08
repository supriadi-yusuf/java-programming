package com.s04.standard;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class P117Properties {
    public static void main(String[] args) {

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("application.properties"));

            String host = properties.getProperty("database.host");
            String port = properties.getProperty("database.port");
            String username = properties.getProperty("database.username");
            String password = properties.getProperty("database.password");

            System.out.println(host);
            System.out.println(port);
            System.out.println(username);
            System.out.println(password);

        }catch (FileNotFoundException e){
            System.out.println("File tidak ditemukan");
        }
        catch (IOException e) {
            System.out.println("Gagal load data dari file");
        }

        try {
            Properties properties = new Properties();
            properties.put("nama","supriadi");
            properties.put("address", "jakarta");
            properties.put("country","Indonesia");

            properties.store(new FileOutputStream("output.properties"), "Konfigurasi MyData Pengguna");
        }catch (FileNotFoundException e){
            System.out.println("File output tidak ditemukan");
        }
        catch (IOException e) {
            System.out.println("Gagal menyimpan data ke file");
        }
    }
}
