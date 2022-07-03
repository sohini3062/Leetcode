class DetectSquares {
    HashMap<String,Integer> map;// counting frequency, String key chosen as a fixed distinguisher
    ArrayList<int[]> coordinates;

    public DetectSquares() {
        
        map=new HashMap<>();
        coordinates=new ArrayList<>();
        
    }
    
    public void add(int[] point) {
        coordinates.add(point);
        int count=map.getOrDefault(point[0]+" "+point[1],0);
        map.put(point[0]+" "+point[1],count+1);
        
        
    }
    
    public int count(int[] point) {
        
        int ans=0;
        
        //check for a diagonal point, if diagonal found then top left coordinate is diagonal's x and querypoints's y and another point is diagonals y and query point's x
        
        for(int[] c: coordinates)
        {
            int x=c[0];
            int y=c[1];
            if(Math.abs(x-point[0]) != 0 && Math.abs(x-point[0])==Math.abs(y-point[1]))
            {
                int[] top=new int[2];
                top[0]=c[0];
                top[1]=point[1];
                int[] bottom=new int[2];
                bottom[0]=point[0];
                bottom[1]=c[1];
                
                ans+=map.getOrDefault(top[0]+" "+top[1],0)*map.getOrDefault(bottom[0]+" "+bottom[1],0);
            }
        }
        
        
        return ans;
        
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */