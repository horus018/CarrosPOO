package trabalho1POO;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

public class FreiosTambor extends Freio {

	public FreiosTambor() {
		this.vidaUtilTotal = new BigDecimal("1000");
		this.vidaUtilRestante = new BigDecimal("1000");
	}

	@Override
	public void usarFreios(BigDecimal distancia, BigDecimal velocidade) {
		
		if(velocidade.compareTo(new BigDecimal("99")) > 0){
			distancia = distancia.multiply(new BigDecimal("2"));
		}
		
		if (this.getVidaUtilRestante().subtract(distancia).compareTo(new BigDecimal("0")) < 1) {
			this.setVidaUtilRestante(new BigDecimal("0"));
			System.out.println("Km de freios restantes: " + this.getVidaUtilRestante() + " km");
			JOptionPane.showMessageDialog(null, "Seus freios acabaram");
		} else {
			this.setVidaUtilRestante(this.getVidaUtilRestante().subtract(distancia));
			System.out.println("Km de freios restantes: " + this.getVidaUtilRestante() + " km");
		}

	}
}
