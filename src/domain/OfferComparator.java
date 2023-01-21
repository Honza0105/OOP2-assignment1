package domain;

import java.util.Comparator;

public class OfferComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s2.getOffer().compareTo(s1.getOffer());
    }
}
