package org.iesfm.app;

import org.iesfm.service.FileService;

public class Ejercicio1 {

    private final static String PATH_FACTURA = "src/main/resources/invoice_202009.csv";
    private final static String PATH_FILE = "src/main/resources/invoice.txt";

    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.insertArticlesInFile(PATH_FILE);
    }
}
