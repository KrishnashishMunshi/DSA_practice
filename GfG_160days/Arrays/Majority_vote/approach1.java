public class approach1 {
    public ArrayList<Integer> findMajority(int[] arr) {
       
        ArrayList<Integer> sol = new ArrayList<Integer>();

        int maj = arr.length / 3;
        int cnt = 0;

        for(int i=0; i<arr.length;i++){
            cnt= 0;
            for(int j =0; j<arr.length;j++ ){
                if(arr[i] == arr[j]){
                    cnt+=1;
                }
            }
            if(cnt>maj && !sol.contains(arr[i])){
                sol.add(arr[i]);
            }
        }

        Collections.sort(sol);
        return sol;
    }

    public static void main(String[] args) {
        approach1 obj = new approach1();
        int[] arr = {1, 2, 3, 1, 2, 1, 1};
        ArrayList<Integer> result = obj.findMajority(arr);
        System.out.println(result);
    }
}