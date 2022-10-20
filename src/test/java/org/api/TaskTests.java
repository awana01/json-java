//package org.api;
//
////import com.aventstack.extentreports.ExtentTest;
//import io.restassured.RestAssured;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.http.ContentType;
//import io.restassured.http.Method;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import static io.restassured.RestAssured.given;
////import static reportUtil.ExtentTestManager.startTest;
//
//public class TaskTests {
//
//    RequestSpecBuilder buildRequest;
//    RequestSpecification requestSpec;
//
//    String uri = "https://app.asana.com/api/1.0/";
//    String token ="Bearer 0/38d75b5504a78662a2adb04410b9b366";
//    public String className;
//    public String methodName;
//    public String fullName;
//    SoftAssert softAssert = new SoftAssert();
//
//
//    @BeforeTest()
//    public void beforeTest(){
//        System.out.println("Executing @BeforeTest method");
//
//    }
//
//    @BeforeMethod
//    public void nameBefore(java.lang.reflect.Method method)
//    {
//        className = this.getClass().getSimpleName();
//        methodName=method.getName();
//        System.out.println("Test class "+className+" method name: " + methodName);
//        fullName = String.format("%s::%s",className,methodName);
//    }
//
//    @Test()
//    public void Test01_getRequestWorkspace(){
////        ExtentTest test =startTest(fullName, "Get request for all asana workspace details");
////        test.createNode("StepInfo","Test info1");
////        test.createNode("StepInfo","Test info2");
//
//          String request_endPoint ="workspaces/";
//
//          buildRequest = new RequestSpecBuilder();
//
//          buildRequest.setBaseUri(uri);
//          buildRequest.setBasePath(request_endPoint);
//          buildRequest.addHeader("Authorization",token);
//          requestSpec = buildRequest.build();
//
//          given().spec(requestSpec).when().get("").then().contentType(ContentType.JSON).assertThat().statusCode(200);
//          System.out.println(given().spec(requestSpec).when().get("").then().contentType(ContentType.JSON).extract().body().asPrettyString());
//
//    }
//
//    @Test()
//    public void test02_getRequestProject(){
////        ExtentTest test =startTest(fullName, "Get request for all asana project details");
////        test.createNode("StepInfo","Test info1");
////        test.createNode("StepInfo","Test info2");
//
//        String request_endPoint ="projects";
//
//        buildRequest = new RequestSpecBuilder();
//
//        buildRequest.setBaseUri(uri);
//        buildRequest.setBasePath(request_endPoint);
//        buildRequest.addHeader("Authorization",token);
//        requestSpec = buildRequest.build();
//
//        given().spec(requestSpec).when().get("").then().contentType(ContentType.JSON).assertThat().statusCode(200);
//        System.out.println(given().spec(requestSpec).when().get("").then().contentType(ContentType.JSON).extract().body().asPrettyString());
//
//    }
//
//
//    @Test()
//    public void test03_GetRequestTask() {
//        //ExtentReports Description
////        ExtentTest test = startTest(fullName, "Get request for all asana task details");
////        test.info("Step 1");
////        test.info("Step 2");
//
//        RestAssured.baseURI = uri;
//        RequestSpecification httpRequest = given().header("Authorization", token);
//        Response response = httpRequest.request(Method.GET, "projects/699759727930897/tasks");
//        test.info("simple tests");
//
//        String responseBody = response.getBody().asString();
//        int status = response.getStatusCode();
//
//        System.out.println("=== Request Response ===== ");
//        System.out.println(responseBody);
//
//        System.out.println("=== Request Response =====");
//        System.out.println("Status Code: " + status);
//        Assert.assertEquals(200,status);
//    }
//
//    @Test()
//    public void Test04_GetTaskSpecBuilder(){
////        //ExtentReports Description
////        startTest(fullName, "Get request for all asana task details");
////        RequestSpecBuilder build = new RequestSpecBuilder();
////           build.setBaseUri (uri);
////           build.setBasePath ("699763649376486/tasks");
//
////        RequestSpecification rspec = build.build ();
//        Date date = new Date();
//        String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//
//        System.out.println(modifiedDate);
//
//
//    }
//
//
//
//
//
//
//
//
//
//
//}
