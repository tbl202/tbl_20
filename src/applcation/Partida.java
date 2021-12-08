package applcation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Partida {

	Scanner sc = new Scanner(System.in);

	List<Jogador> listJ = null;
	List<Pergunta> perguntas = null; 
	Pergunta p = null;

	public Partida() {
		this.perguntas = new ArrayList<>();
		this.listJ = new ArrayList<>();
		this.p = new Pergunta();
		p.loadPerguntas(perguntas);
	}

	public void mostrarPerguntas() {

		System.out.println("Pergunta: ");

	}

	/*
	 * metodo - inicializar jogo chama os metodos em * cadastrar Jogador mostrar
	 * MenuPersonagem escolher Personagem definirJogador escolherPergunta mostrar
	 * pergunta e alternativas verificar acerto/erro
	 * 
	 * 
	 * metodo - mostrarMenuInicial (inicializar jogo, desenvolvedores, sair)
	 * 
	 * metodo - cadastrar jogador (pedir para usuario informar dados - nickname)
	 * 
	 * metodo - mostrar MenuPersonagem
	 * 
	 * metodo - escolher Personagem (setar no Jogador o Personagem dele)
	 * 
	 * metodo - definirJogador (Random para escolher quem come�a o jogo)
	 * 
	 * metodo - escolherPergunta (Random escolher uma pergunta na lista pergunta)
	 * 
	 * metodo - mostrarPergunta e alternativas
	 * 
	 * metodo - verificar Acerto ou Erro da quest�o (se errar chamar o metodo
	 * reduzir vida), passar a vez e verificar a vida pra saber se j� acabou
	 * 
	 * metodo - reduzir vida
	 * 
	 * metodo - verificar vida (se n tem vida acaba o jogo e chama metodo
	 * definirVencedor)
	 * 
	 * metodo - alternarJogador
	 * 
	 * metodo - definirVencedor
	 * 
	 */

	// Falta a linha final
	public void mostrarMenuInicial() {
		clearConsole();

		System.out.println("[1] Inicializar Jogo");
		System.out.println("[2] Desenvolvedor");
		System.out.println("[3] Explica��o do Jogo");
		System.out.println("[4] Sair");
		System.out.print("Informe sua escolha: ");
		int opcao = sc.nextInt();

		while (opcao > 4 || opcao < 1) {
			System.out.println("Dados invalidos. Tente outra vez.");
			System.out.print("Informe sua escolha: ");
			opcao = sc.nextInt();
		}

		if (opcao == 3) {
			explicacaoJogo();
		} else if (opcao == 2) {
			mostrarDesenvolvedores();
		} else if (opcao == 4) {
			System.exit(0);
		} else {
			start();
		}

	}

	private void explicacaoJogo() {

		int x = 0;
		while (x != 1) {
			clearConsole();
			System.out.println(
					"O Jogo � um quiz, no qual 2 jogadores jogar�o alternando seu turno, acertando ou errando as perguntas");
			System.out.println(
					"Voc� possuiu habilidades, no entanto, s� pode escolher 1 pra usar durante a partida.\nAp�s isso, n�o ter� mais nenhuma habilidade pro resto do jogo ");
			System.out.println("Perde quem Zerar (0) a vida primeiro");
			System.out.println("[1] Voltar");
			System.out.print("Escolha: ");

			x = sc.nextInt();
		}

		mostrarMenuInicial();
	}

	private void mostrarDesenvolvedores() {

		int x = 0;
		while (x != 1) {
			clearConsole();

			System.out.println("Desenvolvedores: ");
			System.out.println(". Arthur Gabriel Fernandes de Oliveira");
			System.out.println(". Arthur Latini");
			System.out.println(". Danilo Jorge da Silva");
			System.out.println(". Renato Henrique Lopes da Silva");
			System.out.println("[1] Voltar");
			System.out.print("Escolha: ");

			x = sc.nextInt();
		}

		mostrarMenuInicial();
	}

	private void start() {
		// Met�do que inicia a partida
		// OBS : ler os coment�rios acima para mais detalhes

		// 1 - Cadastrar Jogadores
		cadastroJogador();
		// 2/3 - Mostrar menu Personagem Escolher Personagem
		escolherPersonagem();
		// 4 - DefinirJogador (quem come�a a partida)
		// 5 - escolherPergunta
		// 6 - Mostrar Pergunta e alternativas
		// 7 - Verificar Acerto e Erro

	}

	private void cadastroJogador() {
		
		Scanner sc = new Scanner(System.in);
	
		if (listJ.size() != 0) {
			listJ.clear();
		}

		for (int i = 1; i < 3; i++) {

			System.out.print(i + "�" + " Jogador escolha seu nick: ");
			String nome = sc.nextLine();

			while (NomeEmUso(listJ, nome)) {
				System.out.print("O nome j� est� em uso. Tente outra vez: ");
				nome = sc.nextLine();
			}

			listJ.add(new Jogador(nome));
		}
		
		sc.close();
	}
	
	// M�todo pra verificar se o Nome j� est� em uso
	public static boolean NomeEmUso(List<Jogador> list, String nome) {

		Jogador j = list.stream().filter(x -> x.getNome() == nome).findFirst().orElse(null);
		return j != null;

	}

	public void escolherPersonagem() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
		List<Personagem> listTemporaria = null;
		criarPersonagens(listTemporaria);

		for (int i = 0; i < listJ.size(); i++) {
			System.out.println("Personagens: ");
			int cont = 1;
			for (Personagem pers : listTemporaria) {

				if (!pers.getStatus()) {
					System.out.println("[" + cont + "] " + pers.toString()); // Substituir por toString Personagem
				}

				cont++;
			}

			System.out.print("Jogador " + listJ.get(i).getNome() + "escolha seu Personagem: ");
			int opcao = sc.nextInt(); // colocar um while pra evitar erro
			listTemporaria.get(opcao).setStatus(true);
			listJ.get(i).setPersonagem(opcao, listTemporaria);
		}
		}
		
		catch (Exception ex) {}
		
		sc.close();
		
	}

	// Colocar uma lista de Parametro que vai apontar pra essa lista quano esse
	// m�todo fechar
	// A Lista p ser� utilizada no met�do escolherPersonagem
	public void criarPersonagens(List<Personagem> prs) {

		prs.add(new Personagem("Guerreiro"));
		prs.add(new Personagem("Arqueiro"));
		prs.add(new Personagem("Ca�ador"));
		prs.add(new Personagem("Mago"));
		prs.add(new Personagem("Silvio Santos"));

	}

	// Metodo pra deixar o console Clear
	public final static void clearConsole() {
		for (int i = 0; i < 15; ++i)
			System.out.println();
	}

}
