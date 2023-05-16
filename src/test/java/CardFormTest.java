import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CardFormTest {

    private WebDriver driver;//поле под вебдрайвер с переменной driver, которую мы будем использовать для обращения к драйверу

    @BeforeAll //устанавливаем драйвер хрома, прописываем путь к нему в этом проекте
    static void SetUpAll() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    }

    @BeforeEach
        //перед каждым тестом открываем новую версию хрома, чтобы не переходили какие-то ранее запущенные действия
    void setUp() {
        driver = new ChromeDriver();
    }

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
    void ShouldTestV1() {
        driver.get("http://localhost:9999/");

    }

}

//    В поле фамилии и имени разрешены только русские буквы, дефисы и пробелы.
//        В поле телефона — только 11 цифр, символ + на первом месте.
//        Флажок согласия должен быть выставлен.

//    Смотрите на `data-test-id` и внутри него ищите нужный вам `input` — используйте вложенность для селекторов.
//Для запуска тестируемого приложения скачайте JAR-файл из текущего каталога и запускайте его командой: java -jar app-order.jar.

//Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.