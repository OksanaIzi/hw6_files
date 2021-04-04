package tests;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;

public class DocxFileTests {
    @Test
    void docxTest() throws IOException {
        String docxFilePath = "./src/test/resources/Files/1.docx";
        String expectedData = "file test";
        FileInputStream fis = new FileInputStream(docxFilePath);
        XWPFDocument doc = new XWPFDocument(fis);
        XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
        String actualData = extractor.getText();
        assertThat(actualData, containsString(expectedData));
    }
}
