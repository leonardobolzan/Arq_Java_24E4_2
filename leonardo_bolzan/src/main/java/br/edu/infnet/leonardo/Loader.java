package br.edu.infnet.leonardo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.leonardo.model.domain.Canal;
import br.edu.infnet.leonardo.model.domain.Jogador;
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

		/// INT x GRE
		Partida partida = GetPartida1();
		partidaService.Add(partida);

		/// INT x FLA
		partida = GetPartida2();
		partidaService.Add(partida);

	}

	private Partida GetPartida1() {

		Time timeCasa = new Time("Internacional", "INT");
		timeCasa.addJogador(new Jogador("Rochet", 1, "GOL"));
		timeCasa.addJogador(new Jogador("Bruno Gomes", 15, "LAD"));
		timeCasa.addJogador(new Jogador("Clayton Sampaio", 20, "ZAD"));
		timeCasa.addJogador(new Jogador("Vitão", 44, "ZAE"));
		timeCasa.addJogador(new Jogador("Bernabei", 26, "LAE"));
		timeCasa.addJogador(new Jogador("Rômulo", 40, "VOL"));
		timeCasa.addJogador(new Jogador("Bruno Henrique", 8, "VOL"));
		timeCasa.addJogador(new Jogador("Alan Patrick", 10, "MEC"));
		timeCasa.addJogador(new Jogador("Gabriel Carvalho", 34, "MEC"));
		timeCasa.addJogador(new Jogador("Wesley", 21, "MEC"));
		timeCasa.addJogador(new Jogador("Borré", 19, "ATA"));

		Time timeVisitante = new Time("Grêmio", "GRE");
		timeVisitante.addJogador(new Jogador("Machesin", 1, "GOL"));
		timeVisitante.addJogador(new Jogador("João Pedro", 18, "LAD"));
		timeVisitante.addJogador(new Jogador("Jemerson", 28, "ZAE"));
		timeVisitante.addJogador(new Jogador("Rodrigo Ely", 5, "ZAD"));
		timeVisitante.addJogador(new Jogador("Mayk", 26, "LAE"));
		timeVisitante.addJogador(new Jogador("Dodi", 17, "VOL"));
		timeVisitante.addJogador(new Jogador("Villasanti", 20, "VOL"));
		timeVisitante.addJogador(new Jogador("Edenílson", 15, "VOL"));
		timeVisitante.addJogador(new Jogador("Cristaldo", 10, "MEC"));
		timeVisitante.addJogador(new Jogador("Aravena", 16, "MEC"));
		timeVisitante.addJogador(new Jogador("Braithwaite", 22, "ATA"));

		/// Cria a partida
		Partida partida = new Partida(timeCasa, timeVisitante, GetLocalDateTime("2024-10-19 16:00"),
				"Estádio Beira-Rio");

		/// Associa um canal à partida
		Narrador narrador = new Narrador("Paulo Brito", "Futebol do RS");
		Canal canal = new Canal("Globo RS", 8, narrador);
		partida.addCanal(canal);

		/// Associa outro canal à partida
		narrador = new Narrador("Milton Leite", "Futebol nacional");
		canal = new Canal("SporTV", 38, narrador);
		partida.addCanal(canal);

		return partida;
	}

	private Partida GetPartida2() {

		Time timeCasa = new Time("Internacional", "INT");
		timeCasa.addJogador(new Jogador("Rochet", 1, "GOL"));
		timeCasa.addJogador(new Jogador("Bruno Gomes", 15, "LAD"));
		timeCasa.addJogador(new Jogador("Rogel", 18, "ZAD"));
		timeCasa.addJogador(new Jogador("Vitão", 44, "ZAE"));
		timeCasa.addJogador(new Jogador("Bernabei", 26, "LAE"));
		timeCasa.addJogador(new Jogador("Rômulo", 40, "VOL"));
		timeCasa.addJogador(new Jogador("Thiago Maia", 29, "VOL"));
		timeCasa.addJogador(new Jogador("Alan Patrick", 10, "MEC"));
		timeCasa.addJogador(new Jogador("Bruno Tabata", 27, "MEC"));
		timeCasa.addJogador(new Jogador("Wesley", 21, "MEC"));
		timeCasa.addJogador(new Jogador("Borré", 19, "ATA"));

		Time timeVisitante = new Time("Flamengo", "FLA");
		timeVisitante.addJogador(new Jogador("Rossi", 1, "GOL"));
		timeVisitante.addJogador(new Jogador("Varela", 2, "LAD"));
		timeVisitante.addJogador(new Jogador("Fabrício Bruno", 15, "ZAD"));
		timeVisitante.addJogador(new Jogador("Léo Ortiz", 3, "ZAE"));
		timeVisitante.addJogador(new Jogador("Ayrton Lucas", 6, "LAE"));
		timeVisitante.addJogador(new Jogador("Everton Araújo", 52, "VOL"));
		timeVisitante.addJogador(new Jogador("Erick Pulgar", 5, "VOL"));
		timeVisitante.addJogador(new Jogador("Alcaraz", 37, "MEC"));
		timeVisitante.addJogador(new Jogador("Gerson", 8, "ATA"));
		timeVisitante.addJogador(new Jogador("Plata", 45, "ATA"));
		timeVisitante.addJogador(new Jogador("Bruno Henrique", 27, "ATA"));

		/// Cria a partida
		Partida partida = new Partida(timeCasa, timeVisitante, GetLocalDateTime("2024-10-30 19:00"),
				"Estádio Beira-Rio");

		/// Associa um canal à partida
		Narrador narrador = new Narrador("Paulo Brito", "Futebol do RS");
		Canal canal = new Canal("Canal do Baldasso", 8, narrador);
		partida.addCanal(canal);

		return partida;
	}

	private static LocalDateTime GetLocalDateTime(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		return LocalDateTime.parse(data, formatter);
	}
}
