package laba_5_6.comparator_classes;

import laba_5_6.Learner;

import java.util.Comparator;

public class Second_name_comparator implements Comparator<Learner> {
    @Override
    public int compare(Learner man_1, Learner man_2){
        return man_1.get_second_name().compareTo(man_2.get_second_name());
    }
}
