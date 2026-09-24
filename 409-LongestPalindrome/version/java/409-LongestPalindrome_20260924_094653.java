// Last updated: 24/09/2026, 09:46:53
1class Solution {
2    public String[] findWords(String[] words) {
3       ArrayList<String> ans=new ArrayList<>();
4       String first = "qwertyuiop";
5       String Secound ="asdfghjkl";
6       String Third="zxcvbnm";
7       for(String i : words){
8        if(isinrow(i,first) || isinrow(i,Secound) || isinrow(i,Third))
9         ans.add(i);
10       } 
11       return ans.toArray(new String[0]);
12    }
13    private boolean isinrow(String s,String row){
14      for(char c:s.toCharArray()){
15        if(row.indexOf(Character.toLowerCase(c))==-1){
16            return false;
17        }
18      }
19      return true;
20    }
21}