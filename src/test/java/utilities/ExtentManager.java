package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    ExtentReports extent;
    ExtentTest test;
    ExtentSparkReporter spark;
    public String reportDate;
    public String filePath;

    public void init() {
        reportDate = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        filePath = ".\\reports\\Mailinator Report " + reportDate;
        new File(filePath).mkdirs();

        spark = new ExtentSparkReporter(filePath + "/report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        spark.config().setDocumentTitle("Automation report on Mailinator");
        spark.config().setReportName("PlainId Test");
        spark.config().setEncoding("windows-1255");
    }

    public void create_test(String testName) {
        test = extent.createTest(testName);
    }

    public String CaptureScreen() throws AWTException, IOException {
        String picDate = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        String imagePath = filePath + "\\pic" + picDate + ".jpg";
        String absolutePath =  System.getProperty("user.home") + "\\PlainId" + imagePath;
        Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(screenShot, "jpg", new File(imagePath));
        return absolutePath;
    }

}
