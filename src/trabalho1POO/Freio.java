package trabalho1POO;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

public abstract class Freio {
	protected BigDecimal vidaUtilTotal;
	protected BigDecimal vidaUtilRestante;

	public void usarFreios(BigDecimal distancia, BigDecimal velocidade) {
		
		if (this.getVidaUtilRestante().subtract(distancia).compareTo(new BigDecimal("0")) < 1) {
			this.setVidaUtilRestante(new BigDecimal("0"));
			JOptionPane.showMessageDialog(null, "Seus freios acabaram");
		}else{
			this.setVidaUtilRestante(this.getVidaUtilRestante().subtract(distancia));
			System.out.println("Km de freios restantes: " + this.getVidaUtilRestante() + " km");
		}
		
	}

	public void arrumarFreios() {
		this.setVidaUtilRestante(this.getVidaUtilTotal());
		System.out.println("Freios arrumados, seu carro agora pode usar os freios por mais " + this.vidaUtilTotal + "km");
	}

	public BigDecimal getVidaUtilTotal() {
		return vidaUtilTotal;
	}

	public void setVidaUtilTotal(BigDecimal vidaUtilTotal) {
		this.vidaUtilTotal = vidaUtilTotal;
	}

	public BigDecimal getVidaUtilRestante() {
		return vidaUtilRestante;
	}

	public void setVidaUtilRestante(BigDecimal vidaUtilRestante) {
		this.vidaUtilRestante = vidaUtilRestante;
	}
	
	
}
