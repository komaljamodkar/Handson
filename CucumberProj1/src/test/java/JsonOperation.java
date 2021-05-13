
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonOperation {
	
	public void getRequest()
	{
		Response response=given()
				.when()
				.get("https://jsonplaceholder.typicode.com/users");

		//System.out.println(response.toString());
		JsonPath js=new JsonPath(response.asString());
		//System.out.println(js);
		int count=js.getInt("id.size");
		System.out.println(count);
		for(int i=0;i<count;i++){
			System.out.println(js.getString("name["+i+"]"));
		}
	}

	public void postRequest()
	{
		FirstUser user=new FirstUser();
		Address address=new Address();
		address.setEmail("abc@xyz");
		address.setPhone(233333);
		address.setStreetAddress("abc zyz 10 svc");
		user.setFirstName("abc");
		user.setLastName("xyz");
		user.setAddress(address);

		Response response=given()
				.contentType(ContentType.JSON)
				.when()
				.body(user)
				.post("https://jsonplaceholder.typicode.com/users")
				;
		System.out.println(response.toString());
		JsonPath js=new JsonPath(response.asString());
		System.out.println(js);
		System.out.println(response.statusCode());
		
		
		
		
	}
	public static void main(String[] args) {
		JsonOperation op=new JsonOperation();
		op.postRequest();
		
	}

}
