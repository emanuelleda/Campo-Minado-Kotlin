package view

import model.Tabuleiro
import model.TabuleiroEvento
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.SwingUtilities
import javax.swing.WindowConstants

fun main(args: Array<String>) {
    TelaPrincipal()
}

class TelaPrincipal : JFrame() {
    private val tabuleiro = Tabuleiro(16, 30, 89)
    private val painelTabuleiro = PainelTabuleiro(tabuleiro)

    init {
        tabuleiro.onEvento(this::mostrarResultado)
        add(painelTabuleiro)
        setSize(700, 440)
        setLocationRelativeTo(null)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        title = "Campo Minado"
        isVisible = true
    }

    private fun mostrarResultado(evento: TabuleiroEvento) {
        SwingUtilities.invokeLater {
            val msg = when (evento) {
                TabuleiroEvento.VITORIA -> "Você ganhou!!!"
                TabuleiroEvento.DERROTA -> "Você perdeu :/"
            }

            JOptionPane.showMessageDialog(this, msg)
            tabuleiro.reiniciar()
            painelTabuleiro.repaint()
            painelTabuleiro.validate()
        }
    }
}
