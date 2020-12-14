package StepDefination;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javaFunctionality.SamsungHeladeraFunctionality;

public class SamsungHeladeraStepDef {
	String Appurl = "https://www.fravega.com";
	SamsungHeladeraFunctionality samsunghelFun;

	public SamsungHeladeraStepDef(TestContext context) {
		samsunghelFun = new SamsungHeladeraFunctionality(context);
	}

	@Given("user Lauch the application url {string} and verfiy page title")
	public void user_lauch_the_application_url_and_verfiy_page_title(String url) {
		samsunghelFun.lauchURl(url);
		samsunghelFun.landingpage();
	}

	@And("user click on search box and enter Heladera and click on ok")
	public void user_click_on_search_box_and_enter_heladera_and_click_on_ok() {
		samsunghelFun.Searchoptionforrefrigerator();
	}

	@And("user filter with only Heladera in left side breadcum")
	public void user_filter_with_only_heladera_in_left_side_breadcum() {
		samsunghelFun.BreadCumFilter();
	}

	@When("User select brand as samsung only in the filter")
	public void user_select_brand_as_samsung_only_in_the_filter() {
		samsunghelFun.BradFilter();
	}

	@Then("User get that result display and validate samsung is diaplyed in all the result")
	public void user_get_that_result_display_and_validate_samsung_is_diaplyed_in_all_the_result() {
		samsunghelFun.ResultValidation();
	}

}
