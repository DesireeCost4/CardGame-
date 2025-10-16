#  Card Game Engine (Java)

Este projeto implementa a **lógica central de um jogo de cartas por turnos**, inspirado em TCGs como *Magic: The Gathering*.  
Desenvolvido inteiramente em **Java puro**, o foco está em aplicar **Programação Orientada a Objetos (POO)** e estruturar uma **mecânica de batalha funcional**, antes da integração com frameworks como Spring Boot ou Angular.

---

##  Objetivo

Criar uma base sólida para um jogo de cartas digital, onde dois jogadores se enfrentam utilizando criaturas e magias, com controle de turnos, pontos de vida e mana.

---

##  Funcionalidades

- Sistema completo de **jogadores** (`Jogador`) com vida, mana, mão e baralho  
- **Cartas** de diferentes tipos: `Card`, `Criatura`, `Magia`  
- **Campo de batalha** que armazena as cartas jogadas (`Campo`)  
- **Fluxo de jogo** controlado pela classe `Game`, com alternância de turnos  
- **Condições de vitória** por vida zerada ou baralho vazio  
- **Simulação no console**, permitindo visualizar a execução da lógica

---

##  Estrutura de classes

| Classe | Responsabilidade |
|--------|------------------|
| `Card` | Classe base das cartas |
| `Criatura` | Define criaturas com ataque e defesa |
| `Magia` | Define magias com efeitos simples |
| `Jogador` | Gerencia mão, baralho, campo e ações do jogador |
| `Campo` | Representa o campo de batalha de cada jogador |
| `Game` | Controla o fluxo geral do jogo, turnos e jogadas |

---

##  Execução

Clone o repositório e compile o projeto:

```bash
git clone https://github.com/DesireeCost4/CardGame-.git
cd cardgame-backend
javac -d bin src/**/*.java
java -cp bin app.Main
