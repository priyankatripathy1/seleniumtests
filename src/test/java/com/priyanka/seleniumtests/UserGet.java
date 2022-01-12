package com.priyanka.seleniumtests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UserGet {
    public void getMethod(){
        Response response= RestAssured.given()
                           .auth()
                .preemptive()
                .basic("user","user")
                .when()
                .get("localhost:8080")
                .then()
                .statusCode(200)
                .extract()
                .response();

       JsonPath json= response.jsonPath();
       UserPojo user= json.getObject(".",UserPojo.class);  //Deserialised(Json to onject)
        Assert.assertEquals(user.id,10);
        Assert.assertEquals(user.name,"priyanka");

    }

    @Test
    public void postMethod(){
        UserPojo user= new UserPojo();
        user.name="Abhishek";

        Response response= RestAssured.given()
                   .auth()
                .preemptive()
                .basic("user","user")
                .header("content-type","application/json")
                .body(user)//Restassued does serialization(object to json)
                .when()
                .post()
                .then()
                .statusCode(201)
                .extract()
                .response()
                ;
        JsonPath json = response.jsonPath();
        UserPojo user1 = json.getObject("." ,UserPojo.class);

        Assert.assertEquals(user1.name,"Abhishek");
        Assert.assertTrue(user1.id>0);

    }

}
