package io.github.zuston.DesignPattern.Builder;

/**
 * Created by zhang_jf on 2017/7/7.
 */
public class BasicBuilder {
    public String productName;
    public String productArea;
    public Integer productPrice;

    public BasicBuilder(String name){
        this.productName = name;
    }

    public BasicBuilder setArea(String area){
        this.productArea = area;
        return this;
    }

    public BasicBuilder setPrice(Integer price){
        this.productPrice = price;
        return this;
    }

    public Product construct(){
        return new Product(this);
    }
}


class Product{
    public String productName;
    public String productArea;
    public Integer productPrice;

    public Product(BasicBuilder basicBuilder) {
        this.productName = basicBuilder.productName;
        this.productArea = basicBuilder.productArea;
        this.productPrice = basicBuilder.productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductArea() {
        return productArea;
    }

    public void setProductArea(String productArea) {
        this.productArea = productArea;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }
}


class MainBuilder{
    public static void main(String[] args) {
        Product product = new BasicBuilder("Benz").setArea("Beijing").setPrice(20000).construct();
        System.out.println(product.getProductArea());
    }
}




