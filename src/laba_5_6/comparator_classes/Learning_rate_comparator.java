package laba_5_6.comparator_classes;

import laba_5_6.Learner;

import java.util.Comparator;

public class Learning_rate_comparator implements Comparator<Learner> {
    @Override
    public int compare(Learner man_1, Learner man_2){
        if(man_1.get_learning_rate() > man_2.get_learning_rate()){
            return 1;
        }
        if(man_1.get_learning_rate() == man_2.get_learning_rate()){
            return 0;
        }
        return -1;
    }
}
