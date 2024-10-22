package Utiliyes;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class dataprovider {
	// Dataprovider1
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        // Path to the Excel file
        String path = ".\\TestData\\email.xlsx";

        // Instantiate the Excel utility class (assuming it's correctly implemented)
        Excel_utiliy xlutil = new Excel_utiliy();  // Pass the path to the constructor

        // Get row and column count
        int rownum = xlutil.getRowCount("Sheet1");
        int colnum = xlutil.getCellCount("Sheet1", 1);

        // Create a 2D array to store login data
        String logindata[][] = new String[rownum][colnum];

        // Iterate through the Excel sheet and read data
        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colnum; j++) {
                logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);  // Reading data from each cell
            }
        }

        // Return the data to be used by TestNG tests
        return logindata;
    }

}
