package com.zetcode.myres;

import java.util.ListResourceBundle;
import javax.swing.ImageIcon;

public class MyResources_sk extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {

        return resources;
    }

    private final Object[][] resources = {
        
        {"name", "Slovensko"},
        {"lang_menu", "Jazyk"},
        {"lang_sk", "Slovenčina"},
        {"lang_hu", "Maďarčina"},
        {"flag", new ImageIcon("src/resources/slovakia.png")},
        {"description", "Slovensko je vnútrozemský štát v strednej Európe."}
    };
}
