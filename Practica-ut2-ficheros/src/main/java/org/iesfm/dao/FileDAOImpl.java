package org.iesfm.dao;

import org.iesfm.entity.Article;
import org.iesfm.entity.FileEntity;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileDAOImpl implements FileDAO {

// EJERCICIO 1.

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
    public void insertListIntoFile(File file, String text) {
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(text);
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String printArticleInfo(List<Article> articles) {
        String info = "";

        for (int i = 0; i < articles.size(); i++) {
            double cost = articles.get(i).getDerivedCosts() +
                    articles.get(i).getProductionCosts() +
                    articles.get(i).getTaxes();
            double profits = articles.get(i).getSellPrice() - cost;

            info = "Articulo: " + articles.get(i).getArticle() + "\n" +
                    "Tipo: " + articles.get(i).getType() + "\n" +
                    "Precio de venta: " + articles.get(i).getSellPrice() + "\n" +
                    "Coste: " + cost + "\n" +
                    "Beneficio: " + profits + "\n" +
                    "==================================" + "\n";

        }
        return info;
    }

    @Override
    public Article setArticleInfo(String[] splitInfo) {
        Article article = new Article();

        article.setArticle(splitInfo[0]);
        article.setType(splitInfo[1]);
        article.setDate(splitInfo[2]);
        article.setSellPrice(Double.parseDouble(splitInfo[3]));
        article.setDerivedCosts(Double.parseDouble(splitInfo[4]));
        article.setProductionCosts(Double.parseDouble(splitInfo[5]));
        article.setTaxes(Double.parseDouble(splitInfo[6]));

        return article;
    }

// EJERCICIO 2.

    @Override
    public File[] listFiles(String directory) {
        File path = new File(directory);
        return path.listFiles();
    }

    public String printFileInfo(List<FileEntity> fileEntities) {
        String info = "";

        for (int i = 0; i < fileEntities.size(); i++) {
            info = "Factura: " + fileEntities.get(i).getInvoiceName() + "\n" +
                    "Número de artículos: " + fileEntities.get(i).getArticleNumbers() + "\n" +
                    "Beneficio Total: " + fileEntities.get(i).getTotalProfit() + "\n" +
                    "Ruta de fichero: " + fileEntities.get(i).getFilePath() + "\n" +
                    "Nombre del fichero: " + fileEntities.get(i).getFileName() + "\n" +
                    "Tamaño del fichero: " + fileEntities.get(i).getFileSize() + "\n" +
                    "==================================" + "\n";

        }
        return info;
    }

    public FileEntity setFileInfo() {
        FileEntity fileEntity = new FileEntity();

        fileEntity.setInvoiceName();
        fileEntity.setArticleNumbers();
        fileEntity.setTotalProfit();
        fileEntity.setFilePath();
        fileEntity.setFileName();
        fileEntity.setFileSize();



        return fileEntity;
    }
}
