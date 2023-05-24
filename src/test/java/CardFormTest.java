import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardFormTest {

    private WebDriver driver;//поле под вебдрайвер с переменной driver, которую мы будем использовать для обращения к драйверу

//    @BeforeAll //устанавливаем драйвер хрома, прописываем путь к нему в этом проекте
//    static void SetUpAll() {
//        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
//    }

//    @BeforeEach
//        //перед каждым тестом открываем новую версию хрома, чтобы не переходили какие-то ранее запущенные действия
//    void setUp() {
//        driver = new ChromeDriver();
//    }

    @BeforeEach
    void setUpChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }
    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void ShouldBeCorrect() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Марина");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+79128808008");
        driver.findElement(By.cssSelector("[data-test-id=agreement] input")).click();
        driver.findElement(By.tagName("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText();
        assertEquals (expected, actual);


    }

}

//    В поле фамилии и имени разрешены только русские буквы, дефисы и пробелы.
//        В поле телефона — только 11 цифр, символ + на первом месте.
//        Флажок согласия должен быть выставлен.

//    Смотрите на `data-test-id` и внутри него ищите нужный вам `input` — используйте вложенность для селекторов.
//Для запуска тестируемого приложения скачайте JAR-файл из текущего каталога и запускайте его командой: java -jar app-order.jar.

//Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.