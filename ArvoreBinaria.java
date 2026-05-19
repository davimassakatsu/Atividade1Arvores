public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
        System.out.println("Árvore Binária criada com sucesso!");
    }

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

    //remoção
    public void remover(Integer conteudo) {
        if (estaVazia()) {
            System.out.println("Árvore vazia. Nada a remover.");
            return;
        }
        this.raiz = removerRecursivo(this.raiz, conteudo);
    }


    private No removerRecursivo(No atual, Integer conteudo) {

        // caso base: chegou ao fim sem encontrar o valor
        if (atual == null) {
            System.out.println("Valor " + conteudo + " não encontrado na árvore.");
            return null;
        }

        // navega para a esquerda se o valor é menor
        if (conteudo < atual.getConteudo()) {
            atual.setEsquerda(removerRecursivo(atual.getEsquerda(), conteudo));

        // Navega para a direita se o valor é maior
        } else if (conteudo > atual.getConteudo()) {
            atual.setDireita(removerRecursivo(atual.getDireita(), conteudo));

        // encontrou o nó a ser removido
        } else {

            // caso1 – nó folha (sem filhos)
            if (atual.getEsquerda() == null && atual.getDireita() == null) {
                System.out.println("Nó folha " + conteudo + " removido com sucesso.");
                return null;
            }

            // caso 2a – só filho direito
            if (atual.getEsquerda() == null) {
                System.out.println("Nó " + conteudo + " (filho único direito) removido com sucesso.");
                return atual.getDireita();
            }

            // caso 2a – só filho esquerdo
            if (atual.getDireita() == null) {
                System.out.println("Nó " + conteudo + " (filho único esquerdo) removido com sucesso.");
                return atual.getEsquerda();
            }

            // caso3 – dois filhos: substitui pelo sucessor menor dos dentre os maiores
            No sucessor = encontrarSucessor(atual.getDireita());
            System.out.println("Nó " + conteudo + " (dois filhos) substituído pelo sucessor "
                    + sucessor.getConteudo() + " e removido com sucesso.");

            // seta o conteudo do sucessor para o nó atual
            atual.setConteudo(sucessor.getConteudo());

        // remove sucessor da sub-árvore direita, necessariamente simples
            atual.setDireita(removerRecursivo(atual.getDireita(), sucessor.getConteudo()));
        }

        return atual;
    }

        //encontra sucessor (menor dos maiores
    private No encontrarSucessor(No no) {
        No atual = no;
        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }
        return atual;
    }


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

