package guru.qa;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

public class CheckPDFFileTest {

    @Test
    void checkPdfTest() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("PDF.pdf");
        PDF parsedPdf = new PDF(stream);
        String textExample = "Оплата налоговой задолженности";
        textExample = new String(textExample.getBytes("windows-1251"), StandardCharsets.UTF_8);
        assertThat(parsedPdf.text).contains(textExample);
    }
}
