package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SCollection extends Shape{
	
	private List<Shape> list;
	
	public SCollection(){
		list=new LinkedList<Shape>();
	}

	public Iterator<Shape> iterator(){
		return list.iterator();
	}
	
	public void add(Shape s){
		list.add(s);
	}
	
	public void remove(Shape s){
		list.remove(s);
	}
	
	public void accept(ShapeVisitor sv) {
		sv.visitCollection(this);
	}

	public Rectangle getBounds() {
		Rectangle r=null;
		for(Shape s:list){
			if(r==null){
				r=new Rectangle(s.getBounds());
			}else{
				r=r.union(s.getBounds());
			}
		}
		return r;
	}

	public Point getLoc() {
		return getBounds().getLocation();
	}

	public void setLoc(Point p) {
		for(Shape s:list){
			s.setLoc(p);
		}
	}
	
	public void translate(int xt,int yt){
		for(Shape s:list){
			s.translate(xt, yt);
		}
	}

}
