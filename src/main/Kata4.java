package main;

import view.*;

import java.util.List;
import model.Histogram;
import model.Mail;

public class Kata4 {
    
    private HistogramDisplay histoDisplay;
    private String fileName;
    private List<Mail> mailList;
    private Histogram<String> histogram;
        
    public static void main(String[] args) {
        Kata4 kata = new Kata4();
        kata.execute();    
        MailListReaderBD.read();
    }
    
    private void execute() {
        input();
        process();
        output();
    }
    
    private void input(){
        fileName = "./emails.txt";
        mailList = MailListReaderBD.read();
    }
    
    private void process(){
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    private void output(){
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}
