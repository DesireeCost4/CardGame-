package game;

import cards.Card;
import cards.Criatura;
import cards.Magia;
import cards.TipoMagia;
import jogador.Jogador;

public class Batalha {

    //Esse metodo inicialmente foi escrito no main, pois no momento fiquei confusa com a responsabilidade dele
    //porém é totalmente coerente que ele seja mantido aqui, pois além de ser parte fundamental da batalha, mantém o código limpo no main o fluxo tá bem mais claro agora.
    public void iniciarBatalha(Jogador jogadorAtacante, Jogador jogadorDefensor) {
        Campo campoAtacante = jogadorAtacante.getCampo();
        Campo campoDefensor = jogadorDefensor.getCampo();

        if (campoAtacante.getCartasNoCampo().isEmpty()) {
            System.out.println(jogadorAtacante.getName() + " não tem cartas para atacar!");
            return;
        }

        Card cartaAtacante = campoAtacante.getCartasNoCampo().get(0);

        // se o oponente não tiver cartas, o ataque é direto
        if (campoDefensor.getCartasNoCampo().isEmpty()) {
            if (cartaAtacante instanceof Criatura) {
                ataqueDireto((Criatura) cartaAtacante, jogadorDefensor);
            } else {
                System.out.println("Não é possível atacar diretamente com uma magia.");
            }
            return;
        }

        // há cartas dos dois lados
        Card cartaDefensor = campoDefensor.getCartasNoCampo().get(0);

        if (cartaAtacante instanceof Criatura && cartaDefensor instanceof Criatura) {
            resolverCombate((Criatura) cartaAtacante, (Criatura) cartaDefensor, campoAtacante, campoDefensor);

        } else if (cartaAtacante instanceof Magia) {
            Magia magia = (Magia) cartaAtacante;

            Campo campoAlvo;

            if (magia.getTipoMagia() == TipoMagia.ALIADO) {
                campoAlvo = campoAtacante;
            } else {
                campoAlvo = campoDefensor;
            }

            if (!campoAlvo.getCartasNoCampo().isEmpty()) {
                Card possivelAlvo = campoAlvo.getCartasNoCampo().get(0);

                if (possivelAlvo instanceof Criatura) {
                    Criatura alvo = (Criatura) possivelAlvo;
                    magia.aplicarMagia(alvo);
                } else {
                    System.out.println("Não há criaturas válidas para aplicar a magia " + magia.getName());
                }
            }
        }
    }


    public void usarMagiaEmCriatura(Criatura alvo, Magia magia) {
        System.out.println("Aplicando magia " + magia.getName() + " em " + alvo.getName());

        // recalculando atk e def da criatura
        alvo.setAtk(alvo.getAtk() + magia.getAtkBonus());
        alvo.setDef(alvo.getDef() + magia.getDefBonus());

        System.out.println(alvo.getName() + " agora tem ATK: " + alvo.getAtk()
                + " / DEF: " + alvo.getDef());
    }

    public void resolverCombate(Criatura atacante, Criatura defensor, Campo campoAtacante, Campo campoDefensor) {
        System.out.println(atacante.getName() + " ataca " + defensor.getName());

        if (atacante.getAtk() > defensor.getDef()) {
            System.out.println(defensor.getName() + " foi destruído!");
            campoDefensor.RemoverCard(defensor);
        }
        else if (atacante.getAtk() < defensor.getDef()) {
            System.out.println(atacante.getName() + " foi destruído!");
            campoAtacante.RemoverCard(atacante);
        }
        else {
            System.out.println("Ambas as criaturas foram destruídas!");
            campoAtacante.RemoverCard(atacante);
            campoDefensor.RemoverCard(defensor);
        }
    }

    public void ataqueDireto(Criatura atacante, Jogador alvo) {
        System.out.println(atacante.getName() + " ataca diretamente " + alvo.getName());
        alvo.setVida(alvo.getVida() -  atacante.getAtk());
        System.out.println(alvo.getName() + " agora tem " + alvo.getVida() + " de vida.");
    }

    }

