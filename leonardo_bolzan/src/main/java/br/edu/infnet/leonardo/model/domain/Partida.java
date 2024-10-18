package br.edu.infnet.leonardo.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "TPartidas")
public class Partida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String identificador;
	
	@Transient
	private Time timeCasa;
    
	@Transient
	private Time timeVisitante;
    private LocalDateTime dataHoraInicio;
    private String local;
    private int placarCasa;
    private int placarVisitante;
    
    @Transient
    private Estatisticas estatisticasTimeCasa;
    
    @Transient
    private Estatisticas estatisticasTimeVisitante;
    
    @Transient
    private List<Canal> canais;
    
    public Partida(String identificador, Time timeCasa, Time timeVisitante, LocalDateTime dataHoraInicio, String local) {
        this.identificador = identificador;
    	this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
        this.dataHoraInicio = dataHoraInicio;
        this.local = local;
        this.placarCasa = 0;
        this.placarVisitante = 0;
        this.estatisticasTimeCasa = new Estatisticas();
        this.estatisticasTimeVisitante = new Estatisticas();
        this.canais = new ArrayList<Canal>();
    }

	@Override
    public String toString() {
    	return String.format("Partida iniciada em %s - %s vs %s.",
    			this.dataHoraInicio,
    			this.timeCasa.getNome(),
    			this.timeVisitante.getNome());
    }
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
    public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public Time getTimeCasa() {
		return timeCasa;
	}

	public void setTimeCasa(Time timeCasa) {
		this.timeCasa = timeCasa;
	}

	public Time getTimeVisitante() {
		return timeVisitante;
	}

	public void setTimeVisitante(Time timeVisitante) {
		this.timeVisitante = timeVisitante;
	}

	public String getDataHoraInicio() {
		return dataHoraInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}

	public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getPlacarCasa() {
		return placarCasa;
	}

	public void setPlacarCasa(int placarCasa) {
		this.placarCasa = placarCasa;
	}

	public int getPlacarVisitante() {
		return placarVisitante;
	}

	public void setPlacarVisitante(int placarVisitante) {
		this.placarVisitante = placarVisitante;
	}

	public Estatisticas getEstatisticasTimeCasa() {
		return estatisticasTimeCasa;
	}

	public void setEstatisticasTimeCasa(Estatisticas estatisticasTimeCasa) {
		this.estatisticasTimeCasa = estatisticasTimeCasa;
	}

	public Estatisticas getEstatisticasTimeVisitante() {
		return estatisticasTimeVisitante;
	}

	public void setEstatisticasTimeVisitante(Estatisticas estatisticasTimeVisitante) {
		this.estatisticasTimeVisitante = estatisticasTimeVisitante;
	}

	public List<Canal> getCanais() {
		return canais;
	}

	public void setCanais(List<Canal> canais) {
		this.canais = canais;
	}
	
	public void addCanal(Canal canal) {
		this.canais.add(canal);
	}
}
