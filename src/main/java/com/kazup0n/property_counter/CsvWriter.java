package com.kazup0n.property_counter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

final class CsvWriter {
	
	private CsvWriter(){}
	
	static String write(File file, List<String> lines) throws IOException{
		try(BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF8"))){
			for(String line: lines){
				out.write(line + "\n");
			}
		}
		return file.getCanonicalPath();
	}
	
}
