class Solution {
    public int[][] highFive(int[][] items) {
        // Array to store min-heaps for each student ID (IDs range from 1 to 100)
        PriorityQueue<Integer>[] studentScores = new PriorityQueue[101];
        int uniqueStudents = 0;
        final int TOP_SCORES_COUNT = 5;

        // Process each score entry
        for (int[] item : items) {
            int studentId = item[0];
            int score = item[1];

            // Initialize min-heap for new student
            if (studentScores[studentId] == null) {
                uniqueStudents++;
                studentScores[studentId] = new PriorityQueue<>(TOP_SCORES_COUNT);
            }

            // Add score to student's min-heap
            studentScores[studentId].offer(score);

            // Keep only top 5 scores by removing the smallest when size exceeds 5
            if (studentScores[studentId].size() > TOP_SCORES_COUNT) {
                studentScores[studentId].poll();
            }
        }

        // Create result array with size equal to number of unique students
        int[][] result = new int[uniqueStudents][2];
        int resultIndex = 0;

        // Calculate average of top 5 scores for each student
        for (int studentId = 0; studentId < 101; studentId++) {
            if (studentScores[studentId] == null) {
                continue;
            }

            // Calculate average of the top 5 scores
            int average = calculateSum(studentScores[studentId]) / TOP_SCORES_COUNT;

            // Store student ID and average in result
            result[resultIndex][0] = studentId;
            result[resultIndex][1] = average;
            resultIndex++;
        }

        return result;
    }

    private int calculateSum(PriorityQueue<Integer> queue) {
        int sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll();
        }
        return sum;
    }
}
