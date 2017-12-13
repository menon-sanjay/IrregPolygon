/**
 * SanjayMenon
 3rd period
 */
import java.awt.geom.*;     // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*;            // for DrawingTool
public class IrregularPolygon{
   private ArrayList <Point2D.Double> myPolygon;

   // constructors
   public IrregularPolygon() 
   {
    myPolygon = new ArrayList<Point2D.Double>();   
   }

   // public methods
   public void add(double x, double y) 
   {
       Point2D.Double myPoint = new Point2D.Double (x, y);
       myPolygon.add(myPoint);
   }

   public void draw() 
   { 
    SketchPad paper = new SketchPad(500, 500);
    DrawingTool pen = new DrawingTool(paper);
    pen.up();
    pen.move(myPolygon.get(0).getX(), myPolygon.get(0).getY());
    pen.down();
    for (int i = 0; i < myPolygon.size(); i++)
    {
      pen.move(myPolygon.get(i).getX(), myPolygon.get(i).getY());                                                                               
    }
 
    pen.move(myPolygon.get(0).getX(), myPolygon.get(0).getY());
   }
  
   public double perimeter() 
   {
    double perimeter = 0;
    int a = 0; //to get y1,y1 x1,x2
    int b = 1; //see above
    while(a < myPolygon.size()) 
    {
      perimeter += Math.sqrt(Math.pow((myPolygon.get(b).getX() - myPolygon.get(a).getX()),2) + Math.pow((myPolygon.get(b).getY() - myPolygon.get(a).getY()),2));
      a++;
      b++;
      if(b > myPolygon.size() - 1) 
      {        b = 0;
      }
    }
    return perimeter;
    }  
   public double area() 
   {
    int a = 0; //to get  xs
    int b = 1; //to get the ys
    int n = myPolygon.size();
    double area = 0;
    while(a < n)
    {
      double x1 = myPolygon.get(a).getX();
      double y1 = myPolygon.get(a).getY();
      double x2 = myPolygon.get(b).getX();
      double y2 = myPolygon.get(b).getY();
      area += (0.5)*(x1*y2 - x2*y1);
      a++;
      b++;
      if(b > n-1) 
      {
       b = 0;
      }
     }
     return Math.abs(area);
    }
    public String getName(){
       return "Sanjay Menon";
    }
   public boolean check()
   {
    
    if (myPolygon.size() < 3)
    {
      return false;
    }
   
    ArrayList <Line2D.Double> isPolygon = new ArrayList <Line2D.Double>();
    for (int i = 0; i < myPolygon.size(); i++)
    {
      isPolygon.add(new Line2D.Double(myPolygon.get(i), myPolygon.get((i+1) % myPolygon.size())));         
    }
    //checks if the lines intersect
    for (int i = 0; i < myPolygon.size(); i++)
    {
    for (int q = 0; q < myPolygon.size(); i++)
    {
      if(isPolygon.get(i).intersectsLine(isPolygon.get(q % isPolygon.size())))
        return false;
    }
    }
    return true;
   }
  }
