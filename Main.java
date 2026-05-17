public class Main {
    public static void main(String[] args) {

        ArvoreBinaria arvore = new ArvoreBinaria();

        // Mesma inserção do repositório
        arvore.inserir(0);
        arvore.inserir(-3);
        arvore.inserir(-5);
        arvore.inserir(-4);
        arvore.inserir(5);
        arvore.inserir(3);
        arvore.inserir(4);
        arvore.inserir(10);
        arvore.inserir(7);
        arvore.inserir(9);

        System.out.println("\n=== Árvore original ===");
        arvore.exibir("Em");

        // ---- CASO 1: Remoção de nó FOLHA (-4) ----
        System.out.println("\n--- Removendo nó FOLHA: -4 ---");
        arvore.remover(-4);
        arvore.exibir("Em");

        // ---- CASO 2: Remoção de nó com UM FILHO (-3 tem apenas filho esquerdo -5) ----
        System.out.println("\n--- Removendo nó com 1 FILHO: -3 ---");
        arvore.remover(-3);
        arvore.exibir("Em");

        // ---- CASO 3: Remoção de nó com DOIS FILHOS (5 tem esquerda=3 e direita=10) ----
        System.out.println("\n--- Removendo nó com 2 FILHOS: 5 ---");
        arvore.remover(5);
        arvore.exibir("Em");

        // ---- Caso extra: valor inexistente ----
        System.out.println("\n--- Tentando remover valor inexistente: 99 ---");
        arvore.remover(99);

        // ---- Percursos finais ----
        System.out.println("\n=== Estado final da árvore ===");
        arvore.exibir("Pre");
        arvore.exibir("Em");
        arvore.exibir("Pos");
    }
}

