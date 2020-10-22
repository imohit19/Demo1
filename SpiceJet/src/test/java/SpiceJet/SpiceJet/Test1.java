package SpiceJet.SpiceJet;

import org.testng.Assert;
import io.restassured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;






public class Test1 {
	@Test
		public void Excel() throws IOException
		{
			File src =new File("C:\\Users\\Ishan Mohit\\Desktop\\selenium\\SpiceJet\\ishan.xls");
			FileInputStream fs=new FileInputStream(src);
			
			HSSFWorkbook ed=new HSSFWorkbook(fs);
			HSSFSheet sh=ed.getSheetAt(0);
			int row_count= sh.getLastRowNum();
			for (int i=0;i<=row_count;i++)
			{
			String s=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(s);
			}
			
			for (int i=0;i<=2;i++)
			{
			sh.getRow(i).createCell(2).setCellValue("arvind");
			}
			FileOutputStream os=new FileOutputStream(src);
			ed.write(os);
			
			
		}
		
	

	
	//@Test
	public void OpenSpiceJeTest()
	{
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Ishan Mohit\\Desktop\\selenium\\SpiceJet\\geckodriver.exe");
		 
		// Initialize browser
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://spicejet.com");
		//Boolean ActualTitle = driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled();
		boolean Expected= false;
		
		//Verify trip is round trip
		
		
		boolean Actual=driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected();

		Assert.assertEquals(Expected,Actual);

		//System.out.println(ActualTitle);
		 
		driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		boolean Expected1= true;
		boolean Actual1=driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected();


		
		//Verify trip is round trip
		System.out.println(Actual1);
		Assert.assertEquals(Expected1,Actual1);
		
		driver.close();
		
	}
	//@Test 	 	
	public void FromToValidation() throws InterruptedException
	{
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Ishan Mohit\\Desktop\\selenium\\SpiceJet\\geckodriver.exe");
		 
		// Initialize browser
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://spicejet.com");
		
		//Select oSelect =new Select(driver.findElement(By.id("id="ctl00_mainContent_DropDownListCurrency"")));
		//oSelect.selectByVisibleText("Ahmedabad (AMD)");
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		//boolean Actual1=driver.findElement(By.cssSelector("a[value='AMD']")).isDisplayed();
		//System.out.println(Actual1);
		driver.findElement(By.cssSelector("a[value='HYD']")).click();
		//WebDriverWait wait = new WebDriverWait(driver, 60);

		
		//WebElement element = wait
				//.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[value='IXL']")));
		//driver.findElement(By.cssSelector("a[value='IXL']")).click();
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
		
		driver.findElement(By.xpath("(//a[@value='KQH'])[2]")).click();
		//String dateval="02-09-2020";
	//WebElement date=driver.findElement(By.id("ctl00_mainContent_txt_Fromdate"));
		
		JavascriptExecutor js=((JavascriptExecutor ) driver);
		//js.executeScript("arguments[0].setAttribute('value','"+dateval+"');",date);
		 js.executeScript("document.getElementById('ctl00_mainContent_txt_Fromdate').value='02-09-2020'");
		 Select oSelect =new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
			oSelect.selectByVisibleText("USD");
		 driver.findElement(By.id("divpaxinfo")).click();
		

			Select oSelect1 =new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
			oSelect1.selectByVisibleText("1");

			Select oSelect2 =new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
			oSelect2.selectByVisibleText("3");
			 driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
			 
			String s= driver.findElement(By.className("trip-detrails-sector")).getText();
			String S1="Hyderabad to Ajmer";
			
		boolean Actual2=s.equals(S1);
		boolean Expected2=true;
		Assert.assertEquals(Expected2,Actual2);
System.out.println(s);	
Thread.sleep(2000);
//	Now perform a click using linktext.
	//	WebElement element1 = wait
			//	.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("a[text='Kochi (COK)'])[value='COK']"))));
		//driver.findElement(By.cssSelector(("a[text='Kochi (COK)'])[value='COK']"))).click();
		//WebDriverWait wait1 = new WebDriverWait(driver, 60);
		//WebElement element1= wait1
			//.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[value='AMD']")));
		//driver.findElement(By.cssSelector("a[value='AMD']")).click();;
		//driver.findElement(By.linkText("Kochi (COK)")).click();;
		//boolean Expected1= true;
		//System.out.println(Actual);
		//Thread.sleep(2000);
		//Assert.assertEquals(Expected1,Actual);
	//	driver.quit();
	}
//@Test(dataProvider="getData")
public void GetAllLinks(String URL) throws InterruptedException {
	  
	System.setProperty("webdriver.gecko.driver","C:\\Users\\Ishan Mohit\\Desktop\\selenium\\SpiceJet\\geckodriver.exe");
	 
	// Initialize browser
	WebDriver driver=new FirefoxDriver();
	System.out.println(URL);
	driver.get("https://spicejet.com");
	  
	 //Get list of web-elements with tagName  - a
	 List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	  
	 
	 for(WebElement link:allLinks){
	// System.out.println(link.getText() + " - " + link.getAttribute("href"));
		String S1= link.getAttribute("href");
		if(S1!=null)
		{
		boolean a=S1.equals(URL);
		 if((a))
				 {
			 System.out.println(S1);
System.out.println("link is present");
				 }
		}
	 } 

}

@DataProvider
public Object[][] getData()
{

Object[][] data = new Object[3][1];

// 1st row
data[0][0] ="http://spicejet.woohoo.in/home";

// 2nd row
data[1][0] ="https://www.spicestyle.com/";


// 3rd row
data[2][0] ="https://book.spicejet.com/Search.aspx?op=4";


return data;
}
}
