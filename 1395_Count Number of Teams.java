class Solution {
    public int numTeams(int[] rating) {
        int count=0;
        int len=rating.length;
        
        for(int j=0;j<len;j++){
            int leftSmaller=0,rightLarger=0,leftLarger=0,rightSmaller=0;
            for(int i=0;i<j;i++){
                if(rating[i]<rating[j]){
                    leftSmaller++;
                }
                else if(rating[i]>rating[j]){
                    leftLarger++;
                }
            }
            for(int k=j+1;k<len;k++){
                if(rating[j]>rating[k]){
                    rightSmaller++;
                }
                else if(rating[j]<rating[k]){
                    rightLarger++;
                }
            }
            count+=leftSmaller*rightLarger+leftLarger*rightSmaller;
        }
        return count;
    }
}
