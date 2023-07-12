package trabalho1POO;

import java.math.BigDecimal;

public class CarroEsportivo extends Veiculo{
	
	public CarroEsportivo() {
		this.setFreio(new FreiosABS());
		this.setTanqueCombustivel(new TanqueCombustivel());
		this.getTanqueCombustivel().setCapacidadeMaxima(new BigDecimal("80"));
	}
	
	@Override
	public void andar(BigDecimal distancia, BigDecimal velocidade) {
		BigDecimal consumo = velocidade.compareTo(new BigDecimal("120")) < 0 ? new BigDecimal("10") : new BigDecimal("5");
		BigDecimal quantidadeGasolina = distancia.divide(consumo);
		if(this.getTanqueCombustivel().consumir(quantidadeGasolina)) {
			this.getFreio().usarFreios(distancia, velocidade);
	    }
	    
	    
	}
}
