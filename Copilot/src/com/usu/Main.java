package com.usu;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    // dijkstras algorithm
    public static int[] dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0;
        boolean[] visited = new boolean[n];
        while (true) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] < min) {
                    min = dist[i];
                    minIndex = i;
                }
            }
            if (minIndex == -1) {
                break;
            }
            visited[minIndex] = true;
            for (int i = 0; i < n; i++) {
                if (graph[minIndex][i] != 0) {
                    if (dist[minIndex] + graph[minIndex][i] < dist[i]) {
                        dist[i] = dist[minIndex] + graph[minIndex][i];
                    }
                }
            }
        }
        return dist;
    }
}
