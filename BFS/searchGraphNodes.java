/* Search Graph Nodes
Given a undirected graph, a node and a target, 
return the nearest node to given node which value of it is target,
return NULL if you can't find.
There is a mapping store the nodes' values in the given parameters.

Example
2------3  5
 \     |  | 
  \    |  |
   \   |  |
    \  |  |
      1 --4
Give a node 1, target is 50

there a hash named values which is [3,4,10,50,50], represent:
Value of node 1 is 3
Value of node 2 is 4
Value of node 3 is 10
Value of node 4 is 50
Value of node 5 is 50

Return node 4

*/

/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {  //经典的BFS, 王中王
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // Write your code here
        if(values.get(node) == target) {
            return node;
        } 
        
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        
        while(queue.size() != 0) {
            UndirectedGraphNode curr = queue.poll();
            ArrayList<UndirectedGraphNode> neighbors = curr.neighbors;
            
            for(UndirectedGraphNode neighbor : neighbors) {
                if(values.get(neighbor) == target) {
                    return neighbor;
                }
                
                queue.add(neighbor);
            }
        }
        return null;
    }
}