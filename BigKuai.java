package ylutil.myworks.myFirstTries;

public class BigKuai extends Thread{
	Kuai kuai[]=new Kuai[4];
	private boolean isMove;
	private int shudu=600;
	private int jiyi;   //���մ�XianShi4�Ĺ����˶���ǽҪ���������
	public BigKuai(int choose)
	{
		switch(choose){
		case 1:kuai=create1();break;
		case 2:kuai=create2();break;
		case 3:kuai=create3();break;
		case 4:kuai=create4();break;
		case 5:kuai=create5();break;
		case 6:kuai=create6();break;
		case 7:kuai=create7();break;
		case 8:kuai=create8();break;
		case 9:kuai=create9();break;
		case 10:kuai=create10();break;
		case 11:kuai=create11();break;
		}
		isMove=true;
	}
	public void setShuDu(int s)
	{
		shudu=s;
	}
	
	public int setJiyi(int jiyi)         
	{
		int biaozhi=0;
		this.jiyi=jiyi;                //1 ����   2 ����
		if(jiyi==1){
			biaozhi=0;
			System.out.println("left");
		for(int i=0;i<4;i++)
		{
			int x=kuai[i].getX();
			int y=kuai[i].getY();
			if(x-1>=0&&XianShi.address[y+1][x-1].getUsed()!=1)
			{
				biaozhi++;
			}
		}
		System.out.println(biaozhi);          //����ʵ��
		if(biaozhi==4)                      //�����ĸ��ܹ��ƶ�ʱ�ƶ�
		{
			return -1;
		}
		}
		else if(jiyi==2)
		{
			biaozhi=0;
			for(int i=0;i<4;i++)
			{
				int x=kuai[i].getX();
				int y=kuai[i].getY();
				if(x+1<=XianShi.W+1&&XianShi.address[y+1][x+1].getUsed()!=1)
				{
					biaozhi++;
					
				}
			}
			if(biaozhi==4)                      //�����ĸ��ܹ��ƶ�ʱ�ƶ�
			{
				return 1;
			}
		}
		return 0;
	}
	public boolean getMove()
	{
		return isMove;
	}
	public void setMove(boolean move)
	{
		isMove=move;
	}
	public void run()
	{
		while(isMove){
		for(int i=0;i<4;i++)
		{
			kuai[i].move();
		}
		try{
			Thread.sleep(shudu);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	}
	public Kuai[] getKuai()
	{
		return kuai;
	}

	public Kuai[] create1()
	{
		Kuai k[]=new Kuai[4];
		for(int i=0;i<4;i++)
			k[i]=new Kuai();
		k[0].setXY(7, 5);
		k[1].setXY(8,5);
		k[2].setXY(9, 5);
		k[3].setXY(10,5);
		return k;
	}
	public Kuai[] create2()
	{
		Kuai k[]=new Kuai[4];
		for(int i=0;i<4;i++)
			k[i]=new Kuai();
		k[0].setXY(7, 5);
		k[1].setXY(7,6);
		k[2].setXY(7, 7);
		k[3].setXY(7,8);
		return k;
	}
	public Kuai[] create3()
	{
		Kuai k[]=new Kuai[4];
		for(int i=0;i<4;i++)
			k[i]=new Kuai();
		k[0].setXY(7, 5);
		k[1].setXY(7,6);
		k[2].setXY(8, 6);
		k[3].setXY(8,7);
		return k;
	}
	public Kuai[] create4()
	{
		Kuai k[]=new Kuai[4];
		for(int i=0;i<4;i++)
			k[i]=new Kuai();
		k[0].setXY(9, 5);
		k[1].setXY(8,5);
		k[2].setXY(8, 6);
		k[3].setXY(7,6);
		return k;
	}
	public Kuai[] create5()
	{
		Kuai k[]=new Kuai[4];
		for(int i=0;i<4;i++)
			k[i]=new Kuai();
		k[0].setXY(6, 5);
		k[1].setXY(7,5);
		k[2].setXY(7, 6);
		k[3].setXY(8,6);
		return k;
	}
	public Kuai[] create6()
	{
		Kuai k[]=new Kuai[4];
		for(int i=0;i<4;i++)
			k[i]=new Kuai();
		k[0].setXY(8, 5);
		k[1].setXY(8,6);
		k[2].setXY(7, 6);
		k[3].setXY(7,7);
		return k;
	}
	public Kuai[] create7()
	{
		Kuai k[]=new Kuai[4];
		for(int i=0;i<4;i++)
			k[i]=new Kuai();
		k[0].setXY(7, 5);
		k[1].setXY(7,6);
		k[2].setXY(7, 7);
		k[3].setXY(8,7);
		return k;
	}
	public Kuai[] create8()
	{
		Kuai k[]=new Kuai[4];
		for(int i=0;i<4;i++)
			k[i]=new Kuai();
		k[0].setXY(8, 5);
		k[1].setXY(7,5);
		k[2].setXY(6, 5);
		k[3].setXY(6,6);
		return k;
	}
	public Kuai[] create9()
	{
		Kuai k[]=new Kuai[4];
		for(int i=0;i<4;i++)
			k[i]=new Kuai();
		k[0].setXY(8, 7);
		k[1].setXY(8,6);
		k[2].setXY(8, 5);
		k[3].setXY(7,5);
		return k;
	}
	public Kuai[] create10()
	{
		Kuai k[]=new Kuai[4];
		for(int i=0;i<4;i++)
			k[i]=new Kuai();
		k[0].setXY(6, 6);
		k[1].setXY(7,6);
		k[2].setXY(8, 6);
		k[3].setXY(8,5);
		return k;
	}
	public Kuai[] create11()
	{
		Kuai k[]=new Kuai[4];
		for(int i=0;i<4;i++)
			k[i]=new Kuai();
		k[0].setXY(6, 6);
		k[1].setXY(7,6);
		k[2].setXY(6, 7);
		k[3].setXY(7,7);
		return k;
	}
}
