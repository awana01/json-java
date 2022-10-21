package org.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONValue;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.google.common.io.Files;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

//E:\MyWorkSpace\IdeaJava\IdeaJava\ApiAutomation\RestApi01
//import util.JsonParser1;

public class AsanaGetRequestTest01 {
  
	
    public Faker faker;
	String uri = "https://app.asana.com";
	String token ="0/38d75b5504a78662a2adb04410b9b366";
	
	RequestSpecification httpRequest;
	Response response;
	
	
  @BeforeTest
  public void beforeTest() {
	  
	  RestAssured.baseURI = uri;
      httpRequest =  RestAssured.given().header("Authorization", "Bearer "+token);

  }
  
  
  @Test
  public void getAsanaWorkSpacesTest01() {
	  
	  response = httpRequest.request(Method.GET, "/api/1.0/workspaces/");
		
	  String responseBody =response.getBody().asString(); 
	  int status = response.getStatusCode();
	  System.out.println("Content Type: "+response.getContentType());
		
	  Object obj = JSONValue.parse(responseBody);
	  // JSONArray array = (JSONArray)obj;
		  
	    System.out.println("Total WorkSpaces ");
       
		System.out.println("=== Request Response ===== ");
		System.out.println(responseBody);
		System.out.println("=== Request Response =====");
		System.out.println("Status Code: "+status);
	  
	  
  }
  
  /*
GET /projects
POST /projects
GET /projects/{project_gid}
PUT /projects/{project_gid}
DELETE /projects/{project_gid}
POST /projects/{project_gid}/duplicate
GET /tasks/{task_gid}/projects
GET /teams/{team_gid}/projects
POST /teams/{team_gid}/projects
GET /workspaces/{workspace_gid}/projects
POST /workspaces/{workspace_gid}/projects
POST /projects/{project_gid}/addCustomFieldSetting
POST /projects/{project_gid}/removeCustomFieldSetting
GET /projects/{project_gid}/task_counts
POST /projects/{project_gid}/addMembers
POST /projects/{project_gid}/removeMembers
POST /projects/{project_gid}/addFollowers
POST /projects/{project_gid}/removeFollowers
*/
  
  
  
  
  
  
  @Test
  public void getTotalAsanaProjectsTest02() {
	  
	  response = httpRequest.request(Method.GET, "/api/1.0/projects");
		
	  String responseBody =response.getBody().asString(); 
	  int status = response.getStatusCode();
	  System.out.println("Content Type: "+response.getContentType());
		
	  Object obj = JSONValue.parse(responseBody);
	  // JSONArray array = (JSONArray)obj;
		  
	    System.out.println("Total Projects ");
       
		System.out.println("=== Request Response ===== ");
		System.out.println(responseBody);
		System.out.println("=== Request Response =====");
		System.out.println("Status Code: "+status);
	  
	  
  }
  
  
  @Test
  public void Test03() {
	  
	  String gold_workspace_id = "699763649376486";
	  String blue_workspace_id = "709389129771629";
	  String It_workspace_id = "1167265739713146";
	  String purple_workspace_id = "1169645321291945";
	  
	  
	  String project_api_endpoint = String.format("/workspaces/%s/projects",gold_workspace_id);
	  
	  response = httpRequest.request(Method.GET,"/api/1.0"+project_api_endpoint);
	  
	  String responseBody =response.getBody().asString(); 
	  int status = response.getStatusCode();
	  System.out.println("Content Type: "+response.getContentType());
		
	  Object obj = JSONValue.parse(responseBody);
	  //JSONArray array = (JSONArray)obj;
		  
	    System.out.println("Total Projects Under Gold WorkSpace");
       
		System.out.println("=== Request Response ===== ");
		System.out.println(responseBody);
		System.out.println("=== Request Response =====");
		System.out.println("Status Code: "+status);
	  
  }
  
  
  @Test
  public void GetAsanaUsersTest04() {
      
	  
	  response = httpRequest.request(Method.GET,"/api/1.0/users");
	  
	  String responseBody =response.getBody().asString(); 
	  int status = response.getStatusCode();
	  System.out.println("Content Type: "+response.getContentType());
		
	  Object obj = JSONValue.parse(responseBody);
	  //JSONArray array = (JSONArray)obj;
		  
	    System.out.println("Total Users under WorkSpaces");
       
		System.out.println("=== Request Response ===== ");
		System.out.println(responseBody);
		System.out.println("=== Request Response =====");
		System.out.println("Status Code: "+status);
  }
  
