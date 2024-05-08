class MaxPair {
    public int maxSum(int[] nums) {
        HashMap<Integer,List<Integer>> temp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int a = nums[i];
            int max = Integer.MIN_VALUE;
            while(a > 0){
                int b = a%10;
                if(b > max){
                    max = b;
                }
                a /= 10;
            }
            List<Integer> list1 = new ArrayList<>();
            if(temp.containsKey(max)){
                list1 = temp.get(max);
            }
            list1.add(nums[i]);
            temp.put(max, list1);
        }

        int out = -1;
        int maxKey = Integer.MIN_VALUE;
        List<Integer> keys = new ArrayList<>();

        for(int key : temp.keySet()){
            keys.add(key);
        }
        Collections.sort(keys);

        int size = keys.size();
        int j  = size-1;
        int sum = -1;

        while(j>=0){
            List<Integer> list2 = temp.get(keys.get(j));
            Collections.sort(list2);
            int size1 = list2.size();
            if(size1 < 2){
                j--;
            }else{
                int sum1 = list2.get(size1-1)+list2.get(size1-2);
                if(sum1 > sum){
                    sum = sum1;
                }
                j--;
            }
        }
        return sum;
    }
}
