package mgk.data;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


public class DataReader {

	public void getJsonDataToMap() throws IOException
	{
		String jsonContent=FileUtils.readFileToString(new File(".\\src\\test\\java\\mgk\\data\\PurchaseOrder.json"));
	}
}
