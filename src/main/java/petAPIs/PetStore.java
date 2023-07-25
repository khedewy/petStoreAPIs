package petAPIs;

import Body.PlaceOrderBody;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class PetStore {
    PlaceOrderBody placeOrderBody;
    public  PetStore(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2/store/order";
    }


    public Response placeOrder(String petID, String quantity, String shipDate, String status, String complete){
        placeOrderBody = new PlaceOrderBody();
        return RestAssured.
                given().log().all().body(placeOrderBody.placeOrderBody(petID,quantity,shipDate,status,complete))
                .header("Content-Type","application/json").when().post();
    }


    public Response getOrderPlaced(int id){
        return RestAssured.given().log().all().pathParam("id",id).when().get("{id}");
    }

    public Response deleteOrderPLaced(int id ){
        return RestAssured.given().log().all().pathParam("id",id).when().delete("{id}");
        }

    }




