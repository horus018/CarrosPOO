package trabalho1POO;

import java.math.BigDecimal;

public class CarroSedan extends Veiculo {
	public CarroSedan() {
		this.setFreio(new FreiosTambor());
		this.setTanqueCombustivel(new TanqueCombustivel());
		this.getTanqueCombustivel().setCapacidadeMaxima(new BigDecimal("120"));
	}
	
	@Override
	public void andar(BigDecimal distancia, BigDecimal velocidade) {
		BigDecimal consumo = velocidade.compareTo(new BigDecimal("100")) < 0 ? new BigDecimal("25") : new BigDecimal("10");
		BigDecimal quantidadeGasolina = distancia.divide(consumo);
	    if(this.getTanqueCombustivel().consumir(quantidadeGasolina)) {
	    	this.getFreio().usarFreios(distancia, velocidade);
	    }
	    
	}
}
