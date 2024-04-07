
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author lucas
 */
public class AplicacaoBancaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = null;
        ContaBancaria conta = new ContaBancaria();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Digite seu nome:");
            String nome = scanner.nextLine();
            System.out.println("Digite seu sobrenome:");
            String sobrenome = scanner.nextLine();
            System.out.println("Digite seu CPF:");
            String cpf = scanner.nextLine();

            cliente = new Cliente(nome, sobrenome, cpf);

            while (true) {
                System.out.println("1. Consultar saldo");
                System.out.println("2. Depositar");
                System.out.println("3. Sacar");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opcao: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a linha restante do buffer

                switch (opcao) {
                    case 1 -> System.out.println("Saldo: " + conta.consultarSaldo());
                    case 2 -> {
                        System.out.print("Digite o valor do depósito: ");
                        double deposito = scanner.nextDouble();
                        scanner.nextLine(); // Consome a linha restante do buffer
                        conta.depositar(deposito);
                    }
                    case 3 -> {
                        System.out.print("Digite o valor do saque: ");
                        double saque = scanner.nextDouble();
                        scanner.nextLine(); // Consome a linha restante do buffer
                        conta.sacar(saque);
                    }
                    case 4 -> continuar = false;
                    default -> System.out.println("Opção inválida.");
                }
            }
        }

        scanner.close();
    }
}

class Cliente {
    private String nome;
    private String sobrenome;
    private String cpf;

    public Cliente(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    // Getters e Setters
}

class ContaBancaria {
    private double saldo;

    public ContaBancaria() {
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public double consultarSaldo() {
        return this.saldo;
    }
}
