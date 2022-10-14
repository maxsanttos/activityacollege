package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Funcionario;

public class Index {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Funcionario> list = new ArrayList<>();

        // Exibindo o menu de opções
        Menu();
        System.out.print("Informa a sua opção: ");
        int op = sc.nextInt();

        do {
            double percenDesconto = 0.0;
            switch (op) {
                case 1:
                    System.out.println();
                    System.out.print("Informe a quantidade de funcionario a ser cadastrado: ");
                    int funcionario = sc.nextInt();

                    // Pegando as informações dos funcionario
                    for (int i = 1; i <= funcionario; i++) {

                        System.out.println();
                        System.out.println("Funcionario #"+i + ":");
                        System.out.println();
                        System.out.println("-------------------------------------------");
                        System.out.print("Nome funcionario: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.print("Cpf Funcionario: ");
                        String cpfFuncionario = sc.nextLine();
                        System.out.print("Informe o salario Bruto do funcionario: ");
                        double salBruto = sc.nextDouble();
                        
                        porcentagem();
                        System.out.println("-------------------------------");
                        System.out.print("Porcentual de Desconto:");
                        int opPercentual = sc.nextInt();
                        System.out.println("-------------------------------");
                        if (opPercentual == 1) {
                            percenDesconto = 0.075;
                            list.add(new Funcionario(name,cpfFuncionario,salBruto,percenDesconto));
                        }else if (opPercentual == 2) {
                            percenDesconto = 0.09;
                            list.add(new Funcionario(name, cpfFuncionario, salBruto, percenDesconto));
                        }else if (opPercentual == 3) {
                            percenDesconto = 0.12;
                            list.add(new Funcionario(name, cpfFuncionario, salBruto, percenDesconto));
                        }else if (opPercentual == 4) {
                            percenDesconto = 0.14;
                            list.add(new Funcionario(name, cpfFuncionario, salBruto, percenDesconto));
                        }else{
                            System.out.println("Percentual invalido!");
                            Menu();
                            System.out.print("Informa a sua opção: ");
                            op = sc.nextInt();
                        }
                    }
                case 2:
                    // Lista as informações dos funcionarios
                    System.out.println("INFORMACAO DOS FUNCIONARIOS:");
                    for (Funcionario fun : list) {

                        System.out.println();
                        System.out.println("Nome: "+ fun.getName());
                        System.out.println("Cpf: "+ fun.getCpf());
                        System.out.println("Salario Bruto: "+ fun.getSalBruto());
                        System.out.println("Valor de Desconto: "+ fun.valorDesconto());
                        System.out.println("Salario Liquido: " + fun.salarioLiquido());
                    }
                    Menu();
                    System.out.print("Informa a sua opção: ");
                    op = sc.nextInt();
                    break;
                default:
                    System.out.println("OPCAO INVALIDA!");
                    Menu();
                    System.out.print("Informa a sua opção: ");
                    op = sc.nextInt();
                    break;
            }
        } while (op != 3);
        sc.close();
        System.out.println("Saindo do Systema!");
    }

    // funções de Menu e porcentagem
    public static void Menu(){
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println("1 - Cadastrar Funcionario");
        System.out.println("2 - Listar informações do funcionario");
        System.out.println("3 - Sair");
        System.out.println("---------------------------------------------");
        System.out.println();
    }
    public static void porcentagem(){
        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println("    Salario               | Alíquota");
        System.out.println("1 R$ 1.045,00             | 7,5%");
        System.out.println("2 R% 1.045,01 a R$2089,60 | 9%");
        System.out.println("3 R$ 2.089,61 a 3.134,40  | 12%");
        System.out.println("4 R$ 3.134,41 a 6.101,06  | 14%");
        System.out.println("----------------------------------------------");
        System.out.println();

    }
}
