package com.agiles.UI.Cucumber;

import com.codeborne.selenide.Configuration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class WinTheGameStepDefinitions {
	@Given("^an open browser with AhorcadoWeb/index\\.jsp$")
	public void an_open_browser_with_AhorcadoWeb_index_jsp() throws Throwable {
		Configuration.browser = "chrome";
	    Configuration.startMaximized = false;
	    open("/AhorcadoWeb");
	}
	
	@When("^I click the letter \"([^\"]*)\"$")
	public void i_click_the_letter(String letter) throws Throwable {
		$("#letter"+letter).click();
	}
	
//	@When("^I click the letter h$")
//	public void i_click_the_letter_h() throws Throwable {
//		$("#letterh").click();
//	}
//
//	@When("^I click the letter l$")
//	public void i_click_the_letter_l() throws Throwable {
//		$("#letterl").click();
//	}
//
//	@When("^I click the letter o$")
//	public void i_click_the_letter_o() throws Throwable {
//		$("#lettero").click();
//	}
//
//	@When("^I click the letter a$")
//	public void i_click_the_letter_a() throws Throwable {
//		$("#lettera").click();
//	}

	@Then("^a message saying \"([^\"]*)\" should appear$")
	public void a_message_saying_should_appear(String winTit) throws Throwable {
		$(".ganador-tit").shouldHave(text(winTit));
	}

	@Then("^the keyboard should disappear$")
	public void the_keyboard_should_disappear() throws Throwable {
		$(".alphabets").shouldNot(exist);
	}

	@Then("^the remaining errors should disappear$")
	public void the_remaining_errors_should_disappear() throws Throwable {
		$(".errorestit").shouldNot(exist);
		$(".errores").shouldNot(exist);
	}

	@Then("^the entered letters should disappear$")
	public void the_entered_letters_should_disappear() throws Throwable {
		$(".letrasUsadasTit").shouldNot(exist);
		$(".letrasUsadas").shouldNot(exist);
	}


}
