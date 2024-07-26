import java.util.*;

public class BFSTraversal {
    public static void bfTraversal(int adjMatrix[][]){
        Queue<Integer> pendingVertices = new LinkedList<>();
        boolean visited[] = new boolean[adjMatrix.length];
        visited[0] = true;
        pendingVertices.add(0);

        while(!pendingVertices.isEmpty()){
            int currentVertex = pendingVertices.poll();
            System.out.print(currentVertex+" ");
            for(int i=0; i<adjMatrix.length; i++){
                if(adjMatrix[currentVertex][i]==1 && !visited[1]){
                    pendingVertices.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Vertices: ");
        int vertices = sc.nextInt();
        System.out.print("Enter the number of Edges: ");
        int edges = sc.nextInt();
        int adjMatrix[][] = new int[vertices][vertices];
        for(int i=0; i<edges; i++){
            System.out.print("Enter the "+(i+i)+" edges (ex:0 1): ");
            int vertext1 = sc.nextInt();
            int vertext2 = sc.nextInt();
            adjMatrix[vertext1-1][vertext2-1] = 1;
            adjMatrix[vertext2-1][vertext1-1] = 1;
        }
        bfTraversal(adjMatrix);
        sc.close();
    }
}
