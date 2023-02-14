import static utils.ES.*;
import banco.ContaEspecial;

public class AppCaixa2 {
    private static ContaEspecial conta = new ContaEspecial("neymar", 1500, 3000);

    public static void main(String[] args) {
        print("## CAIXA ELETRÔNICA v2");
        boolean sair = false;
        while (!sair) {
            print("\n## MENU PRINCIPAL");
            print("(1) Consultar Saldo");
            print("(2) Depositar");
            print("(3) Sacar");
            print("(4) Consultar Limite");
            print("(5) Alterar Limite");
            print("(6) Mostrar Informações da conta");
            print("(7) Sair");
            int opcao = inputInt("\n## Escolha uma opção do menu:");
            if (opcao == 1) {
                opcaoConsultar();
            } 
            else if (opcao == 2) {
                opcaoDepositar();
            } 
            else if (opcao == 3) {
                opcaoSacar();
            }
            else if (opcao == 4) {
                opcaoConsultarLim();
            }
            else if (opcao == 5) {
                opcaoAlterarLim();
            }
            else if (opcao == 6) {
                opcaoMostrarInfo();
            }
            else if (opcao == 7) {
                sair = true;
            } 
            else {
                print("\n## OPÇÃO INVÁLIDA!");
            }
        }
        print("\n## Obrigado por usar nossos serviços!");
    }
    
    private static void opcaoConsultar() {
        print("\n## Saldo da conta: R$ " + conta.consultar());        
    }
    
    private static void opcaoDepositar() {
        double v = inputDouble("\n## Valor para depósito:");
        if (v + conta.consultar() < conta.consultarLimite()){
            conta.depositar(v);
            print("\n## Depósito efetuado!");
        }
        else {
            print("\n## Valor do deposito ultrapassa o limite");
        }    
    }

    private static void opcaoSacar() {
        double v = inputDouble("\n## Valor para saque:");
        if (conta.sacar(v)) {
            print("\n## Saque efetuado!");        
        }
        else {
            print("\n## Saldo insuficiente para efetuar o saque!");
        }
    }

    private static void opcaoConsultarLim(){
        print("\n## Limite da Conta: R$ " + conta.consultarLimite());
    }

    private static void opcaoAlterarLim(){
        double v = inputDouble("\n## Valor para Limite: ");
        conta.alterarLimite(v);
    }
        
    private static void opcaoMostrarInfo() {
        print("\n## Informações da conta:");
        print(conta.toString());
    }
}
