class Solution {
    public boolean isValidSudoku(char[][] board) {
       int N = 9;
       HashSet<Character>[] rows = new HashSet[N];
       HashSet<Character>[] cols = new HashSet[N];
       HashSet<Character>[] boxs = new HashSet[N];

       for(int r=0;r<N;r++)
       {
         rows[r] = new HashSet<Character>();
         cols[r] = new HashSet<Character>();
         boxs[r] = new HashSet<Character>();
       }

       for(int r=0;r<N;r++)
       {
         for(int c=0;c<N;c++)
         {
            char val = board[r][c];
            if(val == '.'){
                continue;
            }
            if(rows[r].contains(val)){
                return false;
            }
            rows[r].add(val);

            if(cols[c].contains(val)){
                return false;
            }
            cols[c].add(val);

            int idx = (r/3)*3+c/3;
            if(boxs[idx].contains(val)){
                return false;
            }
            boxs[idx].add(val);
         }
       }
       return true;
    }
}