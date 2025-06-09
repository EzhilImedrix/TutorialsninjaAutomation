package tutorialsninjaRegister;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_RF_010 {
	@Test
    public void VerifyRegisteringAccountInvalidEmail() throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Ezhil");
		driver.findElement(By.id("input-lastname")).sendKeys("B");
		driver.findElement(By.id("input-email")).sendKeys("Ezhil");
		driver.findElement(By.id("input-telephone")).sendKeys("9655903816");
		driver.findElement(By.id("input-password")).sendKeys("1234");
		driver.findElement(By.id("input-confirm")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(3000);
		
		File srcScreenshot1 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot1, new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actule.png"));
		
		BufferedImage actuleBImg = ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actule.png"));
		BufferedImage ExepetedImg = ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Expected.png"));
		
		ImageDiffer imgDiffer =new ImageDiffer();
		ImageDiff imgDifference = imgDiffer.makeDiff(ExepetedImg, actuleBImg);
		
		
		Assert.assertFalse(imgDifference.hasDiff());
		
		driver.quit();
		
		
    	
    }
}
