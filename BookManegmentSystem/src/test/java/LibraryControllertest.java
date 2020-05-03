import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
@RunWith(SpringRunner.class)
public class LibraryControllertest {
	

	@Test
	public void testUpdate() throws URISyntaxException 
	{
		
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:8080" + "/update/3/khan123";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("id"));
	}
	
	@Test
	public void testgetBooks() throws URISyntaxException 
	{
		
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:8080" + "/getBook";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("id"));
	}

}
