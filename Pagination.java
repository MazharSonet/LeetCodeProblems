package leetcode.amazon.solution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Pagination {
	static class PairInts {
	    int relevance;
	    int price;

	    public PairInts(int relevance, int price) {
	        this.relevance = relevance;
	        this.price = price;
	    }
	}

	public static List<String> fetchItemsToDisplay(int numOfItems, HashMap<String,PairInts> items, int sortParameter,
	                                               int sortOrder,int itemsPerPage, int pageNumber) {
		Comparator<String> comparator;
		if(sortOrder==0) {
			if(sortParameter==0) {
				comparator=(a,b)->a.compareTo(b);
			}
			else if(sortParameter==1) {
				comparator=(a,b)->items.get(a).relevance-items.get(b).relevance;
			}
			else {
				comparator=(a,b)->items.get(a).price-items.get(b).price;
			}
		}
		else {
			if(sortParameter==0) {
				comparator=(a,b)->b.compareTo(a);
			}
			else if(sortParameter==1) {
				comparator=(a,b)->items.get(b).relevance-items.get(a).relevance;
			}
			else {
				comparator=(a,b)->items.get(b).price-items.get(a).price;
			}
			
		}
		List<String> output= new ArrayList<>();
		PriorityQueue<String> pq= new PriorityQueue<String>(comparator);
		pq.addAll(items.keySet());
		int total_item_to_skip=itemsPerPage*(pageNumber-1);
		while(total_item_to_skip>0 && !pq.isEmpty()) {
			pq.poll();
		}
		for(int i=1;i<=itemsPerPage;i++) {
			if(pq.isEmpty()) {
				break;
			}
			output.add(pq.poll());
		}
		
		return output;

	    
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 HashMap<String,PairInts> map = new HashMap<>();
		    map.put("item1",new PairInts(10,15));
		    map.put("item2",new PairInts(3,4));
		    map.put("item3",new PairInts(17,8));
		    System.out.println(fetchItemsToDisplay(3,map,2,0,5,0));

	}

}
