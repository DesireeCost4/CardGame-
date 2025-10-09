package model.jogador;

import model.baralho.Baralho;
import model.cards.Card;
import model.cards.Criatura;
import model.cards.Magia;
import model.cards.TipoMagia;
import game.Campo;


import java.util.ArrayList;
import java.util.List;

public class Jogador {

    //aqui setando os atributos básicos
    //mao não é model.baralho e sim as cartas que o model.jogador está em maos, vendo e acessando.
    private String nome;
    private int vida;
    private Baralho baralho;
    private List<Card> mao;
    private Campo campo;
    private int mana;


    //Declarando o construtor, pois irá fácilitar na hora de criar o obj
    public Jogador(String nome, Baralho baralho, Campo campo) {
        this.nome = nome;
        this.baralho = baralho;
        this.vida = 20;
        this.campo = campo;
        this.mao = new ArrayList<>();

    }

    //Metodo comprar card.
    // primeiro cria uma variavel do tipo CARD e armazena o valor randomico da função random.
    //em seguida se o valor NÃO for nulo ele adciona esse card random a mao. que é um arrayList
    //REFATORAÇÃO: REMOVI A CHAMADA AO RANDON AQUI E CHAMEI O METODO COMPRARCARD CRIADO NO BARALHO
    public void comprarCard() {
        Card card = baralho.comprarCard();

        if (card != null) {
            mao.add(card);
            System.out.println(nome + " comprou a carta: " + card.getName());
        }

    }

    //func. mostrar mão. imprime a quem pertence a mao
    // em seguida o loop for itera sobre cada card em ":" mao (que é um array)
    //chamando o metodo mostrarcard para imprimir a mão.
    public void mostrarMao() {
        System.out.println("💠 Mão de " + nome + ": ");


        // REFATORAÇÃO: ALTEREI PARA UM FOR DIFERENTE, POIS PRECISAVA ACESSAR O INDICE E ALÉM DE VER TODAS AS CARTAS EM LISTA VEJO OS NOMES E INDICE.
        for (int i = 0; i < mao.size(); i++) {

            Card card = mao.get(i);
            //mao.get(i).mostrarCard();
            System.out.println("  [" + i + "] 🎴 " + card.getName());
        }


    }

    // implementando o metodo de remoção de carta da mão, aqui encontrei um erro de indice
    //criei o if para validar se existe indice valido para ser acessado.
    public void jogarCard(int i, Jogador oponente) {
        if (i >= 0 && i < mao.size()) {
            Card card = mao.get(i);

            //REFATORADO, AGORA A CARTA SÓ É REMOVIDA APÓS VERIFICAÇÃO DE MANA

            // verifica se há mana suficiente
            if (gastarMana(card.getCustoMana())) {
                // só remove da mão se puder pagar ;)
                mao.remove(i);

                if (card instanceof Criatura) {
                    campo.adcionarCard(card);
                } else if (card instanceof Magia) {
                    Magia magia = (Magia) card;
                    Campo campoAlvo = (magia.getTipoMagia() == TipoMagia.ALIADO) ? this.campo : oponente.getCampo();

                    if (!campoAlvo.getCartasNoCampo().isEmpty()) {
                        Criatura alvo = (Criatura) campoAlvo.getCartasNoCampo().get(0);
                        magia.aplicarMagia(alvo);
                    } else {
                        System.out.println("Não há criaturas no campo alvo para aplicar a magia.");
                    }
                }
            } else {
                System.out.println("Mana insuficiente para jogar " + card.getName());
            }
        } else {
            System.out.println("Índice inválido! " + nome + " tem apenas " + mao.size() + " cartas na mão.");
        }
    }

    //get e set básico padron
    public String getName() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Baralho getBaralho() {
        return baralho;
    }

    public Campo getCampo() {
        return campo;
    }

    public List<Card> getMao() {
        return mao;
    }

    public int getMana() {
        return mana;
    }

    public void ganharMana(int quantidadeMana) {
        this.mana += quantidadeMana;
        System.out.println("Você ganhou " + quantidadeMana + " mana! Total: " + mana);
    }

    public boolean gastarMana(int custo) {
        if (mana >= custo) {
            mana -= custo;
            System.out.println("Gastou " + custo + " mana! Total: " + mana);
            return true;
        } else {
            System.out.println("Mana insuficiente, Precisa " + custo + " mana!");
            return false;
        }

    }

}
