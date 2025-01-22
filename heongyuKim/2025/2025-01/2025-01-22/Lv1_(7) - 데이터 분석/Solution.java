import java.util.*;

class Solution {

    static ArrayList<int[]> result = new ArrayList<>();

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        int[][] answer = {};

        switch (ext) {
            case "code":
                inputData(data, 0, val_ext);
                break;
            case "date":
                inputData(data, 1, val_ext);
                break;
            case "maximum":
                inputData(data, 2, val_ext);
                break;
            case "remain":
                inputData(data, 3, val_ext);
                break;
        }

        switch (sort_by) {
            case "code":
                sortList(0);
                break;
            case "date":
                sortList(1);
                break;
            case "maximum":
                sortList(2);
                break;
            case "remain":
                sortList(3);
                break;
        }

        answer = result.toArray(new int[result.size()][]);


        return answer;
    }

    static void inputData(int[][] data, int subjectNum, int val_ext) {
        for (int[] datum : data) {
            if (datum[subjectNum] < val_ext) {
                result.add(datum);
            }
        }
    }

    static void sortList(int subjectNum) {
        result.sort((a, b) -> Integer.compare(a[subjectNum], b[subjectNum]));
    }
}