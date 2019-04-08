Search JSON file
==========================
The aim of the project is to search for a string pattern in the movies collection, as a JSON file, and return the movie titles  
and the total count of the occurrence of the search pattern.

Softwares Required
==========================
Eclipse IDE
Junit 
Maven
JDK 1.8

How to use the project code
==========================
Download/clone the repository to a local folder
Open Eclipse IDE and Import the maven project( File -> Import -> Maven ( Existing maven projects) 

- How to execute the test cases
	- The JSON data is located in root directory
	- MovieSearchTest.java 
		- This is the JUNIT file for Unit test. 
		- 4 test cases/functions are present now. 
			- testCountOnCast() => Based on "Cast" search, the movie names and count will be retuned( modify variable 'movieToSearch' value with required search value)
			- testCountOnYear() => Based on "Year", the movie names and count will be retuned
			- testCountOnGenre() => Based on "Genre", the movie names and count will be retuned
			- testCountOnUnknownValues() => this is for negative test scanarios. Currently given Values from outside the existing JSON file values. 

