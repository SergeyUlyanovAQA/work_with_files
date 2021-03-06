package guru.qa;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CheckDocxFileTest {

    public static class DocxTest {
        String fileText;
        @Test
        void docxTest()throws Exception {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream stream = classLoader.getResourceAsStream("DOC.docx");
            XWPFDocument docxFile = new XWPFDocument(stream);
            List<XWPFParagraph> paragraphs = docxFile.getParagraphs();
            String textExample = "довольно старенький друг";
            textExample = new String(textExample.getBytes("windows-1251"), StandardCharsets.UTF_8);
            for (XWPFParagraph p : paragraphs) {
                fileText = fileText + p.getText();
            }
            boolean b = fileText.contains("довольно старенький друг");
            Assertions.assertTrue(fileText.contains(textExample));
        }
    }
}
