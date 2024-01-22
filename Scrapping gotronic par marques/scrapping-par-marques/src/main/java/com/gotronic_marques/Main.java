package com.gotronic_marques;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlHeading2;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;

public class Main {
    public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, JavaScriptException {
        try (WebClient navigateur = new WebClient()) {
            navigateur.getOptions().setCssEnabled(false); // On désactive le CSS pour éviter un téléchargement inutile
            navigateur.getOptions().setJavaScriptEnabled(false); // On désactive le JavaScript pour éviter un téléchargement inutile

            HtmlPage Page_accueil = (HtmlPage) navigateur.getPage("https://www.gotronic.fr/marques.htm "); // On se connecte à la page
            String xPath = "/html/body/div[1]/div/div[3]/main/div[2]/div[3]/div[1]/h2";
            List<HtmlHeading2>  h2 = Page_accueil.getByXPath(xPath);
            
            //print the first heading text content
            System.out.println((h2.get(0)).getTextContent());
            
            
            
                                                                                                      
            
            
           
           /*  HtmlForm formulaire_recherche = (HtmlForm)  Page_accueil.getByXPath("//form").get(0); // On récupère le formulaire de recherche
            HtmlInput dispayNameField = formulaire_recherche.getInputByName("qm"); // On récupère le champ de recherche
            //System.out.println(dispayNameField);    // On affiche le champ de recherche
            dispayNameField.type("led"); // On tape "led" dans le champ de recherche
            HtmlInput bouton_recherche = formulaire_recherche.getInputByValue(""); // On récupère le bouton de recherche , sa valeur est nulle dans ce formulaire  
            HtmlPage resultPage = (HtmlPage) bouton_recherche.click(); // On clique sur le bouton de recherche
            System.out.println(resultPage.getUrl()); // On affiche le code source de la page de résultat */
        }
        
    }
}