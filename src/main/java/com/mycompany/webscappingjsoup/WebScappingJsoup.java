package com.mycompany.webscappingjsoup;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScappingJsoup {

    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        
        JSONArray webScraping =ReadJson.leerJson();
        
   
        
         for (int i = 0; i < webScraping.size(); i++) {
            JSONObject jsonobject1 = (JSONObject) webScraping.get(i);
             System.out.println(jsonobject1.get("url").toString());
            WebScappingJsoup.scraping(jsonobject1.get("url").toString(),
                                                      jsonobject1.get("capa1").toString(),
                                                      jsonobject1.get("capa2").toString(),
                                                    jsonobject1.get("atributo").toString(),
                                                  jsonobject1.get("elemento1").toString(),
                                                  jsonobject1.get("elemento2").toString());
                    
            /*System.out.println("usuario numero: " + jsonobject1.get("id")) ;
            System.out.println("el nombre del usuario " + jsonobject1.get("nombre"));
            System.out.println("el telefono del usuario " + jsonobject1.get("telefono"));
            System.out.println("el email del usuario " + jsonobject1.get("email"));
            System.out.println("----------------------------------------------------------------------");*/
        }
        
        
        
        
        
    }

    public static Document getHTML(String url) {
        Document html = null;

        try {
            //en base a la URL pasada por parametro obtiene todo el codigo HTML de la pagina en cuestion
            html = Jsoup.connect(url).get();

        } catch (Exception e) {
            System.out.println("error al obtener el HTML");
        }
        return html;
    }

    public static void scraping(String url, String capa1, String capa2, String atributo, String elemento1, String elemento2) { //metodo para obtener la infomacion 

        //al obtener el html de la pagina le pido que me traigo todos los <article> cuya class sea "notices-article"
        Elements articulos = WebScappingJsoup.getHTML(url).select(capa1);
        
        for (Element noticias : articulos) {

            try {

                //itero por cada noticia y obtengo la url absoluta a esa noticia la cual esta dentro del <a href=...>
                String urlNoticia = noticias.select(capa2).attr(atributo);
                Document htmlnoticia = WebScappingJsoup.getHTML(urlNoticia); //obtengo el html de esa noticia

                String titulo = htmlnoticia.select(elemento1).text();
                String informacion = htmlnoticia.select(elemento2).text();

                System.out.println(titulo);
                System.out.println(informacion);
                System.out.println("-----------------------------------------------------------------------------------------------------------");

            } catch (Exception e) {
                System.out.println("error al obtener la noticia");
            }

        }

    }

}
