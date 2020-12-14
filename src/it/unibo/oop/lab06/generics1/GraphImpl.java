package it.unibo.oop.lab06.generics1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {
	
	final Map<N, Set<N>> graph = new HashMap<>();
	final Map<N, Boolean> visited = new HashMap<>();
	
	public void addNode(N node) {
		this.graph.putIfAbsent(node, new HashSet<N>()) ;		
	}

	public void addEdge(N source, N target) {
		Set<N> edge = this.graph.get(source);
		edge.add(target);
		this.graph.put(source, edge);
	}

	public Set<N> nodeSet() {
		Set<N> nodes = new HashSet<>();
		for(final N n : graph.keySet()) {
			nodes.add(n);
		}
		return nodes;
	}

	public Set<N> linkedNodes(N node) {
		Set<N> linkedNodes = this.graph.get(node);
		return new HashSet<N>(linkedNodes);
	}

	public List<N> getPath(N source, N target) {
		final List<N> path = new LinkedList<>();
		final LinkedList<N> pila = new LinkedList<>();
		N tmp = null;
		for (final N n : this.graph.keySet()) {
			this.visited.put(n, false);
		}
		
		this.visited.put(source, true);
		pila.push(source);
		while(!pila.isEmpty()) {
			tmp = pila.pop();
			path.add(tmp);
			if(tmp.equals(target)) {
				return path;
			}
			for(final N v : this.graph.get(tmp)) {
				if(!this.visited.get(v)) {
					this.visited.put(v, true);
					pila.push(v);
				}
			}
		}	
		return null;
	}
}
