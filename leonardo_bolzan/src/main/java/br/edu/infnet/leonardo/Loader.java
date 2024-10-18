package br.edu.infnet.leonardo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.leonardo.model.domain.Canal;
import br.edu.infnet.leonardo.model.domain.Narrador;
import br.edu.infnet.leonardo.model.domain.Partida;
import br.edu.infnet.leonardo.model.domain.Time;
import br.edu.infnet.leonardo.model.service.PartidaService;

@Component
public class Loader implements ApplicationRunner {

	@Autowired
	private PartidaService partidaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Time timeCasa = new Time("Internacional", "INT");
		Time timeVisitante = new Time("Grêmio", "GRE");
		Partida partida = new Partida("c5fc3a53-45ce-4add-b4f4-94835fabf55d", timeCasa, timeVisitante, LocalDateTime.now(), "Estádio Beira-Rio");

		Narrador narrador = new Narrador("Paulo Brito", "Futebol do RS");
		Canal canal = new Canal("Globo RS", 8, narrador);
		partida.addCanal(canal);

		narrador = new Narrador("Milton Leite", "Futebol nacional");
		canal = new Canal("SporTV", 38, narrador);
		partida.addCanal(canal);
		
		partidaService.AddPartida(partida);
		
		/*
		FileReader file = new FileReader("files/data.txt");
		BufferedReader buffer = new BufferedReader(file);
		
		String line = buffer.readLine();
		
		Partida partida = null;
		
		while (line != null) {
			System.out.println(line);
			
			String[] fields = line.split("|");

			switch (fields[0].toUpperCase()) {
			case "PT":
				partida = new Partida(fields[1], null, null, null, fields[2]);
				partidaService.AddPartida(partida);
				break;
			case "TC":
				Time timeCasa = new Time(fields[1], fields[2]);
				partida.setTimeCasa(timeCasa);
				break;
			case "TV":
				Time timeVisitante = new Time(fields[1], fields[2]);
				partida.setTimeVisitante(timeVisitante);
				break;
			case "CN":
				Narrador narrador = new Narrador(fields[3], null);
				Canal canal = new Canal(fields[1], Integer.parseInt(fields[2]), narrador);
				partida.addCanal(canal);
				break;
			default:
				break;
			}
			
			line = buffer.readLine();
		}
		
		buffer.close();
		*/
	}
}
