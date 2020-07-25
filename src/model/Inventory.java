package model;

public class Inventory {
    
    private String nameOfProduct;
    private String use;
    private String typeOfProduct;
    private int quantity;

    public Inventory () {
        this.nameOfProduct = "";
        this.use = "";
        this.typeOfProduct = "";
        this.quantity = 0;
    }
    
    public Inventory(String nameOfProduct, String use, String typeOfProduct) {
        this.nameOfProduct = nameOfProduct;
        this.use = use;
        this.typeOfProduct = typeOfProduct;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
