package laba_4_5.comparator_classes;

import laba_4_5.Schooler;

import java.util.Comparator;

public class Learning_rate_then_school_number_comparator implements Comparator<Schooler> {
    @Override
    public int compare(Schooler man_1 , Schooler man_2) {
        Integer x1 = man_1.get_learning_rate();
        Integer x2 = man_2.get_learning_rate();
        int cmp = x1.compareTo(x2);
        if (cmp != 0) {
            return cmp;
        }
        x1 = man_1.get_school_number();
        x2 = man_2.get_school_number();
        return x1.compareTo(x2);
    }
}
