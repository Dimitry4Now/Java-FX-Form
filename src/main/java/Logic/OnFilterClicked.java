package Logic;

import Comparators.*;
import JsonManipulation.FileReading;
import JsonManipulation.Review;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OnFilterClicked {
    private static final TextRatingDateComparator textRatingDateComparator = new TextRatingDateComparator();
    private static final NoTextRatingDateComparator noTextRatingDateComparator = new NoTextRatingDateComparator();
    private static final NoTextRatingReversedDateComparator noTextRatingReversedDateComparator = new NoTextRatingReversedDateComparator();
    private static final TextRatingReversedDateComparator textRatingReversedDateComparator = new TextRatingReversedDateComparator();
    private static final TextReversedRatingDateComparator textReversedRatingDateComparator = new TextReversedRatingDateComparator();
    private static final NoTextReversedRatingDateComparator noTextReversedRatingDateComparator = new NoTextReversedRatingDateComparator();
    private static final TextReversedRatingReversedDateComparator textReversedRatingReversedDateComparator = new TextReversedRatingReversedDateComparator();
    private static final NoTextReversedRatingReversedDateComparator noTextReversedRatingReversedDateComparator = new NoTextReversedRatingReversedDateComparator();
    public static List<Review> updateReviewsFrame(JComboBox<String> rating, JComboBox<String> minimum,
                                          JComboBox<String> date, JComboBox<String> text) throws IOException {


        FileReading fr = new FileReading();
        fr.loadReviews();
        List<Review> reviews = fr.getReviews();

        List<Review> pom;

        int lessThan = Integer.parseInt((String) Objects.requireNonNull(minimum.getSelectedItem()));
        pom = filterRating(lessThan, reviews);

        if((rating.getSelectedIndex() == 0) && (date.getSelectedIndex() == 0) && (text.getSelectedIndex() == 0)){
            pom = pom.stream().sorted(textRatingDateComparator).collect(Collectors.toList());
        }
        if((rating.getSelectedIndex() == 0) && (date.getSelectedIndex() == 0) && (text.getSelectedIndex() == 1)){
            pom = pom.stream().sorted(noTextRatingDateComparator).collect(Collectors.toList());
        }
        if((rating.getSelectedIndex() == 0) && (date.getSelectedIndex() == 1) && (text.getSelectedIndex() == 0)){
            pom = pom.stream().sorted(textRatingReversedDateComparator).collect(Collectors.toList());
        }
        if((rating.getSelectedIndex() == 0) && (date.getSelectedIndex() == 1) && (text.getSelectedIndex() == 1)){
            pom = pom.stream().sorted(noTextRatingReversedDateComparator).collect(Collectors.toList());
        }
        if((rating.getSelectedIndex() == 1) && (date.getSelectedIndex() == 0) && (text.getSelectedIndex() == 0)){
            pom = pom.stream().sorted(textReversedRatingDateComparator).collect(Collectors.toList());
        }
        if((rating.getSelectedIndex() == 1) && (date.getSelectedIndex() == 0) && (text.getSelectedIndex() == 1)){
            pom = pom.stream().sorted(noTextReversedRatingDateComparator).collect(Collectors.toList());
        }
        if((rating.getSelectedIndex() == 1) && (date.getSelectedIndex() == 1) && (text.getSelectedIndex() == 0)){
            pom = pom.stream().sorted(textReversedRatingReversedDateComparator).collect(Collectors.toList());
        }
        if((rating.getSelectedIndex() == 1) && (date.getSelectedIndex() == 1) && (text.getSelectedIndex() == 1)){
            pom = pom.stream().sorted(noTextReversedRatingReversedDateComparator).collect(Collectors.toList());
        }
        return pom;
    }

    public static List<Review> filterRating(int i, List<Review> reviews){
        return reviews.stream().filter(item -> (item.rating >= i)).collect(Collectors.toList());
    }
}
