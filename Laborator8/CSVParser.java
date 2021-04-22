import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class CSVParser {
    private MoviesDAO moviesDAO = new MoviesDAO();
    private GenresDAO genresDAO = new GenresDAO();

    public void parseMovies() {
        CSVReader reader;
        try {
//            imdb_title_id,title,original_title,year,date_published,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote,votes,budget,usa_gross_income,worlwide_gross_income,metascore,reviews_from_users,reviews_from_critics
            reader = new CSVReader(new FileReader("C:\\Users\\Gabe\\Desktop\\PA\\Laborator8\\IMDbmovies.csv"));
            String[] lineInArray;
            int i = 1;
            int j = 1;
            while ((lineInArray = reader.readNext()) != null) {
                if (i != 1) {
//                    System.out.println(lineInArray[1] + " " + lineInArray[4] + " " + lineInArray[5] + " " +
//                            lineInArray[6] + " " + lineInArray[9] + " " + lineInArray[12] + " " + lineInArray[14]);
//                    System.out.println(Integer.parseInt(lineInArray[0].substring(2)));
//                    System.out.println(lineInArray[0].substring(2)));
                    Movie movie = new Movie(Integer.parseInt(lineInArray[0].substring(2)), lineInArray[1], lineInArray[4], Float.parseFloat(lineInArray[6]), Float.parseFloat(lineInArray[14]));
                    moviesDAO.save(movie);
                    String genres = lineInArray[5];
                    while (genres.indexOf(", ") != -1) {
                        Genre genre = new Genre(j, genres.substring(0, genres.indexOf(", ")));
                        genresDAO.save(genre);
                        genres = genres.substring(genres.indexOf(", ") + 2);
                        j++;
                    }
                    Genre genre = new Genre(j, genres);
                    genresDAO.save(genre);
                    j++;
                }
                i++;
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
