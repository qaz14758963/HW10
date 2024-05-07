	import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
	import java.util.Map;
	import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
	

	public class HW10 {

	public static void main(String[] args) {

	// TODO Auto-generated method stub
		
		File filecheck = new File("grades.csv");
		Map<String, Integer> grades = null;
		if(filecheck.exists()) loadFromFile(grades,"grades.csv");
		else 
			try {
				filecheck.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		
		
		
	String Sline; 
	int Iline=0;
	boolean loop =true;
	// 創建一個HashMap來存儲學生名字和對應的成績

	Map<String, Integer> grades1 = new HashMap<>();
	while(loop) {
		 

		int num=Iinput("請選擇功能:1.新增學生成績 2.查詢學生成績 3.修改學生成績 4.刪除學生成績 "
				+ "5.列出所有學生成績 99.結束:");
		
		
		switch (num){
		case 1:
			Sline=Sinput("請輸入學生姓名:");
			Iline=Iinput("請輸入學生分數:");
			grades1.put(Sline,Iline);
		    break;
		case 2:
			// 查找特定學生的成績
			String studentName = Sinput("請輸入學生姓名:");
			if (grades1.containsKey(studentName)) {

				System.out.println(studentName + "的成績是: " + grades1.get(studentName));

				} else {

				System.out.println("沒有找到" + studentName + "的成績。");

				}
			    break;
		case 3:
			
			// 更新學生的成績
			String e= Sinput("請輸入學生姓名:");
	        int u =Iinput("請輸入學生分數");
			
			grades1.put(e,u);

			System.out.println("更新後，"+e+"的成績是: " + grades1.get(e));
			break;
		case 4:
			// 移除一位學生的記錄
			String t= Sinput("請輸入學生姓名:");
			grades1.remove(t);

			System.out.println(t+"已刪除");
			break;
		case 5:
			// 打印所有學生的成績

			System.out.println("學生成績列表:");

			for (Map.Entry<String, Integer> entry : grades1.entrySet()) {

			System.out.println(entry.getKey() + ": " + entry.getValue());

			}
			break;
		case 99:
			loop=false;
			saveToFile(grades1,"grades.csv");
			break;

			


			
		
		  }
		 }
	    }
	  

	 


	static int Iinput(String prompt) {
		  System.out.print(prompt);
		  Scanner scanner = new Scanner(System.in);
		  int line=scanner.nextInt();
		  return line;
		
		
	}

	static String Sinput(String prompt) {
		  System.out.print(prompt);
		  Scanner scanner = new Scanner(System.in);
		  String line=scanner.nextLine();
		  return line;

	}
	static void loadFromFile(Map<String, Integer> grades,String filename) {
		try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
			String line;
			while((line = reader.readLine())!=null) {
				String[] parts = line.split(",");
				String name =parts[0];
				int grade = Integer.parseInt(parts[1]);
				grades.put(name,grade);
			}
		}catch (IOException e) {
			System.out.println("讀取檔案時發生錯誤:"+ e.getMessage());
			
		}
		
	}
	static void saveToFile(Map<String, Integer>grades ,String filename) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
			for(Map.Entry<String, Integer> entry : grades.entrySet()) {
				writer.write(entry.getKey()+","+entry.getValue());
				writer.newLine();
			}
		}catch (IOException e) {
			System.out.println("讀取檔案時發生錯誤:"+ e.getMessage());
		}
	}
	
	
	
	
	}
	
	