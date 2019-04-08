package com.ey.parseJSON;

import java.util.List;

public class MovieJSON {
	
	private String title;
	private Integer year;
	private List<String> cast = null;
	private List<String> genres = null;
	
		
	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public List<String> getCast() {
		return cast;
	}

	public List<String> getGenres() {
		return genres;
	}
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n----- Movie Information-----\n");
        sb.append("Title: " + getTitle() + "\n");
        sb.append("Year: " + getYear() + "\n");
        sb.append("Cast: " + getCast() + "\n");
             sb.append("*****************************");
        return sb.toString();
    }

}

