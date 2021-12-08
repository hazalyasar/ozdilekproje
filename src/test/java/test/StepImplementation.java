package test;

import com.thoughtworks.gauge.Step;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

public class StepImplementation extends BaseTest {
    @Step("<time> saniye bekle")
    public void waitTime(int time) throws InterruptedException {
        Thread.sleep(1000 * time);
    }

    @Step("<Element> Id'li elemente tıkla")
    public void clickElementById(String Element) {
        appiumDriver.findElement(By.id(Element)).click();

        System.out.println(Element + "elementine tıklandı");
    }

    @Step("<Element> CssSelector'lu elemente tıkla")
    public void clickElementByCssSelector(String Element) {
        appiumDriver.findElement(By.id(Element)).click();
        System.out.println(Element + "elementine tıklandı");
    }

    @Step("<Element> Xpath'li elementine tıkla.")
    public void clickElementByXpath(String Element) {
        appiumDriver.findElement(By.xpath(Element)).click();
        System.out.println(Element + "elementine tıklandı");
    }

    @Step("<Element> xpath'li elemente <Gönderi> değerini gir")
    public void SendkeyElementByxpath(String Element, String Gönderi) {
        appiumDriver.findElement(By.id(Element)).sendKeys(Gönderi);
        System.out.println(Element + "SendKey alanına gönderildi");

    }

    @Step("<Element> id'li elemete <Gönderi> değeri yaz")
    public void SendKeyElementByid(String Element, String Gönderi) {
        appiumDriver.findElement((By.id(Element))).sendKeys(Gönderi);
        System.out.println(Element + "Elementine tıklandı");


    }

    @Step("<Element> kere scroll yap")
    public void ScrollThePage(int Element) {
        while (Element > 0) {
            TouchAction swipe = new TouchAction(appiumDriver).press(PointOption.point(540, 1824)).waitAction(waitOptions(ofMillis(800))).moveTo(PointOption.point(540, 672)).release().perform();
            Element--;

        }
    }
    @Step("random ürün ekleme")
    public  void addFav(){

        List<String> elementList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {

           elementList.add("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout["+(i+1)+"]/android.view.ViewGroup/android.widget.ImageView");
        }int index = random.nextInt(4);
        appiumDriver.findElement(By.xpath(elementList.get(index))).click();

    }


}