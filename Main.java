public class Main {
    public static void main(String[] args) {

        ArvoreBinaria arvore = new ArvoreBinaria();

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

        // ---- caso 1 - nó folha ----
        System.out.println("\n--- Removendo nó FOLHA: -4 ---");
        arvore.remover(-4);
        arvore.exibir("Em");

        // ---- caso 2 - apenas 1 filho ----
        System.out.println("\n--- Removendo nó com 1 FILHO: -3 ---");
        arvore.remover(-3);
        arvore.exibir("Em");

        // ---- caso 3 - nó com 2 filhos ----
        System.out.println("\n--- Removendo nó com 2 FILHOS: 5 ---");
        arvore.remover(5);
        arvore.exibir("Em");

        // ---- caso a mais - valor inexistente ----
        System.out.println("\n--- Tentando remover valor inexistente: 99 ---");
        arvore.remover(99);

        // ---- percursos finais ----
        System.out.println("\n=== Estado final da árvore ===");
        arvore.exibir("Pre");
        arvore.exibir("Em");
        arvore.exibir("Pos");
    }
}

