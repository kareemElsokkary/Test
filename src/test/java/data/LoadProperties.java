package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

	public static Properties userData = loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\Properties\\TestData.properties");
	

	private static Properties loadProperties(String path) {

		Properties pro = new Properties();

		FileInputStream stream;
		try {
			stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {

			System.out.println(e.getMessage());

		}
		return pro ;
	}
}
