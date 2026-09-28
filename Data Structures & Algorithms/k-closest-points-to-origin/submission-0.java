class Point implements Comparable<Point> {

    int x;
    int y;
    int dist;

    Point(int x,int y,int dist) {
        this.x= x;
        this.y = y;
        this.dist=dist;
    }

    public int compareTo(Point p1) {
        return this.dist-p1.dist;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int[] point :points) {
            int x = point[0];
            int y = point[1];
            int dist =(int) (Math.pow((x-0),2) + Math.pow((y-0),2));

            pq.offer(new Point(x,y,dist));
        }

        int[][] result = new int[k][2];

        for(int i=0;i<k;i++) {
            Point p = pq.poll();
            result[i] = new int[]{p.x,p.y};
        }

        return result;
    }
}
