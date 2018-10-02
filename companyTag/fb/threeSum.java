import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class threeSum{

	public static List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length == 0){
			return res;
		}

		Arrays.sort(nums);

		for(int i = 0; i < nums.length; i ++){
			if(i != 0 && nums[i] == nums[i-1]){
				continue;
			}
			int lo = i+1;	// CATCH : is not 0
			int hi = nums.length -1;
			while(lo < hi){
				int sum = nums[i] + nums[lo] + nums[hi];
				if(sum == 0){
					res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[lo], nums[hi])));
					// must dedup the lo and hi, otherwise will dup answer
					while(lo < hi && nums[lo] == nums[lo+1]) lo ++;
					while(lo < hi && nums[hi] == nums[hi-1]) hi --;
					lo ++;
					hi --;
				} else if(sum > 0){
					// dedup or do not dedup are both OK, as dup will not result in wrong or dup answer
					hi --;
				} else {
					lo ++;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = {-2, -1, -1, 0, 0, 0, 2, 2};
		List<List<Integer>> res = threeSum.threeSum(nums);
		for(List<Integer> list : res){
			System.out.println(list);
		}
	}
}