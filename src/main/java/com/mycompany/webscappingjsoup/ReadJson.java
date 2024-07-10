/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.webscappingjsoup;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Thiago
 */
public class ReadJson {

    public static JSONArray leerJson() throws FileNotFoundException, IOException, ParseException {

        JSONParser parse = new JSONParser();

        
            //leemos el archivo JSON 
            Object obj = parse.parse(new FileReader("usuarios.json"));

            //lo hacemos objeto para poder manipularlo apropiadamente
            JSONObject jsonobject = (JSONObject) obj;

            // System.out.println("JSON LEIDO " + jsonobject);
            //pasamos a un array cada uno de los objetos Usuarios, para poder interar en cada uno 
            JSONArray array = (JSONArray) jsonobject.get("Webs");

            /* for (int i = 0; i < array.size(); i++) {
            JSONObject jsonobject1 = (JSONObject) array.get(i);
            System.out.println("usuario numero: " + jsonobject1.get("id")) ;
            System.out.println("el nombre del usuario " + jsonobject1.get("nombre"));
            System.out.println("el telefono del usuario " + jsonobject1.get("telefono"));
            System.out.println("el email del usuario " + jsonobject1.get("email"));
            System.out.println("----------------------------------------------------------------------");
        }*/ 
            //System.out.println(array);
  
       return array;
       
       
    }

}
