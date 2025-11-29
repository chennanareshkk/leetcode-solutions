class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stops = new int[1001];

        for(int trip[] : trips) {
            int from = trip[1];
            int to = trip[2];

            stops[from] += trip[0];
            stops[to] -= trip[0];
        }

        int passengers = 0;

        for(int i = 0; i < 1001; i++) {
            passengers += stops[i];

            if(passengers > capacity) {
                return false;
            }
        }

        return true;

    }
}
