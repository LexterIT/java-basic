import java.util.Scanner;

public class JavaBasic{

	static Scanner sc=new Scanner(System.in);

	public static void main(String[]args){

	 JavaBasic javaBasic=new JavaBasic();

	 int numberofAscii=93;
	 char asciiChar;
	 int textLength=3;
	 int charIndex;
	 int row,col;
	 String action;

	 System.out.println("Enter how many rows:");
	 row=sc.nextInt();

	 System.out.println("Enter how many columns:");
	 col=sc.nextInt();
	 sc.nextLine();

	 String[][]textTable=new String[row][col];

	 javaBasic.createTable(textTable,numberofAscii,textLength,row,col);

	 System.out.println("A table with random characters has been generated");

	 do {
		System.out.println("Press P for Print");
	 	System.out.println("Press S for Search");
	 	System.out.println("Press E for Edit");
	 	System.out.println("Press R for Reset");
	 	System.out.println("Press X for Exit");
	 	action=sc.nextLine();

	 	if(action.equalsIgnoreCase("p")) {
	 		javaBasic.printTable(textTable,row,col);
		}
		else if(action.equalsIgnoreCase("S")) {
			String textSearch;
			
			do {
				System.out.println("Enter the string you want to search");
				textSearch=sc.nextLine();
			}while (textSearch.equals(""));
				javaBasic.searchTable(textTable,textSearch);
		}
		else if(action.equalsIgnoreCase("E")) {
			javaBasic.editTable(textTable);
		}
		else if(action.equalsIgnoreCase("R")) {
			System.out.println("Enter how many rows:");
			row=sc.nextInt();
			System.out.println("Enter how many columns:");
			col=sc.nextInt();
			sc.nextLine();
			textTable=new String[row][col];

			javaBasic.createTable(textTable,numberofAscii,textLength,row,col);
			System.out.println("A table with random characters has been generated");
		}
	}while(!action.equalsIgnoreCase("X"));

	}

	public void createTable(String[][]textTable,int asciiChars,int textLength,int row,int col) {	
		char charVal;
	 for(int i=0;i<row;i++) {
	 	for(int a=0;a<col;a++) {
	 		String text="";

	 		for(int b=0;b<textLength;b++) {
	 			int value=33+(int)(Math.random()*asciiChars);
	 			charVal=(char)value;
	 			text+=charVal;
	 		}
	 		textTable[i][a]=text;
	 	}
	 }
	}

	public void printTable(String[][]textTable,int row,int col) {
		System.out.println("\n");
		for(int i=0;i<row;i++) {
			for(int a=0;a<col;a++) {
				System.out.print(textTable[i][a]+" | ");
	 		}
	 		System.out.println();
	 }
	 System.out.println("\n");
	}

	public void editTable(String[][]textTable) {
		int row,col;
		String value;

		System.out.println("Enter the row number");
		row=sc.nextInt();
		System.out.println("Enter the column number");
		col=sc.nextInt();
		sc.nextLine();

		System.out.println("The selected column value is "+textTable[row][col]);
		System.out.println("Enter the replacement value: ");
		value=sc.nextLine();
		textTable[row][col]=value;

	}

	public void searchTable(String[][]textTable,String text) {	
		String result="",comparison="",value;
		int occurencess;

		for(int i=0;i<3;i++) {
			for(int a=0;a<3;a++) {
				value=textTable[i][a];
				occurences=0;
				
				for(int b=0;b<=value.length()-text.length();b++) {
					comparison="";

						for(int c=0;c<text.length();c++) {
							comparison+=value.charAt(b+c);
						}
					
					if(comparison.equals(text)) {
						occurences+=1;
					}

				}
				
				if(occurences!=0) {
					result+="Occurences at ("+i+","+a+") is "+occurences+"\n";
				}
			}
		}
		if (result.equals("")) {
			System.out.println("\nThere are no occurences\n");
		}else{
		System.out.println(result);
		}
	}

}

//deleting directory rm -R (foldername)
//variable types instance declared inside a class, outside a method. local declared inside a method. static variable, static a variable declared static.
//non-access modifiers static, final, abstract, synchronized, transient, volatile
//capacity of datatypes
//non-primitive are data types that are created by the programmer not pre-defined by java. example Car car=new Car(); #2 converting data types.
//switch vs if : if checks for equality  and logical expressions, switch only equality 
//string[]args = isang parameter na kung saan ang kinukuhaan ng value is commandline/terminal
//ternary operators int1=10 int2=20 int higher = int1 >= int2 ? int1(true) : int2(false);
