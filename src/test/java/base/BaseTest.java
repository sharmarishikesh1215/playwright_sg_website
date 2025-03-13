package base;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BaseTest {
    public static Playwright playwright;
    public static Browser browser;
    BrowserContext context;
    Page page;

    protected String baseUrl = "https://sacredgroves.earth/";

    @Test
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        context = browser.newContext();
        page = context.newPage();
        page.navigate(baseUrl);

        // Expect a title "to contain" a substring.
        assertThat(page).hasTitle(Pattern.compile("Sacred"));
    }
}
