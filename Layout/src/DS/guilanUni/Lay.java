package DS.guilanUni;
import java.util.ArrayList;
import java.util.Scanner;

public class Lay {

public static void main(String[] args) {
	Scanner input=new  Scanner(System.in);
	String str=input.next();//voroodi gerefte mishavad
cal(str);
}
/*
 * str:String voroodi ke majmooe ast
 * agar "{" vojood dashte bashad yani bayad majoome ra hal konad vagarna khodash hal shode ast va bayad return shavad
 * 
 */
public static int cal(String str) {
	int count=0;//shomarande baraye tashkhis va tafkike beracket haye aza az khode majoome
	int ans=0;//javab
	if(!str.contains("{")) {
		
	return Integer.parseInt(str);}
	else {
		//////////////////////////azaye majoome shenasayi mishavand va ba # dar yek String rikhte mishavand
		String listInString="";
	String tmp="";//tmp
	for(int i=0;i<str.length();i++) {
		
		if(str.charAt(i)==',' && count==1) {//agar count=1 bashad tanha berackete baz shode az khode majoome ast va virgool ham male majmooe ast

			listInString+=tmp+"#";//negahdarie ozv
			tmp="";
			continue;	
		}
		else if(str.charAt(i)=='}') {
			count--;
			if(count==0)//estesnaye be akhar residane majmoome(chon virgul nist)
				listInString+=tmp+"#";
				}
		else if(str.charAt(i)=='{') {
			count++;
			if(count==1)//estesnaye shoroo ke beracket bayad hazf shavad
				continue;}
			tmp+=str.charAt(i);
	}
	String[] list=listInString.split("#");//tafkike aza
	for(int i=0;i<list.length;i++ ) {
ans+=cal(list[i]);//har ozv dobare ba hamin tabe hal mishavad va haswl ha jam mishavand
	}
System.out.println(ans);//chap javab majmooe feli
	}
	return ans;
}
}
