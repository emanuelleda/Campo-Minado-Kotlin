# 💣 Campo Minado (Minesweeper) - Kotlin Swing

Um clássico jogo de Campo Minado desenvolvido em **Kotlin** utilizando a biblioteca gráfica **Swing**. O projeto foi construído seguindo princípios de orientação a objetos e o padrão de arquitetura **Observer** para a comunicação entre a lógica do tabuleiro e a interface gráfica.

## 🕹️ Como Jogar

O objetivo é descobrir todos os campos que não contêm minas sem detonar nenhuma delas.

- **Clique Esquerdo:** Abre um campo. Se houver uma mina, você perde! Se estiver vazio, revelará o número de minas vizinhas.
- **Clique Direito:** Marca/Desmarca um campo com uma bandeira onde você suspeita que haja uma mina.
- **Vitória:** Ocorre quando todos os campos seguros (sem minas) são abertos.

## 🚀 Tecnologias Utilizadas

- [Kotlin](https://kotlinlang.org/) - Linguagem de programação moderna e concisa.
- [Swing](https://docs.oracle.com/javase/8/docs/technotes/guides/swing/) - Biblioteca Java para criação de interfaces gráficas (GUI).

## 📂 Estrutura do Projeto

O projeto está dividido em dois pacotes principais:

- `model`: Contém a lógica de negócio do jogo (`Tabuleiro`, `Campo`, etc).
- `view`: Contém a implementação da interface visual (`TelaPrincipal`, `PainelTabuleiro`, `BotaoCampo`).

## 🛠️ Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone [https://github.com/emanuelleda/Campo-Minado-Kotlin.git](https://github.com/emanuelleda/Campo-Minado-Kotlin.git)
