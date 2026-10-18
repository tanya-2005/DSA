/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                parentMap.put(curr.left, curr);
                q.add(curr.left);
            }
            if(curr.right != null){
                parentMap.put(curr.right, curr);
                q.add(curr.right);
            }
        }

        Queue <TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode>visited = new HashSet<>();

        queue.add(target);
        visited.add(target);

        int distance = 0;

        while(!queue.isEmpty() && distance < k){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null && !visited.contains(curr.left)){
                    visited.add(curr.left);
                    queue.add(curr.left);
                }
                if(curr.right != null && !visited.contains(curr.right)){
                    visited.add(curr.right);
                    queue.add(curr.right);
                }
                TreeNode parent = parentMap.get(curr);
                if(parent != null && !visited.contains(parent)){
                visited.add(parent);
                queue.add(parent);
                }
            }
            
            distance++;
        }

        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            result.add(curr.val);
        }
        return result;
    }
}