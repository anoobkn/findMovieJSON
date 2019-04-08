package com.ey.parseJSON;

import static org.junit.Assert.*;
import org.junit.*;
import com.sun.org.glassfish.gmbal.Description;

public class MovieSearchTest{
	private static MovieActions movieActnObj;
	
	@BeforeClass
    public static void initMovieAction() {
		movieActnObj = new MovieActions();
    }
	   
   @Test()
   @Description("Find movie names and search count based on Cast ")
    public void testCountOnCast() {
    	try {
    	String movieToSearch = "Chris";
    	int result = movieActnObj.searchMovieBasedOnCast(movieToSearch);        
        assertEquals(2, result);
    	}catch(Exception e) {
    		System.out.println("Exception in testMovieCount "+ e.getLocalizedMessage());
    	}
    }
   
    @Test()
    @Description("Find movie names and search count based on Year ")
    public void testCountOnYear() {
    	try {
    	int movieToSearch = 2015;	
    	int result = movieActnObj.searchMovieBasedOnYear(movieToSearch);        
        assertEquals(1, result);
    	}catch(Exception e) {
    		System.out.println("Exception in testMovieCount "+ e.getLocalizedMessage());
    	}
    }
	
	@Test()
    @Description("Find movie names and search count based on Genre ")
    public void testCountOnGenre() {
    	try {
    	String movieToSearch = "History";	
    	int result = movieActnObj.searchMovieBasedOnGenres(movieToSearch);
         assertEquals(1, result);
    	}catch(Exception e) {
    		System.out.println("Exception in testMovieCount "+ e.getLocalizedMessage());
    	}
    }

	@Test()
    @Description("Find movie names and search count based on unknown values ")
    public void testCountOnUnknownValues() {
    	try {
    	String movieToSearch = "testGenre";	
    	int result = movieActnObj.searchMovieBasedOnGenres(movieToSearch);
         assertEquals(0, result);
        
        movieToSearch = "testCast";
        result = movieActnObj.searchMovieBasedOnCast(movieToSearch);
         assertEquals(0, result);
         
         int yearSearch = 0;
         result = movieActnObj.searchMovieBasedOnYear(yearSearch);
          assertEquals(0, result);
         
    	}catch(Exception e) {
    		System.out.println("Exception in testMovieCount "+ e.getLocalizedMessage());
    	}
    }
	
}
