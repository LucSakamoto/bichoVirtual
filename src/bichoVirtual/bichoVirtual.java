package bichoVirtual;

import java.util.Scanner;

public class bichoVirtual {

    private String nome;
    private String classe;
    private String familia;
    private int idade;
    private boolean estado;
    private int caloria;
    private int forca;

    public bichoVirtual(String nome, String classe, String familia) {
        this.nome = nome;
        this.classe = classe;
        this.familia = familia;
        this.idade = 0;
        this.estado = true;
        this.caloria = 10;
        this.forca = 10;
    }

    public void comer() {
        if (estado && caloria < 100) {
            caloria += 10;
            forca -= 2;
            if (caloria > 100) caloria = 100;
            System.out.println("O animal comeu e agora sua força é " + forca + " e suas calorias valem " + caloria + ".");
        } else if (!estado) {
            System.out.println("O animal está morto e não pode comer.");
        } else {
            System.out.println("O animal está cheio e não pode comer mais.");
        }
    }

    public void correr() {
        if (estado && caloria > 0) {
            forca -= 5;
            caloria -= 5;
            if (forca < 0) forca = 0;
            if (caloria < 0) caloria = 0;
            System.out.println("O animal está correndo!! Agora sua força é de " + forca + " e suas calorias valem " + caloria + ".");
        } else if (!estado) {
            System.out.println("O animal está morto e não pode correr.");
        } else {
            System.out.println("O animal está exausto e não tem calorias suficientes para correr.");
        }
    }

    public void dormir() {
        if (estado) {
            forca += 10;
            caloria -= 2;
            if (caloria < 0) caloria = 0;
            System.out.println("O animal está dormindo agora! Sua força aumentou para " + forca + " e suas calorias diminuíram para " + caloria + ".");
        } else {
            System.out.println("O animal está morto e não pode dormir.");
        }
    }

    public void morrer() {
        forca = 0;
        estado = false;
        System.out.println("O animal morreu!");
        System.out.println("GAME OVER!");
    }

    public void exibirDados() {
        System.out.println("O animal se chama " + nome + ", é da classe " + classe + " e da família " + familia + ".");
        System.out.println("O animal possui força " + forca + ", calorias de " + caloria + " e " + idade + " anos.");
    }

    public boolean isVivo() {
        return estado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Crie seu novo animal");
        System.out.print("Insira o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Insira a classe: ");
        String classe = scanner.nextLine();
        System.out.print("Insira a família: ");
        String familia = scanner.nextLine();

        bichoVirtual bicho = new bichoVirtual(nome, classe, familia);

        bicho.exibirDados();

        while (bicho.isVivo()) {
            System.out.println("\nO que o " + nome + " vai fazer agora?");
            System.out.println("1- Comer");
            System.out.println("2- Correr");
            System.out.println("3- Dormir");
            System.out.println("4- Morrer");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    bicho.comer();
                    break;
                case 2:
                    bicho.correr();
                    break;
                case 3:
                    bicho.dormir();
                    break;
                case 4:
                    bicho.morrer();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}