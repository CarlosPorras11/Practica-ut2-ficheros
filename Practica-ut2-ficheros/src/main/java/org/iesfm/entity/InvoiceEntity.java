package org.iesfm.entity;

public class InvoiceEntity {
    private String article;
    private String type;
    private String sellDate;
    private double sellPrice;
    private double derivedCosts;
    private double productionCosts;
    private double taxes;
    private double profit;

    public InvoiceEntity(String article, String type, String sellDate, double sellPrice, double derivedCosts, double productionCosts, double taxes, double profit) {
        this.article = article;
        this.type = type;
        this.sellDate = sellDate;
        this.sellPrice = sellPrice;
        this.derivedCosts = derivedCosts;
        this.productionCosts = productionCosts;
        this.taxes = taxes;
        this.profit = profit;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSellDate() {
        return sellDate;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getDerivedCosts() {
        return derivedCosts;
    }

    public void setDerivedCosts(double derivedCosts) {
        this.derivedCosts = derivedCosts;
    }

    public double getProductionCosts() {
        return productionCosts;
    }

    public void setProductionCosts(double productionCosts) {
        this.productionCosts = productionCosts;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
