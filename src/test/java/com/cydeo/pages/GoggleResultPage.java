package com.cydeo.pages;

import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoggleResultPage  {


    @FindBy (id="result-stats")
    private WebElement searchResultCount;

    @FindBy(xpath = "//h3[@class='LC20lb DKV0Md']")
    private List<WebElement> resultLinks;

    public GoggleResultPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getResultCountText(){
        return searchResultCount.getText();
    }

    public void printAllSearchResultLinks(){
        System.out.println("resultLinks.size() = " + resultLinks.size());
        for (WebElement eachLinkElm : resultLinks) {
            System.out.println("eachLinkElm.getText() = " + eachLinkElm.getText());
        }
    }
}
