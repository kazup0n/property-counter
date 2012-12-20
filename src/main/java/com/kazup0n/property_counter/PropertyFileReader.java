package com.kazup0n.property_counter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.apache.commons.lang3.StringEscapeUtils.escapeCsv;

final class PropertyFileReader {

	static Properties read(File file) throws IOException{
		Properties p = new Properties();
		try(InputStreamReader reader = new InputStreamReader(new FileInputStream(file), "UTF-8")){
			p.load(reader);
			return p;
		}
	}
	
	static List<String> readAsCSV(File file, String sep) throws IOException{
		final Properties p = read(file);
		final List<String> lines = new ArrayList<>();
		for(Map.Entry<Object, Object> entry: p.entrySet()){
			lines.add(escapeCsv(entry.getKey().toString()) + sep + escapeCsv(entry.getValue().toString()));
		}
		return lines;
	}
	
	
}
