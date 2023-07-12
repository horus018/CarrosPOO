package trabalho1POO;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

public class Programa {

	public static void main(String[] args) {
		boolean continuar = true;
		CarroEsportivo carroEsportivo = new CarroEsportivo();
		CarroSedan carroSedan = new CarroSedan();

		while (continuar) {
			Object[] inicio = { "Escolher veículo", "Sair do programa" };

			int escolha = JOptionPane.showOptionDialog(null, "O que você deseja fazer?", "Menu principal",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, inicio, inicio[0]);

			if (escolha == 0) {

				Object[] carros = { "Carro Esportivo", "Carro Sedan" };

				escolha = JOptionPane.showOptionDialog(null, "Escolha um veículo", "Escolha de veículos",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, carros, carros[0]);

				if (escolha == 0) {
					if(!SistemaVeiculos(carroEsportivo)) {
						continuar = false;
					}

				} else if (escolha == 1) {
					if(!SistemaVeiculos(carroSedan)) {
						continuar = false;
					}

				} else {
					continuar = false;
				}

			} else {
				continuar = false;
			}
		}

	}

	public static boolean SistemaVeiculos(Veiculo tipoVeiculo) {
		BigDecimal kmConvertido;
		BigDecimal kmPorHoraConvertido;
		BigDecimal litrosConvertidos;

		Object[] opcoes = { "Abastecer", "Andar", "Arrumar os freios" };

		int escolha = JOptionPane.showOptionDialog(null, "O que você deseja fazer com o veículo?", "Escolha de opções",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

		if (escolha == 0) {
			String litros = JOptionPane.showInputDialog("Quantos litros?");
			Combustivel tipoCombustivel = tipoVeiculo.getTanqueCombustivel().getCombustivelUtilizado();

			if (litros == null) {
				return false;
			} else {
				try {
					litrosConvertidos = new BigDecimal(litros);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor inválido!");
					throw new RuntimeException("Não foi possivel converter o valor para um BigDecimal!");
				}

				Object[] combustivel = { "Gasolina", "Alcool", "Diesel" };

				escolha = JOptionPane.showOptionDialog(null, "Escolha um tipo de combustível", "Escolha de veículos",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, combustivel, combustivel[0]);

				if (escolha == 0) {
					tipoCombustivel = Combustivel.valueOf("GASOLINA");
				} else if (escolha == 1) {
					tipoCombustivel = Combustivel.valueOf("ALCOOL");
				} else if (escolha == 2) {
					tipoCombustivel = Combustivel.valueOf("DIESEL");
				} else {
					return false;
				}
				tipoVeiculo.abastecer(litrosConvertidos, tipoCombustivel);

			}

		} else if (escolha == 1) {
			String km = JOptionPane.showInputDialog("Quantos quilômetros você quer andar?");

			if (km == null) {
				return false;
			} else {
				try {
					kmConvertido = new BigDecimal(km);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor inválido!");
					throw new RuntimeException("Não foi possivel converter o valor para um BigDecimal!");
				}

				String kmPorHora = JOptionPane.showInputDialog("Quantos quilômetros por hora?");

				if (kmPorHora == null) {
					return false;
				} else {
					try {
						kmPorHoraConvertido = new BigDecimal(kmPorHora);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Valor inválido!");
						throw new RuntimeException("Não foi possivel converter o valor para um BigDecimal!");
					}

					tipoVeiculo.andar(kmConvertido, kmPorHoraConvertido);
				}
			}

		} else if (escolha == 2) {
			tipoVeiculo.arrumarFreios();
		} else {
			return false;
		}
		return true;
	}

}
