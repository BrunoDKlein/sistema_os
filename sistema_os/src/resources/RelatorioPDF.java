/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import javax.swing.JFileChooser;

public class RelatorioPDF<T> {

    public void gerarRelatorio(String titulo, List<String> tituloColunas, List<String> nomesAtributos, List<T> dados) {
        Document document = new Document();
        String c = caminho();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(c + ".pdf"));
            document.open();

            // Adiciona título
            Font tituloFonte = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph tituloParagrafo = new Paragraph(titulo, tituloFonte);
            tituloParagrafo.setAlignment(Element.ALIGN_CENTER);
            tituloParagrafo.setSpacingAfter(20);
            document.add(tituloParagrafo);

            // Cria a tabela
            PdfPTable tabela = new PdfPTable(tituloColunas.size());
            tabela.setWidthPercentage(100);

            // Cabeçalhos
            Font cabecalhoFonte = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            for (String coluna : tituloColunas) {
                PdfPCell cell = new PdfPCell(new Phrase(coluna, cabecalhoFonte));
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabela.addCell(cell);
            }

            // Dados
            for (T item : dados) {
                for (String atributo : nomesAtributos) {
                    Object valor = getCampoPorNome(item, atributo);
                    tabela.addCell(valor != null ? valor.toString() : "");
                }
            }

            document.add(tabela);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
            abrirArquivo(c);
        }
    }

    private Object getCampoPorNome(T obj, String nomeCampo) {
        try {
            Field field = obj.getClass().getDeclaredField(nomeCampo);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            return null;
        }
    }

    private String caminho() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar PDF");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File file) {
                return file.getName().toLowerCase().endsWith(".pdf") || file.isDirectory();
            }

            public String getDescription() {
                return "Arquivos PDF (*.pdf)";
            }
        });

        // Mostrar a caixa de diálogo de seleção de arquivo
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            return file.getAbsolutePath();
        }
        return null;
    }

    private void abrirArquivo(String c) {
        File file = new File(c + ".pdf");
        if (file.exists()) {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
