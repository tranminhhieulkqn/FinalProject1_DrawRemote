package Shape;

import java.awt.Color;
import java.awt.Point;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;

import Frame.WhiteBoardClient;
import Object.GraphicAdapter;

/**
 * @author VanAnh, MinhHieu
 *
 */
public class MyPoint extends Class1D implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4429762987976869433L;
	private Point point;
	private Color color = Color.black;//Set original color
	
	//Data Encapsulation
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	//Constructor
	public MyPoint() {
		// TODO Auto-generated constructor stub
	}
	public MyPoint(Point p) {
		// TODO Auto-generated constructor stub
		this.point = p;
	}
	
	public MyPoint(Point p, Color c) {
		// TODO Auto-generated constructor stub
		this.point = p;
		this.color = c;
	}
	
	//Functions override
	@Override
	public void draw(GraphicAdapter g){
		g.GraphicAdapter.setColor(getColor());
		g.getGraphicAdapter().drawLine(getPoint().x, getPoint().y,getPoint().x, getPoint().y);
	}
	
	@Override
    public boolean contains(Point p) {
		if(p.x == getPoint().x && p.y == getPoint().y){
			return true;
		}
		return false;
    }
    @Override
    public void move(Point startDrag, Point endDrag){
    	setPoint(endDrag);
    }
	
    @Override
    public void writetoFile(BufferedWriter b){
    	try {
    		b.write(getClass().getSimpleName() + ";");
    		b.write(getPoint().x + ";" + getPoint().y + ";");
    		b.write(getColor().getRed() + ";" + getColor().getGreen() + ";" + getColor().getBlue());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @Override
    public void makeObject(Point startDrag, Point endDrag){
    	Point p = new Point(startDrag.x, startDrag.y);
    	setPoint(p);
    	setColor(WhiteBoardClient.selectColor);
    }
	
}
