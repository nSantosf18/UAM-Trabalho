package br.com.anhembi;

import java.util.Scanner;

/**
 * @authors Leonardo, Rodrigo, Nicolas, Lucas e Gabriel
 */
public class ClassePrincipal {
    
    // Métodos 
    static void bannerSubmarinoYellow() {
        System.out.println("------------------ALUNOS--------------------\n" 
                           +"--------------------------------------------\n" 
                           +"|Nicolas dos Santos Ferreira | RA: 21044239|\n" 
                           +"|Leonardo de Sá Santos       | RA: 20936105| \n"
                           +"|Lucas Grosso                | RA: 21053184| \n"
                           +"|Rodrigo Torres Savone       | RA: 20530679| \n" 
                           +"|Gabriel Vitor               | RA: 21050781|\n" 
                           +"--------------------------------------------\n" );
        System.out.println(" ▛=============================================================================================▜");
        System.out.println("▍ ---------------------------------===== SUBMARINO YELLOW =====--------------------------------  ▍ ");
        System.out.println(" ▙=============================================================================================▟ \n");
    }
    static void menuSubmarinoYellow() {
        System.out.println("__________________________________________");
        System.out.println("1 - Cadastrar produto\n"
                + "2 - Listar produtos\n"
                + "3 - Vender produto\n"
                + "4 - Relatório de vendas\n"
                + "5 - Sair");
        System.out.println("__________________________________________");
    }
    static void listarProdutosCadastrados(String nomeProduto[], int codigos[], double valores[]) {
        // Verifcar primeiramente se o vetor está preechido corretamente
        if(codigos[0] != 0)
        {
            System.out.println("==== Listar Produtos ====\n");
            for (int i = 0; i < 10; i++) {
                if(codigos[i] != 0) {
                    System.out.println("=== PRODUTO " + (i+1) +  " ===\n"
                            + "NOME: " + nomeProduto[i] + '\n'
                            + "CÓDIGO: " + codigos[i] + '\n'
                            + "VALOR: R$ " + valores[i] + '\n');
                }
            }
        } else {
            System.out.println("ERRO! -> Não há produtos cadastrados!");
        }
    }
    static void venderProdutosListados(int codigos[], int vendas[], int codProcurado, int iterador) {
        boolean codAchado = true;   // Usado para verificar o código procurado

        if (codProcurado >= 1) {
            
            if (iterador <= 99) {
                
                for (int i = 0; i < 10; i++) {
                    // Verifica se o código foi encontrado no vetor
                    if (codigos[i] == codProcurado) {
                        codAchado = true;
                        break;
                    } else {
                        codAchado = false;
                    }
                }

                /* 
             *  Caso o código seja encontrado irá efetivar a venda do produto cadastrado pelo usuário.
             *  Verifica também o iterador caso tente ultrapassar o limete dele(100 vendas) ele emite um erro.
                 */
                if (codAchado == true) {
                    System.out.println("---> Compra efetivada com sucesso!");
                    vendas[iterador] = codProcurado;
                } else {
                    System.out.println("ERRO! -> Código não encontrado!");
                }
            } else {
                System.out.println("ERRO! -> Limite de vendas atingido!");
            }
            
        } else {
            System.out.println("ERRO! -> Código procurado inválido!");
        }
    }
    static void relatorioDosProdutos(String nomeProduto[], int codigos[], int vendas[], double valores[]) {

        int nDeVendas = 0;
        double valorTotalProduto = 0;
        double somaTotal = 0;
        
        // Verifica se o índice 0 do vetor codigos[] é maior que zero.
        if (codigos[0] >= 1) {
            System.out.println("==== Relatório de Vendas ====\n");
            for (int i = 0; i < 10; i++) {
                
                nDeVendas = 0;
                valorTotalProduto = 0;
                
                // Contador para verificar a quantidade de vezes que os códigos se repetem.
                for (int k = 0; k < 100; k++) {
                    if (vendas[k] == codigos[i]) {
                        nDeVendas = nDeVendas + 1;
                    }
                }
                
                valorTotalProduto = nDeVendas * valores[i]; // Valor total do produto (número de vendas x índice do vetor valores[]). 
                somaTotal = somaTotal + valorTotalProduto;  // Soma total de todos os produtos.

                if (codigos[i] != 0) {
                    System.out.println("--->CÓDIGO: " + codigos[i]
                            + "\nPRODUTO: " + nomeProduto[i]
                            + "\nNº DE VENDAS: " + nDeVendas
                            + "\nPREÇO: " + valores[i]
                            + "\nTOTAL: " + valorTotalProduto + "\n");
                }
            }
            System.out.println("=========================================");
            System.out.println("TOTAL GERAL DAS VENDAS: R$ " + somaTotal);
            System.out.println("=========================================");
        } else {
            System.out.println("ERRO! -> Não há produtos cadastrados!");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Variáveis
        char opcao        = 0;      // Opção digitada pelo usuário
        int itrCadastro   = 0;      // Contador para o método de cadastro
        int itrVender     = 0;      // Contador para o método de vendas
        int codProcurado  = 0;      // Código procura pelo usário
        boolean verifica  = true;   

        String nomeProduto[] = new String[10];
        int codigos[]        = new int[10];
        int vendas[]         = new int[100];
        double valores[]     = new double[10];
 

        // Banner do programa
        bannerSubmarinoYellow();
        
        // Verifica se pode continuar no while-loop se for FALSE(opção 5) ele sái do loop
        while (verifica){

            menuSubmarinoYellow();
            
            // Verifica a opção inserida pelo usuário.
            System.out.print("Digite uma opção: ");
            opcao = scan.next().charAt(0);
            
            // Válida a opção do usuário.
            if (opcao >= 1) {
                switch (opcao) {
                    case '1':
                        // Cadastro dos produtos 
                        // Verifica se a quantidade de produtos foi preenchida.
                        if (itrCadastro == 10) {
                            System.out.println("Quantidade de produtos(10) preenchida! ");
                        } else {
                            System.out.println("=== Cadastrar produto ===\n");
                            System.out.println("=== PRODUTO " + (itrCadastro + 1) + " === ");
                            System.out.print("Inserir nome: ");
                            nomeProduto[itrCadastro] = scan.next();
                            
                            if (!nomeProduto[itrCadastro].equals("")) {
                                System.out.print("Inserir um valor: ");
                                valores[itrCadastro] = scan.nextDouble();

                                if (valores[itrCadastro] >= 0.01) {
                                    codigos[itrCadastro] = (itrCadastro + 1);
                                    itrCadastro++;
                                    System.out.println("\n---> Cadastro realizado com sucesso!.");
                                } else {
                                    System.out.println("ERRO! -> Digite um valor maior que 0!");
                                }
                            }
                        }
                        break;

                    case '2':
                        listarProdutosCadastrados(nomeProduto, codigos, valores);
                        break;

                    case '3':
                        if (codigos[0] != 1) {
                            System.out.println("ERRO! -> Não há produtos cadastrados!");
                        } else {
                            listarProdutosCadastrados(nomeProduto, codigos, valores);
                            
                            System.out.print("Digite o codigo do produto para compra-lo: ");
                            codProcurado = scan.nextInt();
                            
                            venderProdutosListados(codigos, vendas, codProcurado, itrVender);
                            itrVender++;
                        }
                        break;

                    case '4':
                        relatorioDosProdutos(nomeProduto, codigos, vendas, valores);
                        break;

                    case '5':
                        verifica = false;
                        System.out.println("\n---=== Obrigado por usar o nosso aplicativo! ===---\n");
                        break;
                        
                    default:
                        System.out.println("Digite um opção válida!");
                        break;
                }
            } else {
                System.out.println("Digite uma opção válida!");
            }
        }
    }
}
