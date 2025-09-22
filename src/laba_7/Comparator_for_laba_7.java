package laba_7;

public class Comparator_for_laba_7 {
    public int string_length_compare(String s1, String s2){
        if(s1.length() > s2.length()){
            return 1;
        }
        if(s1.length() < s2.length()){
            return -1;
        }
        return 0;
    }
}
