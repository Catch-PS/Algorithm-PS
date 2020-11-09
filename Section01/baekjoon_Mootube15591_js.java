package com.company.study.section.section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Mootube {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(n);

        for (int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.addEdge(node1, node2, weight);
        }

        for (int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            System.out.println(graph.dfs(k, s));
        }
    }


    static class Graph {
        private int node;
        private LinkedList<Edge>[] adjacencylist;

        public Graph(int node) {
            this.node = node;
            this.adjacencylist = new LinkedList[node+1];
            for (int i=0; i<=node; i++) adjacencylist[i] = new LinkedList<>();
        }

        public void addEdge(int node1, int node2, int weight) {
            Edge edge = new Edge(node1, node2, weight);
            Edge edge2 = new Edge(node2, node1, weight);
            adjacencylist[node1].addFirst(edge);
            adjacencylist[node2].addFirst(edge2);
        }

        public int dfs(int k, int s) {
            int result = 0;
            List<Integer> bfsList = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[node+1];

            visited[s] = true;
            stack.add(s);
            while (!stack.isEmpty()) {
                int pop = stack.pop();
                bfsList.add(pop);

                Iterator<Edge> iterator =  adjacencylist[pop].listIterator();
                while (iterator.hasNext()) {
                    Edge nextEdge = iterator.next();
                    int next = nextEdge.node2;
                    int weight = nextEdge.weight;

                    if (!visited[next] && weight >= k) {
                        visited[next] = true;
                        stack.add(next);
                        result++;
                    }
                }
            }

            return result;
        }
    }

    static class Edge {
        int node1;
        int node2;
        int weight;

        public Edge(int node1, int node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }
    }
}
