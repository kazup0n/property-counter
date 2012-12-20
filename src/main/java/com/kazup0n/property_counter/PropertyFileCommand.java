package com.kazup0n.property_counter;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;


@Component
public class PropertyFileCommand implements CommandMarker {

	@CliCommand(value="count")
	public String count(
			@CliOption(key={""}, mandatory = true, help= "the name of properties file") final  String file
	) {
		try{
			return String.valueOf(PropertyFileLineCounter.countEntries(new File(file)));
		}catch(IOException e){
			return "[ERROR] " + e.getMessage();
		}
	}
	
	@CliCommand(value="tsv")
	public String tsv(
			@CliOption(key={""}, mandatory = true, help= "the name of properties file") final String fileName
			){
		try{
			final File file = new File(fileName);
			final List<String> lines = PropertyFileReader.readAsCSV(file, "\t");
			final String csvFile = CsvWriter.write(new File(file.getName() + ".tsv") , lines);
			return String.format("%s lines written in %s", lines.size(), csvFile);
		}catch(IOException e){
			return "[ERROR] " + e.getMessage();
		}
	}
	
	
}
