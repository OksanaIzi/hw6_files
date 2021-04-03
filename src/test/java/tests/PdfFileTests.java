package tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Files.getPdf;

public class PdfFileTests {

    @Test
    void pdfTests() throws IOException {
        String pdfFilepath = "./src/test/resources/files/1.pdf";
        String expectedData = "PDF Test File";

        PDF pdf = getPdf(pdfFilepath);
        assertThat(pdf, PDF.containsText(expectedData));
    }
}
