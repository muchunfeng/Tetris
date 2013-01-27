package ylutil.myworks.myFirstTries;

public class Address {
	private int x,y;  // record the zuobiao
	private int Xa,Ya;   // location
	private int isused;
	public Address(int x,int y,int isused)
	{
		this.x=x;
		this.y=y;
		this.isused=isused;
	}
	public void setX(int x)
	{
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	public void setXa(int Xa)
	{
		this.Xa=Xa;
	}
	public void setYa(int Ya)
	{
		this.Ya=Ya;
	}
	public void setUsed(int use)
	{
		isused=use;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getXa()
	{
		return Xa;
	}
	public int getYa()
	{
		return Ya;
	}
	public int getUsed()
	{
		return isused;
	}

}
