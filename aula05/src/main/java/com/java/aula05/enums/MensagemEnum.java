package com.java.aula05.enums;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;

@AllArgsConstructor
public enum MensagemEnum {

    Titulo("Relatório de Alunos e Cursos", FontFactory.getFont(FontFactory.TIMES_ROMAN,25,Font.BOLD));

    @Getter
    private String value;

    @Getter
    private Font font;


}
