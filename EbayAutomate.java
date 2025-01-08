Prerequesites:

Add selenium dependencies in pom.xml file using Maven
Pom.xml file
<dependency>
<groupId>org.seleniumhq.selenium</ groupId>
<artifactId>selenium-java</artifactId>
<version>4.9.0</version>
</dependency>
<dependency>
<groupId>org.seleniumhq.selenium</ groupId>
<artifactId>selenium-chrome-driver</artifactId>
<version>4.9.0</version></dependency>

Automation code implementation

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class EbayAutomation {
public static void main (String [] args)
{
//Set up webdriver
System.setProperty("webdriver.chrome.driver","C:/Users/rishi/OneDrive/Desktop/chromedriver.exe");
ChromeOptions options = new ChromeOptions();
options.addArguments("-—start-maximized"); //open browser maximized
WebDriver driver = new ChromeDriver(options);
try{
//navigate to ebay site
driver.get("https://www.ebay.com");
//3.search for book
WebElement searchBox = driver.findElements(By.id("gh-ac"));
//locate the search bar by id
searchBox.sendKeys("book"); //Enter book in the search box

WebElement  searchButton = driver.findElement(By.id("gh-btn"));   //locate the search btn by id
searchButton.click(); //perform search action



//Wait for search results to load
driver.manage.timeouts.implicitlyWait(Duration.ofSeconds(10));
//4. Click on first book item in the list
 WebElement firstBook = driver.findElement(By.xpath ("(//li[contains(@class,'s-item')])[1]//h3"));
firstBook.click();
//5.In the item listing page, click on ‘Add to cart’
//locate add to cart btn 
WebElement addTocartButn=driver.findElement(By.id("atcRedesignId_btn"));
addTocartButn.click(); //click on add to cart

//6.Verify cart has been updated
WebElement cartCountElemnt =driver.findElement(By.id("gh-cart-n")); //locate cart count elemnt
 String cartCount = cartCountElemnt.getText(); //get cart  count text

//validation
if(cartCount.equals("1"))
{
System.out.println("Test Passed: Item successfully added to cart.");
}
else
{ 
System.out.println("Test Failed: Cart Count does not match");
}
}
catch(Exception e)
{
//print exception details
System.out.println("An error occurred: " + e.getMessage());

}
finally{
//close browser
driver.quit();
}
}
}
