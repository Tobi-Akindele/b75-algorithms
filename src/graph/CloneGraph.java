package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
	
	Map<Node, Node> oldToNew = new HashMap<>();

	public static void main(String[] args) {
		
	}

	public Node cloneGraph(Node node) {
		return node != null ? dfs(node) : null;
	}
	
	private Node dfs(Node node) {
		if(oldToNew.containsKey(node)) {
			return oldToNew.get(node);
		}
		Node copy = new Node(node.val);
		oldToNew.put(node, copy);
		for(Node nei: node.neighbors) {
			copy.neighbors.add(dfs(nei));
		}
		return copy;
	}

	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}
}
