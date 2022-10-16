package org.iesfm.dao;

import org.iesfm.entity.FileEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDAOImpl implements FileDAO {


    @Override
    public void readTextInFile(File file, String text) {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader br = new BufferedReader(fileReader)) {
            String line;
            System.out.printf("Lectura del fichero %s: \n", file.getName());
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
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
    public void insertArticleInfo(FileEntity fileEntity) {
        System.out.println("Articulo: " + fileEntity.getArticle());
        System.out.println("Tipo: " + fileEntity.getType());
        System.out.println("Precio de Venta: " + fileEntity.getSellPrice());
        double cost = fileEntity.getDerivedCosts() + fileEntity.getProductionCosts() + fileEntity.getTaxes();
        System.out.println("Coste: " + cost);
        double benefits = fileEntity.getSellPrice() - cost;
        System.out.println("Beneficio" + benefits);
        for (int i = 0; i < 25; i++) {
            System.out.printf("=");
        }
    }

    @Override
    public String[] separaPorComponentes(File file) {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader br = new BufferedReader(fileReader)){
            String[] line;
            String separaline = line.split(";");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
