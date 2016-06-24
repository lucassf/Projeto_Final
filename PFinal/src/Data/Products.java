package Data;
import java.sql.Date;

public class Products {
    private String id="";
    private int qtd=0;
    private String name="";
    private String categoryid = "";
    private String dif="";
    private String buyprice="";
    private String price="";
    private String date="";
    private String sender="";
    private String manufacturer="";

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDif() {
        return dif;
    }

    public void setDif(String dif) {
        this.dif = dif.replace(',', '.');
    }

    public String getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(String buyprice) {
        this.buyprice = buyprice.replace(',', '.');
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price.replace(',', '.');
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String produccer) {
        this.manufacturer = produccer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

}