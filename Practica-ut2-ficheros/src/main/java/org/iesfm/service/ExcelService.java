package org.iesfm.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.iesfm.dao.ExcelDAO;
import org.iesfm.dao.ExcelDAOImpl;
import org.iesfm.dao.FileDAO;
import org.iesfm.dao.FileDAOImpl;
import org.iesfm.entity.Article;
import org.iesfm.entity.InvoiceEntity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExcelService {

    FileDAO fileDAO = new FileDAOImpl();
    ExcelDAO excelDAO = new ExcelDAOImpl();

    public void createInvoiceExcel(String filePath, String pathInvoice) {
        File file = new File(pathInvoice);
        List<Article> articles = new LinkedList<>();
        String[] splitLines;
        List<InvoiceEntity> invoiceEntityList = loadInfo(articles);
        try (Workbook workbook = new XSSFWorkbook()) {
            List<String> lines = fileDAO.readTextAndLoadInFile(file);
            for (String line : lines) {
                splitLines = line
                        .replace(",", ".")
                        .split(";");
                Sheet sheet = workbook.createSheet();
                createHeader(sheet, workbook.createCellStyle(), workbook.createFont());
                createRows(invoiceEntityList, sheet, articles.size());

                excelDAO.createFileInDisk(workbook, filePath);
            }
        } catch (IOException e) {
            System.err.println("Error creando workbook: " + e.getMessage());
        }
    }

    private List<InvoiceEntity> loadInfo(List<Article> articles) {
        List<InvoiceEntity> invoiceEntityList = new ArrayList<>();
        for (int i = 0; i < articles.size(); i++) {

            double cost = articles.get(i).getDerivedCosts() +
                    articles.get(i).getProductionCosts() +
                    articles.get(i).getTaxes();
            double profit = articles.get(i).getSellPrice() - cost;

            invoiceEntityList.add(new InvoiceEntity());
        }
        return invoiceEntityList;
    }

    private void createHeader(Sheet sheet, CellStyle cellStyle, Font font) {
        cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setColor(IndexedColors.BLACK.getIndex());
        font.setBold(true);
        cellStyle.setFont(font);

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        RichTextString text = new XSSFRichTextString("Articulo");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(1);
        text = new XSSFRichTextString("Tipo");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(2);
        text = new XSSFRichTextString("Fecha de venta");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(3);
        text = new XSSFRichTextString("Precio de venta");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(4);
        text = new XSSFRichTextString("Costes derivados");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(5);
        text = new XSSFRichTextString("Costes de producción");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(6);
        text = new XSSFRichTextString("Impuestos");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(7);
        text = new XSSFRichTextString("Beneficio");
        cell.setCellValue(text);
        cell.setCellStyle(cellStyle);
    }

    private void createRows(List<InvoiceEntity> invoiceEntityList, Sheet sheet, int rowNumber) {
        for (int i = 0; i < invoiceEntityList.size(); i++) {

            InvoiceEntity invoiceEntity = invoiceEntityList.get(i);
            Row row = sheet.createRow(i + 1);

            Cell cell;
            RichTextString text;
            CellStyle cellStyle = null;
            if (rowNumber % 2 == 0) {
                cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                cell = row.createCell(0);
                text = new XSSFRichTextString(invoiceEntity.getArticle());
                cell.setCellValue(text);
                cell.setCellStyle(cellStyle);

                cell = row.createCell(2);
                text = new XSSFRichTextString(invoiceEntity.getSellDate());
                cell.setCellValue(text);
                cell.setCellStyle(cellStyle);

                cell = row.createCell(4);
                text = new XSSFRichTextString(String.valueOf(invoiceEntity.getDerivedCosts()));
                cell.setCellValue(text);
                cell.setCellStyle(cellStyle);

                cell = row.createCell(6);
                text = new XSSFRichTextString(String.valueOf(invoiceEntity.getTaxes()));
                cell.setCellValue(text);
                cell.setCellStyle(cellStyle);


            } else {
                cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
                cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);


                cell = row.createCell(1);
                text = new XSSFRichTextString(invoiceEntity.getType());
                cell.setCellValue(text);
                cell.setCellStyle(cellStyle);

                cell = row.createCell(3);
                text = new XSSFRichTextString(String.valueOf(invoiceEntity.getSellPrice()));
                cell.setCellValue(text);
                cell.setCellStyle(cellStyle);

                cell = row.createCell(5);
                text = new XSSFRichTextString(String.valueOf(invoiceEntity.getProductionCosts()));
                cell.setCellValue(text);
                cell.setCellStyle(cellStyle);

                cell = row.createCell(7);
                text = new XSSFRichTextString(String.valueOf(invoiceEntity.getProfit()));
                cell.setCellValue(text);
                cell.setCellStyle(cellStyle);
            }
            cell.setCellValue(text);
        }
    }
}