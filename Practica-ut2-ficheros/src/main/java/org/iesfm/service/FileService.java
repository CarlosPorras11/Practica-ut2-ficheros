package org.iesfm.service;

import org.iesfm.dao.FileDAO;
import org.iesfm.dao.FileDAOImpl;
import org.iesfm.entity.Article;
import org.iesfm.entity.FileEntity;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
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
                System.out.print(fileDAO.printArticleInfo(articles));
                fileDAO.insertListIntoFile(fileResult, fileDAO.printArticleInfo(articles));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

// EJERCICIO 2.

    public void printInvoiceFile(String pathResult, String pathInvoice) {
        File[] files = fileDAO.listFiles(pathResult);
        List<Article> articles = new LinkedList<>();
        File invoiceFile = new File(pathInvoice);
        for (File file : files) {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Escribe el nombre del fichero resultado anterior.");
                String fileName = sc.nextLine();

                File fileResult = new File("result_" + fileName + ".txt");
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
                    List<FileEntity> fileEntities = new LinkedList<>();
                    FileEntity fileEntity = fileDAO.setFileInfo(fileName, invoiceFile, articles);
                    fileEntities.add(fileEntity);
                    System.out.println(fileDAO.printFileInfo(fileEntities, fileEntity));
                    fileDAO.insertListIntoFile(fileResult, fileDAO.printFileInfo(fileEntities, fileEntity));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}