package org.iesfm.dao;

import org.iesfm.entity.FileEntity;

import java.io.File;
import java.io.IOException;

public interface FileDAO {

    void readTextInFile(File file, String text);

    void insertTextIntoFile(File file, String text);

    void insertArticleInfo(FileEntity fileEntity);

    String[] separaPorComponentes(File file);
}
