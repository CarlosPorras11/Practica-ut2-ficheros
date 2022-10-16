package org.iesfm.service;

import org.iesfm.dao.FileDAO;
import org.iesfm.dao.FileDAOImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileService {

    FileDAO fileDAO = new FileDAOImpl();

    public void insertArticlesInFile(String pathFile) {
//        try (Scanner sc = new Scanner(System.in)) {
//            System.out.println("Escribe el nombre para el fichero: ");
//            String fileName = sc.nextLine();
//            File file = new File(pathFile + fileName + ".txt");
//            if (file.createNewFile()) {
//
//            } else {
//                System.out.println("No se ha creado el fichero");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
