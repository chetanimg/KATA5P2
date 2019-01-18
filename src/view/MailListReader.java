package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import model.Mail;

public class MailListReader {
    
    public static List<Mail> read(String fileName){
        
        ArrayList<Mail> lista = new ArrayList<>();
        
        try {
            
            FileReader fichero = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fichero);
            String linea="";
            while((linea = br.readLine()) != null){
                
                if(linea.contains("@")){
                    Mail mail = new Mail(linea);
                    lista.add(mail);
                }
            }
            
            br.close();
            
        } catch (Exception e) {
            System.out.println("No puedo abrir el fichero " + fileName);
        }
        
        return lista;
    }
    
}