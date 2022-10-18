package org.iesfm.service;

import org.iesfm.dao.FileDAO;
import org.iesfm.dao.FileDAOImpl;
import org.iesfm.entity.Article;
import org.iesfm.entity.FileEntity;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileService {

    FileDAO fileDAO = new FileDAOImpl();

// EJERCICIO 1.

    public void insertArticlesInFile(String pathFactura, String pathResult) {

        File file = new File(pathFactura);
        List<Article> articles = new LinkedList<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Escribe el nombre del fichero resultado.");
            String fileName = sc.nextLine();

            File fileResult = new File(pathResult + fileName + ".txt");
            while (fileResult.exists()) {
                fileResult.delete();
            }
            fileResult.createNewFile();
            List<String> lines = fileDAO.readTextAndLoadInFile(file);
            String[] splitLines;
            for (String line : lines) {
                splitLines = line
                        .replace(",", ".")
                        .split(";");
                Article article = fileDAO.setArticleInfo(splitLines);
                articles.add(article);
                System.out.println(fileDAO.printArticleInfo(articles));
                fileDAO.insertListIntoFile(articles, fileResult);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

// EJERCICIO 2.

    public void printInvoiceFile(String pathResult) {
        File[] files = fileDAO.listFiles(pathResult);

    }
}

