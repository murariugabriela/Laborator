package compulsory.app;

import compulsory.com.DisplayLocales;
import compulsory.com.Info;
import compulsory.com.SetLocale;

import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args) {
        DisplayLocales displayLocales = new DisplayLocales();
        Info info = new Info();
        SetLocale setLocale = new SetLocale();
        while (true) {
            Scanner keyboard = new Scanner(System.in);
            ResourceBundle messagesRo =
                    ResourceBundle.getBundle("res.Messages_ro", Locale.getDefault());
            ResourceBundle messagesEn =
                    ResourceBundle.getBundle("res.Messages", Locale.getDefault());
            System.out.print(messagesRo.getString("prompt"));
            System.out.println("(" + messagesEn.getString("prompt") + ")");
            String command = keyboard.nextLine();
            if (command.contains("info")) {
                System.out.print(messagesRo.getString("info"));
                System.out.println("(" + messagesEn.getString("info") + ")");
                if (command.indexOf(' ') >= 0) {
                    System.out.println(command.substring(command.indexOf(":") + 2, command.indexOf(",")) + "," + command.substring(command.indexOf(",") + 1) + ".");
                    info.getInfo(new Locale(command.substring(command.indexOf(":") + 2, command.indexOf(",")), command.substring(command.indexOf(",") + 2)));
                } else
                    info.getInfo(Locale.getDefault());
            } else if (command.contains("set locale")) {
                System.out.print(messagesRo.getString("locale.set"));
                System.out.println("(" + messagesEn.getString("locale.set") + ")");
                setLocale.setDefault(new Locale(command.substring(command.indexOf(":") + 2, command.indexOf(",")), command.substring(command.indexOf(",") + 2)));
            } else if (command.equalsIgnoreCase("display locales")) {
                System.out.print(messagesRo.getString("locales"));
                System.out.println("(" + messagesEn.getString("locales") + ")");
                displayLocales.displayLocales();
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exit successful");
                break;
            }
            else{
                System.out.print(messagesRo.getString("invalid"));
                System.out.println("(" + messagesEn.getString("invalid") + ")");
            }
        }

    }
}
