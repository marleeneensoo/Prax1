package ttu.idu0080.repositories;

public class RESTService2API extends API{
	private static final String ENDPOINT = "http://localhost:8080/RESTService2/";
	private static final String BOOK_RESOURCE = "book";
	
	public String getBooks(){
		String URL = this.ENDPOINT + this.BOOK_RESOURCE;
		return this.makeRequest(URL); //loeb kogu urili ja teeb baitjadaks, teeb päringu vastu url-i ja annab vastuse string kuju
	}

}
