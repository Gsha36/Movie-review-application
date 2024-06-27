package gouri.sharma.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication //annotation used to let the compiler know what the class does
// @RestController  //framework know that this class is actually a REST API
public class MoviesApplication {
	public static void main(String[] args)
	{
		SpringApplication.run(MoviesApplication.class, args); //run method of spring application class
	} //calling

}
