package laba_5_6;

import java.util.Map;

public interface Schooler_interface {
    int get_school_number();
    Map<String, Integer> get_marks();
    Map<String, Integer> get_olympiads();
    Boolean deserve_bonus();
}