  @Test
  public void GetAsanaUsersUnderWorkspaceTest04() {
      
	  String user_endpoint ="/workspaces/699763649376486/users";
	  response = httpRequest.request(Method.GET,"/api/1.0"+user_endpoint);
	  
	  String responseBody =response.getBody().asString(); 
	  int status = response.getStatusCode();
	  System.out.println("Content Type: "+response.getContentType());
		
	  Object obj = JSONValue.parse(responseBody);
	  //JSONArray array = (JSONArray)obj;
		  
	    System.out.println("Total Users under Gold WorkSpaces");
       
		System.out.println("=== Request Response ===== ");
		System.out.println(responseBody);
		System.out.println("=== Request Response =====");
		System.out.println("Status Code: "+status);
  }
  
  
  @Test(enabled = false)
  public void ParseJsonTest() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
	  System.out.println("Try to parsing JSON file");
	  //JsonParser1.getKey("");;
  }
  
  @Test(enabled = false)
  public void JsonParserT01() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
	//Read the file from the saved location and store it in JsonObject
		
			JsonObject myobject = (JsonObject) JsonParser.parseReader(new FileReader("./src/test/resources/data/samplejson.json"));   //.parse(new FileReader("MyFilePath"));
			
			//Hold the "response" in a JSON Object
			//Hold root object data
			JsonObject root_object = (JsonObject) myobject.get("response");
			
			//Drill down further and store the "body" and "patient" in JSON Object
			JsonObject root_body = (JsonObject) root_object.get("body");
			JsonObject patients= (JsonObject) root_body.get("patients");
			
//			"patient" tag is in a Array hence we will store it in Array Object
			JsonArray patientbody= (JsonArray) patients.get("patient");   //(JsonObject) patients.get("patient");
			
			JsonObject patient0= patientbody.get(0).getAsJsonObject();
			
//			Next we will fetch the "patientID"
			String patientID =patient0.get("patientID").getAsString(); 
			System.out.println(patientID);
  }
  
  @Test(enabled = false)
  public void ParseWorkspaceResonseT02() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
	  JsonObject JObject = (JsonObject) JsonParser.parseReader(new FileReader("./src/test/resources/data/workspace_response.json"));   //.parse(new FileReader("MyFilePath"));
        
	  JsonArray responseArray = (JsonArray)JObject.get("data");
  	  JsonObject ArryJsonObjectElement1= responseArray.get(0).getAsJsonObject();
  	  String workspace_id =ArryJsonObjectElement1.get("gid").getAsString(); 
  	  String workspace_name =ArryJsonObjectElement1.get("name").getAsString(); 
	  
	  System.out.println("Size of Response Array: "+responseArray.size());
      System.out.println("Response Array: "+responseArray);
      System.out.println("Response Array json Object Ist Element: "+ArryJsonObjectElement1);
      System.out.println("Response Array json Object Ist Element ,gid element: "+workspace_id);
      System.out.println("Response Array json Object Ist Element ,name element: "+workspace_name);
      
      JsonObject ArryJsonObjectElement11 =null;
      HashMap<String,String> workspaces = new HashMap<String,String>();
      
      for(int i=0;i<responseArray.size();i++) {
    	  
    	  ArryJsonObjectElement11= responseArray.get(i).getAsJsonObject();
      	  String workspace_id1 =ArryJsonObjectElement11.get("gid").getAsString(); 
      	  String workspace_name1 =ArryJsonObjectElement11.get("name").getAsString(); 
      	  System.out.println("====");
      	  System.out.println("Response Array json Object Ist Element: "+ArryJsonObjectElement11);
          System.out.println("Response Array json Object Ist Element ,gid element: "+workspace_id1);
          System.out.println("Response Array json Object Ist Element ,name element: "+workspace_name1);
          System.out.println("====");
          workspaces.put(workspace_name1, workspace_id1);
       	  
        }
     
  }
  
  @Test
  public void JsonPathExampleTest()  {
      
	  String workspace_gold_gid="699763649376486";
	  String user_endpoint = "/projects";
      response = httpRequest.request(Method.GET,"/api/1.0"+user_endpoint);
	  
//	  String responseBody =response.getBody().asString(); 
//	  int status = response.getStatusCode();
//	  System.out.println("Content Type: "+response.getContentType());
	  
   // Create a request specification
      RequestSpecification request = RestAssured.given();
      request.baseUri("https://app.asana.com");
      request.header("Authorization", "Bearer "+token);
      
      Response response = request.get(String.format("/api/1.0/workspaces/%s/projects",workspace_gold_gid));
      
      System.out.println("Projects:"+response.getStatusCode());
      System.out.println("Projects Under Gold Workspace:"+response.getBody().asString());
      
      
    //Get JsonPath instance of above JSON string
      JsonPath jsonPath = JsonPath.from(response.getBody().asInputStream());
      String projectName = jsonPath.getString("data");
      System.out.println("Name is : "+projectName);


      
      
      
  }
  
  
  
  
  @AfterTest
  public void afterTest() {
  }

}
