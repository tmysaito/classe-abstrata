package entities;

public class PessoaJuridica extends PagadorImposto {

	private int numeroFunc;

	public PessoaJuridica() {
	}

	public PessoaJuridica(String nome, Double rendaAnual, int numeroFunc) {
		super(nome, rendaAnual);
		this.numeroFunc = numeroFunc;
	}

	public int getNumeroFunc() {
		return numeroFunc;
	}

	public void setNumeroFunc(int numeroFunc) {
		this.numeroFunc = numeroFunc;
	}

	@Override
	public Double taxa() {
		if (getNumeroFunc() < 11) {
			return (getRendaAnual() * 0.16);
		} else {
			return (getRendaAnual() * 0.14);
		}
	}
}
