package com.cydeo.step_definitions;

import com.cydeo.pages.WLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;

import java.util.List;
import java.util.Map;

public class DatatableStepDefs {
    @Given("I have a {string}")
    public void i_have_a(String animal) {
        System.out.println("Given I have a "+animal);
    }
    @When("I call their names")
    public void i_call_their_names() {
        System.out.println(" When I call their names ");
    }
    @Then("They come to me.")
    public void they_come_to_me() {
        System.out.println("Then they come to me");
    }
    @Given("I have following animals")
    public void i_have_following_animals(List<String> animalLst) {
        System.out.println("animalLst = " + animalLst);
    }

    @When("I call their names with below names")
    public void iCallTheirNamesWithBelowNames(List<String>nameLst) {
        System.out.println("nameLst = " + nameLst);

    }

 //   @Then("They come to me with below noise")
  //  public void theyComeToMeWithBelowNoise(Map<String,String> animalNoiseMap) {

  //      System.out.println("animalNoiseMap = " + animalNoiseMap);

   // }
    @Then("They come to me with below noise")
      public void theyComeToMeWithBelowNoise(List<List<String>> animalRowLst) {
        System.out.println("animalRowLst = " + animalRowLst);

    }

    @When("we provide below credentials")
    public void weProvideBelowCredentials(Map<String,String>credentialMap) {
        System.out.println("credentialMap = " + credentialMap);
        String userNameFromTable=credentialMap.get("username");
        String passwordFromTable=credentialMap.get("password");
        WLoginPage loginPage=new WLoginPage();
        loginPage.login(userNameFromTable,passwordFromTable);

    }

    @Given("this is the product reference")
    public void thisIsTheProductReference(List<Map<String,Object>>productMapList) {

        System.out.println("productMapList = " + productMapList);

        for (Map<String,Object>eachRowMap :productMapList){
            System.out.println("eachRowMap = " + eachRowMap);

            Map<String, Object> thirdRowMap = productMapList.get(2);
            // the key is column name , the value is cell value
            System.out.println("thirdRowMap = " + thirdRowMap);
            // print Discount column of 3rd row
            System.out.println("thirdRowMap.get(\"Discount\") = "
                    + thirdRowMap.get("Discount"));
            System.out.println("productMapList.get(1).get(\"Price\") = "
                    + productMapList.get(1).get("Price"));
        }
    }

    @And("I have a another product reference without header")
    public void headlessTable(List<List<String>>productInfoList) {
        System.out.println("productInfoList = " + productInfoList);
         List<String> thirdRow = productInfoList.get(2);
        List<String> firstRow = productInfoList.get(0);
        System.out.println("thirdRow = " + thirdRow);
        System.out.println("firstRow = " + firstRow);
        System.out.println("thirdRow price is = " + thirdRow.get(1));
        System.out.println("productInfoList.get(0).get(2) = " + productInfoList.get(0).get(2));
    }
}

