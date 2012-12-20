package com.kazup0n.property_counter;

import java.io.File;
import java.io.IOException;


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
		return PropertyFileReader.read(f).entrySet().size();
	}
	
	
	
	
}