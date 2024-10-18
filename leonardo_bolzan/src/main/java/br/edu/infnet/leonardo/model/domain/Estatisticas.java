package br.edu.infnet.leonardo.model.domain;

public class Estatisticas {
	private float percentualPosseBola;
    private int chutesAGol;
    private int faltasCometidas;
    private int cartoesAmarelos;
    private int cartoesVermelhos;

    public Estatisticas() {
        this.percentualPosseBola = 0;
        this.chutesAGol = 0;
        this.faltasCometidas = 0;
        this.cartoesAmarelos = 0;
        this.cartoesVermelhos = 0;
    }

    @Override
    public String toString() {
    	return "Estatísticas da partida.";
    }
    
	public float getPercentualPosseBola() {
		return percentualPosseBola;
	}

	public void setPercentualPosseBola(float percentualPosseBola) {
		this.percentualPosseBola = percentualPosseBola;
	}

	public int getChutesAGol() {
		return chutesAGol;
	}

	public void setChutesAGol(int chutesAGol) {
		this.chutesAGol = chutesAGol;
	}

	public int getFaltasCometidas() {
		return faltasCometidas;
	}

	public void setFaltasCometidas(int faltasCometidas) {
		this.faltasCometidas = faltasCometidas;
	}

	public int getCartoesAmarelos() {
		return cartoesAmarelos;
	}

	public void setCartoesAmarelos(int cartoesAmarelos) {
		this.cartoesAmarelos = cartoesAmarelos;
	}

	public int getCartoesVermelhos() {
		return cartoesVermelhos;
	}

	public void setCartoesVermelhos(int cartoesVermelhos) {
		this.cartoesVermelhos = cartoesVermelhos;
	}
}
