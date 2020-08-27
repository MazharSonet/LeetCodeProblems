class Solution {

    public List<Integer> partitionLabels(String S) {
        int[] last= new int[26];
        List<Integer> par_size=new ArrayList<Integer>();
        
        for(int i=0;i<S.length();i++){
            last[S.charAt(i)-'a']= i;
        }
        //sliding window
        //left boundary -> start
        //right boundary ->end
        int start=0;
        int j=0;
        for(int i=0;i<S.length();i++){
            j=Math.max(j,last[S.charAt(i)-'a']);
            if(i==j){
                par_size.add(j-start+1);
                start=i+1;
            }
        }
        
        return par_size;
    }
}
