package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.PagadorImposto;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<PagadorImposto> lista = new ArrayList<>();

		System.out.print("Digite o numero de contribuintes: ");
		int contribuintes = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= contribuintes; i++) {
			System.out.println("Dados do contribuinte #" + i + ":");
			System.out.print("Individual ou Companhia (i/c)? ");
			char c = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Renda Anual: ");
			double renda = sc.nextDouble();
			if (c == 'i') {
				System.out.print("Gastos com saude: ");
				double gasto = sc.nextDouble();
				lista.add(new PessoaFisica(nome, renda, gasto));
			} else {
				System.out.print("Numero de Funcionarios: ");
				int num = sc.nextInt();
				lista.add(new PessoaJuridica(nome, renda, num));
			}
		}

		System.out.println();
		System.out.println("IMPOSTOS PAGOS: ");
		for (PagadorImposto p : lista) {
			System.out.println(p.getNome() + ": $ " + String.format("%.2f", p.taxa()));
		}

		System.out.println();
		double acm = 0;
		for (PagadorImposto p : lista) {
			acm += p.taxa();
		}
		System.out.println("IMPOSTOS TOTAIS: $ " + String.format("%.2f", acm));

		sc.close();
	}

}
