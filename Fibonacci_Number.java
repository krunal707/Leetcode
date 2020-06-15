class Solution {
    public int fib(int N) {
        
        //Using DP?
        
        // Recursive using Array List; 100%
        
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(0);
        list.add(1);
        
        for(int i=2; i<=N; i++){
            int temp = list.get(i-1) + list.get(i-2);
            list.add(temp);
        }
        return list.get(N);
        
        
        
        
        
        // Recursive Approach
//         if(N == 0){
//             return 0;
//         }
//         if(N == 1){
//             return 1;
//         }
        
//         return fib(N-1) + fib(N-2);
    }
}