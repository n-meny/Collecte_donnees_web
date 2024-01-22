package collecte_web.example;

import java.io.IOException;
import java.net.MalformedURLException;

import org.htmlunit.FailingHttpStatusCodeException;
import org.htmlunit.WebClient;
import org.htmlunit.corejs.javascript.JavaScriptException;
import org.htmlunit.html.HtmlForm;
import org.htmlunit.html.HtmlInput;
import org.htmlunit.html.HtmlPage;



public class Main {
    public static void main(String[] args)
            throws FailingHttpStatusCodeException, MalformedURLException, IOException, JavaScriptException {
        try (WebClient navigateur = new WebClient()) {
            navigateur.getOptions().setCssEnabled(false); // On désactive le CSS pour éviter un téléchargement inutile
            navigateur.getOptions().setJavaScriptEnabled(false); // On désactive le JavaScript pour éviter un téléchargement inutile

            HtmlPage Page_accueil = (HtmlPage) navigateur.getPage("https://www.gotronic.fr "); // On se connecte à la
                                                                                                      // page

            String titre = Page_accueil.getTitleText();
            System.out.println("Le titre de la page est : " + titre);
            HtmlForm form = (HtmlForm)  Page_accueil.getByXPath("//form").get(0); // On récupère le formulaire de recherche
            HtmlInput dispayNameField = form.getInputByName("qm"); // On récupère le champ de recherche
            System.out.println(dispayNameField);    // On affiche le champ de recherche
            dispayNameField.type("led"); // On tape "led" dans le champ de recherche
            HtmlInput searchButton = form.getInputByName("action"); // On récupère le bouton de reche  rche
            HtmlPage resultPage = (HtmlPage) searchButton.click(); // On  clique sur le bouton de recherche
            System.out.println(resultPage.asXml()); // On affiche le code source de la page de résultat
        }
        
    }
}