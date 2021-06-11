package google;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Google {

    String url1;
    String url2;
    WebDriver driver;


    @Before
    public void iniciar (){
        url1 = "https://google.com.br/";
        url2 = "https://cacaushow.com.br";
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/90/chromedriver.exe" );
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

    }

    @Test
    public void consultarArtigo(){
        String ovo = "OVO PANTUFA P ROXO 160G";
        String preco = "R$99.90";
        String ovo2 = "OVO AMARULA 216G";
        driver.get(url1);
        driver.findElement(By.name("q")).sendKeys("ovos de pascoa");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.get(url2);
        driver.findElement(By.name("q")).sendKeys("ovo" + Keys.ENTER);
        driver.findElement(By.id("consent-tracking")).click();
        assertEquals(ovo,driver.findElement(By.cssSelector("div.page:nth-child(5) div.Search-Show div.container.search-results div.row:nth-child(2) div.tab-content.col-12 div.tab-pane.container.active:nth-child(1) div.row:nth-child(2) div.col-sm-12.col-md-9 div.row.product-grid:nth-child(2) div.it__shelf__item:nth-child(3) div.product:nth-child(3) div.product-tile div.tile-body div.pdp-link > a.link")).getText());
        assertEquals(preco,driver.findElement(By.cssSelector("div.page:nth-child(5) div.Search-Show div.container.search-results div.row:nth-child(2) div.tab-content.col-12 div.tab-pane.container.active:nth-child(1) div.row:nth-child(2) div.col-sm-12.col-md-9 div.row.product-grid:nth-child(2) div.it__shelf__item:nth-child(3) div.product:nth-child(3) div.product-tile div.tile-body div.it__shelf--price div.it__shelf--bestPrice > div.it__shelf__discountPrice")).getText());
        assertEquals(ovo2,driver.findElement(By.cssSelector("div.page:nth-child(5) div.Search-Show div.container.search-results div.row:nth-child(2) div.tab-content.col-12 div.tab-pane.container.active:nth-child(1) div.row:nth-child(2) div.col-sm-12.col-md-9 div.row.product-grid:nth-child(2) div.it__shelf__item:nth-child(9) div.product:nth-child(3) div.product-tile div.tile-body div.pdp-link > a.link")).getText());


    }

    @After
    public void finalizarArtigo(){
        driver.quit();


    }


}
