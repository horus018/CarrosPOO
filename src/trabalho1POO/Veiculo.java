package trabalho1POO;

import java.math.BigDecimal;

public abstract class Veiculo {
	private BigDecimal quilometragem;
	private Freio freio;
	private TanqueCombustivel tanqueCombustivel;

	public abstract void andar(BigDecimal distancia, BigDecimal velocidade);

	public void abastecer(BigDecimal quantidade, Combustivel combustivel) {
		this.tanqueCombustivel.receber(quantidade, combustivel);
	}

	public void arrumarFreios() {
		this.freio.arrumarFreios();
	}

	public BigDecimal getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(BigDecimal quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Freio getFreio() {
		return freio;
	}

	public void setFreio(Freio freio) {
		this.freio = freio;
	}

	public TanqueCombustivel getTanqueCombustivel() {
		return tanqueCombustivel;
	}

	public void setTanqueCombustivel(TanqueCombustivel tanqueCombustivel) {
		this.tanqueCombustivel = tanqueCombustivel;
	}

}
