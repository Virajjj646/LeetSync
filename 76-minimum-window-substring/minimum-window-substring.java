class Solution {
    public String minWindow(String s, String t) {
        if(s==null||t==null||s.length()<t.length()||t.isEmpty()) return "";
        int[] need = new int[128];
        for(char c : t.toCharArray()) need[c]++;
        int required = t.length();
        int l=0,bestLen = Integer.MAX_VALUE,bestStart=0;
        for(int r = 0; r < s.length() ; r++ ){
            if(need[s.charAt(r)]-->0) required--;
            while(required==0){
                if(bestLen>r-l+1){
                    bestLen = r-l+1;
                    bestStart = l;
                }
                if(need[s.charAt(l)]++ == 0)required++;
                l++;
            }
        }
        return bestLen == Integer.MAX_VALUE? "" : s.substring(bestStart,bestStart+bestLen);
    }
}