package zadanie1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;

import java.util.Random;

public class BingTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();

        // Przejdź do Google
        driver.get("https://www.bing.com");
    }

    @Test
    public void testGoogleSearch() {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("q"));
        // Wyczyść teskst zapisany w elemencie
        element.clear();


        // String query = "Mistrzostwa świata w piłce nożnej";
        String[] queries = {
                "Mistrzostwa świata w piłce nożnej", //0
                "Mistrzostwa świata w piłce siatkowej",
                "Mistrzostwa świata w piłce wodnej",
                "a",
                "b",
                "c" // 5
        };

        Random random = new Random();
        int randomInteger = random.nextInt(6);

        // Wpisz informacje do wyszukania
        element.sendKeys(queries[randomInteger]);

        // Prześlij formularz
        element.submit();
    }

    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        // driver.quit();
    }
}