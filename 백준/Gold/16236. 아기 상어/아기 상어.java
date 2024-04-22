

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dx={1,0,-1,0};
  static int[] dy={0,-1,0,1};
  static class Fish implements Comparable<Fish>{
    int x;
    int y;
    int distance;

    public Fish(int x,int y,int distance){
      this.x=x;
      this.y=y;
      this.distance=distance;
    }

    @Override
    public int compareTo(Fish other){
      if(this.distance==other.distance){
        if(this.x==other.x){
          return this.y-other.y;
        }
        return this.x-other.x;
      }
      return this.distance-other.distance;
    }

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    int N=Integer.parseInt(br.readLine());

    StringTokenizer st;

    Queue<int[]> shark=new LinkedList<>();
    Queue<int[]> move=new LinkedList<>();


    int[][] map=new int[N][N];
    for(int i=0;i<N;i++){
      st=new StringTokenizer(br.readLine());
      for(int j=0;j<N;j++){
        map[i][j]=Integer.parseInt(st.nextToken());
        if(map[i][j]==9){
          shark.add(new int[]{i,j,0});
          map[i][j]=0;
        }
      }
    }

    int sharkWeight=2;
    int eatFish=0;
    int sec=0;
    while(!shark.isEmpty()){
      int[] sharkPos=shark.poll();
      move.add(sharkPos);
      if(eatFish==sharkWeight){
        sharkWeight++;
        eatFish=0;
      }
      boolean[][] visited=new boolean[N][N];
      visited[sharkPos[0]][sharkPos[1]]=true;
      PriorityQueue<Fish> fishs=new PriorityQueue<>();
      int minDist=Integer.MAX_VALUE;
      while(!move.isEmpty()){
        int[] pos=move.poll();
        for(int d=0;d<4;d++) {
          int nx = pos[0]+dx[d];
          int ny=pos[1]+dy[d];
          int distance=pos[2]+1;
          if(nx<0||ny<0||nx>=N||ny>=N) continue;
          if(visited[nx][ny]) continue;
          visited[nx][ny]=true;
          if(map[nx][ny]==0||map[nx][ny]==sharkWeight){
            move.add(new int[]{nx,ny,pos[2]+1});
          }
          else if(map[nx][ny]<sharkWeight&&minDist>=distance){
            minDist=distance;
            fishs.add(new Fish(nx,ny,distance));
            move.add(new int[]{nx,ny,distance});
          }
        }
      }
      if(!fishs.isEmpty()){
        Fish fish=fishs.poll();
        map[fish.x][fish.y]=0;
        eatFish++;
        sec+=fish.distance;
        shark.add(new int[]{fish.x,fish.y,0});
        move.clear();
      }else{
        break;
      }

    }

    System.out.println(sec);

  }

}
