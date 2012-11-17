package com.kazup0n.property_counter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;


public final class PropertyFileLineCounter {

	public static void main(String[] args){
		if(args.length == 0){
			System.out.println("no file name given");
			System.exit(-1);
		}
		try {
			final File file = new File(args[0]);
			System.out.format("%s\t%s\n", file,  countEntries(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	static long countEntries(File f) throws IOException{
		Properties p = new Properties();
		
		InputStreamReader reader = null;
		
		try{
			reader = new InputStreamReader(new FileInputStream(f), "UTF-8");
			p.load(reader);
			return p.entrySet().size();
		}finally{
			if(reader != null){
				reader.close();
			}
		}
	}
	
	
	
	
}