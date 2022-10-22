package org.iesfm.app;

import org.iesfm.service.ExcelService;

public class Ejercicio3 {
    private  static final String PATH_EXCEL = "src/main/resources/invoice_202009.xlsx";
    private  static final String PATH_INVOICE = "src/main/resources/invoice_202009.csv";

    public static void main(String[] args) {
        ExcelService excelService = new ExcelService();
        excelService.createInvoiceExcel(PATH_EXCEL, PATH_INVOICE);
    }
}
