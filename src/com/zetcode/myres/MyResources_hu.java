package com.zetcode.myres;

import java.util.ListResourceBundle;
import javax.swing.ImageIcon;

public class MyResources_hu extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {

        return resources;
    }

    private final Object[][] resources = {
        
        {"name", "Magyarország"},
        {"lang_menu", "Nyelv"},
        {"lang_sk", "Szlovák"},
        {"lang_hu", "Magyar"},        
        {"flag", new ImageIcon("src/resources/hungary.png")},
        {"description", "Magyarország közép-európai ország "
            + "a Kárpát-medencében."}
    };
}
