package com.cydeo.utility;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtil {
    public static void waitFor(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static boolean checkVisibilityOfElement(By locator , int timeToWait ){

        boolean result = false ;

        WebDriverWait wait = new WebDriverWait(Driver.getDriver() ,timeToWait ) ;

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated( locator  ));
            // if above line does not throw exception we will come to this line and below
            result = true ;
        }catch(TimeoutException e){
            //System.out.println("The error message is = " + e.getMessage()  );
            System.out.println("WE DID NOT SEE THE ERROR MESSAGE ELEMENT ");
        }

        return result ;



    }

public static List<String> getAllText(List<WebElement>lstOfWebElements){
        List<String> allTextList=new ArrayList<>();
    for (WebElement eachElement : lstOfWebElements) {
        allTextList.add(eachElement.getText());
    }
    return allTextList;
}




}