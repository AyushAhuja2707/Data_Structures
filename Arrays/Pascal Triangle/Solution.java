import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        // Loop to generate each row of Pascal's Triangle
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // First element of each row is always 1

            // Generate elements in the middle of the row
            for (int j = 1; j < i; j++) {
                List<Integer> prevRow = list.get(i - 1); // Previous row
                int value = prevRow.get(j - 1) + prevRow.get(j); // Sum of two elements above
                row.add(value);
            }

            // Last element of each row is 1 (if not the first row)
            if (i > 0) {
                row.add(1);
            }

            // Add the row to the triangle
            list.add(row);
        }

        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numRows = 10; // Number of rows for Pascal's Triangle
        List<List<Integer>> result = solution.generate(numRows);

        // Print the result
        System.out.println("Pascal's Triangle with " + numRows + " rows:");
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}
