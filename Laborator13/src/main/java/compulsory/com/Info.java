package compulsory.com;

import java.text.DateFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Info {
    public void getInfo(Locale locale) {
        Currency currency = Currency.getInstance(locale);
        DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
        System.out.println(locale.getCountry());
        System.out.println(locale.getLanguage());
        System.out.println(currency.getCurrencyCode());
        for (String weekday : dateFormatSymbols.getWeekdays()) {
            System.out.print(weekday + "\t");
        }
        System.out.println();
        for (String month : dateFormatSymbols.getMonths()) {
            System.out.print(month + "\t");
        }
        System.out.println();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MMM.YYYY", locale);
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));
    }
}
