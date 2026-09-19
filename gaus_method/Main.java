package gaus_method;

import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    private static void show_matrix(ArrayList<ArrayList<Double>> matrix, ArrayList<Double> equals){
        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix.getFirst().size(); j++){
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.print("| ");
            System.out.print(equals.get(i) + "\n");
        }
        return;
    }

    private static double abs(double a){
        if(a < 0.0){
            return -a;
        }
        return a;
    }

    private static int get_lead_str(ArrayList<ArrayList<Double>> matrix, int col_number, int start_row){
        int lead_str = start_row;
        double max_in_col = abs(matrix.get(start_row).get(col_number));

        for(int i = start_row + 1; i < matrix.size(); i++){
            if(abs(matrix.get(i).get(col_number)) > abs(max_in_col)){
                lead_str = i;
                max_in_col = matrix.get(i).get(col_number);
            }
        }
        return lead_str;
    }

    public static int gaus(ArrayList<ArrayList<Double>> matrix, ArrayList<Double> equals, ArrayList<Double> answer){
        ArrayList<Double> temp;
        double buffer;
        double coeff;
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        int current_row = 0;
        ArrayList<Integer> lead_cols = new ArrayList<>();

        for(int col = 0; col < cols && current_row < rows; col++){
            int lead_str = get_lead_str(matrix, col, current_row);

            if(abs(matrix.get(lead_str).get(col)) < 1e-12){
                continue;
            }

            if(lead_str != current_row){
                temp = matrix.get(current_row);
                matrix.set(current_row, matrix.get(lead_str));
                matrix.set(lead_str, temp);
                buffer = equals.get(current_row);
                equals.set(current_row, equals.get(lead_str));
                equals.set(lead_str, buffer);
            }

            lead_cols.add(col);

            for(int j = current_row + 1; j < rows; j++){
                coeff = matrix.get(j).get(col) / matrix.get(current_row).get(col);
                if(coeff == 0.0) continue;
                for(int k = col; k < cols; k++){
                    matrix.get(j).set(k,
                            matrix.get(j).get(k) - coeff * matrix.get(current_row).get(k));
                }
                equals.set(j, equals.get(j) - coeff * equals.get(current_row));
            }

            current_row++;
        }

        show_matrix(matrix, equals);

        for(int i = current_row; i < rows; i++){
            if(abs(equals.get(i)) > 1e-9){
                return -1;
            }
        }

        for(int i = 0; i < cols; i++) answer.add(0.0);

        for(int i = lead_cols.size() - 1; i >= 0; i--){
            int row = i;
            int col = lead_cols.get(i);
            double sum = equals.get(row);

            for(int j = col + 1; j < cols; j++){
                sum -= matrix.get(row).get(j) * answer.get(j);
            }
            answer.set(col, sum / matrix.get(row).get(col));
        }

        return 0;
    }

    public static void main(String[] args){
        int rows = 3;
        int cols = 3;
        Random random = new Random();
        ArrayList<ArrayList<Double>> matrix = new ArrayList<>();
        ArrayList<Double> equals = new ArrayList<>();
        ArrayList<Double> answer = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            ArrayList<Double> row = new ArrayList<>(cols);
            for (int j = 0; j < cols; j++) {
                row.add(random.nextDouble(10));
            }
            matrix.add(row);
        }

        for(int i = 0; i < rows; i++){
            equals.add(random.nextDouble(10));
        }

        show_matrix(matrix, equals);
        System.out.println();
        if(gaus(matrix, equals, answer) != 0){
            System.out.print("Система несовместна");
            return;
        }
        System.out.println("\n Решение:");
        for(int i = 0; i < answer.size(); i++){
            System.out.println("x" + (i + 1) + " = " + answer.get(i));
        }
    }
}
