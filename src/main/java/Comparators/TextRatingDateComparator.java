package Comparators;

import JsonManipulation.Review;

import java.util.Comparator;

public class TextRatingDateComparator implements Comparator<Review> {
    private final DatesComparator dc = new DatesComparator();
    @Override
    public int compare(Review o1, Review o2) {
        if((!(o1.reviewText.equals("")) && !(o2.reviewText.equals(""))) || ((o1.reviewText.equals("")) && (o2.reviewText.equals("")))){
            if(o1.rating == o2.rating){
                return dc.compare(o2, o1);
            }
            if(o1.rating > o2.rating){
                return -1;
            }
            return 1;
        }
        else if(!o1.reviewText.equals("")){
            return -1;
        }
        return 1;
    }
}
