package Body;

import org.json.simple.JSONObject;

public class PlaceOrderBody {
    public JSONObject placeOrderBody(String petID, String quantity, String shipDate, String status, String complete){
        JSONObject placeOrder = new JSONObject();

        placeOrder.put("petId", petID);
        placeOrder.put("quantity",quantity);
        placeOrder.put("shipDate",shipDate);
        placeOrder.put("status",status);
        placeOrder.put("complete",complete);

        return placeOrder;
    }
}
