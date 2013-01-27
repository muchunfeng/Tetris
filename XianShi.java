package ylutil.myworks.myFirstTries;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.awt.event.*;
public class XianShi extends JPanel implements KeyListener{
	static int W=12,H=20;
	private final int Max=100;
	private int jilu[]=new int[H],jilu2[]={-1,-1,-1,-1};    //��¼2Ϊ��¼���������
	public static int fengshu=0,cengu=H+4,cengd;   //fengshu����������,ֵ�ÿ���,ceng point to the floor at first
	private int choose1,choose2;
	static Address address[][];
	static int width,height,Aw,Ah;
	private Kuai kuai[];
	private BigKuai bk;
	private JLabel label1,label2;
	private int controlInsert=0;
	public XianShi(int width,int height,JLabel label1,JLabel label2)
	{
		this.setBorder(BorderFactory.createLineBorder(new Color(107,200,100)));
		Arrays.fill(jilu, 0);      // ��jilu[0]>=0ʱ������
		System.out.println(jilu[0]+" "+jilu[2]);
		this.width=width;
		this.height=height;
		this.label1=label1;
		this.label2=label2;
		label1.setText(String.valueOf(fengshu));
		Aw=width/W;
		Ah=height/H;
		address=new Address[H+5][W+2];    //ǰ4�п���,���һ��������,��Ϊһ��������.W+2�Ǻ�4�ӵ�,��͸ü�,û���ǵ�
		for(int i=4;i<H+4;i++)
		{
			address[i][0]=new Address(0,i,1);
			address[i][W+1]=new Address(W+1,i,1);
			for(int j=1;j<W+1;j++)
			{
				address[i][j]=new Address(j,i,0);
				address[i][j].setXa(Aw*(j-1));
				address[i][j].setYa(Ah*(i-4));
			}
		}
		for(int i=0;i<W+1;i++)
		{
			address[H+4][i]=new Address(i,H+4,1);
		}
	}
	//���Ƶķ���
	public void control()
	{
		choose1=1+(int)(Math.random()*11)%11;   //ע��Ϊ0������,Ҫ��switch�е�һ��
		choose2=choose1;
		while(jilu[1]<=0&&fengshu<Max)
		{
			boolean flag=true; //��������һ��ѭ����
			int pd=0,pd2=0;  //�ж��Ƿ�ֹͣ,pd2�ж��Ƿ���мӷ�
			switch(choose1){
			case 1:bk=new BigKuai(1);break;
			case 2:bk=new BigKuai(2);break;
			case 3:bk=new BigKuai(3);break;
			case 4:bk=new BigKuai(4);break;
			case 5:bk=new BigKuai(5);break;
			case 6:bk=new BigKuai(6);break;
			case 7:bk=new BigKuai(7);break;
			case 8:bk=new BigKuai(8);break;
			case 9:bk=new BigKuai(9);break;
			case 10:bk=new BigKuai(10);break;
			case 11:bk=new BigKuai(11);break;
			}
			//System.out.println(choose1);
			choose2=1+(int)(Math.random()*11)%11;             //choose2 for show next
			label2.setText(String.valueOf(choose2));
			kuai=bk.getKuai();
			bk.start();
			while(flag){
			for(int i=0;i<kuai.length;i++)
			{
				int x=kuai[i].getX();
				int y=kuai[i].getY();                       //����ô��ֻ��Ϊ����ʾ��һЩ����ʵ��һ��͹���,�Ǻ�.
				if(address[y+1][x].getUsed()==1)            //&&controlInsert==0  �Ѿ��̶��ڵײ���1
				//controlInsert �ڿ��Ʒ����ʱ��仯,+���֣�-����
				{ 
					pd=1;
					break;
				}
			}
			repaint();
			if(pd==1){                                  //Ҫֹͣ��
				flag=false;
				bk.setMove(false);
				cengd=kuai[0].getY();           //�ĸ�С��������ѡȡһ�����ҳ�����һ��Ĳ��
			    for(int i=0;i<kuai.length;i++)
			    {
				    int x=kuai[i].getX();
				    int y=kuai[i].getY();      //y���ص���address�ж�Ӧ�������
				  /* if(y>cengd)
				    {
				    	cengd=y;               //��֤CengD��Ҫ�����ײ㣬��������ν�Ĺ���
				    }*/
				    if(y<cengu)
				    {
				    	cengu=y;                 // cengu ָ�򶥲㣬��Cengu����ָ�򶥲��
				    }
				    if(y<=4)
				    {
				    	break;
				    }
				    jilu[y-4]++;
				    address[y][x+controlInsert].setUsed(1);      //controlInsert   ????
				    if(jilu[y-4]>=W)                       // ����������
				    {
				    	jilu2[pd2]=y;                   // y �� address �Ķ�Ӧ
				    	pd2++;                                //Ҫ����м���,�Ӵ˶�֪
				    }
			    }
			    if(pd2!=0)                                     //�Ѿ�����         
			    {
			    	fengshu+=10*pd2;
		    		label1.setText(String.valueOf(fengshu));
		    		for(int i=0;i<pd2;i++)
		    		{
		    			int h=jilu2[i];
		    			for(int c=h;c>cengu;c--)
		    			{
		    				for(int j=1;j<W+1;j++)
			    			{
			    				address[c][j].setUsed(address[c-1][j].getUsed());
			    				address[c-1][j].setUsed(0);
			    			}
		    				jilu[c-4]=jilu[c-5];
		    			}
		    		}
		    		
		    		}
		    		cengu=cengu-pd2;
		    		
			    }
//			controlInsert=0;
			}
			choose1=choose2;
			repaint();
			
			}
		if(jilu[1]>0)
		{
			repaint();
		}
		if(fengshu>=Max)
		{
			repaint();
		}
	}
	// ��keything�ṩ����
	
