package com.itheima17.mobileguard.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/**
 *@创建者              杜鹏
 *创建时间          2016-9-19 下午6:00:25
 *@描述      TODO
 *
 *@版本        $Rev$
 *@更新者       $Author$
 *@更新时间     $Date$
 *@更新描述     TODO
 */
public class FileUtils {

	private static String	fileString;

	public static void filewrite(String fileName, String content) {   
        RandomAccessFile randomFile = null;  
        try {     
            // 打开一个随机访问文件流，按读写方式     
            randomFile = new RandomAccessFile(fileName, "rw");     
            // 文件长度，字节数     
            long fileLength = randomFile.length();     
            // 将写文件指针移到文件尾。     
            randomFile.seek(fileLength);     
            randomFile.writeBytes(content);      
        } catch (IOException e) {     
            e.printStackTrace();     
        } finally{  
            if(randomFile != null){  
                try {  
                    randomFile.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }
	
	public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
	
public static String readContent(String path){
		
		try {
			InputStream in = new FileInputStream(path);
			
			int len=0;
			byte[] buf = new byte[1024];
			while((len=in.read(buf))>0){
				fileString = new String(buf,0,len);
				System.out.println(fileString);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileString;
	}
}

