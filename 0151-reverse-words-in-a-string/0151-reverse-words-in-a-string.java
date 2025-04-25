class Solution{
    public String reverseWords(String s){
        String[] separated = s.split(" ");
        StringBuilder str = new StringBuilder();
        for(int i =separated.length-1;i>=0;i--)
        {
            if(!separated[i].equals(""))
            {
                str.append(separated[i]).append(" ");
            }
        }
        return str.toString().trim();
    }
}