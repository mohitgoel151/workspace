package learn.ds.dp;

public class FloydWarshalAlgo {

    private int[][] matrix;

    Point[] allPoints = null;
    private Point StartPoint;
    private Point EndPoint;

    public FloydWarshalAlgo(Point[] pts) 
    {
        if (pts.length > 1)
        {
            allPoints = pts;
            //matrix = new double[allPoints.Length, allPoints.Length];
            matrix = new int[][]
            {
                {0, 8, Integer.MAX_VALUE,Integer.MAX_VALUE,10,Integer.MAX_VALUE, Integer.MAX_VALUE},
                {8,0,3,2,5,Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE,3,0,2,Integer.MAX_VALUE,Integer.MAX_VALUE,2},
                {Integer.MAX_VALUE,2,2,0,5,10,5},
                {10,5,Integer.MAX_VALUE,5,0,13,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,10,13,0,9},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,2,5,Integer.MAX_VALUE,9,0}
            };
            //InitializeMatrix();
            RunQuery();
            StartPoint = allPoints[0];
            EndPoint = allPoints[1];
        }
    }

    public void InitializeMatrix()
    {
        for (int i = 0; i < allPoints.length; i++)
        {
            for (int j = 0; j < allPoints.length; j++)
            {
                if (i == j)
                {
                    matrix[i][j] = 0;
                }
                else
                {
                    double a = allPoints[i].Distance(allPoints[j]);
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        RunQuery();
    }

    public void RunQuery()
    {
        for (int k = 0; k < allPoints.length; k++)
        {
            for (int i = 0; i < allPoints.length; i++)
            {
                for (int j = 0; j < allPoints.length; j++)
                {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        System.out.println("path length = " + matrix[0][5]);
    }

    
    class Point
    {
        private int x;
        private int y;


        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Point()
        {
            this(0,0);
        }

        public Point(int ix, int iy)
        {
            x = ix;
            y = iy;
        }

        public double Distance(Point sPoint)
        {
            return Math.sqrt((x - sPoint.x) * (x - sPoint.x) + (y - sPoint.y) * (y - sPoint.y));
        }
    }
}
