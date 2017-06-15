/* Top k Largest Numbers II
Implement a data structure, provide two interfaces:

add(number). Add a new number in the data structure.
topk(). Return the top k largest numbers in this data structure. k is given when we create the data structure.

Example
s = new Solution(3);
>> create a new data structure.
s.add(3)
s.add(10)
s.topk()
>> return [10, 3]
s.add(1000)
s.add(-99)
s.topk()
>> return [1000, 10, 3]
s.add(4)
s.topk()
>> return [1000, 10, 4]
s.add(100)
s.topk()
>> return [1000, 100, 10]
*/

public class Solution {
    private PriorityQueue<Integer> minHeap;
    private int maxSize = 0;
    private Comparator<Integer> comparator = new Comparator<Integer>(){
        public int compare(Integer a, Integer b) { //minheap
            if(a > b) {//minheap
                return 1;
            }else if(a < b) {//minheap
                return -1;
            }else {
                return 0;
            }
        }
    };
    public Solution(int k) {
        // initialize your data structure here.
        minHeap = new PriorityQueue(k, comparator);
        maxSize = k;
    }

    public void add(int num) {
        // Write your code here
        minHeap.add(num);
        
        if(minHeap.size() > maxSize) {
            minHeap.poll();
        }
    }

    public List<Integer> topk() {
        // Write your code here
        List<Integer> answer = new ArrayList<>();
        Iterator<Integer> it = minHeap.iterator();
        
        while(it.hasNext()) {
            answer.add(it.next());
        }
        
        Collections.sort(answer, Collections.reverseOrder());
        
        return answer;
    }
};
