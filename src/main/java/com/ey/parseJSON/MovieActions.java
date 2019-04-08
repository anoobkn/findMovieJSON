package com.ey.parseJSON;
import java.io.File;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MovieActions {
	
	public static int searchCount;
	ObjectMapper objectMapper;
	List<MovieJSON> movieJson;
	private static Set<String> movieList;
	
	public MovieActions() {
		searchCount = 0;
		movieList = new HashSet<>();
		objectMapper = new ObjectMapper();
		try {
			movieJson = objectMapper.readValue(new File("MovieData.json"),new TypeReference<List<MovieJSON>>(){});
		} catch (Exception e) {
			System.out.println("MovieActions() => Exception :" + e.getLocalizedMessage());
		}
	}
	
	public int searchMovieBasedOnYear(int searchFor) throws JsonParseException, JsonMappingException, IOException {
		searchCount = 0;
		movieList.clear();
		for(MovieJSON movie: movieJson) {
			int yearObj =  movie.getYear();			
			if(yearObj == searchFor)
			{				
				movieList.add(movie.getTitle());
				searchCount ++;
			}
		}		
		display(Integer.toString(searchFor));
		return searchCount;
	}
	
	public int searchMovieBasedOnCast(String searchFor) throws JsonParseException, JsonMappingException, IOException {
		searchCount = 0;
		movieList.clear();
		for(MovieJSON movie: movieJson) {			
			Iterator<String> castItr = movie.getCast().iterator();
			Iterator<String> genresItr = movie.getGenres().iterator();
			if(movie.getTitle().contains(searchFor)) {
				movieList.add(movie.getTitle());
				searchCount++;
			};
			iterateList( movie,castItr, searchFor);
			iterateList( movie, genresItr,searchFor);			
		}		
		display(searchFor);
		return searchCount;
	}
		
	public int searchMovieBasedOnGenres(String searchFor) throws JsonParseException, JsonMappingException, IOException {
		searchCount = 0;
		movieList.clear();
		for(MovieJSON movie: movieJson) {			
			Iterator<String> castItr = movie.getCast().iterator();
			Iterator<String> genresItr = movie.getGenres().iterator();
			if(movie.getTitle().contains(searchFor)) {
				movieList.add(movie.getTitle());
				searchCount++;
			};
			iterateList( movie,castItr, searchFor);
			iterateList( movie, genresItr,searchFor);			
		}		
		display(searchFor);
		return searchCount;
	}
	
	private void iterateList(MovieJSON movie,Iterator<String> itr, String search) {
		while(itr.hasNext()) {
			if(itr.next().contains(search)) {
				movieList.add(movie.getTitle());
				searchCount++;
			}
		}
	}
	
	private void display(String searchFor) {
		if(movieList.size()>0){
			System.out.println("Input: \""+searchFor+"\" Output: Search Term: \""+searchFor+"\" Movie: "+movieList+" count: "+searchCount);
		}
		else {
			System.out.println("No search results found for "+searchFor);
		}
	}	
	

}
