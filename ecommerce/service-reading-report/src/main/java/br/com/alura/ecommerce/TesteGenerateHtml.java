package br.com.alura.ecommerce;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.UUID;

public class TesteGenerateHtml {
    public static void main(String[] args) throws IOException {
        File htmlTemplateFile = new File("E:\\Java\\ecommerce\\service-reading-report\\src\\main\\resources\\template.html");
        String htmlString = FileUtils.readFileToString(htmlTemplateFile, Charset.defaultCharset());
        String title = "New Page";
        String body = "This is Body";
        String uuid = UUID.randomUUID().toString() + ".html";
        htmlString = htmlString.replace("$title", title);
        htmlString = htmlString.replace("$body", body);
        File newHtmlFile = new File("E:\\Java\\ecommerce\\service-reading-report\\src\\main\\resources\\" + uuid);
        FileUtils.writeStringToFile(newHtmlFile, htmlString, Charset.defaultCharset());
    }
}
