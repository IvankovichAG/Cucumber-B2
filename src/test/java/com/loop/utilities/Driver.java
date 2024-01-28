package com.loop.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    /*
    Creating the private constructor so this class's Object is not reachable from outside
     */
    private Driver(){

    }

    /*
    making driver instance private
    static - run before everything else and also use in static method
     */

    //private static WebDriver driver;
    // implement TreadLocal to achieve multi thread locally
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    reusable method that will return the same driver instance every time called
     */
    /**
     * singleton pattern
     * @return driver
     * @author anna
     */

    public static WebDriver getDriver(){
        // if (driver == null) {
        if(driverPool.get()==null){
           String browserType = ConfigurationReader.getProperty("browser");
           switch(browserType.toLowerCase()){
               case "chrome":
                   WebDriverManager.chromedriver().setup();
                   //  driver = new ChromeDriver();
                   driverPool.set(new ChromeDriver());
                   driverPool.get().manage().window().maximize();
                   driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                   break;
               case "firefox":
                   WebDriverManager.firefoxdriver().setup();
                  // driver = new FirefoxDriver();
                   driverPool.set(new FirefoxDriver());
                   driverPool.get().manage().window().maximize();
                   driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                   break;
               case "headless":
                   ChromeOptions options = new ChromeOptions();
                   options.addArguments("--headless"); // enable headless mode
                   options.addArguments("--start-maximized"); // maximize
                   WebDriverManager.chromedriver().setup();
                   driverPool.set(new ChromeDriver(options));
                   break;
           }
//           driver.manage().window().maximize();
//           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }
       // return  driver;
        return  driverPool.get();
    }

    /**
     * closing driver
     * @author anna
     */
    public static void closeDriver(){

//        if (driver!= null){
//            driver.quit();
//            driver = null;


            if (driverPool.get() != null){
                driverPool.get().quit();
                driverPool.remove();
        }
    }



}
