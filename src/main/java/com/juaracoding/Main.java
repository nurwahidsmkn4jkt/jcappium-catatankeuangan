package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        // Setup
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "SM M115F");
        dc.setCapability("udid", "R9RNA002W5R");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.chad.financialrecord");
        dc.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        dc.setCapability("noReset", "true");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, dc);
        System.out.println("Appium Start");
        delay(3);


        // Pengeluaran
        MobileElement btnTambah = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        btnTambah.click();
        delay(2);
        MobileElement formJmlh = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        formJmlh.sendKeys("10000");
        MobileElement formNote = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        formNote.sendKeys("Makan Siang");
        MobileElement btnSave = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");
        btnSave.click();
        delay(2);
        MobileElement pengeluaran = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvExpense");


        // Pemasukan
        btnTambah.click();
        delay(2);
        MobileElement tabIncome = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnIncome");
        tabIncome.click();
        delay(2);
        MobileElement jmlhIncome = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        jmlhIncome.sendKeys("100000");
        MobileElement noteIncome = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        noteIncome.sendKeys("Bulanan");
        MobileElement saveIncome = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");
        saveIncome.click();
        delay(2);
        MobileElement pemasukan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvIncome");

        // Validasi Test
        String actlExpense = "-"+pengeluaran.getText();
        String expdExpense = "-10.000";
        if (actlExpense.equalsIgnoreCase(expdExpense)){
            System.out.println("Data Pengeluaran Berhasil Ditambahkan");
            System.out.println("Jumlah Pengeluaran: "+actlExpense);
        }else {
            System.out.println("Data Pengeluaran Gagal Ditambahkan");
        }
        String actlIncome = pemasukan.getText();
        String expdIncome = "100.000";
        if (actlIncome.equalsIgnoreCase(expdIncome)){
            System.out.println("Data Pemasukan Berhasil Ditambahkan");
            System.out.println("Jumlah Pemasukan: "+actlIncome);
        }else {
            System.out.println("Data Pemasukan Gagal Ditambahkan");
        }
    }

    public static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}