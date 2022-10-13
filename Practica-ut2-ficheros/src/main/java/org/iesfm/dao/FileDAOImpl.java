package org.iesfm.dao;

import org.iesfm.entity.FileEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDAOImpl implements FileDAO {

    @Override
    public void readTextInFile(File file, String text) throws IOException {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader br = new BufferedReader(fileReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    @Override
    public void createInfoEntity(File file) {
        List<FileEntity> fileEntityList = new ArrayList<>();
        
    }


}
