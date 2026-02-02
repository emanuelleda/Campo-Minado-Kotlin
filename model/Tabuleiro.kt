package model

import kotlin.random.Random
//define uma classe enum
enum class TabuleiroEvento {
    VITORIA,
    DERROTA
}

class Tabuleiro(val qtdLinhas: Int, val qtdColunas: Int, val qtdMinas: Int){
    private val campos = ArrayList<ArrayList<Campo>>()
    private val callbacks = ArrayList<(TabuleiroEvento) -> Unit>()

    init{
        gerarCampos()
        associarVizinhos()
        sortearMinas()
    }

    private fun gerarCampos(){
        for(linha in 0..<qtdLinhas){
            campos.add(ArrayList())
            for(coluna in 0..<qtdColunas){
                val novoCampo = Campo(linha,coluna)
                novoCampo.onEvento(this::verificarDerrotaOuVitoria)
                campos[linha].add(novoCampo)
            }
        }
    }

    private fun associarVizinhos() {
        forEachCampo({ associarVizinhos(it) })
    }

    private fun associarVizinhos(campo: Campo){
        val(linha, coluna) = campo
        val linhas = arrayOf(linha - 1,linha,linha +1)
        val colunas = arrayOf(coluna - 1,coluna,coluna +1)
        linhas.forEach { linha ->
            colunas.forEach { coluna ->
                val atual = campos.
                getOrNull(linha)
                ?.getOrNull(coluna)
                atual?.takeIf { campo!=it }?.let{campo.addVizinhos(it)}
            }
        }
    }

    private fun sortearMinas(){
        val gerador = Random

        var linhaSorteada = -1
        var colunaSorteada = -1
        var qtdMinasAtual = 0

        while(qtdMinasAtual < this.qtdMinas){
            linhaSorteada = gerador.nextInt(qtdLinhas)
            colunaSorteada = gerador.nextInt(qtdColunas)

            val campoSorteado = campos[linhaSorteada][colunaSorteada]
            if(campoSorteado.seguro){
                campoSorteado.minar()
                qtdMinasAtual++
            }
        }
    }

    fun forEachCampo(callback: (Campo)->Unit){
        campos.forEach { linha->linha.forEach(callback) }
    }

    fun objetivoAlcancado(): Boolean {
        var jogadorGanhou = true
        forEachCampo { if(!it.objetivoAlcancado) jogadorGanhou = false  }
        return jogadorGanhou
    }

    fun verificarDerrotaOuVitoria(campo: Campo, evento: CampoEvento){
        if(evento == CampoEvento.EXPLOSAO ){
            callbacks.forEach {it(TabuleiroEvento.DERROTA) }
        }else if(objetivoAlcancado()){
            callbacks.forEach {it(TabuleiroEvento.VITORIA) }
        }
    }

    fun onEvento(callback: (TabuleiroEvento) -> Unit){
        callbacks.add(callback)
    }

    fun reiniciar(){
        forEachCampo{it.reiniciar()}
        sortearMinas()
    }
}