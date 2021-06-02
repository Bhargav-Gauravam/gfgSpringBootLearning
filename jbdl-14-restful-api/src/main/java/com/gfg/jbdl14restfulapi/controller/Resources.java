package com.gfg.jbdl14restfulapi.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resources {

//    @Autowired
//    Map<String,Movie> movies;

    @Autowired
    MovieService movieService;

    @PostMapping("/v1/movie")
    public void createMovie(@RequestBody MovieRequest movieRequest){ // jackson object mapper converts json obj to pojo

//        Movie movie = Movie.builder()
//                .genre(movieRequest.getGenre())
//                .language(movieRequest.getLanguage())
//                .name(movieRequest.getName())
//                .build();
//        movies.put(movieRequest.getName(), movie);

        movieService.create(movieRequest);
    }

    @GetMapping("/v1/movie") // api looks like /v1/movie?name=*
    public Movie getMovie(@RequestParam("name")  String name){
//        return movies.get(name);
        return movieService.get(name);
    }

    @PutMapping("/v1/movie/{name}")
    void updateMovie(@PathVariable("name") String name, @RequestBody MovieRequest movieRequest){
//        Movie movie = movies.get(name);
//        if(null != movieRequest.getGenre())
//            movie.setGenre(movieRequest.getGenre());
//        if(null != movieRequest.getLanguage())
//            movie.setLanguage(movieRequest.getLanguage());
        movieService.update(name,movieRequest);

    }

    @DeleteMapping("/v1/movie/{name}")
    void deleteMovie(@PathVariable("name") String name, @RequestBody MovieRequest movieRequest){
//        if(movies.containsKey(movieRequest.getName()))
//            movies.remove(movieRequest.getName());
        movieService.delete(name);
    }

}
