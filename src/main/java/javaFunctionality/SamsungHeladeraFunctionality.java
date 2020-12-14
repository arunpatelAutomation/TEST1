package javaFunctionality;

import cucumber.TestContext;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObject.SamsungHeladeraPageObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SamsungHeladeraFunctionality {
	private Properties properties;
	private final String propertyFilePath = "src\\test\\java\\Resource\\TestData.properties";
	String BrandName = "Samsung";
	String Searchtype = "Heladeras";
	WebDriver driver;
	SamsungHeladeraPageObjects SamsungHeladeraPageObjects;

	public SamsungHeladeraFunctionality(TestContext context) {

		this.driver = context.getDriver();
		SamsungHeladeraPageObjects = new SamsungHeladeraPageObjects(driver);

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			properties.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}

	}

	public void lauchURl(String URl) {
		URl = properties.getProperty(URl);
		driver.get(URl);
		driver.manage().window().maximize();

	}

	public void landingpage() {

		String actualTitle = "";
		String ExpectedTitle = "Frávega: Electrodomésticos, Tecnología y Artículos para el hogar";

		try {
			SamsungHeladeraPageObjects.PostcalCodePopUP.click();

			actualTitle = driver.getTitle();
			Assert.assertEquals(ExpectedTitle, actualTitle);
			System.out.println("The actual title is " + actualTitle);
			System.out.println("The Expected title is " + ExpectedTitle);

		} catch (AssertionError e) {
			e.printStackTrace();

			System.out.println("The actual title is " + actualTitle);
			System.out.println("The Expected title is " + ExpectedTitle);
			throw e;

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void Searchoptionforrefrigerator() {

		String actualTitle = "";
		String ExpectedTitle = "Frávega: Electrodomésticos, Tecnología y Artículos para el hogar";

		try {
			SamsungHeladeraPageObjects.SearchBar.click();
			SamsungHeladeraPageObjects.SearchBar.sendKeys(Searchtype);
			SamsungHeladeraPageObjects.SearchButton.click();

			actualTitle = driver.getTitle();
			Assert.assertEquals(ExpectedTitle, actualTitle);
			System.out.println("The actual title is " + actualTitle);
			System.out.println("The Expected title is " + ExpectedTitle);

		} catch (AssertionError e) {
			e.printStackTrace();

			System.out.println("The actual title is " + actualTitle);
			System.out.println("The Expected title is " + ExpectedTitle);
			throw e;

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void BreadCumFilter() {

		try {
			SamsungHeladeraPageObjects.LeftsideMenuTypeHeladeras.isDisplayed();
			SamsungHeladeraPageObjects.LeftsideMenuTypeHeladeras.click();

			SamsungHeladeraPageObjects.LeftsideMenubrandFilterMore.isDisplayed();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void BradFilter() {

		try {
			SamsungHeladeraPageObjects.LeftsideMenubrandFilterMore.click();
			driver.switchTo().activeElement();

			if (SamsungHeladeraPageObjects.BrandModelSearchBox.isDisplayed()) {
				System.out.println("Brand pop loaded succesfull");

			} else {
				Thread.sleep(3000);
			}
			SamsungHeladeraPageObjects.BrandModelSearchBox.click();
			SamsungHeladeraPageObjects.BrandModelSearchBox.sendKeys(BrandName);
			SamsungHeladeraPageObjects.SamsungBrandModelselection.click();
			SamsungHeladeraPageObjects.ButtonAplicar.click();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void ResultValidation() {
		String Actualresult = "";

		try {

			int count = SamsungHeladeraPageObjects.SearchResultafterBrandfilter.size();
			if (count == 0) {
				Thread.sleep(3000);
			} else {
				driver.switchTo().activeElement();
			}
			for (WebElement resultelement : SamsungHeladeraPageObjects.SearchResultafterBrandfilter) {
				Actualresult = resultelement.getText();
				Assert.assertTrue("Product name contain " + BrandName + " As a keyword",
						Actualresult.contains(BrandName));

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
