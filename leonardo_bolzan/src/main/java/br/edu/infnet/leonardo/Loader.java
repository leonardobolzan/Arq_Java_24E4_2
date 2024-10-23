package br.edu.infnet.leonardo;

import java.time.LocalDateTime;

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
		
		Time timeCasa = new Time("Internacional", "INT");
		timeCasa.addJogador(new Jogador("Rochet", 1, "GOL"));
		timeCasa.addJogador(new Jogador("", 2, "LD"));
		timeCasa.addJogador(new Jogador("", 6, "LE"));
		timeCasa.addJogador(new Jogador("", 3, "ZAG"));
		timeCasa.addJogador(new Jogador("", 4, "ZAG"));
		timeCasa.addJogador(new Jogador("", 5, "VOL"));
		timeCasa.addJogador(new Jogador("", 8, "VOL"));
		timeCasa.addJogador(new Jogador("", 10, "MC"));
		timeCasa.addJogador(new Jogador("", 11, "ME"));
		timeCasa.addJogador(new Jogador("", 7, "MD"));
		timeCasa.addJogador(new Jogador("", 9, "CA"));
		
		Time timeVisitante = new Time("Grêmio", "GRE");
		timeVisitante.addJogador(new Jogador("", 12, "GOL"));
		timeVisitante.addJogador(new Jogador("", 2, "LD"));
		timeVisitante.addJogador(new Jogador("", 6, "LE"));
		timeVisitante.addJogador(new Jogador("", 44, "ZAG"));
		timeVisitante.addJogador(new Jogador("", 4, "ZAG"));
		timeVisitante.addJogador(new Jogador("", 5, "VOL"));
		timeVisitante.addJogador(new Jogador("", 8, "VOL"));
		timeVisitante.addJogador(new Jogador("", 10, "MC"));
		timeVisitante.addJogador(new Jogador("", 11, "ME"));
		timeVisitante.addJogador(new Jogador("", 7, "MD"));
		timeVisitante.addJogador(new Jogador("", 99, "CA"));
		
		Partida partida = new Partida(timeCasa, timeVisitante, LocalDateTime.now(), "Estádio Beira-Rio");

		Narrador narrador = new Narrador("Paulo Brito", "Futebol do RS");
		Canal canal = new Canal("Globo RS", 8, narrador);
		partida.addCanal(canal);

		narrador = new Narrador("Milton Leite", "Futebol nacional");
		canal = new Canal("SporTV", 38, narrador);
		partida.addCanal(canal);
		
		partidaService.AddPartida(partida);
	}
}
