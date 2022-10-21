//package org.api;
//
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.parsing.Parser;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import org.testng.annotations.Test;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class JsonPathTests {
//
//    String uri = "https://api.github.com/";
//    String token = "token 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";
//    String userDetailEndpoint = "/user";
//    List<String> repo_urls=null;
//    List<String> owner_map =null;
//    List<Map<String, Object>> owners_map =null;
//    Response rs ;
//    List<String> jsonResponse;
//    String book;
//    Map<String, String> data1 = new HashMap<>();
//
//    @Test()
//    public void Test1(){
//        RestAssured.defaultParser = Parser.JSON;
//
//        rs = RestAssured.given().baseUri(uri)
//                .contentType(ContentType.JSON)
//                .header("Authorization", token)
//                .when()
//                .get("/user/repos");
//
////                .then().assertThat().statusCode(201);
//
//        rs.then().assertThat().statusCode(200);
//        System.out.println("success in repo creation");
//
//        rs.then().contentType(ContentType.JSON).extract().response();
//
//        jsonResponse = rs.jsonPath().getList("$");
//
//        System.out.println("Total Repos Found: "+jsonResponse.size());
//
//        List<String> repo_urls = rs.jsonPath().getList("html_url");
//        System.out.println(repo_urls);
//        System.out.println(repo_urls.size());
//
//        for(String htmlURL:repo_urls){
//            System.out.println(htmlURL);
//        }
//
//    }
//
//    String vaildEndPoint ="/user/repos";
//    private static JsonPath getjsonPath;
//    private static List<String> getResponseList;
//
//    @Test()
//    public void Test2(){
//        RestAssured.defaultParser = Parser.JSON;
//        RequestSpecification requestSpec = RestAssured.given().baseUri(uri).contentType(ContentType.JSON).header("Authorization", token);
////         if(requestType.equals("GET_REPO")){
//        Response restResponse = requestSpec.when().get(this.vaildEndPoint);
////         }
//        Response res  = restResponse.then().contentType(ContentType.JSON).extract().response();
//        //System.out.println(res.getBody().prettyPrint());
//        getResponseList = res.jsonPath().getList("$");
//        getjsonPath  = res.jsonPath();
//
//        //System.out.println(getJsonResponseList().size());
//    }
//
//
//
//
//}
