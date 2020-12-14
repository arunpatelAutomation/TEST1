package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import io.cucumber.core.api.Scenario;

public class SamsungHeladeraPageObjects {

	WebDriver driver;

	public SamsungHeladeraPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[contains(@class,'InputBar__SearchInput')]")
	public WebElement SearchBar;

	@FindBy(xpath = "//*[contains(@class,'GeolocalizationDesktop__StyledCloseIcon')]")
	public WebElement PostcalCodePopUP;

	@FindBy(xpath = "//button[contains(@class,'InputBar__SearchButton')]")
	public WebElement SearchButton;

	@FindBy(xpath = "//h1[contains(@name,'categoryTitle')]")
	public WebElement LeftsideMenuHeader;

	@FindBy(xpath = "//a[contains(@href,'freezers')]/h4[contains(text(),'Heladeras')]")
	public WebElement LeftsideMenuTypeHeladeras;

	@FindBy(xpath = "//li[@name='brandsFilter']//a[text()='Ver todas']")
	public WebElement LeftsideMenubrandFilterMore;

	@FindBy(xpath = "//input[contains(@class,'styled__SearchInput')]")
	public WebElement BrandModelSearchBox;

	@FindBy(xpath = "//input[@id='filterItemsamsung']//following::label[text()='Samsung']")
	public WebElement SamsungBrandModelselection;

	@FindBy(xpath = "//button[contains(text(),'Aplicar')]")
	public WebElement ButtonAplicar;

	@FindBy(xpath = "//ul[@name='itemsGrid']//h4[contains(@class,'PieceTitle')]")
	public List<WebElement> SearchResultafterBrandfilter;

}
