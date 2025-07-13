class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        // 1. Let's get the teams sorted, FAST! ⚡
        // We use threads so the players and trainers can get organized at the same time!
        Thread t1 = new Thread(() -> Arrays.sort(players)); // Player team, get in order!
        Thread t2 = new Thread(() -> Arrays.sort(trainers)); // Trainer team, line up by skill!
        t1.start(); // Player team, GO! \U0001f3c3‍♂️
        t2.start(); // Trainer team, LET'S GO! \U0001f3cb️‍♀️
        try { 
          t1.join(); // Wait for the players to sort themselves
          t2.join(); // Wait for the trainers to sort themselves
        } catch (Exception ignored) {} // If we get interrupted, no biggie

        // 2. Okay, now that everyone's sorted, let's start matching! \U0001f91d
        int count = 0, // How many successful matches we've made
            left = 0,  // Pointer for the player team
            right = 0; // Pointer for the trainer team

        // 3. Go through each team until someone runs out of people
        while (left < players.length && right < trainers.length) {
            // If this trainer can handle the current player...
            if (trainers[right] >= players[left]) {
                count++;  // Match made! \U0001f389
                left++;   // Move to the next player
            }
            right++; // Move to the next trainer. Whether we matched or not, we're checking everyone!
        }
        return count; // And the winner is... the maximum matches we could make! \U0001f3c6
    }
}