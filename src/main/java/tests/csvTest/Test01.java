package tests.csvTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Test01 {

	public static void main(String[] args) {
		
		String path_before = "C:\\Users\\이상성\\Desktop\\workspace\\Test\\src\\main\\webapp\\resources";
		String stored_path = path_before.replace('\\', '/');
		stored_path +="/Test01.csv";
		System.out.println(stored_path);
		
		File file = null;
		BufferedWriter bw = null;
		try {
			file = new File(stored_path);
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"MS949"));
			bw.write("번호,이름,지역");
			bw.write(System.lineSeparator());
			bw.write("1,김철수,서울");
			bw.write(System.lineSeparator());
			bw.write("2,김영희,경기");
			bw.write(System.lineSeparator());
			bw.write("3,이철희,경북");
			
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
