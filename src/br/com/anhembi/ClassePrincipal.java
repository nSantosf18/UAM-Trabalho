package br.com.anhembi;

/**
 *
 * @authors Leonardo, Rodrigo, Nicolas, Lucas e Gabriel
 */
public class ClassePrincipal {
    
    // Exemplo de método que em vez de usar System.out.println eu só uso o método criado na linha 21
    static void print_msg(String msg)
    {
        System.out.println(msg + '\n');
    }
    
    // Exemplo 2 dar o print no menu de forma mais eficiente. Chamem o método e testem!
    static void print_menu()
    {
        System.out.println("================================");
        System.out.println("1 - Cadastrar produto\n" 
                          +"2 - Listar produtos\n"
                          +"3 - Vender produto\n"
                          +"4 - Relatório de vendas\n"
                          +"5 - Sair");
        System.out.println("================================");
    }
    
    public static void main(String[] args)
    {
        // Olá grupo essa é a nossa classe principal do trabalho 
        // Iremos usar métodos e vetores 
        
        // Chamando o método print_msg()
        print_msg("Digitem qualquer coisa e executem.");
        
        // Chamando o método print_menu()
        print_menu();
    }
}
