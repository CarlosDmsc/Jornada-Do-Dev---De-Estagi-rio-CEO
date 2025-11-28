# Jornada do Dev – Do Estagiário ao CEO

Um jogo em Java que simula a evolução de um desenvolvedor na carreira de TI, utilizando todos os pilares da Programação Orientada a Objetos.

## Objetivo do Jogo

O jogador começa como Estagiário e deve:

-Trabalhar em projetos;
-Estudar para ganhar XP;
-Enfrentar desafios do mundo real;
-Controlar cansaço e dias;
-Evoluir até atingir o cargo CEO;
-Tudo isso enquanto gerencia seus recursos (XP, cansaço e tempo).

# Funcionalidades Principais:

## Progressão de Cargo
A quantidade de XP necessária pra subir de cargo aumenta conforme o jogador progride:
Cargo Atual |	XP Necessário
Estagiário |	100 XP
Júnior |	200 XP
Pleno |	350 XP
Sênior |	500 XP
CEO |	—

## Sistema de Cansaço
-Cansaço aumenta conforme a atividade
-Ao atingir o limite → jogador deve escolher:
  Descansar (zera cansaço e avança o dia)
  Jogar Clash Royale (Easter Egg):
    -35% vitória → zera cansaço e não perde dia
    -65% derrota → perde XP e avança dias

## Projetos Polimórficos

Três tipos diferentes:
ProjetoWeb;
ProjetoMobile;
ProjetoIA;
(Cada um com sua dificuldade e XP.)

## Desafios Aleatórios

Durante projetos, há chance de eventos como:
  -Bug crítico
  -Servidor instável
  -Cliente mudando requisitos
  Que podem causar:
    -Perda de XP
    -Aumento de cansaço
    -Avanço de dias

## Arquitetura

Dev's Journey/
  src/
   ├─ Main.java
   └─ models/
      ├─ Desenvolvedor.java
      ├─ Projeto.java
      ├─ ProjetoWeb.java
      ├─ ProjetoMobile.java
      ├─ ProjetoIA.java
      ├─ Desafio.java
      └─ Carreira.java

# Conceitos de POO utilizados
## Abstração

Classes modelam elementos reais:
Desenvolvedor, Carreira, Projeto, Desafio

## Encapsulamento

Todos os atributos são privados
Acesso via métodos controlados (getters e ações)

## Herança

ProjetoWeb, ProjetoMobile e ProjetoIA herdam de Projeto

## Polimorfismo

Projeto é usado para manipular qualquer subclasse
Métodos como concluirProjeto() mudam dependendo da subclasse

## Coleções

ArrayList para:
habilidades
lista de projetos
HashMap para:
cargos e dias atingidos

## Como Executar

Instale o JDK 17+
Instale VS Code + extensão Extension Pack for Java
Compile e execute:
javac models/*.java Main.java
java Main

# Como Jogar

Escolha no menu:
Trabalhar
Estudar (leve / normal / intenso)
Descansar
Subir de cargo
Ver status
Sair

Gerencie bem:
XP
Cansaço
Dias
Riscos (desafios aleatórios + Clash Royale)

## Final do Jogo
O jogo mostra:
Quantos dias levou para alcançar cada cargo
Progresso total da carreira

# Autores:

Carlos Roberto - 00000853313, carlosmdev11@gmail.com - https://www.linkedin.com/in/damasceno-neto-377516306/ .
Bruno Cavalcanti - 00000853197, brunoc.wanderley07@gmail.com
