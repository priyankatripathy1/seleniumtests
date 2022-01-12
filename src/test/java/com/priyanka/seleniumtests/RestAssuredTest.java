package com.priyanka.seleniumtests;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RestAssuredTest {

    @Test
    public static void testGetRepo(){
        Response response = RestAssured.given()
                .auth()
                .preemptive()
                .basic("priyankatripathy1","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")
                .when()
                .get("https://api.github.com/repos/priyankatripathy1/githubapitests")
                .then()
                .statusCode(200)
                .extract()
                .response();

        //System.out.println(response.body().asPrettyString());

        JsonPath jsonPath = response.jsonPath();

//        Assert.assertEquals("githubapitests", jsonPath.getString("name"));
//        Assert.assertEquals(418255522, jsonPath.getInt("id"));

        RepoPojo repoPojo = jsonPath.getObject(".", RepoPojo.class);

        Assert.assertEquals("githubapitests", repoPojo.name);
        Assert.assertEquals(418255522, repoPojo.id);
    }

    @Test
    public static void testPostRepo(){
        RepoPojo bodyPojo = new RepoPojo();
        bodyPojo.name = "priyanka-new-repo";
        bodyPojo.full_name ="priyanka's new repo";

        Response response = RestAssured.given()
                .auth()
                .preemptive()
                .basic("priyankatripathy1","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")
                .header("content-type", "application/json")
                .body(bodyPojo)
                .when()
                .post("https://api.github.com/user/repos")
                .then()
                .statusCode(201)
                .extract()
                .response();

        System.out.println(response.body().asPrettyString());

        JsonPath jsonPath = response.jsonPath();

        RepoPojo repoPojo = jsonPath.getObject(".", RepoPojo.class);

        Assert.assertEquals("priyanka-new-repo", repoPojo.name);
        Assert.assertTrue(repoPojo.id > 0);
    }


    @Test
    public static void testListResponse(){
        Response response = RestAssured.given()
                .auth()
                .preemptive()
                .basic("priyankatripathy1","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")
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // System.out.println(response.body().asPrettyString());

        List<RepoPojo> pojos = response.jsonPath().getList(".", RepoPojo.class);


        Assert.assertEquals(11, pojos.size());
    }
}
