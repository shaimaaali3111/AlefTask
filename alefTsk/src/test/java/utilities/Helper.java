package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper  {
	
	public static void caputerScreenshot (WebDriver driver, String ScreenshotName)
	{
		
		Path dest= Paths.get("./Screenshoots", ScreenshotName+".png");
		
		try {
			
			//create folder if folder not exist
			Files.createDirectories(dest.getParent());
			//take object from stream to write on file
			FileOutputStream Out = new FileOutputStream (dest.toString());
			//take screenshot to write on file
			Out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			Out.close();
		} catch (IOException e) {
			
			System.out.println("Exception while take screenshot"+e.getMessage());
		
		}
		
		
	}

}
