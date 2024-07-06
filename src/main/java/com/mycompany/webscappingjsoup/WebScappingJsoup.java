package com.mycompany.webscappingjsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScappingJsoup {

    public static void main(String[] args) {
        
        ReadJson.leerJson();
        
       // String url = "http://diarioadn.co";
        //WebScappingJsoup.scraping(url);

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

    public static void scraping(String url) { //metodo para obtener la infomacion 

        //al obtener el html de la pagina le pido que me traigo todos los <article> cuya class sea "notices-article"
        Elements articulos = WebScappingJsoup.getHTML(url).select("article.notices-article");
        for (Element noticias : articulos) {

            try {

                //itero por cada noticia y obtengo la url absoluta a esa noticia la cual esta dentro del <a href=...>
                String urlNoticia = noticias.select("a").attr("abs:href");
                Document htmlnoticia = WebScappingJsoup.getHTML(urlNoticia); //obtengo el html de esa noticia

                String titulo = htmlnoticia.select("h1").text();
                String informacion = htmlnoticia.select("div.margins").text();

                System.out.println(titulo);
                System.out.println(informacion);
                System.out.println("-----------------------------------------------------------------------------------------------------------");

            } catch (Exception e) {
                System.out.println("error al obtener la noticia");
            }

        }

    }

}
