package org.iesfm.dao;

import org.iesfm.entity.Article;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileDAOImpl implements FileDAO {


    @Override
    public List<String> readTextAndLoadInFile(File file) throws IOException {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader br = new BufferedReader(fileReader)) {
            String line;
            List<String> text = new LinkedList<>();
            boolean lineN1 = true;
            while ((line = br.readLine()) != null) {
                if (lineN1) {
                    lineN1 = false;
                    continue;
                }
                text.add(line);
            }
            return text;
        }
    }

    @Override
    public void insertTextIntoFile(File file, String text) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(text);
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void insertArticleInfo(Article article) {
        System.out.println("Articulo: " + article.getArticle());
        System.out.println("Tipo: " + article.getType());
        System.out.println("Precio de Venta: " + article.getSellPrice());
        double cost = article.getDerivedCosts() + article.getProductionCosts() + article.getTaxes();
        System.out.println("Coste: " + cost);
        double benefits = article.getSellPrice() - cost;
        System.out.println("Beneficio" + benefits);
        for (int i = 0; i < 25; i++) {
            System.out.printf("=");
        }
    }

    @Override
    public List<Article> createNewArticle(String path) throws IOException {
        File file = new File(path);

        List<String> lines = readTextAndLoadInFile(file);
        List<Article> articles = new LinkedList<>();

        String[] separatedText;
        for (String line : lines) {
            separatedText = line.replace(",", ".").split(";");
        }

    }


}
