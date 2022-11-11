package com.kadirbozkurt.api;
import com.kadirbozkurt.utils.ConfigReader;
import io.cucumber.java.BeforeStep;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.hc.core5.reactor.Command;
import org.junit.Test;

import java.util.Random;



public class ApiTest {
    static String token= ConfigReader.getToken();
    static String key = ConfigReader.getKey();
    static String board_id="";
    static String list_id="";
    static String[] cards_id = new String[2];

    public static void main(String[] args) {
        RestAssured.baseURI = "https://api.trello.com/1/";
        t1_createTable();
        t2_createCard();
        t3_createCard();
        t4_updateCard();
        t5_deleteCards();
        t6_deleteBoard();
    }

    public static void t1_createTable(){
        Response response = RestAssured.given().header("Content-Type", "application/json;charset=utf-8")
                .queryParam("name","KadirBoard")
                .queryParam("key",key)
                .queryParam("token",token)
                .post("boards/");
        ResponseBody body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
        board_id = response.path("id");
    }
    public static void t2_createCard(){
        Response response =  RestAssured.given()
                .pathParam("id",board_id).and()
                .queryParam("name","KadirList").and()
                .queryParam("key",key).and()
                .queryParam("token",token).and()
                .header("Content-Type", "application/json;charset=utf-8")
                .when().post("boards/{id}/lists");
        ResponseBody body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
        list_id = response.path("id");

    }
    public static void t3_createCard(){
        for (int i = 0; i <= 1; i++) {
            Response response =  RestAssured.given()
                    .queryParam("idList",list_id).and()
                    .queryParam("key",key).and()
                    .queryParam("name","KadirCard_"+i).and()
                    .queryParam("token",token).and()
                    .header("Content-Type", "application/json;charset=utf-8")
                    .when().post("cards");
            ResponseBody body = response.getBody();
            System.out.println(response.getStatusLine());
            System.out.println(body.asString());
            cards_id[i] = response.path("id");
        }
    }
    public static void t4_updateCard(){
        Random random = new Random();
        int i = random.nextInt(2);

        Response response =  RestAssured.given()
                .pathParam("id",cards_id[i]).and()
                .queryParam("name","updated_name")
                .queryParam("key",key).and()
                .queryParam("token",token).and()
                .header("Content-Type", "application/json;charset=utf-8")
                .when().put("cards/{id}");
        ResponseBody body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }

    public static void t5_deleteCards(){
        for (String each : cards_id) {
            Response response =  RestAssured.given()
                    .pathParam("id",each).and()
                    .queryParam("key",key).and()
                    .queryParam("token",token).and()
                    .header("Content-Type", "application/json;charset=utf-8")
                    .when().delete("cards/{id}");
            ResponseBody body = response.getBody();
            System.out.println(response.getStatusLine());
            System.out.println(body.asString());
        }
    }
    public static void t6_deleteBoard(){
        Response response =  RestAssured.given()
                .pathParam("id",board_id).and()
                .queryParam("key",key).and()
                .queryParam("token",token).and()
                .header("Content-Type", "application/json;charset=utf-8")
                .when().delete("boards/{id}");
        ResponseBody body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }
}
