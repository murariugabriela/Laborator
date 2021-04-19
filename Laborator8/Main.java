import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        DBConnection connection = DBConnection.getConnection();
//        connection.createDatabase();
        try {
            String line;
            Process p = Runtime.getRuntime().exec
                    ("C:\\Program Files\\PostgreSQL\\13\\bin\\psql.exe -f C:/Users/Gabe/Desktop/PA/Laborator8/createTablesScript.sql postgresql://postgres:gabriela@localhost:5432/java");
            BufferedReader input =
                    new BufferedReader
                            (new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }

        CSVParser parser = new CSVParser();
        parser.parseMovies();

        connection.closeConnectionDB();
    }

}
