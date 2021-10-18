package com.cydeo.step_definitions;

import com.cydeo.pages.WCommonArea;
import com.cydeo.pages.WOrderPage;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeWorkStepDefs {
    @Then("side bar tabs should be as below")
    public void sideBarTabsShouldBeAsBelow(List<String> expectedResult) {

       List<String> actualResult=new ArrayList<>();


       List<WebElement> allModule= Driver.getDriver().findElements(By.xpath("//li/a"));

        for (WebElement module : allModule) {
            actualResult.add(module.getText());
        }

        Assert.assertEquals(expectedResult,actualResult);
    }


    @Then("we should see three section as below")
    public void weShouldSeeThreeSectionAsBelow(List<String> expectedSections) {
        System.out.println("expectedSections = " + expectedSections);
        List<WebElement> visibleSections = Driver.getDriver().findElements(By.xpath("//td/h3"));

        List<String> actualSections = new ArrayList<>();
        for (WebElement visibleSection : visibleSections) {

            actualSections.add(visibleSection.getText());

        }
        System.out.println("actualSections = " + actualSections);

        Assert.assertEquals(actualSections,expectedSections);
    }

    @And("select each product from dropdown should change the unit price accordingly")
    public void selectEachProductFromDropdownShouldChangeTheUnitPriceAccordingly(Map<String, Object>dropdownProduct) {

        System.out.println("dropdownProduct = " + dropdownProduct);
        WOrderPage orderPage = new WOrderPage();
        Map<String, Object> allpriceAndProduct = orderPage.getUnitPriceAndProducts();
        assertEquals(dropdownProduct, allpriceAndProduct);


    }

    @Then("selecting blow product and quantity should show correct total and discount")
    public void selectingBlowProductAndQuantityShouldShowCorrectTotalAndDiscount(List<Map<String, String>> productsTable) {

        System.out.println("productsTable = " + productsTable);
        WOrderPage wOrderPage=new WOrderPage();

        System.out.println("wOrderPage.getAllProductOptionFromList() = " + wOrderPage.getAllProductOptionFromList());
        System.out.println("wOrderPage.getUnitPriceAndProducts() = " + wOrderPage.getUnitPriceAndProducts());
    }
}

