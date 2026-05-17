public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
        System.out.println("Árvore Binária criada com sucesso!");
    }

    // ------------------------------------------------------------------ inserção
    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);
        if (estaVazia()) {
            this.raiz = novoNo;
        } else {
            inserirRecursivo(novoNo, this.raiz);
        }
    }

    public void inserirRecursivo(No novoNo, No atual) {
        if (atual.getConteudo() > novoNo.getConteudo()) {
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novoNo);
                System.out.println("O nó " + novoNo.getConteudo() + " foi inserido na Árvore.");
                return;
            } else {
                inserirRecursivo(novoNo, atual.getEsquerda());
            }
        } else if (atual.getConteudo().equals(novoNo.getConteudo())) {
            System.out.println("Não é possível informar nós repetidos.");
        } else {
            if (atual.getDireita() == null) {
                atual.setDireita(novoNo);
                System.out.println("O nó " + novoNo.getConteudo() + " foi inserido na Árvore.");
                return;
            } else {
                inserirRecursivo(novoNo, atual.getDireita());
            }
        }
    }

    // ------------------------------------------------------------------ remoção
    /**
     * Método público de remoção — ponto de entrada.
     * Delega para o método recursivo e atualiza a raiz com o resultado.
     */
    public void remover(Integer conteudo) {
        if (estaVazia()) {
            System.out.println("Árvore vazia. Nada a remover.");
            return;
        }
        this.raiz = removerRecursivo(this.raiz, conteudo);
    }

    /**
     * Remove recursivamente o nó com o conteúdo informado e retorna
     * o nó que deve ocupar a posição do nó removido na árvore.
     *
     * Casos tratados:
     *   1. Nó folha         → retorna null (sem filhos).
     *   2. Nó com 1 filho   → retorna o filho sobrevivente.
     *   3. Nó com 2 filhos  → substitui pelo sucessor (menor dos maiores),
     *                          remove o sucessor da sub-árvore direita e
     *                          reconstrói o nó no lugar.
     */
    private No removerRecursivo(No atual, Integer conteudo) {

        // Caso base: chegou ao fim sem encontrar o valor
        if (atual == null) {
            System.out.println("Valor " + conteudo + " não encontrado na árvore.");
            return null;
        }

        // Navega para a esquerda se o valor é menor
        if (conteudo < atual.getConteudo()) {
            atual.setEsquerda(removerRecursivo(atual.getEsquerda(), conteudo));

        // Navega para a direita se o valor é maior
        } else if (conteudo > atual.getConteudo()) {
            atual.setDireita(removerRecursivo(atual.getDireita(), conteudo));

        // Encontrou o nó a ser removido
        } else {

            // CASO 1 – Nó folha (sem filhos)
            if (atual.getEsquerda() == null && atual.getDireita() == null) {
                System.out.println("Nó folha " + conteudo + " removido com sucesso.");
                return null;
            }

            // CASO 2a – Só filho direito
            if (atual.getEsquerda() == null) {
                System.out.println("Nó " + conteudo + " (filho único direito) removido com sucesso.");
                return atual.getDireita();
            }

            // CASO 2b – Só filho esquerdo
            if (atual.getDireita() == null) {
                System.out.println("Nó " + conteudo + " (filho único esquerdo) removido com sucesso.");
                return atual.getEsquerda();
            }

            // CASO 3 – Dois filhos: substitui pelo sucessor (menor dos maiores)
            No sucessor = encontrarSucessor(atual.getDireita());
            System.out.println("Nó " + conteudo + " (dois filhos) substituído pelo sucessor "
                    + sucessor.getConteudo() + " e removido com sucesso.");

            // Copia o conteúdo do sucessor para o nó atual
            atual.setConteudo(sucessor.getConteudo());

            // Remove o sucessor da sub-árvore direita (ele é necessariamente
            // simples: pode ter no máximo um filho à direita)
            atual.setDireita(removerRecursivo(atual.getDireita(), sucessor.getConteudo()));
        }

        return atual;
    }

    /**
     * Encontra o sucessor: o nó mais à esquerda de uma sub-árvore,
     * ou seja, o menor valor entre os maiores (menor dos maiores).
     */
    private No encontrarSucessor(No no) {
        No atual = no;
        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }
        return atual;
    }

    // ------------------------------------------------------------------ utilitários
    public boolean estaVazia() {
        return this.raiz.getConteudo() == null;
    }

    private void preOrdem(No no) {
        if (no == null) return;
        System.out.print(no.getConteudo() + " ");
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    private void emOrdem(No no) {
        if (no == null) return;
        emOrdem(no.getEsquerda());
        System.out.print(no.getConteudo() + " ");
        emOrdem(no.getDireita());
    }

    private void posOrdem(No no) {
        if (no == null) return;
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.print(no.getConteudo() + " ");
    }

    public void exibir(String percurso) {
        System.out.print("Percurso " + percurso + ": ");
        switch (percurso) {
            case "Pre": preOrdem(this.raiz);  break;
            case "Em":  emOrdem(this.raiz);   break;
            case "Pos": posOrdem(this.raiz);  break;
        }
        System.out.println();
    }
}

