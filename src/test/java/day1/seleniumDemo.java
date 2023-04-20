package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumDemo {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","//Users/NanditaAgarwal/Downloads/chromedriver_mac64//chromedriver");
        WebDriver d = new ChromeDriver();
        d.get("https://www.facebook.com/");
        d.quit();
    }
}
