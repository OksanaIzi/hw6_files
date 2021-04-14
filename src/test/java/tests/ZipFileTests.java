package tests;

import com.codeborne.pdftest.PDF;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.getPdf;
import static utils.Files.readTextFromPath;
import static utils.Zip.unzip;

public class ZipFileTests {


    @Test
    void zipWithPasswordTest() throws IOException, ZipException {
        String zipFilePath = "src/test/resources/files/1.zip";
        String unzipFolderPath = "src/test/resources/files/unzip";
        String zipPassword = "1";
        String unzipPdfFilePath = "src/test/resources/files/unzip/1.pdf";
        String expectedData = "PDF Test File";

        unzip(zipFilePath, unzipFolderPath, zipPassword);

        PDF actualData = getPdf(unzipPdfFilePath);

        assertThat(actualData, PDF.containsText(expectedData));
    }

    @Test
    void zipTest() throws IOException, ZipException {
        String zipFilePath = "./src/test/resources/files/2.zip";
        String unzipFolderPath = "./src/test/resources/files/unzip1";
        String unzipTxtFilePath = "./src/test/resources/files/unzip1/1.txt";
        String expectedData = "6 lesson files";

        unzip(zipFilePath, unzipFolderPath);

        String actualData = readTextFromPath(unzipTxtFilePath);

        assertThat(actualData, containsString(expectedData));
    }
}
