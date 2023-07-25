package tests;

import data.ReadJsonData;
import org.testng.annotations.BeforeMethod;
import petAPIs.PetStore;

import java.io.FileNotFoundException;

public class TestBase {
    PetStore petStore;
    ReadJsonData placeOrderData;

    @BeforeMethod
    public void setData() throws FileNotFoundException {
        petStore = new PetStore();
        placeOrderData = new ReadJsonData("src/test/java/data/placeOrder.json");
    }
}
