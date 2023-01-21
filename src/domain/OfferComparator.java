package domain;

import java.util.Comparator;

public class OfferComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        int compareOffer = s2.getOffer().compareTo(s1.getOffer());
        if (compareOffer == 0) {
            return s2.getExperience().compareTo(s1.getExperience());
        }
        return compareOffer;
    }
}
