import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;



class chamada {
    public static String[] alunos = new String[10];
    public static List<String> chamadas = new ArrayList<>();
    public static int indiceAluno = 0; // Novo índice para controlar o registro de alunos

	public static String presencaAluno = "FALTOU!";

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        limparConsole();

        System.out.println("|--- Menu ---|");
        System.out.println("|---BEM VINDO---|");
        System.out.println("| [1] - Gerenciar Alunos [2] - Gerenciar Chamadas [3] - Sair|");

        Scanner teclado = new Scanner(System.in);

        int opcao = teclado.nextInt();
        teclado.nextLine(); // Limpar o buffer de entrada

        switch (opcao) {
            case 1:
                menuGerenciaAlunos();
                break;

            case 2:
                gerenciarChamadasSubMenu();
                break;

            case 3:
                sair();
                break;

            default:
                System.out.println("opcao invalida! Por favor, insira uma opcao valida.");
                menu();
                break;
        }
    }

    public static void limparConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void menuGerenciaAlunos() {
        limparConsole();

        Scanner teclado = new Scanner(System.in);

        System.out.println("|--- Gerenciar Alunos ---|");
        System.out.println("| [1] - Adicionar alunos [2] - Ver Alunos [3] - Editar Aluno [4] - Remover Aluno [5] - Voltar |");

        int opcao = teclado.nextInt();
        teclado.nextLine(); // Limpar o buffer de entrada

        switch (opcao) {
            case 1:
                adicionarAlunos();
                break;

            case 2:
                exibirAlunos();
                break;

            case 3:
                editarAlunos();
                break;

            case 4:
                excluirAlunos();
                break;

            case 5:
                menu();
                break;

            default:
                System.out.println("opcao invalida! Por favor, insira uma opcao valida.");
                menuGerenciaAlunos();
                break;
        }
    }

    public static void adicionarAlunos() {
        limparConsole();

        Scanner teclado = new Scanner(System.in);

        boolean laco = true;

        while (laco && indiceAluno < alunos.length) {
            System.out.println("|--- Inserir Nome ---|");
            System.out.println("| Por favor, insira o nome do aluno: |");
            alunos[indiceAluno] = teclado.nextLine();
            indiceAluno++; // Incrementa o índice

            if (indiceAluno == alunos.length) {
                laco = false;
                System.out.println("| O maximo de alunos que você pode registrar é " + alunos.length + "!! |");
                System.out.println("| Pressione Enter para voltar. |");
                teclado.nextLine();
            } else {
                System.out.println("| Aluno registrado! |");
                System.out.println("| [1] - Adicionar outro aluno [0] - Voltar ao Menu                             |");
				
				if (!teclado.hasNextInt()) {
					System.out.println("| opcao selecionada invalida!                                                  |");
					teclado.nextLine(); // Limpar a entrada invalida

					// Exibir novamente a pergunta e aguardar uma entrada valida
					continue;
				} else {
					int opcao = teclado.nextInt();
					teclado.nextLine(); // Limpar o buffer de entrada

					if (opcao == 0) {
						laco = false;
						menuGerenciaAlunos();
					} else if (opcao == 1) {
						//System.out.println("| [1] - Adicionar outro aluno [0] - Voltar ao Menu           |");
						// Continuar adicionando outro aluno
					} else {
						System.out.println("| opcao selecionada invalida!");
						// Exibir novamente a pergunta e aguardar uma entrada valida
						continue;
					}
				}
            }
        }
    }

    public static void exibirAlunos() {
        limparConsole();

        System.out.println("|--- Alunos ---|");
        System.out.println("| Alunos registrados: |");

        for (String aluno : alunos) {
            if (aluno != null) {
                System.out.println("| " + aluno);
            }
        }

        System.out.println("| Pressione Enter para voltar. |");

        Scanner teclado = new Scanner(System.in);
        teclado.nextLine();

        menuGerenciaAlunos();
    }

    public static void editarAlunos() {
        limparConsole();

        Scanner teclado = new Scanner(System.in);

        System.out.println("|--- Editar Aluno ---|");
        System.out.println("| Alunos registrados: |");

        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null) {
                System.out.println("| [" + i + "] - " + alunos[i]);
            }
        }

        System.out.println("| Insira o numero do aluno que deseja editar: |");

        int opcao = teclado.nextInt();
        teclado.nextLine(); // Limpar o buffer de entrada

        if (opcao >= 0 && opcao < alunos.length && alunos[opcao] != null) {
            System.out.println("| Insira o novo nome do aluno: |");
            alunos[opcao] = teclado.nextLine();
            System.out.println("| Aluno editado com sucesso! |");
        } else {
            System.out.println("| opcao invalida. Por favor, insira uma opcao valida!   |");
        }

        System.out.println("| Pressione Enter para voltar. |");
        teclado.nextLine();

        menuGerenciaAlunos();
    }

    public static void excluirAlunos() {
        limparConsole();

        Scanner teclado = new Scanner(System.in);

        System.out.println("|--- Remover Aluno ---|");
        System.out.println("| Alunos registrados: |");

        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null) {
                System.out.println("| [" + i + "] - " + alunos[i]);
            }
        }

        System.out.println("| Insira o numero do aluno que deseja remover: |");

        int opcao = teclado.nextInt();
        teclado.nextLine(); // Limpar o buffer de entrada

        if (opcao >= 0 && opcao < alunos.length && alunos[opcao] != null) {
            alunos[opcao] = null;
            System.out.println("| Aluno removido com sucesso! |");
        } else {
            System.out.println("| opcao invalida! Por favor, insira uma opcao valida.   |");
        }

        System.out.println("| Pressione Enter para voltar. |");
        teclado.nextLine();

        menuGerenciaAlunos();
    }

    public static void gerenciarChamadasSubMenu() {
        limparConsole();

        Scanner teclado = new Scanner(System.in);

        System.out.println("|--- Gerenciar Chamadas ---|");
        System.out.println("| [1] - Fazer Chamada [2] - Ver Chamada [3] - Voltar   |");

        int opcao = teclado.nextInt();
        teclado.nextLine(); // Limpar o buffer de entrada

        switch (opcao) {
            case 1:
                fazerChamada();
                break;

            case 2:
                verChamadas();
                break;

            case 3:
                menu();
                break;

            default:
                System.out.println("opcao invalida! Por favor, insira uma opcao valida.");
                gerenciarChamadasSubMenu();
                break;
        }
    }

    public static void fazerChamada() {
	  limparConsole();
	  
	  Scanner teclado = new Scanner(System.in);
	  
	  System.out.println("|--- Fazer Chamada ---|");
	  System.out.println("| Alunos registrados: |");
	  
	 for (int i = 0; i < alunos.length; i++) {
		if (alunos[i] != null) {
			System.out.println("| [" + i + "] - " + alunos[i]);
			System.out.println("| Insira [1] - Presente ou [2] - Falta: |");
			int presenca = teclado.nextInt();
			
			
			if(presenca == 1){
			  presencaAluno = "PRESENTE";	
			}
		}
	}

	  
	  System.out.println("| Insira o numero  -1 para sair: |");
	  
	  int opcao = teclado.nextInt();
	  teclado.nextLine(); // Limpar o buffer de entrada
	  
	  
	 
	  if (opcao >= -1 && opcao < alunos.length) {
		if (opcao == -1) {
		  gerenciarChamadasSubMenu();
		} else if (alunos[opcao] != null) {
		  if (chamadas.contains(alunos[opcao])) {
			System.out.println("| Chamada ja registrada para o aluno: " + alunos[opcao]);
		  } else {
			chamadas.add(alunos[opcao]);
			System.out.println("| Chamada registrada para o aluno: " + alunos[opcao]);
		  }
		} else {
		  System.out.println("| Aluno nao existe. Por favor, insira um numero valido.");
		}
	  } else {
		System.out.println("| opcao invalida! Por favor, insira uma opcao valida.");
	  }
	  
	  System.out.println("| Pressione Enter para continuar. |");
	  teclado.nextLine();
	  
	  fazerChamada();
	
	}

   public static void verChamadas() {
	  limparConsole();
	  
	  System.out.println("|--- Chamada Registrada ---|");
	  System.out.println("| Chamadas realizadas: |");
	  
		 for (int i = 0; i < alunos.length; i++) {
			if (alunos[i] != null ) {
				System.out.println("| " + alunos[i] + " - " + presencaAluno + "          |");
				
			}
		}
	  
	  System.out.println("| Pressione Enter para voltar. |");
	  
	  Scanner teclado = new Scanner(System.in);
	  teclado.nextLine();
	  
	  gerenciarChamadasSubMenu();
	}

    public static void sair() {
		System.out.println("|--- Saindo do Programa.. ---|");
        limparConsole();
        System.exit(0);
    }
}