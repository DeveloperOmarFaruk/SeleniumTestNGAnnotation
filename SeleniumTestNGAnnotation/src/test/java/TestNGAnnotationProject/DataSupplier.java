package TestNGAnnotationProject;

import org.testng.annotations.DataProvider;

public class DataSupplier {

	@DataProvider(name = "LoginTestData")
	public static Object[][] LoginData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "locked_out_user";
		data[0][1] = "secret_sauce";
		
		data[1][0] = "standard_user";
		data[1][1] = "secret_sauce";
		
		return data;
		
	}
}
