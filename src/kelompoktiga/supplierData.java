/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelompoktiga;

import java.sql.Date;



/**
 *
 * @author Dandi Ganteng
 */
public class supplierData {

    private Integer supplierId;
    private String supplierName;
    private String type;
    private String brand;
    private String productName;
    private Double price;
    private String status;
    private String image;
    private Date date; 
    
    public supplierData(Integer supplierId, String supplierName, String type, String brand, String productName, Double price,
             String status, String image, Date date){
        
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.type = type;
        this.brand = brand;
        this.productName = productName;
        this.price = price;
        this.status = status;
        this.image = image;
        this.date = date;
    }
    
    public Integer getSupplierId(){
        return supplierId;
    }
    public String getSupplierName(){
        return supplierName;
    }
    public String getType(){
        return type;
    }
    public String getBrand(){
        return brand;
    }
    public String productName(){
        return productName;
    }
    public Double getPrice(){
        return price;
    }
    public String getStatus(){
        return status;
    }
    public String getImage(){
        return image;
    }
    public Date getDate(){
        return date;
    }
    
    
}
