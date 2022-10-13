package org.iesfm.dao;

import java.io.File;
import java.io.IOException;

public interface FileDAO {
    void readTextInFile(File file, String text) throws IOException;
    void createInfoEntity(File file);
}
