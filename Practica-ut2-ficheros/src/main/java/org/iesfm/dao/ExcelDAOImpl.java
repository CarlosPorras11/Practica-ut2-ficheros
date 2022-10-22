package org.iesfm.dao;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelDAOImpl implements ExcelDAO{
    @Override
    public void createFileInDisk(Workbook workbook, String path) throws IOException {
        try (FileOutputStream file= new FileOutputStream(path)){
            workbook.write(file);
            System.out.println("Fichero creado en: " + path);
        }
    }
}
