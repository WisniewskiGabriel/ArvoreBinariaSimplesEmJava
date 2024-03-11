class NoArvore {
    int dado;
    NoArvore esquerda, direita;

    public NoArvore(int dado) {
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
    }
}

class ArvoreBinaria {
    private NoArvore raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public NoArvore inserirNoArvore(NoArvore arvore, int novoDado) {
        if (arvore == null) {
            return new NoArvore(novoDado);
        } else {
            if (novoDado < arvore.dado) {
                arvore.esquerda = inserirNoArvore(arvore.esquerda, novoDado);
            } else {
                arvore.direita = inserirNoArvore(arvore.direita, novoDado);
            }
            return arvore;
        }
    }

    public void inserirNo(int novoDado) {
        raiz = inserirNoArvore(raiz, novoDado);
    }

    private void exibirEsquerda(NoArvore arvore) {
        if (arvore != null) {
            exibirEsquerda(arvore.esquerda);
            System.out.print(arvore.dado + " ");
        }
    }

    public void exibirNosEsquerda() {
        exibirEsquerda(raiz);
    }

    private void exibirDireita(NoArvore arvore) {
        if (arvore != null) {
            exibirDireita(arvore.direita);
            System.out.print(arvore.dado + " ");
        }
    }

    public void exibirNosDireita() {
        exibirDireita(raiz);
    }

    public void exibirNos() {
        exibirNosEsquerda();
        exibirRaiz();
        exibirNosDireita();
    }

    public void exibirRaiz() {
        System.out.println("raiz " + raiz.dado);
    }
}
public class AtividadeArvoreBinaria {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        System.out.println("Digite os números para inserir na árvore:");

        for (int i = 0; i < 5; i++) {
            int numero = scanner.nextInt();
            arvoreBinaria.inserirNo(numero);
        }

        System.out.println("Exibindo árvore:");
        arvoreBinaria.exibirNos();
    }
}
