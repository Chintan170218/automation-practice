package resources.testdata;


import org.testng.annotations.DataProvider;


public class TestData {

    @DataProvider(name = "credentials")
    public Object[][] getData() {
        Object[][] data = new Object[][]{
                {"", "Peace1234", "An email address required." },
                {"abcdefg@gmail.com ", "", "Password is required." },
                {"adfdfgfg", "123456", "Invalid email address." },
                {"abcd@gmail.com", "123456", "Authentication failed." },
        };
        return data;

    }
    @DataProvider(name = "dataSet")
    public Object[][]  getData1() {
        Object[][] data = new Object[][] {
                {"Blouse","2","M","White"},
                {"Printed Dress","3","S","Orange"},
                {"Printed Chiffon Dress","4","S","Green"},
                {"Printed Summer Dress","2","M","Blue"}
        };
        return data;
    }


}
