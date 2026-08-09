// Problem: Insert Delete GetRandom O(1)
// LeetCode: https://leetcode.com/problems/insert-delete-getrandom-o1/

// Goal:
// Design a data structure that supports insert, remove, and getRandom in average O(1).

// Example:
// ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
// [[], [1], [2], [2], [], [1], [2], []]

// -------------------------------------------------------------

// Brute Force Approach:
// - Use ArrayList only.
// - Insert: O(1), Remove: O(n) (shift), getRandom: O(1).
// Time Complexity: O(n) for remove.
// Space Complexity: O(n)

// Better Approach (HashSet + ArrayList):
// - HashSet for membership check.
// - ArrayList for random access.
// - Remove still O(n) because shifting.
// Time Complexity: O(n) for remove.
// Space Complexity: O(n)

// Optimal Approach (HashMap + ArrayList):
// - ArrayList stores elements.
// - HashMap stores element → index.
// - Remove: swap with last element, update map, pop last.
// - Insert: add to end, update map.
// - getRandom: pick random index.
// Time Complexity: O(1) average for all ops.
// Space Complexity: O(n)

class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random rand;

    // Constructor
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    // Brute Force (ArrayList only)
    public boolean bruteInsert(int val) {
        if (list.contains(val)) return false;
        list.add(val);
        return true;
    }
    public boolean bruteRemove(int val) {
        return list.remove((Integer) val); // O(n)
    }
    public int bruteGetRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    // Optimal Approach
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        int last = list.get(list.size() - 1);

        // Swap with last element
        list.set(index, last);
        map.put(last, index);

        // Remove last
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
