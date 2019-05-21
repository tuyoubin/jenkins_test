package data.ClientData;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class filetest {
	
//增客户
	public boolean writeFile(String a,String name,String numbering) {
		File file = new File("客户信息"+File.separator+name+"_"+numbering+"_"+"ClientInfo.txt");
		System.out.println("test");
		BufferedWriter writer=null;
		try {
			writer=new BufferedWriter(new FileWriter(file));
			
			writer.write(a);
			writer.flush();
			writer.close();
			return true; 
	
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
//读取客户	
	public String readFile(String name,String numbering) {
		

		try{
			
			File myFile=new File("客户信息"+File.separator+name+"_"+numbering+"_"+"ClientInfo.txt");

			FileReader fileReader=new FileReader(myFile);
			BufferedReader reader=new BufferedReader(fileReader);
			String line=reader.readLine();
			
			reader.close();
		
			return line;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return "呵呵，出错了";
	}
	
//删除客户	
	public void deleteFile(String name,String numbering){
		File myFile=new File("客户信息"+File.separator+name+"_"+numbering+"_"+"ClientInfo.txt");
		if(myFile.exists()){
			myFile.delete();
		}
		
		
	}
//修改客户	
	public boolean changeFile(String a,String name,String numbering){
		File file=new File("客户信息"+File.separator+name+"_"+numbering+"_"+"ClientInfo.txt");
		
		BufferedWriter writer=null;
		try {
			writer=new BufferedWriter(new FileWriter(file));
			
			writer.write(a);
			writer.flush();
			writer.close();
			return true; 
	
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
//读文件名	
	public String[] readFileList() {
		
		String result[];
		String r[] ={"出错了逗比"};
		
		File file=new File("客户信息");
		File[] list=file.listFiles();
		
		result = new String[list.length];
		try{
			for(int i=0;i<list.length;i++){
				result[i]=list[i].getName();
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return r;
		}
	}
	
	public boolean FindExist(String input){
		boolean result = false;
		int all = this.readFileList().length;
		String name[] =new String[all];
		String numbering[] =new String[all];
		
System.out.println(all);
		
		String store[]= new String[3]; 
		for(int i=0;i<all;i++){
			store = this.readFileList()[i].split("_");
			
			name[i] = store[0];
			numbering[i] =store[1];
		}
		
		for(int i=0;i<all;i++){
			if(input.equals(name[i])||input.equals(numbering[i]))
			result =true;
		}
		return result;
	}
	
	
//根据名称和编号查找信息
	/**
	 *
	 * @param input
	 * @return
	 */
	public String Info(String input){
		String result ="";
		String needed_name="";
		String needed_numbering="";
		int all = this.readFileList().length;
		String name[] =new String[all];
		String numbering[] =new String[all];
		
		String store[]= new String[3]; 
		for(int i=0;i<all;i++){
			store = this.readFileList()[i].split("_");
			name[i] = store[0];
			numbering[i] =store[1];
		}
		for(int i=0;i<all;i++){
			if(input.equals(name[i])||input.equals(numbering[i])){
				needed_name = name[i];
				 needed_numbering = numbering[i];
			}
		}
		
		result = this.readFile(needed_name, needed_numbering);
		return result;
		
	}
//返回所有的客户信息		
	public String[] getAll(){
		
		int all = this.readFileList().length;
		String result[] = new String[all];
		String name[] =new String[all];
		String numbering[] =new String[all];
		
		String store[]= new String[3]; 
		for(int i=0;i<all;i++){
			store = this.readFileList()[i].split("_");
			name[i] = store[0];
			numbering[i] =store[1];
		}
		for(int i=0;i<all;i++){
			result[i] =this.readFile(name[i], numbering[i]); 	
		}
		return result;
	}
	
	
	
}
