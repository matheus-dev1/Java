package br.com.alura.ecommerce;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.UUID;

// Classe responsave por gerar um novo relatorio em um HTML
public class ReportingUtils {
    public void generateReporting(String origem, String destino, String t1, String t2) throws IOException {
        // Aqui eu vou abrir um arquivo HTML
        File templateArquivoHtml = new File(origem);
        // Aqui eu vou transformar o HTML em String usando o encondig padrão do projeto, acho que neste projeto é o UTF-8
        String arquivoHtmlEmString = FileUtils.readFileToString(templateArquivoHtml, Charset.defaultCharset());
        String uuid = UUID.randomUUID().toString() + ".html";
        // Aqui eu vou pegar a "variavel" $title no html e substituir por o conteutod da variavel title aqui no Java.
        arquivoHtmlEmString = arquivoHtmlEmString.replace("$title", t1);
        arquivoHtmlEmString = arquivoHtmlEmString.replace("$body", t2);
        // Crio um novo HTML
        File novoHtml = new File(destino + uuid);
        // E escrevo um novo arquivo HTML renomeado.
        FileUtils.writeStringToFile(novoHtml, arquivoHtmlEmString, Charset.defaultCharset());
    }
}
