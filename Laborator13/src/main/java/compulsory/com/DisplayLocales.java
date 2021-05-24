package compulsory.com;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales {
    public void displayLocales() {
        Locale available[] =
                Locale.getAvailableLocales();
        for (Locale locale : available) {
            System.out.println(locale.getDisplayCountry() + "\t" +
                                locale.getDisplayLanguage(locale));
        }
    }
}
