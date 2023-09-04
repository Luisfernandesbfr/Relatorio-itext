package com.java.aula05.reports;

import com.itextpdf.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.java.aula05.entities.VWAlunoCurso;
import com.java.aula05.enums.MensagemEnum;
import net.bytebuddy.asm.MemberSubstitution;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import static sun.plugin.javascript.navig.JSType.Image;

public class AlunoCursoReport {

    private static Font Font_Titulo = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);
    private static Font Font_Corpo = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private List<VWAlunoCurso> lista;

    public AlunoCursoReport(List<VWAlunoCurso> lista) {
        this.lista = lista;
    }

    public byte[] createPDF() {
        try {
           //Adicionando orientacao e tipo da pagina
            Document documento = new Document(PageSize.A4);
            documento.setMargins(20,20,20,20);

          //o stream forbece um array
            ByteArrayOutputStream stream = new ByteArrayOutputStream();

          //escreve o documento criado em formato de arrtay de bytes
            PdfWriter.getInstance(documento, stream);

            documento.open();
            MensagemEnum mensagem = MensagemEnum.Titulo;

            Paragraph titulo = new Paragraph();
           Phrase phrase = new Phrase(mensagem.getValue(), mensagem.getFont());
           titulo.add(phrase);
           titulo.setAlignment(Element.ALIGN_CENTER);
           titulo.setSpacingAfter(20);

           Image foto = com.itextpdf.text.Image.getInstance(IOUtils.toByteArray(getClass().getResourceAsStream("/static/imagens/republica.png")));
           foto.scaleAbsolute(100f,100f);

            documento.add(foto);
            documento.add(titulo);

            PdfPTable tabela =new PdfPTable(4);
            tabela.setWidthPercentage(100);
            tabela.setSpacingBefore(10);
            tabela.setSpacingAfter(10);

            PdfPCell cellNome = new PdfPCell(new Phrase("Nome",Font_Corpo));
            PdfPCell cellEmail = new PdfPCell(new Phrase("Email",Font_Corpo));
            PdfPCell cellCurso =new  PdfPCell(new Phrase("Curso",Font_Corpo));
            PdfPCell cellDataMatricula = new  PdfPCell(new Phrase("Data de Matricula",Font_Corpo));

            tabela.addCell(cellNome);
            tabela.addCell(cellEmail);
            tabela.addCell(cellCurso);
            tabela.addCell(cellDataMatricula);

            for (VWAlunoCurso alunoCurso : lista) {
                tabela.addCell(alunoCurso.getNomeAluno());
                tabela.addCell(alunoCurso.getEmailAluno());
                tabela.addCell(alunoCurso.getDescricaoCurso());

                PdfPCell cellDtMatricula = new PdfPCell(new Phrase(dateFormat.format(alunoCurso.getDtMatricula()),Font_Corpo));
                tabela.addCell(cellDtMatricula);
            }
            documento.add(tabela);


            documento.close();

            return stream.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}