package tests;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import org.testng.annotations.Test;


import java.io.FileNotFoundException;

public class PetStoreTest extends TestBase {
    JsonPath jsonPath;



    @Test
    public void placeOrder() throws FileNotFoundException {


       String response =  petStore.placeOrder(placeOrderData.getTestData("petId"),placeOrderData.getTestData("quantity"),
                placeOrderData.getTestData("shipDate"),placeOrderData.getTestData("status"),
                placeOrderData.getTestData("complete")).then().statusCode(200).extract().response().asString();



       jsonPath = new JsonPath(response);
        int id  = jsonPath.getInt("id");
        String status = jsonPath.getString("status");

        // get order placed
        petStore.getOrderPlaced(id);
        System.out.println(response);
        Assert.assertEquals(placeOrderData.getTestData("status"),status);

        // delete order placed

        petStore.deleteOrderPLaced(id);
        int code = jsonPath.getInt("code");
        Assert.assertEquals(code,200);
    }




}