	public BigKuai getBigkuai()
	{
		return bk;
	}
	
	
	 //����  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public void Change12()    
	{           //���ⷽ�����ǺͿ�ʼ���õ�ȫ�ֱ�kuaiһ��
		kuai[0].setXY(kuai[0].getX()+2,kuai[0].getY());
		kuai[1].setXY(kuai[1].getX()+1,kuai[1].getY()+1);
		kuai[2].setXY(kuai[2].getX(),kuai[2].getY()+2);
		kuai[3].setXY(kuai[3].getX()-1,kuai[3].getY()+3);
		choose1=2;
	}
	public void Change21()
	{
	    //  ���������һ�������x,��ֹ����ʱԽ��,���ǻ���һ���Ӵ��ûʲô�����Ĺ���,����ʱ�Ͳ�����
		//   �Ժ���ʱ��ʱ��Ū����
		//############################################################################################
		kuai[0].setXY(kuai[0].getX()-2,kuai[0].getY()+1);
		kuai[1].setXY(kuai[1].getX()-1,kuai[1].getY());
		kuai[2].setXY(kuai[2].getX(),kuai[2].getY()-1);
		kuai[3].setXY(kuai[3].getX()+1,kuai[3].getY()-2);
		choose1=1;
	}
	public void Change34()
	{
		//Kuai kuai[]=new Kuai[4];
		//kuai=bk.getKuai();            
		kuai[0].setXY(kuai[0].getX()+2,kuai[0].getY()+1);
		kuai[1].setXY(kuai[1].getX()+1,kuai[1].getY());
		kuai[2].setXY(kuai[2].getX(),kuai[2].getY()+1);
		kuai[3].setXY(kuai[3].getX()-1,kuai[3].getY());
		choose1=4;
	}
	public void Change43()
	{
		//Kuai kuai[]=new Kuai[4];
		//kuai=bk.getKuai();            
		kuai[0].setXY(kuai[0].getX()-2,kuai[0].getY());
		kuai[1].setXY(kuai[1].getX()-1,kuai[1].getY()+1);
		kuai[2].setXY(kuai[2].getX(),kuai[2].getY());
		kuai[3].setXY(kuai[3].getX()+1,kuai[3].getY()+1);
		choose1=3;
	}
	public void Change56()
	{
		kuai[0].setXY(kuai[0].getX()+2,kuai[0].getY());
		kuai[1].setXY(kuai[1].getX()+1,kuai[1].getY()+1);
		kuai[2].setXY(kuai[2].getX(),kuai[2].getY());
		kuai[3].setXY(kuai[3].getX()-1,kuai[3].getY()+1);
		choose1=6;
	}
	public void Change65()
	{
		kuai[0].setXY(kuai[0].getX()-1,kuai[0].getY());
		kuai[1].setXY(kuai[1].getX(),kuai[1].getY()-1);
		kuai[2].setXY(kuai[2].getX()+1,kuai[2].getY());
		kuai[3].setXY(kuai[3].getX()+2,kuai[3].getY()-1);
		choose1=5;
	}
	public void Change78()
	{
		//Kuai kuai[]=new Kuai[4];
		//kuai=bk.getKuai();            
		kuai[0].setXY(kuai[0].getX()+2,kuai[0].getY()+1);
		kuai[1].setXY(kuai[1].getX()+1,kuai[1].getY());
		kuai[2].setXY(kuai[2].getX(),kuai[2].getY()-1);
		kuai[3].setXY(kuai[3].getX()-1,kuai[3].getY());
		choose1=8;
	}
	public void Change89(){
		//Kuai kuai[]=new Kuai[4];
		//kuai=bk.getKuai();            
		kuai[0].setXY(kuai[0].getX()-1,kuai[0].getY()+2);
		kuai[1].setXY(kuai[1].getX(),kuai[1].getY()+1);
		kuai[2].setXY(kuai[2].getX()+1,kuai[2].getY());
		kuai[3].setXY(kuai[3].getX(),kuai[3].getY()-1);
		choose1=9;
	}
	public void Change910()
	{
		//Kuai kuai[]=new Kuai[4];
		//kuai=bk.getKuai();            
		kuai[0].setXY(kuai[0].getX()-1,kuai[0].getY());
		kuai[1].setXY(kuai[1].getX(),kuai[1].getY()+1);
		kuai[2].setXY(kuai[2].getX()+1,kuai[2].getY()+2);
		kuai[3].setXY(kuai[3].getX()+2,kuai[3].getY()+1);
		choose1=10;
	}
	public void Change107()
	{         
		kuai[0].setXY(kuai[0].getX()+1,kuai[0].getY()-2);
		kuai[1].setXY(kuai[1].getX(),kuai[1].getY()-1);
		kuai[2].setXY(kuai[2].getX()-1,kuai[2].getY());
		kuai[3].setXY(kuai[3].getX(),kuai[3].getY()+1);
		choose1=7;
	}
	
