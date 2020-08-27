// "static void main" must be defined in a public class.
public class Diskspace {
    public int analyse(int numComputer, int[] hardDiskSpace, int segmentLength) {
        int global_max=Integer.MIN_VALUE;
        int local_min=0;
        int left=0;
        int right=0;
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i=0;i<hardDiskSpace.length;i++){
            pq.add(hardDiskSpace[i]);
            //local_min=Math.min(local_min,hardDiskSpace[i]);
            if(i-left+1==segmentLength){
                global_max=Math.max(pq.peek(),global_max);
                pq.remove(hardDiskSpace[left]);
                left++;
            }
        }
        return global_max;
    }
    public static void main(String[] args) {
        Diskspace space = new Diskspace();
        System.out.println(space.analyse(3, new int[] {8, 2, 4}, 2));
        System.out.println(space.analyse(6, new int[] {8, 2,4,3,7,6}, 2));//6
        System.out.println(space.analyse(6, new int[] {8, 2,4,3,7,6}, 3));//3
        System.out.println(space.analyse(7, new int[] {2,4,3,7,8,6,5}, 4));//5
        System.out.println(space.analyse(13, new int[] {2,4,3,7,8,6,5,16,19,33,32,34,35}, 5));
    }
}
