package JsonManipulation;

public class Review {
    public int id;
    public String reviewId;
    public String reviewFullText;
    public String reviewText;
    public int numLikes;
    public int numComments;
    public int numShares;
    public int rating;
    public String reviewCreatedOn;
    public String reviewCreatedOnDate;
    public String reviewCreatedOnTime;
    public String reviewerId;
    public String reviewerUrl;
    public String reviewerName;
    public String reviewerEmail;
    public String sourceType;
    public boolean isVerified;
    public String source;
    public String sourceName;
    public String sourceId;
    public String[] tags;
    public String href;
    public String logoHref;
    public String[] photos;

    public String toString(){
        String s = "ID:" + id + ", " + reviewFullText + ", " + reviewCreatedOnDate;
        return s;
    }
}


