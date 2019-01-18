package view;

import java.util.List;
import model.Histogram;
import model.Mail;

public class MailHistogramBuilder {
    
    public static Histogram<String> build(List<Mail> lista){
        
        Histogram<String> histogram = new Histogram<>();
        
        for (Mail mail : lista) {
            String domain = mail.getDomains();
            if(!domain.equals("")) histogram.increment(domain);
        }
        
        return histogram;
    }
    
}
