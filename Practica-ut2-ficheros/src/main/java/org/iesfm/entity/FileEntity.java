package org.iesfm.entity;

import java.util.Objects;

public class FileEntity {

    private String invoiceName;
    private float articleNumbers;
    private double totalProfit;
    private String filePath;
    private String fileName;
    private float fileSize;

    public FileEntity(String invoiceName, float articleNumbers, double totalProfit, String filePath, String fileName, float fileSize) {
        this.invoiceName = invoiceName;
        this.articleNumbers = articleNumbers;
        this.totalProfit = totalProfit;
        this.filePath = filePath;
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public FileEntity() {
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    public float getArticleNumbers() {
        return articleNumbers;
    }

    public void setArticleNumbers(float articleNumbers) {
        this.articleNumbers = articleNumbers;
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(double totalProfit) {
        this.totalProfit = totalProfit;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public float getFileSize() {
        return fileSize;
    }

    public void setFileSize(float fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileEntity that = (FileEntity) o;
        return Float.compare(that.articleNumbers, articleNumbers) == 0 && Double.compare(that.totalProfit, totalProfit) == 0 && Float.compare(that.fileSize, fileSize) == 0 && Objects.equals(invoiceName, that.invoiceName) && Objects.equals(filePath, that.filePath) && Objects.equals(fileName, that.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceName, articleNumbers, totalProfit, filePath, fileName, fileSize);
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "invoiceName='" + invoiceName + '\'' +
                ", articleNumbers=" + articleNumbers +
                ", totalProfit=" + totalProfit +
                ", filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}