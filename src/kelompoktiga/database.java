/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelompoktiga;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Lenovo
 */
public class database {

    public static Connection connectDB() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/kelompoktiga", "root", ""); // Link database
            return connect;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
