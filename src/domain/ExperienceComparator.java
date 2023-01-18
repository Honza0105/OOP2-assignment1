package domain;

import java.util.Comparator;

public class ExperienceComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getExperience().compareTo(s2.getExperience());
    }
}

