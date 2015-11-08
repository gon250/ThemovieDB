package gdg.spanish.themoviedb.Services;

import java.util.List;

import gdg.spanish.themoviedb.Models.Movie;
import retrofit.http.GET;
import retrofit.http.Path;
public interface  TheMovieDbService {

    @GET("/search/movie?query={searchString}&api_key={appKey}")
    List<Movie> getMovies(@Path("searchString") String searchString, @Path("appKey")
    String appKEy);

    @GET("/search/tv?query={searchString}&api_key={appKey}")
    List<Movie> getSeries(@Path("searchString") String searchString, @Path("appKey")
    String appKEy);
}
