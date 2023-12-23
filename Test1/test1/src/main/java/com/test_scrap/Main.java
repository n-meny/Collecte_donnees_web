package com.test_scrap;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jaxen.JaxenException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Main {
    public static void main(String[] args)             throws FailingHttpStatusCodeException, MalformedURLException, IOException, JaxenException {
        WebClient client = new WebClient(); // On créer un navigateur web
        HtmlPage searchPage = (HtmlPage) client.getPage("https://new.uschess.org/player-search"); // On se connecte à la
                                                                                                  // page

        HtmlForm form = (HtmlForm) searchPage.getByXPath("//form").get(0);
        HtmlInput dispayNameField = form.getInputByName("display_name");
        // System.out.println(dispayNameField);
        dispayNameField.setValueAttribute("Bobby Fischer");
        HtmlInput searchButton = form.getInputByName("submit");
        HtmlPage resultPage = (HtmlPage) searchButton.click();
        System.out.println(resultPage.asXml());

    }
}