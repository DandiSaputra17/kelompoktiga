/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelompoktiga;

import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class customersData {

    private Integer id;
    private Integer customerID;
    private Double total;
    private Date date;
    private String emUsername;

    public customersData(Integer id, Integer customerID, Double total, Date date, String emUsername) {
        this.id = id;
        this.customerID = customerID;
        this.total = total;
        this.date = date;
        this.emUsername = emUsername;
    }

    public Integer geId() {
        return id;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public Double getTotal() {
        return total;
    }

    public Date getDate() {
        return date;
    }

    public String getEmUsername() {
        return emUsername;
    }
}
