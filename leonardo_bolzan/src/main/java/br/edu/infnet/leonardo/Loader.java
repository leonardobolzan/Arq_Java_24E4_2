package br.edu.infnet.leonardo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.leonardo.model.domain.Canal;
import br.edu.infnet.leonardo.model.domain.Estatisticas;
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
		
		/// Define o time da casa
		Time timeCasa = new Time("Internacional", "INT");
		timeCasa.addJogador(new Jogador("Rochet", 1, "GOL"));
		timeCasa.addJogador(new Jogador("Bruno Gomes", 2, "LD"));
		timeCasa.addJogador(new Jogador("Bernabei", 6, "LE"));
		timeCasa.addJogador(new Jogador("Vitão", 44, "ZAG"));
		timeCasa.addJogador(new Jogador("Clayton Sampaio", 4, "ZAG"));
		timeCasa.addJogador(new Jogador("Fernando", 5, "VOL"));
		timeCasa.addJogador(new Jogador("Thiago Maia", 8, "VOL"));
		timeCasa.addJogador(new Jogador("Alan Patrick", 10, "MC"));
		timeCasa.addJogador(new Jogador("Wesley", 11, "ME"));
		timeCasa.addJogador(new Jogador("Bruno Tabata", 7, "MD"));
		timeCasa.addJogador(new Jogador("Borré", 9, "CA"));
		
		/// Define o time visitante
		Time timeVisitante = new Time("Grêmio", "GRE");
		timeVisitante.addJogador(new Jogador("Machesin", 12, "GOL"));
		timeVisitante.addJogador(new Jogador("João Pedro", 2, "LD"));
		timeVisitante.addJogador(new Jogador("Reinaldo", 6, "LE"));
		timeVisitante.addJogador(new Jogador("Rodrigo Ely", 3, "ZAG"));
		timeVisitante.addJogador(new Jogador("Jemerson", 4, "ZAG"));
		timeVisitante.addJogador(new Jogador("Dodi", 5, "VOL"));
		timeVisitante.addJogador(new Jogador("Villasanti", 8, "VOL"));
		timeVisitante.addJogador(new Jogador("Cristaldo", 10, "MC"));
		timeVisitante.addJogador(new Jogador("Soteldo", 7, "ME"));
		timeVisitante.addJogador(new Jogador("Aravena", 11, "MD"));
		timeVisitante.addJogador(new Jogador("Braithwaite", 9, "CA"));
		
		/// Cria a partida
		Partida partida = new Partida(timeCasa, timeVisitante, LocalDateTime.now(), "Estádio Beira-Rio");

		/// Associa um canal à partida
		Narrador narrador = new Narrador("Paulo Brito", "Futebol do RS");
		Canal canal = new Canal("Globo RS", 8, narrador);
		partida.addCanal(canal);

		/// Associa outro canal à partida
		narrador = new Narrador("Milton Leite", "Futebol nacional");
		canal = new Canal("SporTV", 38, narrador);
		partida.addCanal(canal);
		
		/// Inicializa as estatísticas do time da casa
		var estatisticasTimeCasa = new Estatisticas();
		partida.setEstatisticasTimeCasa(estatisticasTimeCasa);

		/// Inicializa as estatísticas do time visitante
		var estatisticasTimeVisitante = new Estatisticas();
		partida.setEstatisticasTimeVisitante(estatisticasTimeVisitante);
		
		partidaService.Add(partida);
	}
}
