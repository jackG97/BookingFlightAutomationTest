package StepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BookingFlightSteps {
	
	// important note: This test is running based on the assumption that user has an account created with Ryanair, so please log in to the website before starting
	
	public WebDriver driver;
	
	
	
	@Given("browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jackg\\OneDrive\\Documents\\ChromeDrive"); // Driver file is used to launch GoogleChrome.  
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
	
	}

	@Given("user is on booking flight page")
	public void user_is_on_booking_flight_page() {
		
		driver.navigate().to("https://www.ryanair.com/ie/en"); // Used to re-direct user to Ryanair page
	  
	}

	@When("user enters in their flight information \\(date, one way trip, one adult, desintation, departure location)")
	public void user_enters_in_their_flight_information_date_one_way_trip_one_adult_desintation_departure_location() {
		 driver.findElement(By.id("input-button__departure")).sendKeys("Dublin"); // user selects departure field and selects Dublin
		    driver.findElement(By.id("input-button__destination")).sendKeys("London"); // user selects Destination field and selects London
		    driver.findElement(By.id("LGW")).click(); // user selects London Gatwick
		    driver.findElement(By.id("One way")).click(); // // user selects one way button
		    driver.findElement(By.id("input-button__label")).click(); // user selects date field
		    driver.findElement(By.id(" 9 ")).click(); // user selects on calender 9th April
		    driver.findElement(By.id("input-button__content")).click(); // user selects number of people field
		    driver.findElement(By.id("counter.counter__increment")).click(); // user selects increments number for 1 adult
	}

	@When("selects search button")
	public void selects_search_button() {
		driver.findElement(By.id("flight-search-widget__cta")).click(); // user selects Search to search for flight
	   
	}

	@Then("user is navigated to select flight page")
	public void user_is_navigated_to_select_flight_page() {
		// User is Flight page
	}

	@Then("user selects flight")
	public void user_selects_flight() {
		driver.findElement(By.id("glyphs/take-off")).click(); // selects the flight they want based on the time that suits them. They select the icon
		driver.findElement(By.className("fare-card__button-text ng-star-inserted")).click(); //This is where they select value package after selecting the flight
	}

	@When("user enters in passenger details")
	public void user_enters_in_passenger_details() {
		driver.findElement(By.className("dropdown__toggle b2")).click(); // selects the dropdown
		driver.findElement(By.className("dropdown-item__label b2")).click(); // selects Mr
		driver.findElement(By.id("formState.passengers.ADT-0.name")).sendKeys("Jack"); // enters in first name
		driver.findElement(By.id("formState.passengers.ADT-0.surname")).sendKeys("Gallaher"); // enters in second name
		driver.findElement(net.serenitybdd.core.annotations.findby.By.buttonText(" Continue ")).click(); // selects continue button
	}

	@Then("user is navigated to select seat page")
	public void user_is_navigated_to_select_seat_page() {
			// user is on select seat page
	}

	@Given("user selects seat")
	public void user_selects_seat() {
		driver.findElement(By.className("ng-star-inserted seatmap__seat seatmap__seat--priority")).click(); // selects seat
		driver.findElement(net.serenitybdd.core.annotations.findby.By.buttonText(" Continue ")).click(); // selects continue
		driver.findElement(net.serenitybdd.core.annotations.findby.By.buttonText(" No, thanks ")).click(); // selects no thanks button with regards to priority queue
	}

	@Given("clicks continue")
	public void clicks_continue() {
	   // clicked continue on
	}

	@Then("user will be directed to luggage page")
	public void user_will_be_directed_to_luggage_page() {
		// user is on the luggage page
	}

	@Given("user selects one small bag")
	public void user_selects_one_small_bag() {
		driver.findElement(By.className("ng-star-inserted")).click(); // selects small bag
		driver.findElement(By.className("ry-button--gradient-yellow")).click(); // selects continue
	}

	@Then("user will be directed to insurance page")
	public void user_will_be_directed_to_insurance_page() {
		// user is on insurance page
	}

	@Given("User selects continue")
	public void user_selects_continue() {
	   driver.findElement(By.className("ry-button--full ng-tns-c169-1 ry-button--gradient-yellow ry-button--large")).click(); // selects continue
	}

	@Then("user will be directed to overview page")
	public void user_will_be_directed_to_overview_page() {
		// user will be directed to over view page
	}

	@When("user selects basket")
	public void user_selects_basket() {
		driver.findElement(By.className("ng-tns-c112-1")).click(); // selects the basket
	}

	@When("selects check out")
	public void selects_check_out() {
	   driver.findElement(By.className("ry-button--full ry-button--gradient-yellow")); // selects the check out button
	}

	@Then("user should be directed to Payment page")
	public void user_should_be_directed_to_payment_page() {
	    // user is on payment page
	}

	@When("user selects in payment information")
	public void user_selects_in_payment_information() {
	    driver.findElement(By.className("b2 _error")).sendKeys("0859863472"); // enters in phone number
	    driver.findElement(By.className("b2 date-placeholder _error")).sendKeys("5555 5555 5555 5557"); // enters in Card number
	    driver.findElement(By.className("dropdown__toggle b2")).click(); // selects from drop down
	    driver.findElement(By.name("October")).click(); // selects October
	    driver.findElement(By.className("dropdown__toggle b2")).click(); // selects drop down
	    driver.findElement(By.name("2021")); // selects 2021 at the year
	    driver.findElement(By.name("CVV")).sendKeys("265"); // enters in the CVV
	    driver.findElement(By.className("b2 date-placeholder _error")).sendKeys("Jack Gallaher"); // enters in name
	    driver.findElement(By.className("b2 date-placeholder _error")).sendKeys("45 High Road"); // enters in address 
	    driver.findElement(By.className("b2 date-placeholder _error")).sendKeys("Ballinteer");
	    driver.findElement(By.className("b2 date-placeholder _error")).sendKeys("Dublin");
	    driver.findElement(By.className("b2 _autocomplete_input ng-tns-c82-3 _autocomplete_input--dropdown _error")).sendKeys("Ireland"); // selects on ireland on the drop down
	    driver.findElement(By.className("wrapper ng-tns-c82-3")).click();
	    driver.findElement(By.className("b2 date-placeholder _error")).sendKeys("D14W4G7"); // enters in postal code
	    driver.findElement(By.className("_background")).click();
	   
	}

	@When("slects pay now")
	public void slects_pay_now() {
		driver.findElement(By.className("pay-button ry-button--gradient-yellow")).click(); // selects payment 
	}

	@Then("Payment should fail")
	public void payment_should_fail() {
	   // payment should fail
		driver.close();
		driver.quit();
	}


}
