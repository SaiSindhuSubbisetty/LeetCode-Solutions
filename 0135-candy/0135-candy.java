class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length; // Get the number of kids in the line \U0001f9d1‍\U0001f9d1‍\U0001f467‍\U0001f466
        int[] candy = new int[n]; // Create an array to store the number of candies each kid will get \U0001f36c
        Arrays.fill(candy, 1); // Give each kid at least one candy to start with. Everyone's happy! \U0001f60a

        // First pass: From left to right ➡️
        for (int i = 1; i < n; i++) { // Start from the second kid (index 1)
            if (ratings[i] > ratings[i - 1]) { // If this kid is better behaved than the kid to their left... \U0001f914
                candy[i] = candy[i - 1] + 1; // ...give them one more candy than the kid on their left! \U0001f973
            }
        }

        // Second pass: From right to left ⬅️
        for (int i = n - 2; i >= 0; i--) { // Start from the second to last kid
            if (ratings[i] > ratings[i + 1]) { // If this kid is better behaved than the kid to their right... \U0001f914
                candy[i] = Math.max(candy[i], candy[i + 1] + 1); // ...make sure they have at least one more candy than the kid on their right.
                                                                 // Use Math.max to ensure we don't decrease the number of candies if they already have enough! \U0001f4aa
            }
        }

        // Calculate the total number of candies needed ➕
        int totalCandies = 0;
        for (int c : candy) { // Go through each kid's candy count
            totalCandies += c; // Add it to the total
        }

        return totalCandies; // Return the total number of candies we need! \U0001f381
    }
}