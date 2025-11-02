public class approach3 {
    public ArrayList<Integer> findMajority(int[] arr) {
      
    int can1 = -1, can2 = -1, cnt1=0, cnt2=0;
    int majority = arr.length/3;
    ArrayList<Integer> sol = new ArrayList<>();

    for(int i=0; i<arr.length;i++){
        if(arr[i]==can1){
            cnt1 += 1;
        }
        else if(arr[i]==can2){
            cnt2 += 1;
        }
        else if(cnt1 == 0){
            can1 = arr[i];
            cnt1 = 1;
        }
        else if(cnt2 == 0){
            can2 = arr[i];
        }
        else{
            cnt1 -= 1;
            cnt2 -= 1;
        }
    }

    cnt1 =0;
    cnt2 = 0;

    for(int j=0; j<arr.length;j++){
        if(arr[j]==can1){
            cnt1+=1;
        }else if(arr[j] == can2 && can1 != can2){
            cnt2 += 1;
        }
    }
    
    if(cnt1>majority){
        sol.add(can1);
    }
    if(cnt2>majority){
        sol.add(can2);
    }
    
    Collections.sort(sol);
    return sol;
    }

    public static void main(String[] args) {
        approach3 obj = new approach3();
        int[] arr = {1, 2, 3, 1, 2, 1, 1};
        ArrayList<Integer> result = obj.findMajority(arr);
        System.out.println(result);
    }
}