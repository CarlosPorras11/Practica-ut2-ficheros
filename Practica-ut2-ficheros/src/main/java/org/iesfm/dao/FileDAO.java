package org.iesfm.dao;

import org.iesfm.entity.Article;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileDAO {

    List<String> readTextAndLoadInFile(File file) throws IOException;

    void insertTextIntoFile(File file, String text);

    void insertArticleInfo(Article article);

    List<Article> createNewArticle(String path) throws IOException;
}
