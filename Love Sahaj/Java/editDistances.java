import java.util.HashMap;

public class editDistances {
    private class Pair {
        int first;
        int second;

        Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }

    private HashMap<Pair, Integer> dp = new HashMap<>();

    public int minDistance(String word1, String word2) {
        return minDistance(word1, word2, 0, 0, word1.length() - 1, word2.length() - 1);
    }

    private int minDistance(String word1, String word2, int i, int j, int len1, int len2) {
        if (i == len1 || j == len2) {
            Pair x = new Pair(i, j);
            if (dp.containsKey(x))
                return dp.get(x);

            int cost = Math.max(i, j);
            dp.put(x, cost);
            return cost;
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            Pair x = new Pair(i, j);
            if (dp.containsKey(x))
                return dp.get(x);

            int cost = minDistance(word1, word2, i + 1, j + 1, len1, len2);
            dp.put(x, cost);
            return cost;
        }

        int cost = 1 + Math.min(minDistance(word1, word2, i + 1, j + 1, len1, len2), Math
                .min(minDistance(word1, word2, i, j + 1, len1, len2), minDistance(word1, word2, i + 1, j, len1, len2)));

        dp.put(new Pair(i, j), cost);
        return cost;
    }

    public static void main(String[] args) {
        editDistances sol = new editDistances();
        System.out.println(sol.minDistance("intention", "execution"));
    }
}
