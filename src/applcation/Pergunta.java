package applcation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pergunta {

	private String enunciado;
	private List<Alternativa> alternativas;

	public Pergunta() {
		this.alternativas = new ArrayList<>();
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(String a) {

		// CRIA UMA ALTERNATIVA FALSE E ADICIONA NA LISTA
		Alternativa b = new Alternativa(a);
		alternativas.add(b);

	}

	private void setAlternativas(String a, boolean x) {

		// CRIA UMA ALTERNATIVA TRUE E ADICIONA NA LISTA
		Alternativa b = new Alternativa(a, x);
		alternativas.add(b);

	}

	public List<Pergunta> loadPerguntas() {

		// CRIAR UMA LISTA DE PERGUNTAS E RETORNA ELA

		List<Pergunta> perguntas = Arrays.asList(

				// 1 -
				criarObjPrgt(
						"Um modelo ________ descreve um banco de dados em termos de tabelas, colunas e jun��es entre tabelas.",
						"Relacional", "Orientado a Objetos", "De rede", "Hier�rquico", "Relacional"),

				// 2 -
				criarObjPrgt("Um(a) ______ � uma cole��o de registro", "tabela", "campo", "tabela", "coluna", "linha"),

				// 3 -
				criarObjPrgt("Que s�mbolo � usado para mostrar que um determinado atributo � obrigat�rio?", "*", "o",
						"*", "&", "#"),

				// 4 -
				criarObjPrgt(
						"Na nota��o UML, uma t�cnica (modelagem) que utiliza uma ferramenta que identifica o tipo de intera��o\n entre os envolvido com elipses (a��o), retas e agentes (pessoa/stick) envolvidos � conhecida por:",
						"Diagrama de Casos de Uso", "Diagrama de Contexto", "Diagrama de Entidades",
						"Diagrama de Casos de Uso", "Diagrama de Fluxo de Dados"),

				// 5 -
				criarObjPrgt(
						"Os(as) ___ s�o usadas(os) para enteder os processos de neg�cios, bem como\n a sua natureza, a fun��o, e o escopo de dados.",
						"regras de neg�cios", "regras de neg�cios", "metas", "processos", "declara��es de miss�o"),

				// 6 -
				criarObjPrgt(
						"Qual � o princ�pio pelo qual duas ou mais classes derivadas da mesma superclasse \npodem invocar m�todos que t�m a mesma assinatura, mas comportamentos distintos.",
						"Polimorfismo", "Heran�a", "Agrega��o", "Composi��o", "Polimorfismo"),

				// 7 -
				criarObjPrgt("Um Construtor para uma classe chamada Player em Java seria", "Player()", "Jogador()",
						"Pessoa()", "Jogador1()", "Player()"),

				// 8 -
				criarObjPrgt(
						"Para que os atributos de uma classe somente sejam acessadas por ela mesma \ne e suas classes filha, o modificador de acesso que deve ser usado �:",
						"Private", "Private", "Public", "Protected", "Static"),

				// 9 -
				criarObjPrgt(
						"Uma classe que n�o � instanciada e apenas fornece um modelo para gera��ode outras classes � denominada",
						"Classe Abstrata", "Subclasse", "Classe Construtora", "Classe Sobrescritas", "Classe Abstrata"),

				// 10 -
				criarObjPrgt("Os quatro pilares do paradigma de Orienta��o a Objetos s�o:",
						"Abstra��o, Encapsulamento, Heran�a e Polimorfismo.",
						"Sequenciamento, Procedimentos, Bibliotes e Heran�as.",
						"Heran�a, Polimorfismo, Classes e Objetos.", "Classes, Atributos, M�todos e Abstra��o.",
						"Abstra��o, Encapsulamento, Heran�a e Polimorfismo.")

		);

		return perguntas;

	}

	public Pergunta criarObjPrgt(String questao, String resp_C, String a, String b, String c, String d) {

		// METODO PRA CRIAR PERGUNTA PASSANDO OS PARAMETROS NECESSARIOS
		// resp_C DEVE SER IGUAL A ALGUMAS DAS ALTERNATIVAS
		// DESSA FORMA A ALTERNATIVA CERTA VAI TER SEU STATUS = TRUE

		Pergunta p = new Pergunta();

		p.setEnunciado(questao);

		String[] str = { a, b, c, d };

		for (String s : str) {

			if (resp_C.equals(s)) {
				p.setAlternativas(s, true);
			} else {
				p.setAlternativas(s);
			}

		}

		return p;

	}

	public String toString() {

		return "Enunciado: " + getEnunciado() + "\n1) " + alternativas.get(0).toString() + "\n2) "
				+ alternativas.get(1).toString() + "\n3) " + alternativas.get(2).toString() + "\n4) "
				+ alternativas.get(3).toString();

	}

}
