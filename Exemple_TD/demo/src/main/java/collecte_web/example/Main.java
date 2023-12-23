package collecte_web.example;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jaxen.JaxenException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Main {
    public static void main(String[] args)
            throws FailingHttpStatusCodeException, MalformedURLException, IOException, JaxenException {
        WebClient client = new WebClient(); // On créer un navigateur web
        HtmlPage searchPage = (HtmlPage) client.getPage("https://www.gotronic.fr/"); // On se connecte à la
                                                                                                  // page

        HtmlForm form = (HtmlForm) searchPage.getByXPath("//form").get(0); // On récupère le formulaire de recherche
        HtmlInput dispayNameField = form.getInputByName("qm"); // On récupère le champ de recherche
        System.out.println(dispayNameField);    // On affiche le champ de recherche
        dispayNameField.type("led"); // On tape "led" dans le champ de recherche
        HtmlInput searchButton = form.getInputByName("action"); // On récupère le bouton de recherche
        HtmlPage resultPage = (HtmlPage) searchButton.click(); // On clique sur le bouton de recherche
        System.out.println(resultPage.asXml()); // On affiche le code source de la page de résultat
        
    }
}