package com.cydeo.pages;

import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WAllProductPage {

    //table[@class='ProductsTable']//tr[2]/td
    @FindBy(xpath = "//table[@class='ProductsTable']//tr/th")
    private List<WebElement> allHeaderRowCells;

    @FindBy(xpath = "//table[@class='ProductsTable']//tr[2]/td")
    private List<WebElement>firstRowCells;

    @FindBy(xpath = "//table[@class='ProductsTable']//tr[3]/td")
    private List<WebElement>secondRowCells;

    @FindBy(xpath = "//table[@class='ProductsTable']//tr[4]/td")
    private List<WebElement>thirdRowCells;
    public WAllProductPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public List<String> getAllHeaderText(){
     //   List<String> allTexts=new ArrayList<>();
     //   for (WebElement eachElement : allHeaderRowCells) {
     //       allTexts.add(eachElement.getText());
      //  }



        return BrowserUtil.getAllText(allHeaderRowCells);
    }
    public Map<String,String> getRowMapFromWebTable(){


        // we want to create a map:
        //- key as coloumn name
        //- value as cell value

        Map<String,String>rowMap=new LinkedHashMap<>();
        //how to get all headers  so we can use as key
        List<String> allHeaders=BrowserUtil.getAllText(allHeaderRowCells);

        List<String> allFirstRow=BrowserUtil.getAllText(firstRowCells);

    //    rowMap.put(allHeader.get(0),allFirstRow.get(0));
    //    rowMap.put(allHeader.get(1),allFirstRow.get(1));
     //   rowMap.put(allHeader.get(2),allFirstRow.get(2));
        for (int collIndex = 0; collIndex < allHeaders.size(); collIndex++) {
            rowMap.put(allHeaders.get(collIndex),allFirstRow.get(collIndex));
        }

        return rowMap;
    }
}
