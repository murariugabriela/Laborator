import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Movie> movies = new ArrayList<>();
        List<Genre> genres;
        MoviesDAO moviesDAO = new MoviesDAO();
        GenresDAO genresDAO = new GenresDAO();
        genres = genresDAO.getAll();
        int i = 1;
        while (i <= 30) {
            movies.add(moviesDAO.getById(i++));
        }
        Map<String, Object> root = new HashMap<>();

        root.put("movies", movies);
        root.put("genres", genres);
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        try {
            cfg.setDirectoryForTemplateLoading(new File("E:\\Gabe\\facultate\\An 2\\Sem2\\Programare Avansata - Java\\Laborator 8 Compulsory\\src\\main\\resources\\templates"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            cfg.setWrapUncheckedExceptions(true);
            cfg.setFallbackOnNullLoopVariable(false);
            Template temp = cfg.getTemplate("report.html");
            File file = new File("E:\\Gabe\\facultate\\An 2\\Sem2\\Programare Avansata - Java\\Laborator 8 Compulsory\\src\\main\\resources\\templates\\reportResult.html");
            Writer out = new OutputStreamWriter(new FileOutputStream(file));
            temp.process(root, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        connection.closeConnectionDB();
    }

}
