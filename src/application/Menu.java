package application;
import set1.util.ScannerValidate;

public class Menu {

	public static void main(String[] args) {
		 boolean quit=true;
		 Verticle[] arr=new Verticle[100];
		 Project[] arrOne=new Project[100];
		 System.out.println("Enter the no of verticles you want");
		 int n=ScannerValidate.getValidInt();
		 do {
			 System.out.println("\n");

	    	 System.out.println("1>Read verticles and projects\n2>Display all Verticles and projects\n"
	    	 		+ "3>display all projects based on project type and project name\n"
	    	 		+ "4>Display project which has more team size\n5>Exit ");
			 System.out.println("\n");

	    	 int choice=ScannerValidate.getValidInt();
	    	 switch(choice)
	    	 {
	    	 case 1:
	    		 System.out.println("\n");
	    		 System.out.println("Enter the verticle and project details");
	    		 Verticle[] res= add(arr,n,arrOne);
	    		 display(res,arrOne);
	    		 break;
	    	 case 2:
	    		 display(arr,arrOne);
	    		 break;
	    	 case 3:
	    		 Project[] arrTwo=sortType(arrOne);
	    		 display(arrTwo);
	    		 break;
	    	 case 4: 
	    		 Project[] arrThree=more(arrOne);
	    		 display(arrThree);
	    		 break; 
	    	 case 5:
	    		 quit=false;
	    		 break;
	    		 
	    	 }
			 
		 }while(quit);
	}
	
	
	
	public static Verticle[] add(Verticle[] arr,int n,Project[] arrOne)
	{
		int c=0;
		Verticle obj=new Verticle();
		for(int i=0;i<n;i++)
		{
			System.out.println("enter Vericle Id");
			int id=ScannerValidate.getValidInt();
			System.out.println("enter Verticle name");
			ScannerValidate.scanner.nextLine();
			String name=ScannerValidate.getName();
			System.out.println("enter how many projects you want to add");
			int num=ScannerValidate.getValidInt();
			for(int j=0;j<num;j++) {
			System.out.println("enter Project Id");
			int idP=ScannerValidate.getValidInt();
			int count=0;
			for (Project p : arrOne) {
				if (arrOne == null || p == null) {
					count=0;
					break;
				} else if (p.getId() != 0 && idP == p.getId()) {
					System.out.println("this id already present :!");
					count=1;
					break;
				} else {
				}
			}
			if(count==0) {
			
			System.out.println("enter project name");
			ScannerValidate.scanner.nextLine();
			String pName=ScannerValidate.getString();
			System.out.println("enter Life cycle");
			String lifeCycle=ScannerValidate.getLifeCycle();
			System.out.println("enter project type");
			String pType=ScannerValidate.getProjectType();
			System.out.println("enter team size");
			int teamSize=ScannerValidate.getValidInt();
			System.out.println("enter number of tech used");
			int techSize=ScannerValidate.getValidInt();
			System.out.println("enter texhnologies");
			String pArr[]=new String[techSize];
			ScannerValidate.scanner.nextLine();
			for(int k=0;k<techSize;k++) {
			pArr[k]=(ScannerValidate.getTech());
			
			}
			String str="";
			for(int k=0;k<techSize;k++) {
				str+=pArr[k]+",";
				
			}
			String strOne[]=new String[100];
			strOne[i]=str;
			System.out.println("enter start date");
			String sDate=ScannerValidate.getValidDate();
			System.out.println("enter end date");
			String eDate=ScannerValidate.getValidDate();
			arrOne[c]=new Project(idP,pName,lifeCycle,pType,teamSize,strOne,sDate,eDate);
				c++;
			}
			
			else
			{
			
			}
			}
			
			arr[i]=new Verticle(id,name,num,arrOne);

		}
		
	return arr;	
	}
	
	public static Project[]  more(Project[] arr)
	{
	int count=0;
	int j=0;
	Project[] arrOne=new Project[100];
		for(int i=0;i<arr.length;i++)
		{

			if(arr==null || arr[i]==null)
			{
				break;
			}else
			{
				if(count<arr[i].getTeamSize())
				{
					count=arr[i].getTeamSize();
				}
			}
		}

		for(int i=0;i<arr.length;i++)
		{
			if(arr==null || arr[i]==null)
			{
				break;
			}else
			{
				if(count==arr[i].getTeamSize())
				{
					arrOne[j]=arr[i];
				j++;}
			}
		}
		return arrOne;
	}
	
	public static  Project[] sortType(Project[] arrOne)
{
		
		for(int i=0;i<arrOne.length-1;i++)
		{
			for (int j = i + 1; j < arrOne.length; j++) {
		if(arrOne==null || arrOne[i]==null ||arrOne[j]==null)
		{
			break;
		}
			else if (arrOne[i].getpType().compareTo(arrOne[j].getpType()) > 0) {
				Project temp = arrOne[j];
				arrOne[j] = arrOne[i];
				arrOne[i] = temp;
			}
			}
		}
		for(int i=0;i<arrOne.length-1;i++)
		{
			for (int j = i + 1; j < arrOne.length; j++) {
		if(arrOne==null || arrOne[i]==null ||arrOne[j]==null)
		{
			break;
		}
			else if (arrOne[i].getpType().compareTo(arrOne[j].getpType()) ==0) {
				if(arrOne[i].getName().compareTo(arrOne[j].getName()) > 0) {
				Project tempOne = arrOne[j];
				arrOne[j] = arrOne[i];
				arrOne[i] = tempOne;
				}
			}
			}
		}
		
	return arrOne;
	
}
	public static void display (Verticle[] arr,Project[] arrOne) {
		
		int n=0;
		for(int i=0;i<arr.length;i++)
		{
			
			if(arr==null || arr[i]==null)
			{
				break;
			}
			else
				System.out.println("verticle details are");
				System.out.println(arr[i].getId()+"\t"+arr[i].getName()+"\t");
			displayOne(arrOne,arr[i].getSize(),n);
			n+=arr[i].getSize();
		}
	}
	public static void displayOne (Project[] arr,int n,int s) {

		for(int i=s;i<n+s;i++)
		{
			if(arr==null || arr[i]==null)
			{
				break;
			}
			else
				System.out.println(arr[i].getId()+"\t"+arr[i].getName()+"\t"+arr[i].getLifeCycle()+"\t"
						 +"\t"+arr[i].getTeamSize()+"\t"+arr[i].getpType()+"\t"
						+arr[i].getStartDate()+"\t"+arr[i].getEndDate());
			String[] a=new String[100];
			a=arr[i].getTechnology();
			for(int j=0;j<arr[i].getTechnology().length;j++)
			{
				if(a[j]==null)
				{
					break;
				}
				else if(a[j]!=null) {
				System.out.print(a[j]);
				}
			}
			System.out.print("\n");
		
			
		}
	}

	
	public static void display(Project[] arr) {
		for(int i=0;i<arr.length;i++)
		{
			if(arr==null || arr[i]==null)
			{
				break;
			}
			else
				System.out.println(arr[i].getId()+"\t"+arr[i].getName()+"\t"+arr[i].getLifeCycle()+"\t"
						 +"\t"+arr[i].getTeamSize()+"\t"+arr[i].getpType()+"\t"
						+arr[i].getStartDate()+"\t"+arr[i].getEndDate());
			String[] a=new String[100];
			a=arr[i].getTechnology();
			for(int j=0;j<arr[i].getTechnology().length;j++)
			{
				if(a[j]==null)
				{
					break;
				}
				else if(a[j]!=null) {
				System.out.print(a[j]);
				}
			}
			System.out.print("\n");
		}
	}
	
}
