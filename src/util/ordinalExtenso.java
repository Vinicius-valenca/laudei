package util;

public class ordinalExtenso {
	private StringBuffer resultado = new StringBuffer();

	String milhar;

	private String Numeros[][] = {
			{ "primeiro", "segundo", "terceiro", "quarto", "quinto", "sexto", "sétimo", "oitavo", "nono" },
			{ "décimo ", "vigésimo ", "trigésimo ", "quadragésimo ", "quinquagésimo ", "sexagésimo ", "septuagésimo ",
					"octogésimo ", "nonagésimo " },
			{ "centésimo ", "ducentésimo ", "trecentésimo ", "quadrigentésimo ", "quinguentesimo ", "sexcentésimo ",
					"septicentésimo ", "octigentésimo ", "nonigentésimo " },
			{ "milésimo ", "milionésimo ", "bilionésimo " } };
	private String Milheiros[][] = {
			{ "um ", "dois ", "três ", "quatro ", "cinco ", "seis ", "sete ", "oito ", "nove " },
			{ "dez ", "vinte ", "trinta ", "quarenta ", "cinquente ", "sessenta ", "setenta ", "oitenta ", "noventa " },
			{ "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove" },
			{ "cento ", "duzentos ", "trezentos ", "quatrocentos ", "quinhentos ", "seiscentos ", "setecentos ",
					"oitocentos ", "novecentos " } };

	public ordinalExtenso() {

	}

	public ordinalExtenso(Integer dec) {
		this();
		setNumber(dec);
	}

	public ordinalExtenso(String valor) {
		this();
		setNumber(Integer.parseInt(valor));
	}

	public void setNumber(Integer dec) {
		String val = String.valueOf(dec);

		if (dec > 999 && dec < 10000) {

			resultado.append((setMilhar(val.substring(0, 1))));
			resultado.append(setCentena(val.substring(1, 2)).toLowerCase());
			resultado.append(setDecena(val.substring(2, 3)).toLowerCase());
			resultado.append(setUnidade(val.substring(3, 4)).toLowerCase());

		} else if (dec > 99 && dec < 1000) {

			resultado.append((setCentena(val.substring(0, 1))));
			resultado.append(setDecena(val.substring(1, 2)).toLowerCase());
			resultado.append(setUnidade(val.substring(2, 3)).toLowerCase());

		} else if (dec > 9 && dec < 100) {

			resultado.append((setDecena(val.substring(0, 1))));
			resultado.append(setUnidade(val.substring(1, 2)).toLowerCase());

		} else if (dec < 10) {

			resultado.append((setUnidade(val.substring(0))));

		} else
			resultado.append("Número Ordinal Invalido");
	}

	public String resultado() {
		return resultado.toString();
	}

	public static String primeiraMaiuscula(String palavra) {
		return palavra.substring(0, 1).toUpperCase() + palavra.substring(1);
	}

	private String setUnidade(String uni) {
		Integer unidade = Integer.parseInt(uni);

		switch (unidade) {
		case 1:
			return Numeros[0][0];
		case 2:
			return Numeros[0][1];
		case 3:
			return Numeros[0][2];
		case 4:
			return Numeros[0][3];
		case 5:
			return Numeros[0][4];
		case 6:
			return Numeros[0][5];
		case 7:
			return Numeros[0][6];
		case 8:
			return Numeros[0][7];
		case 9:
			return Numeros[0][8];
		default:
			return "";
		}
	}

	private String setDecena(String dec) {
		Integer unidade = Integer.parseInt(dec);

		switch (unidade) {
		case 1:
			return Numeros[1][0];
		case 2:
			return Numeros[1][1];
		case 3:
			return Numeros[1][2];
		case 4:
			return Numeros[1][3];
		case 5:
			return Numeros[1][4];
		case 6:
			return Numeros[1][5];
		case 7:
			return Numeros[1][6];
		case 8:
			return Numeros[1][7];
		case 9:
			return Numeros[1][8];
		default:
			return "";
		}
	}

	private String setCentena(String cen) {
		Integer unidade = Integer.parseInt(cen);

		switch (unidade) {
		case 1:
			return Numeros[2][0];
		case 2:
			return Numeros[2][1];
		case 3:
			return Numeros[2][2];
		case 4:
			return Numeros[2][3];
		case 5:
			return Numeros[2][4];
		case 6:
			return Numeros[2][5];
		case 7:
			return Numeros[2][6];
		case 8:
			return Numeros[2][7];
		case 9:
			return Numeros[2][8];
		default:
			return "";
		}
	}

	private String setMilhar(String mil) {
		Integer unidade = Integer.parseInt(mil);

		switch (unidade) {
		case 1:
			return Numeros[3][0];
		case 2:
			return Milheiros[0][1] + Numeros[3][0];
		case 3:
			return Milheiros[0][2] + Numeros[3][0];
		case 4:
			return Milheiros[0][3] + Numeros[3][0];
		case 5:
			return Milheiros[0][4] + Numeros[3][0];
		case 6:
			return Milheiros[0][5] + Numeros[3][0];
		case 7:
			return Milheiros[0][6] + Numeros[3][0];
		case 8:
			return Milheiros[0][7] + Numeros[3][0];
		case 9:
			return Milheiros[0][8] + Numeros[3][0];
		default:
			return "";
		}
	}
}