class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
        sort(meetings.begin(), meetings.end());
        vector<int> count(n, 0);
        priority_queue<int, vector<int>, greater<int>> freeRoom;
        for (int i = 0; i < n; i++){
            freeRoom.push(i);
        }
        priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> used;
        for (auto& m : meetings){
            long long start = m[0], end = m[1];
            while (!used.empty() && used.top().first <= start){
                int room = used.top().second;
                used.pop();
                freeRoom.push(room);
            }
            long long dur = end - start;
            int room;
            long long begin;
            if (!freeRoom.empty()){
                room = freeRoom.top();
                freeRoom.pop();
                begin = start;
            } else {
                auto [delay, room2] = used.top();
                used.pop();
                room = room2;
                begin = delay;
            }
            count[room]++;
            used.push({begin + dur, room});
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            if (count[i] > count[ans]){
                ans = i;
            }
        }
        return ans;
    }
};