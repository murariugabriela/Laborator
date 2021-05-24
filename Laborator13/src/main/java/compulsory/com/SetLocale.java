package compulsory.com;

import java.util.Locale;

public class SetLocale {
    public void setDefault(Locale locale){
        Locale.setDefault(locale);
        System.out.println(locale.getCountry());
    }
}
