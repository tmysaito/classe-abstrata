package entities;

public class PessoaFisica extends PagadorImposto {

	private Double gastoSaude;

	public PessoaFisica() {
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastoSaude) {
		super(nome, rendaAnual);
		this.gastoSaude = gastoSaude;
	}

	public Double getGastoSaude() {
		return gastoSaude;
	}

	public void setGastoSaude(Double gastoSaude) {
		this.gastoSaude = gastoSaude;
	}

	@Override
	public Double taxa() {
		if (getRendaAnual() < 20000) {
			return (getRendaAnual() * 0.15) - (getGastoSaude() / 2);
		} else {
			return (getRendaAnual() * 0.25) - (getGastoSaude() / 2);
		}

	}

}
