import java.util.*;
 
class Solution {
    
    int[][] result; // 전위/후위 순회 결과 저장용 배열
    int idx;        // 현재 result 배열 인덱스
    
    public int[][] solution(int[][] nodeinfo) {
        // (x, y, 노드 번호) 정보를 Node 객체로 변환
        Node[] node = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            node[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);
        }

        // [트리 구성 규칙]
        // 1. 자식 노드의 y값은 항상 부모 노드보다 작다.
        // 2. 왼쪽 서브트리의 모든 노드는 부모의 x값보다 작다.
        // 3. 오른쪽 서브트리의 모든 노드는 부모의 x값보다 크다.
        
        // y값이 큰 순서(루트부터), y가 같다면 x값이 작은 순서대로 정렬
        Arrays.sort(node, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.y == n2.y) 
                    return n1.x - n2.x;
                return n2.y - n1.y;
            }
        });
        
        // 첫 번째 노드를 루트로 설정
        Node root = node[0];
        // 나머지 노드들을 규칙에 맞게 삽입
        for (int i = 1; i < node.length; i++) {
            insertNode(root, node[i]);
        }
        
        result = new int[2][nodeinfo.length];
        idx = 0;
        
        // 전위 순회 (루트 → 왼쪽 → 오른쪽)
        preorder(root);
        idx = 0;
        
        // 후위 순회 (왼쪽 → 오른쪽 → 루트)
        postorder(root);
        
        return result;
    }
    
    // 트리 삽입 규칙에 따라 자식 노드 추가
    public void insertNode(Node parent, Node child) {
        // x 좌표 비교를 통해 왼쪽 / 오른쪽 서브트리 결정
        if (parent.x > child.x) { // 부모보다 x가 작으면 왼쪽
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else { // 부모보다 x가 크면 오른쪽
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
    
    // 전위 순회: 루트 → 왼쪽 → 오른쪽
    public void preorder(Node root) {
        if (root != null) {
            result[0][idx++] = root.value;
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    // 후위 순회: 왼쪽 → 오른쪽 → 루트
    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            result[1][idx++] = root.value;
        }
    }
    
    // 노드 클래스
    public class Node {
        int x;      // x좌표
        int y;      // y좌표
        int value;  // 노드 번호
        Node left;  // 왼쪽 자식
        Node right; // 오른쪽 자식
        
        public Node(int x, int y, int value, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
