package com.hepsiburada.tests;

import com.hepsiburada.pages.HepsiburadaHomePage;
import com.hepsiburada.utilities.ConfigReader;
import com.hepsiburada.utilities.Driver;
import com.hepsiburada.utilities.ReusableMethods;
import com.hepsiburada.utilities.TestBaseRapor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HepsiBuradaLogin extends TestBaseRapor {

    @Test
    public void LoginTest() throws InterruptedException {




        ReusableMethods.waitFor(5);
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburada_url"));

        System.out.println(Driver.getDriver().getCurrentUrl());
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ConfigReader.getProperty("expected_url"));

        Actions actions = new Actions(Driver.getDriver());
        HepsiburadaHomePage hepsiburadaHomePage = new HepsiburadaHomePage();
        actions.moveToElement(hepsiburadaHomePage.girisyap).perform();
        ReusableMethods.waitFor(5);
        actions.click(hepsiburadaHomePage.login).perform();

        ReusableMethods.waitFor(5);
        hepsiburadaHomePage.loginEmail.sendKeys(ConfigReader.getProperty("hepsiburada_mail"));

        hepsiburadaHomePage.loginSifre.sendKeys(ConfigReader.getProperty("hepsiburada_sifre"));

        ReusableMethods.waitFor(5);
        hepsiburadaHomePage.login2.click();


    }
    @Test
    public void searchBoxTest() throws InterruptedException {
            extentTest=extentReports.createTest("Urun begenip sepete ekledikten sonra sepetten cikarilma testi","Belilenen urun begenildikten sonra begendiklerime girilip urun sepete eklendi ardından sepetime gidilip urun sepetten cikarildi");
            HepsiburadaHomePage hepsiburadaHomePage = new HepsiburadaHomePage();
            LoginTest();
            extentTest.info("Login yapildi");
            hepsiburadaHomePage.searchBox.sendKeys(ConfigReader.getProperty("aranan_kelime"));
            extentTest.info("aranmasi belirlenen kelime searchbox'ta arandi");
            ReusableMethods.waitFor(1);
            hepsiburadaHomePage.ara.click();
            extentTest.info("ara butonuna basildi");
            ReusableMethods.waitFor(1);
            hepsiburadaHomePage.telefonDropDown.click();
            extentTest.info("Soldaki menuden telefon secildi");
            ReusableMethods.waitFor(3);
            hepsiburadaHomePage.ceptelefonu.click();
            extentTest.info("soldaki menuden cep telefonu secildi");
            System.out.println(hepsiburadaHomePage.samsungDogrulama.getText());
            Assert.assertTrue(hepsiburadaHomePage.samsungDogrulama.getText().contains("samsung"));
            extentTest.info("Excepted result ile actual result karsilastirildi");
            Actions actions = new Actions(Driver.getDriver());
            ReusableMethods.waitFor(2);

            for (int i =1; i<=10;i++){
                    if (!hepsiburadaHomePage.page2.isDisplayed()) {
                            actions.sendKeys(Keys.PAGE_DOWN).perform();
                    }
            }

            hepsiburadaHomePage.page2.click();
            extentTest.info("Aranilan urunlerde ikinci sayfaya gecis yapildi");
            System.out.println(Driver.getDriver().getCurrentUrl());
            Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("sayfa=2"));
            extentTest.info("ikinci sayfaya gecildigi url'den dogrulandi");
            ReusableMethods.waitFor(2);
            hepsiburadaHomePage.product5.click();
            extentTest.info("5.Urun secildi");
            ReusableMethods.waitFor(2);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.waitFor(1);
            String seciliUrunAdi=hepsiburadaHomePage.secilenUrun.getText();
            ReusableMethods.waitFor(1);
            hepsiburadaHomePage.begenButton.click();
            extentTest.info("Belirlenen urun begenildi");
            ReusableMethods.waitFor(1);
            String actualResult=hepsiburadaHomePage.begeneneeklendi.getText();
            System.out.println(actualResult);
            ReusableMethods.waitFor(2);
            Assert.assertTrue(actualResult.contains("eklendi"));
            extentTest.info("Begenilen urunden sonra gelen begendiniz pop-up kontrol edildi");
            actions.sendKeys(Keys.PAGE_UP).perform();
            actions.sendKeys(Keys.PAGE_UP).perform();
            ReusableMethods.waitFor(2);
            actions.moveToElement(hepsiburadaHomePage.hesabım).perform();
            ReusableMethods.waitFor(1);
            actions.click(hepsiburadaHomePage.begendiklerim).perform();
            extentTest.info("Begendiklerim sayfasina gecis yapildi");
            ReusableMethods.waitFor(1);
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            String seciliUrunAdi2 =  hepsiburadaHomePage.secilenUrunBegendiklerim.getText();
            System.out.println(seciliUrunAdi);
            Assert.assertTrue(seciliUrunAdi2.contains("Samsung"));
            extentTest.info("Belirlenen urunun begendiklerimde oldugu test edildi");
            ReusableMethods.waitFor(2);
            actions.moveToElement(hepsiburadaHomePage.secilenUrunBegendiklerim).perform();
            ReusableMethods.waitFor(2);
            hepsiburadaHomePage.sepeteEkle.click();
            extentTest.info("begenilen urun sepete eklendi");
            ReusableMethods.waitFor(2);
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            actions.moveToElement(hepsiburadaHomePage.secilenUrunBegendiklerim).perform();
            ReusableMethods.waitFor(1);
            hepsiburadaHomePage.sepeteEkle.click();
            ReusableMethods.waitFor(1);
            Assert.assertTrue(hepsiburadaHomePage.sepeteEklendiPopUp.isDisplayed());
            actions.sendKeys(Keys.PAGE_UP).perform();
            actions.sendKeys(Keys.PAGE_UP).perform();
            ReusableMethods.waitFor(6);
            hepsiburadaHomePage.sepetimeGit.click();
            ReusableMethods.waitFor(2);
            hepsiburadaHomePage.copKutusu.click();
            ReusableMethods.waitFor(2);
            String urununsilindigidogrulama =  hepsiburadaHomePage.urununSilindiginiDogrulama.getText();
            System.out.println(urununsilindigidogrulama);
            Assert.assertTrue(urununsilindigidogrulama.contains("silin"));

    }



}
