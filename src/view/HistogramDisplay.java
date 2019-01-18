package view;

import java.awt.Dimension;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JPanel;
import model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{
    
    Histogram<String> histogram;
    
    public HistogramDisplay(Histogram<String> histo){
        super("Histogram");
        histogram = histo;
        setContentPane(CreatePanel());
        pack(); 

    }
    
    public JPanel CreatePanel(){
        ChartPanel chartPanel = new ChartPanel(CreateChart(CreateDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    
    public JFreeChart CreateChart(DefaultCategoryDataset dataSet){
        return ChartFactory.createBarChart("Histograma", "Dominios email", "Nº de emails", dataSet, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
    }
    
    public DefaultCategoryDataset CreateDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        Set<String> set = histogram.keySet();
        for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            dataSet.addValue(histogram.get(next), "", next);
        }   
        return dataSet;
    }
    
    public void execute(){
        this.setVisible(true);
    }
}
