package trabalho1POO;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

public class TanqueCombustivel {
	private BigDecimal capacidadeMaxima;
	private BigDecimal volumeAtual = new BigDecimal("1");
	private Combustivel combustivelUtilizado = Combustivel.GASOLINA;

	public boolean consumir(BigDecimal quantidade) {
		if (this.getVolumeAtual().subtract(quantidade).compareTo(new BigDecimal("0")) < 1) {
			JOptionPane.showMessageDialog(null, "Combustível insuficiente para o percurso!");
			return false;
		} else {
			this.setVolumeAtual(this.getVolumeAtual().subtract(quantidade));
			System.out.println("Combustível restante: " + this.getVolumeAtual() + " litros\nCombustível utilizado: " + quantidade + " litros");
			return true;
		}
	}

	public void receber(BigDecimal quantidade, Combustivel combustivel) {
		if (this.getCombustivelUtilizado() == combustivel) {
			if (this.getVolumeAtual().add(quantidade).compareTo(this.getCapacidadeMaxima()) == 1) {
				 
				System.out.println("Capacidade máxima do tanque atingida, você acabou desperdiçando "
						+ (this.getVolumeAtual().add(quantidade).subtract(this.getCapacidadeMaxima())) + " litros de "
						+ this.getCombustivelUtilizado());
				
				this.setVolumeAtual(this.getCapacidadeMaxima());
				
				System.out.println("Seu tanque foi abastecido, total de combustível: " + this.getCapacidadeMaxima()
                + " litros de " + this.getCombustivelUtilizado());
				
			} else {
				this.setVolumeAtual(this.getVolumeAtual().add(quantidade));
	            System.out.println("Seu tanque foi abastecido, total de combustível: " + this.getVolumeAtual()
	                    + " litros de " + this.getCombustivelUtilizado());
			}
		} else {
			
			this.setVolumeAtual(quantidade);
			this.setCombustivelUtilizado(combustivel);
			
			if (this.getVolumeAtual().compareTo(this.getCapacidadeMaxima()) == 1) {
				 
				System.out.println("Capacidade máxima do tanque atingida, você acabou desperdiçando "
						+ (this.getVolumeAtual().subtract(this.getCapacidadeMaxima())) + " litros de "
						+ this.getCombustivelUtilizado());
				
				this.setVolumeAtual(this.getCapacidadeMaxima());
				
				System.out.println("Seu tanque foi abastecido, total de combustível: " + this.getCapacidadeMaxima()
                + " litros de " + this.getCombustivelUtilizado());
				
			}else {
				System.out.println("Seu tanque foi abastecido, total de combustível: " + this.getVolumeAtual()
                + " litros de " + this.getCombustivelUtilizado());
			}

		}

	}

	public BigDecimal getCapacidadeMaxima() {
		return this.capacidadeMaxima;
	}

	public void setCapacidadeMaxima(BigDecimal capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}

	public BigDecimal getVolumeAtual() {
		return this.volumeAtual;
	}

	public void setVolumeAtual(BigDecimal volumeAtual) {
		this.volumeAtual = volumeAtual;
	}

	public Combustivel getCombustivelUtilizado() {
		return this.combustivelUtilizado;
	}

	public void setCombustivelUtilizado(Combustivel combustivelUtilizado) {
		this.combustivelUtilizado = combustivelUtilizado;
	}

}
