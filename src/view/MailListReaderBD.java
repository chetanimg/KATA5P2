package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Mail;

public class MailListReaderBD {
    
    public static List<Mail> read(){
        
        ArrayList<Mail> lista = new ArrayList<>();
        String sql = "SELECT direccion FROM direcc_email";
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:mail.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String email = rs.getString("direccion");               
                if(email.contains("@")){
                    Mail mail = new Mail(email);
                    lista.add(mail);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
}