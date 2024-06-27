package gouri.sharma.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection="movies")
@Data //take care of getter setter and string methods
@AllArgsConstructor //creating constructor that takes in all the private fields as arguments
@NoArgsConstructor //takes in no argument
public class Movie {
    @Id  //identifier-this prop should be treated as the unique identifier for each entry
    private ObjectId id;

    private String imdbId;
    private String title;
    private String releasedate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference //cause database to store only the ids of reviews and reviews in separate collection
    private List<Review> reviewIds; //embedded relationship

    public Movie(String imdbId, String title, String releaseDate, String trailerLink, String poster, List<String> backdrops, List<String> genres) {
        this.imdbId = imdbId;
        this.title = title;
        this.releasedate = releaseDate;
        this.trailerLink = trailerLink;
        this.poster = poster;
        this.backdrops = backdrops;
        this.genres = genres;
    }
}
