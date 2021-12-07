// Substrings That Begin and End With the Same Letter

class Solution {
    public long numberOfSubstrings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        HashMap<Character, List<Integer>> map = new HashMap<>();
        long result = 0;
        for(int i = 0 ; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),new ArrayList<>());
                map.get(s.charAt(i)).add(i);
                result++;
            } else {
                map.get(s.charAt(i)).add(i);
                result += map.get(s.charAt(i)).size();
            }
        }
        return result;
    }
}


// Count Nice Pairs in an Array

class Solution {
    int[] rev;
    public int countNicePairs(int[] nums) {
        if(nums == null) {
            return 0;
        }
        rev = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++) {
            rev[i] = reverse(nums[i]);
        }
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++) {
            int diff = nums[i] - rev[i];
            if(!map.containsKey(diff)) {
                map.put(diff , 1);
            } else {
                result += map.get(diff);
                result = (int) (result % (Math.pow(10,9) + 7));
                map.put(diff,(map.get(diff) + 1));
                
            }
        }
        
        
        return result;

    }
    
    public int reverse(int num) {
        int result = 0;
        int p = 1;
        while(num > 0) {
            int temp = num % 10 ;
            result = result * 10 + temp;
            num = num / 10;
        }
        return result;
    }
}