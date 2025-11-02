 public class apporach2 {
    public ArrayList<Integer> findMajority(int[] arr) {
        // Code here

    HashMap<Integer,Integer> hmap = new HashMap<>();
    ArrayList<Integer> sol = new ArrayList<>();
    int majority = arr.length/3;

    for(int i=0; i<arr.length;i++){
        if(!hmap.containsKey(arr[i])){
            hmap.put(arr[i], 1);
        }
        else{
            int val = hmap.get(arr[i]);
            val += 1;
            hmap.put(arr[i], val);
        }
    }
    
    for(Map.Entry<Integer, Integer> entry : hmap.entrySet()){
        Integer value = entry.getValue();
        if(value > majority){
            sol.add(entry.getKey());
        }
    }
    
    
    Collections.sort(sol);
    return sol;
    }

    public static void main(String[] args) {
        approach2 obj = new approach2();
        int[] arr = {1, 2, 3, 1, 2, 1, 1};
        ArrayList<Integer> result = obj.findMajority(arr);
        System.out.println(result);
    }
}