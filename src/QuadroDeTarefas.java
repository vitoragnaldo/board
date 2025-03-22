import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuadroDeTarefas {

    public static void main(String[] args) {
        List<String> tarefas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite a tarefa: ");
                    String tarefa = scanner.nextLine();
                    tarefas.add(tarefa);
                    break;
                case 2:
                    System.out.println("\nTarefas:");
                    for (int i = 0; i < tarefas.size(); i++) {
                        System.out.println((i + 1) + ". " + tarefas.get(i));
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}