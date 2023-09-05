package com.syscho.dsa.string;

class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
       int ans[] = new int[nums.length];
        int pre = 1, post = 1;
        
        //find pre product
        for(int i=0;i<nums.length;i++){
            ans[i] = pre;
            pre*=nums[i];
        }

        //find post product
        for(int i=nums.length-1;i>=0;i--){
            ans[i]*=post;
            post*=nums[i];
        }

        return ans;
        
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        int expected[] ={24,12,8,6};

        int[] result = productExceptSelf(nums);
        System.out.println(result);
        if(expected.equals(result)){
            System.out.println("correct");
        }else{
            System.out.println("wrong");
        }


    }
}