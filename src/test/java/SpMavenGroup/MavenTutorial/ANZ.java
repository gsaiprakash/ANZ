package SpMavenGroup.MavenTutorial;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ANZ 
{

	@Test
	
	
	public void Anzcalculators () throws InterruptedException
	{
	WebElement element=null;
    System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver\\chromedriver.exe"); 
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
	driver.manage().window().maximize();

	driver.findElement(By.id("application_type_joint")).click();
	driver.findElement(By.id("application_type_single")).click();
	JavascriptExecutor Js= (JavascriptExecutor)driver ;
    Js.executeScript("window.scrollBy(0,300)");
    
	element = driver.findElement(By.cssSelector("select[ title='Number of dependants']"));
    Select dropdown1 = new Select(element);
  
	
	 dropdown1.selectByIndex(0);
	 driver.findElement(By.cssSelector("label[for='borrow_type_investment']")).click();
	 driver.findElement(By.cssSelector("label[for='borrow_type_home']")).click();
	 driver.findElement(By.cssSelector("input[aria-labelledby='q2q1']")).sendKeys("80000");
	 driver.findElement(By.cssSelector("input[aria-labelledby='q2q2']")).sendKeys("10000");
	 driver.findElement(By.id("expenses")).sendKeys("500");
	 driver.findElement(By.id("homeloans")).sendKeys("0");
	 driver.findElement(By.id("otherloans")).sendKeys("100");
	 driver.findElement(By.cssSelector("input[aria-labelledby='q3q4']")).sendKeys("0");
	 driver.findElement(By.id("credit")).sendKeys("10000");
	 Js.executeScript("window.scrollBy(0,200)");
	 driver.findElement(By.id("btnBorrowCalculater")).click();
	System.out.println( driver.findElement(By.id("borrowResultTextAmount")).getText());
	//Assert.assertEquals(driver.findElement(By.id("borrowResultTextAmount")).getText(),"542000");
	driver.findElement(By.cssSelector("button[class='start-over']")).click();
	driver.findElement(By.id("expenses")).sendKeys("1");
	  Thread.sleep(1000);
	driver.findElement(By.id("btnBorrowCalculater")).click();
	System.out.println(driver.findElement(By.cssSelector("div[class='borrow__error__text']")).getText());
	
	}	
	
	
}
