package model;

public class Mail {
    
    public String mail;
    
    public Mail(String email){
        mail = email;
    }
    
    public String getDomains(){

        String res [];
        
        try {
            res = mail.split("[@]");
            return res[1];
        } catch (Exception e) {            
        }
        return "";
    }
    
    public String getMail(){
        return mail;
    }
    
}
