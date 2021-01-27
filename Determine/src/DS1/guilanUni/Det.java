package DS1.guilanUni;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

public class Det {

public static void main(String[] args) {
	Scanner input=new Scanner(System.in);

	System.out.println("please choose type of your number:\n1)Integer and Float  \n2)Complex");
	String type=input.next();//gereftane noe adad
	System.out.println("Please enter n");
	int n=input.nextInt();//gereftane n

	if(type.equals("1")) {//Float
		float[][] matris=new float [n][n];
		for(int i=0;i<n;i++) 
			for(int j=0;j<n;j++) 
				matris[i][j]=input.nextFloat();//matris gerefte mishavad
			System.out.format("%.3f", cal(matris,n));//chape javab ba se raqam ashar
	}else {//Complex
		Complex[][] matris=new Complex [n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {//gereftane deraye ha
				String str=input.next();
				String a="0",b="0";
				boolean flag=false;//agar false bashad dar a hastim
				for(int t=0;t<str.length();t++) {//inghadar mikhanad ta be '+' ya '-' beresad;a+bi
					if(flag==false) {//agar dar hale sakhte a bashim
						if(((int)str.charAt(t)>=48 && (int)str.charAt(t)<=57) || (int)str.charAt(t)==46){//character adad bashad
							a+=str.charAt(t);//sakhte a
						}
						else {
							flag=true;
							continue;}
					}
					else {//sakhte b
						if((int)str.charAt(t)>=48 && (int)str.charAt(t)<=57  || (int)str.charAt(t)==46){
							b+=str.charAt(t);
						}
						else //residan be 'i'
							break;
					}
				}

				matris[i][j]=new Complex(Float.parseFloat(a), Float.parseFloat(b));//dar matris rikhte mishavad
			}}
		System.out.println(cal(matris,n));
	}
	
	
}
/**
 * mohasebe determinan baraye adade mokhtalet
 * @param matris
 * @param n
 * @return
 */

public static Complex cal(Complex[][] matris,int n) {
	if(n==1) {
		return matris[0][0];
	}
	
	///estefade az raveshe gavs baraye kahesh hazine ejra////
	//satre aval be joz daraye avalash sefr mishavad.yani zaribi az sotoone aval az har sotoon kam mishavad
	for(int j=1;j<n;j++) {

		Complex amir=Complex.div(matris[0][j],matris[0][0]);//zaribe morede nazar
		
		//deraye avale har sotoone bayad sefr shavad
		matris[0][j].a=0;
		matris[0][j].b=0;
		//
		
		for(int i=1;i<n;i++) {
			matris[i][j]=Complex.taf(	matris[i][j],Complex.mul(matris[i][0],amir));//tafriq
		}

	}
	///////////////////////////////////////////
	
		Complex x=new Complex(0,0);//javab

			Complex[][] tmp=new Complex[n-1][n-1];//kahade A[0][0]

			for(int t=1;t<n;t++) {
				for(int u=1;u<n;u++) {
			tmp[t-1][u-1]=matris[t][u];
				}
			}
			x=Complex.mul(matris[0][0],cal(tmp,n-1));//x=matrs[0][0]*Aij
		return x;
	
	
}
/**
 * mohasebe determinan baraye adade ashari
 * @param matris
 * @param n
 * @return
 */
public static float cal(float[][] matris,int n) {
	if(n==1) {
		return matris[0][0];
	}
	///estefade az raveshe gavs baraye kahesh hazine ejra////
		//satre aval be joz daraye avalash sefr mishavad.yani zaribi az sotoone aval az har sotoon kam mishavad
	
for(int j=1;j<n;j++) {

	float amir=matris[0][j]/matris[0][0];//zaribe morede nazar
	matris[0][j]=0;
	for(int i=1;i<n;i++) {
		matris[i][j]-=matris[i][0]*amir;//tafriq

	}

}
	float x=0;//javab

		float[][] tmp=new float[n-1][n-1];

		/////sakhte Aij/////
		for(int t=1;t<n;t++) {
			for(int u=1;u<n;u++) {
		
		tmp[t-1][u-1]=matris[t][u];
			}
		}
		////////////////////
		x=matris[0][0]*cal(tmp,n-1);
	return x;
}
}

//////////////class Complex/////
class Complex{
	float a,b;//a+bi
	
	/**
	 * Constructor
	 * @param a
	 * @param b
	 */
	public Complex(float a,float b) {
		this.a=a;
		this.b=b;
	}
	/**
	 * +
	 * @param Complex 1
	 * @param  Complex 2
	 * @return
	 */
	public static Complex sum(Complex one,Complex two) {
		float x1=one.a,y1=one.b,x2=two.a,y2=two.b;
		return new Complex(x1+x2, y1+y2);
		
	}
	/**
	 * -
	 * @param Complex 1
	 * @param  Complex 2
	 * @return
	 */
	public static Complex taf(Complex one,Complex two) {
		float x1=one.a,y1=one.b,x2=two.a,y2=two.b;
		return new Complex(x1-x2, y1-y2);
		
	}
	/**
	 * *
	 * @param Complex 1
	 * @param  Complex 2
	 * @return
	 */
	public static Complex mul(Complex one,Complex two) {
		float x1=one.a,y1=one.b,x2=two.a,y2=two.b;
		return new Complex(x1*x2-y1*y2, x1*y2+x2*y1);
		
	}
	/**
	 * 
	 * @param Complex 1
	 * @param  Complex 2
	 * @return
	 */
	public static Complex div(Complex one,Complex two) {
		float x1=one.a,y1=one.b,x2=two.a,y2=two.b;
		float a1=Float.parseFloat(String.valueOf((x1*x2+y1*y2)/(Math.pow(x2, 2)-Math.pow(y2, 2))));
		float a2=Float.parseFloat(String.valueOf((y1*x2-y2*x1)/(Math.pow(x2, 2)-Math.pow(y2, 2))));
		return new Complex(a1, a2);
	}
	
	/**
	 * toString
	 */
	public String toString() {
		String ans="";
		if(a!=0)
			ans=String.valueOf(a);
		if(b!=0) {
			if(a==0)
				ans=String.valueOf(b)+"i";
			else
				ans+="+"+String.valueOf(b)+"i";
		}
		return ans;
	}
}
