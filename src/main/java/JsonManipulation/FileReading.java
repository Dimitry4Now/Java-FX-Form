package JsonManipulation;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReading {
    private final List<Review> reviews;

    public FileReading(){
        reviews = new ArrayList<>();
    }

    public void loadReviews() throws IOException {
        StringBuilder entered = new StringBuilder();
        try {
            File f = new File("C:\\Users\\dimit\\IdeaProjects\\Backend\\src\\main\\java\\JsonManipulation\\reviews.json");
            Scanner s = new Scanner(f);
            while(s.hasNextLine()){
                String data = s.nextLine();
                entered.append(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] split = entered.toString().split("}");

        String[] ret = new String[split.length - 1];
        for(int i = 0; i < split.length - 1; i++){
            ret[i] = split[i].substring(2, split[i].length() - 2);
            ret[i] += "}";
        }
        JsonNode node;
        Review r;
        for (String s : ret) {
            node = Parser.parse(s);
            r = Parser.fromJson(node, Review.class);
            reviews.add(r);
        }

    }

    public List<Review> getReviews() {
        return reviews;
    }
}
