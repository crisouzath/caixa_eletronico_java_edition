import java.util.Scanner;

class Main {
  static double saldo = 100;
  static String nome;
  static int senha = 3589;

  public static void ver_saldo() {
    verificar_senha();
    System.out.println("Seu saldo atual é: " + saldo);
    main(null);
  }

  public static void login() {
    System.out.println("Informe seu nome:");
    Scanner resposta = new Scanner(System.in);
    String usuario = resposta.nextLine();
    nome = usuario;
    System.out.println("Olá, " + nome + " é um prazer ter você aqui.");
    resposta.close();
  }

  public static void verificar_senha() {
    System.out.println("Informe a senha:");
    Scanner resposta = new Scanner(System.in);
    int senha_digitada = resposta.nextInt();
    if (senha_digitada == senha) {
      System.out.println("Senha correta");
    } else {
      main(null);
    }
    resposta.close();
  }

  public static void fazer_deposito() {
    verificar_senha();
    System.out.println("Qual o valor a ser depositado?");
    Scanner valor = new Scanner(System.in);
    Double deposito = valor.nextDouble();

    boolean checaNumero = deposito.isNaN(); 
    if (checaNumero || deposito <= 0) {
      System.out.println("Por favor, informe um número válido:");
      fazer_deposito();
    } else {
      saldo += deposito;
      ver_saldo();
    }

    valor.close();
  }

  public static void fazer_saque() {
    verificar_senha();
    System.out.println("Qual o valor para saque?");
    Scanner valor = new Scanner(System.in);
    Double saque = valor.nextDouble();

    boolean checaNumero = saque.isNaN();

    if (checaNumero || saque < 0) {
      System.out.println("Por favor, informe um número válido:");
      fazer_saque();
    } else if (saque > saldo) {
      System.out.println("Operação não autorizada");
      fazer_saque();
    } else {
      saldo -= saque;
      ver_saldo();

      valor.close();
    }
  }

  public static void ver_extrato() {
    verificar_senha();
    System.out.println("Saque de R$300,00. Depósito de R$4000");
    main(null);
  }

  public static void transferencia() {
    verificar_senha();
    System.out.println("Qual o valor para transferencia?");
    Scanner valor = new Scanner(System.in);
    Double transferencia_valor = valor.nextDouble();

     System.out.println("Para qual conta tranferir?");
     Scanner conta = new Scanner(System.in);
     Double numero_conta = conta.nextDouble();

    boolean checaNumero = transferencia_valor.isNaN();
    boolean checarConta= numero_conta.isNaN();

    if (checaNumero || checarConta || transferencia_valor <= 0 || transferencia_valor > saldo) {
      System.out.println("Por favor, informe um número válido:");
      transferencia();
    } else {
      saldo -= transferencia_valor;
      ver_saldo();

      valor.close();
    }
  }

  public static void erro() {
    System.out.println("Por favor, informe um número entre 1 e 6");
    main(null);
  }

  public static void sair() {
    System.out.println("Você deseja sair? S/N");

    Scanner sair = new Scanner(System.in);
    String escolha = sair.nextLine();

    if (escolha.equals("S")) {
      System.out.println(nome + ", foi um prazer ter você por aqui.");
      System.exit(0);
    } else if (escolha.equals("N")) {
      main(null);
    } else {
      System.out.println("Desculpe, mas não compreendi.");
      sair();
    }

    sair.close();

  }

  public static void main(String[] args) {
    login();

    System.out.println("Selecione uma opção 1.) Saldo 2.) Depósito 3.) Saque 4.) Extrato 5. ) Transferência 6. ) Sair");

    Scanner in = new Scanner(System.in);
    int escolha = in.nextInt();

     switch(escolha){
      case 1:
        ver_saldo();
        break;
      case 2:
        ver_extrato();
        break;
      case 3:
        fazer_saque();
        break;
      case 4:
         fazer_deposito();
        break;
      case 5:
         transferencia();
         break;
      case 6:
        sair();
        break;
      default:
        erro();
    }

    in.close();
  }

}