// Last updated: 14/07/2026, 16:12:45
class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] S=stamp.toCharArray();
        char[] T=target.toCharArray();
        int m=S.length, n=T.length;
        boolean[] visited=new boolean[n];
        List<Integer> ans=new ArrayList<>();
        int stars=0;
        while(stars<n){
            boolean replaced=false;
            for(int i=0;i<=n-m;i++){
                if(!visited[i] && canReplace(T,i,S)){
                    stars+=doReplace(T,i,m);
                    visited[i]=true;
                    replaced=true;
                    ans.add(i);
                    if(stars==n)break;
                }
            }
            if(!replaced)return new int[0];
        }
        Collections.reverse(ans);
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
    public boolean canReplace(char[] target,int pos,char[] stamp){
        boolean hasRealChar=false;
        for(int i=0;i<stamp.length;i++){
            if(target[pos+i]=='*')continue;
            if(target[pos+i]!=stamp[i])return false;
            hasRealChar=true;
        }
        return hasRealChar;
    }
    public int doReplace(char[] target,int pos,int len){
        int replacedCount=0;
        for(int i=0;i<len;i++){
            if(target[pos+i]!='*'){
                target[pos+i]='*';
                replacedCount++;
            }
        }
        return replacedCount;
    }
}