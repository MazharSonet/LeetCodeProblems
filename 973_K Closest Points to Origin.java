class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        Arrays.sort(points,(a,b)->{
            double origin_dist_a= Math.sqrt(a[0]*a[0]+a[1]*a[1]);
            double origin_dist_b= Math.sqrt(b[0]*b[0]+b[1]*b[1]);
            if(origin_dist_a<origin_dist_b){
                return -1;
            }
            else{
                return 1;
            }
        });
        //return points;
        int[][] result =new int[K][2];
        for(int i=0;i<K;i++){
            result[i][0]=points[i][0];
             result[i][1]=points[i][1];
            
        }
        return result;
    }
}
