package gouri.sharma.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository; //reference to ReviewRepository

    @Autowired
    private MongoTemplate mongoTemplate; //one more way to talk to database
    public Review createReview(String reviewBody,String imdbId){
        Review review= reviewRepository.insert(new Review(reviewBody));

        //mapping review body to movie with a particular imdbid
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))//update review where the imdbid matches
                .apply(new Update().push("reviewIds").value(review)) //our db contains a empty array of reviewIds, therefore we need to push the respective review into it
                .first();

        return review;
    }
}









//package gouri.sharma.movies;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.stereotype.Service;
//import org.springframework.data.mongodb.core.query.Criteria;
//
//import java.time.LocalDateTime;
//
//@Service
//public class ReviewService {
//    private ReviewRepository reviewRepository; //ref to review repo
//    @Autowired
//    private MongoTemplate mongoTemplate; //one way to talk to db, form new dynamic query
//    public Review createReview(String reviewBody, String imdbId) {
//        Review review=reviewRepository.insert(new Review(reviewBody));
//        //map review body to a movie with some imdbid
//        mongoTemplate.update(Movie.class)
//                .matching(Criteria.where("imdbId").is(imdbId)) //update review where imdbid matches
//                .apply(new Update().push("reviewIds").value(review)) //db has empty array of imdb ids in which reviews need to be pushed
//                .first();
//        return review;
//    }
//}
