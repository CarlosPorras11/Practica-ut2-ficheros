package org.iesfm.dao;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;

public interface ExcelDAO {
    void createFileInDisk(Workbook libro, String path) throws IOException;

}
