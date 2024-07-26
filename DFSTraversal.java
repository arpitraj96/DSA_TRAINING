import java.util.Scanner;

public class DFSTraversal {
    public static void dftraversal(int adjMatrix[][], int currentVertex, boolean[] visited){
        visited[currentVertex] = true;
        System.out.print(currentVertex+1+" ");
        for(int i=0; i<adjMatrix.length; i++){
            if(adjMatrix[currentVertex][i]==1 && visited[i]==false){
                dftraversal(adjMatrix, i, visited);
            }
        }
    }

    public static void dftraversal(int adjMatrix[][]){
        boolean visited[] = new boolean[adjMatrix.length];
        dftraversal(adjMatrix, 0, visited);
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
        dftraversal(adjMatrix);
        sc.close();
    }
}