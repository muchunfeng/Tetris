package ylutil.myworks.myFirstTries;

/**
 * @author yanglu
 *
 */
public class Kuai {
	private int x,y;       
	private int jiyi;      
	private boolean isMove;
	public Kuai(){
		isMove=true;
	}
	public Kuai(int x,int y)    
	{
		this.x=x;
		this.y=y;
		isMove=true;
	}
	public void setJiyi(int direction)   
	{
		jiyi=direction;
	}
	public void stop()
	{
		isMove=false;
	}
	public void move()
	{
		y+=1;
	}
	public void setXY(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public void setX(int x)
	{
		this.x=x;
	}
	public void setY(int y)
	{
		this.y=y;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public boolean getIsmove()
	{
		return isMove;
	}
	public void setIsmove(boolean isMove)
	{
		this.isMove=isMove;
	}

}
