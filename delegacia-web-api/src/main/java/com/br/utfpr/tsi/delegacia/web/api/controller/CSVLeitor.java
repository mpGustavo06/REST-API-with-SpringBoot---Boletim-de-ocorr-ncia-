package com.br.utfpr.tsi.delegacia.web.api.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.stereotype.Component;
import com.br.utfpr.tsi.delegacia.web.api.model.BoletimFurto;
import com.br.utfpr.tsi.delegacia.web.api.model.Veiculo;

import lombok.Data;

@Data
@Component
public class CSVLeitor {
	 private Map<String, BoletimFurto> boletins = new HashMap<>();
	 
	 public CSVLeitor() {
		 this.boletins =  this.leitorCSV();
	 }
	 
	 public Map<String, BoletimFurto> leitorCSV() {
		 HashMap vehiclesMap = new HashMap<>();
		 
		 try 
		 {
			 Reader readerCSV = new FileReader("src/main/resources/furtos.csv");
			 
			 @SuppressWarnings("deprecation")
			 CSVParser parserCSV = CSVFormat.TDF.withFirstRecordAsHeader().withQuoteMode(QuoteMode.ALL).parse(readerCSV);
			 List<CSVRecord> registers = parserCSV.getRecords();
			 
			 Iterator registerIterator = registers.iterator();
			 
			 while(registerIterator.hasNext()) {
				 CSVRecord register = (CSVRecord)registerIterator.next();
				 Veiculo veiculo = this.veiculoDataProcessor(register);
				 
				 if (veiculo != null) {
					 BoletimFurto bof = this.crimeDataProcessor(register);
					 bof.setIdentificador(UUID.randomUUID().toString());
					 bof.setVeiculoFurtado(veiculo);
					 veiculo.setEnvolvidoEm(new BoletimFurto(UUID.randomUUID().toString()));
					 
					 vehiclesMap.put(veiculo.getEmplacamento().getCodigo(), bof);
				 }
			 }
			 
			 System.out.println("Veiculos processados: " + vehiclesMap.keySet().size());
		 } catch (IOException ioe) 
		 {
			 System.out.println("Não foi possível abrir o arquivo CSV!");
		 }
		 
		 Map<String, BoletimFurto> uniqueProcessedVehicles = new HashMap<>();
		 Collection<BoletimFurto> values = vehiclesMap.values();
		 Iterator uniqueVehiclesIterator = values.iterator();
		 
		 
		 return vehiclesMap;
	 }
}
