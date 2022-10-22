package org.iesfm.dao;

import org.iesfm.entity.Article;
import org.iesfm.entity.FileEntity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileDAO {

    List<String> readTextAndLoadInFile(File file) throws IOException;

    void insertListIntoFile(File file, String text);

    String printArticleInfo(List<Article> articles);

    Article setArticleInfo(String[] splitInfo);

    File[] listFiles(String directory);

    String printFileInfo(List<FileEntity> fileEntities, FileEntity fileEntity);

    int sumArticles(List<Article> articles);

    double totalProfit(List<Article> articles);

    FileEntity setFileInfo(String path, File file, List<Article> articles);
}
