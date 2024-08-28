package com.br.utfpr.tsi.delegacia.web.api.controller;

import java.io.*;
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
import com.br.utfpr.tsi.delegacia.web.api.model.Endereco;
import com.br.utfpr.tsi.delegacia.web.api.model.Placa;
import com.br.utfpr.tsi.delegacia.web.api.model.Veiculo;

@Component
public class CSVLeitor {
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public Map<String, BoletimFurto> lerCSV() {
		Map<String, BoletimFurto> boletins = new HashMap<>();
		
		try 
		{
			Reader readerCSV = new FileReader("/furtos.csv");

			CSVParser parserCSV = CSVFormat.TDF.withFirstRecordAsHeader().withQuoteMode(QuoteMode.ALL).parse(readerCSV);
			
			List<CSVRecord> registers = parserCSV.getRecords();
			Iterator registerIterator = registers.iterator();
			
			while (registerIterator.hasNext()) {
				CSVRecord register = (CSVRecord) registerIterator.next();
				Veiculo veiculo = this.veiculoDataProcessor(register);

				if (veiculo != null) {
					BoletimFurto bof = this.crimeDataProcessor(register);
					bof.setIdentificador(UUID.randomUUID().toString());
					bof.setVeiculoFurtado(veiculo);
					veiculo.setEnvolvidoEm(new BoletimFurto(UUID.randomUUID().toString()));

					boletins.put(bof.getIdentificador(), bof);
				}
			}

			System.out.println("Boletins processados: " + boletins.size());
		} 
		catch (IOException ioe) 
		{
			System.out.println("Não foi possível abrir o arquivo CSV!");
			System.out.println("Favor adicionar o arquivo furtos.csv que se encontra na pasta src/main/resources no diretório C:/");
		}

		return boletins;
	}

	// Processamento dos dados dos Veiculos
	private Veiculo veiculoDataProcessor(CSVRecord record) {
		Veiculo furtado = null;
		String placaCodigo = record.get("PLACA_VEICULO");

		if (!placaCodigo.isBlank()) {
			furtado = new Veiculo();

			String placaUF = record.get("UF_VEICULO");
			String placaCidade = record.get("CIDADE_VEICULO");
			String cor = record.get("DESCR_COR_VEICULO");
			String marca = record.get("DESCR_MARCA_VEICULO");
			String tipo = record.get("DESCR_TIPO_VEICULO");

			int ano;
			try {
				ano = Integer.parseInt(record.get("ANO_FABRICACAO"));
			} catch (NumberFormatException e) {
				ano = 0;
			}

			Placa placa = new Placa(placaCodigo, placaUF, placaCidade);
			furtado.setEmplacamento(placa);
			furtado.setAnoFabricacao(ano);
			furtado.setCor(cor);
			furtado.setMarca(marca);
			furtado.setTipoVeiculo(tipo);
		}

		return furtado;
	}

	// Processamento dos dados dos Boletins de Ocorrencia
	private BoletimFurto crimeDataProcessor(CSVRecord record) {
		BoletimFurto registroCrime = new BoletimFurto();

		String crime = record.get("RUBRICA");
		String estado = record.get("UF");
		String cidade = record.get("CIDADE");
		String bairro = record.get("BAIRRO");
		String rua = record.get("LOGRADOURO");
		int numero = Integer.parseInt(record.get("NUMERO"));
		String periodo = record.get("PERIDOOCORRENCIA");
		String dataOcorrido = record.get("DATAOCORRENCIA");

		Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado);
		registroCrime.setLocalOcorrido(endereco);
		registroCrime.setDataOcorrido(dataOcorrido);
		registroCrime.setPeriodoOcorrido(periodo);
		registroCrime.setCrime(crime);

		return registroCrime;
	}
}
