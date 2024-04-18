
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
  static int[] dx={-1,-1,-1,0,0,1,1,1};
  static int[] dy={-1,0,1,-1,1,-1,0,1};
  static class Tree implements Comparable<Tree>{
    int x;
    int y;
    int age;
    public Tree(int x,int y,int age){
      this.x=x;
      this.y=y;
      this.age=age;
    }

    @Override
    public int compareTo(Tree other){
      return this.age-other.age;
    }

    public void addAge(){
      this.age+=1;
    }
  }
  static int[][] plusMap,map;
  static int N,M,K;
  public static void main(String[] args) throws IOException{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());

    N=Integer.parseInt(st.nextToken());
    M=Integer.parseInt(st.nextToken());
    K=Integer.parseInt(st.nextToken());

    plusMap=new int[N][N];
    map=new int[N][N];

    for(int i=0;i<N;i++){
      st=new StringTokenizer(br.readLine());
      for(int j=0;j<N;j++){
        plusMap[i][j]=Integer.parseInt(st.nextToken());
        map[i][j]=5;
      }
    }

    Deque<Tree> trees=new ArrayDeque<>();


    for(int i=0;i<M;i++){
      st=new StringTokenizer(br.readLine());
      int x=Integer.parseInt(st.nextToken())-1;
      int y=Integer.parseInt(st.nextToken())-1;
      int z=Integer.parseInt(st.nextToken());
      trees.add(new Tree(x,y,z));
    }

    while(K-->0){
      //spring
      simulate(trees);
    }

    System.out.println(trees.size());

  }

  private static void simulate(Deque<Tree> trees){
    Deque<Tree> nextTree=new ArrayDeque<>();
    Deque<Tree> deadTree=new ArrayDeque<>();

    while(!trees.isEmpty()){
      Tree tree=trees.poll();
      if(map[tree.x][tree.y]>=tree.age){
        map[tree.x][tree.y]-=tree.age;
        tree.addAge();
        nextTree.add(tree);
      }else{
        deadTree.add(tree);
      }
    }

    while(!deadTree.isEmpty()){
      Tree tree=deadTree.poll();
      map[tree.x][tree.y]+=tree.age/2;
    }

    while(!nextTree.isEmpty()){
      Tree tree=nextTree.poll();
      if(tree.age%5==0){
        for(int d=0;d<8;d++){
          int nx=tree.x+dx[d];
          int ny=tree.y+dy[d];
          if(nx<0||ny<0||nx>=N||ny>=N) continue;
          trees.addFirst(new Tree(nx,ny,1));
        }
      }
      trees.addLast(tree);
    }

    plusMap();
  }
  private static void plusMap(){
    for(int i=0;i<N;i++) {
      for (int j = 0; j < N; j++) {
        map[i][j]+=plusMap[i][j];
      }
    }
  }

}
