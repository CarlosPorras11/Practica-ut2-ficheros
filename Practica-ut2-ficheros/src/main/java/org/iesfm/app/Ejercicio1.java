package org.iesfm.app;

import org.iesfm.service.FileService;

public class Ejercicio1 {

    private final static String NOMBRE_FACTURA = "src/main/resources/invoice_202009.csv";

    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.printInfoArticleInFile(NOMBRE_FACTURA);
    }
}
