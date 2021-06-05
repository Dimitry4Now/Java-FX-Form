package GUI;

import JsonManipulation.FileReading;
import JsonManipulation.Review;
import Logic.OnFilterClicked;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class GUI implements ActionListener {
    private final JFrame frame;
    private final JFrame frame2;
    private final JPanel panel;
    private final JPanel panel2;
    private final String[] Rating = {"Highest First", "Lowest First"};
    private final String[] Minimum = {"5", "4", "3", "2", "1"};
    private final String[] Date = {"Newest First", "Oldest First"};
    private final String[] Text = {"Yes", "No"};

    public GUI(){
        frame = new JFrame();
        frame2 = new JFrame();
        panel = new JPanel();
        panel2 = new JPanel();
    }

    public void init() throws IOException {

        JComboBox<String> text = new JComboBox<>(Text);
        text.setSelectedIndex(0);
        JComboBox<String> rating = new JComboBox<>(Rating);
        rating.setSelectedIndex(0);
        JComboBox<String> date = new JComboBox<>(Date);
        date.setSelectedIndex(0);
        JComboBox<String> minimum = new JComboBox<>(Minimum);
        minimum.setSelectedIndex(3);

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(13,1));

        Label blank = new Label("");
        Label blank2 = new Label("");
        Label blank3 = new Label("");
        Label blank4 = new Label("");
        Label l1 = new Label("Order by rating : ");
        Label l2 = new Label("Minimum rating : ");
        Label l3 = new Label("Order by date : ");
        Label l4 = new Label("Prioritize by text : ");
        l1.setFont(new Font("Verdana", Font.BOLD, 18));
        l2.setFont(new Font("Verdana", Font.BOLD, 18));
        l3.setFont(new Font("Verdana", Font.BOLD, 18));
        l4.setFont(new Font("Verdana", Font.BOLD, 18));

        panel.add(l1);
        panel.add(rating);
        panel.add(blank);
        panel.add(l2);
        panel.add(minimum);
        panel.add(blank2);
        panel.add(l3);
        panel.add(date);
        panel.add(blank3);
        panel.add(l4);
        panel.add(text);
        panel.add(blank4);

        JButton filter = new JButton("Filter");
        Dimension buttonD = new Dimension(30, 20);
        filter.setPreferredSize(buttonD);
        filter.addActionListener(this);

        panel.add(filter);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Dimension dimension = new Dimension(400, 500);
        frame.setPreferredSize(dimension);
        frame.setTitle("Filter reviews");
        frame.pack();
        frame.setVisible(true);

        FileReading fr = new FileReading();
        fr.loadReviews();
        List<Review> reviews = fr.getReviews();

        showListToScreen(reviews);
    }

    public void showListToScreen(List<Review> reviewList){
        panel2.removeAll();
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel2.setLayout(new GridLayout(21,1));
        Label l;
        for (Review r:reviewList) {
            l = new Label(r.toString());
            l.setFont(new Font("Verdana", Font.BOLD, 15));
            panel2.add(l);
        }

        showListFrame(panel2);

    }

    public void showListFrame(JPanel panel){
        Dimension dimension2 = new Dimension(450, 800);
        frame2.add(panel, BorderLayout.CENTER);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.setPreferredSize(dimension2);
        frame2.setLocation(410, 0);
        frame2.setTitle("List of reviews");
        frame2.pack();
        frame2.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        GUI gui = new GUI();
        gui.init();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JComboBox<String> rating = (JComboBox<String>) panel.getComponents()[1];
            JComboBox<String> minimum = (JComboBox<String>) panel.getComponents()[4];
            JComboBox<String> date = (JComboBox<String>) panel.getComponents()[7];
            JComboBox<String> text = (JComboBox<String>) panel.getComponents()[10];
            List<Review> go = OnFilterClicked.updateReviewsFrame(rating, minimum, date, text);
            showListToScreen(go);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