	//��ͼ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(fengshu>=Max){
			g.setFont(new Font(" ",Font.ITALIC,20));
			g.drawString("WINNER", 30, 250);
		}
		else if(jilu[1]<=0){
		for(int i=0;i<=H;i++)
		{
			g.setColor(new Color(100,100,100));
			g.drawLine(0,Ah*i ,width, Ah*i);
		}
		for(int i=0;i<=W;i++)
		{
			g.setColor(new Color(100,100,100));
			g.drawLine(Aw*i,0,Aw*i,height);
		}
		
		for(int i=0;i<H;i++){
			for(int j=0;j<W;j++)
			{
				int use1=address[i+4][j+1].getUsed();
				if(use1==1)
				{
					g.setColor(new Color(204,100,200));
					g.setColor(new Color(189,100,200));
					g.fillRect(address[i+4][j+1].getXa(), address[i+4][j+1].getYa(), Aw, Ah);
					g.setColor(new Color(50,100,50));
					//g.draw3DRect(address[i+4][j+1].getXa(), address[i+4][j+1].getYa(), Aw, Ah,true);
					g.drawRoundRect(address[i+4][j+1].getXa(), address[i+4][j+1].getYa(), Aw, Ah,13,15);
				}
			}
		}
		for(int i=0;i<4;i++)
		{
			int x=kuai[i].getX();
			int y=kuai[i].getY();
			g.fillRect(address[y][x].getXa(), address[y][x].getYa(), Aw, Ah);
		}
		}
		else{
			g.setFont(new Font(" ",Font.ITALIC,50));
			g.drawString("Sorry", 30, 250);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int x,y;
		/**��Ӧ���м��书��,�ȵ��Ա��ж����ס�����㰴�˼�����ס�㰴��
		 * �������С�ռ������
		 */
		//controlInsert=0;
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{	
			
			int biaoji=0;
			//��������
			for(int i=0;i<4;i++)
			{
				int x1=kuai[i].getX();
				int y1=kuai[i].getY();
				if(address[y1][x1-1].getUsed()==1)
				{
					biaoji=1;     
					controlInsert=bk.setJiyi(1);                     //  wait for deal with,һֱû�����䣬����������Բߡ�
				    System.out.println(" I don't know"+ " "+controlInsert);
				}
			}
			if(biaoji!=1){
			for(int i=0;i<4;i++)
			{
				x=kuai[i].getX();
				x-=1;
				kuai[i].setX(x);
			}
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			int biaoji=0;
			for(int i=0;i<4;i++)
			{
				int x1=kuai[i].getX();
				int y1=kuai[i].getY();
				/*if(x1==W)       //pay attention
				{
					biaoji=1;
				}*/
				if(address[y1][x1+1].getUsed()==1)
					{
						biaoji=1;  
						controlInsert=bk.setJiyi(2); 
					}
			}
			if(biaoji!=1){
			for(int i=0;i<4;i++)
			{
				x=kuai[i].getX();
				x+=1;
				kuai[i].setX(x);
			}
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			switch(choose1){
			case 1:Change12();break;
			case 2:Change21();break;
			case 3:Change34();break;
			case 4:Change43();break;
			case 5:Change56();break;
			case 6:Change65();break;
			case 7:Change78();break;
			case 8:Change89();break;
			case 9:Change910();break;
			case 10:Change107();break;
			}
			//System.out.println(choose);
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			bk.setShuDu(100);
		}
	}
	public void keyReleased(KeyEvent e1) {
		if(e1.getKeyCode()==KeyEvent.VK_DOWN)
		{
			bk.setShuDu(600);
		}
		/*if(e1.getKeyCode()==KeyEvent.VK_LEFT||e1.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			controlInsert=0;
		}*/
	}
	public void keyTyped(KeyEvent arg0) {}

}
