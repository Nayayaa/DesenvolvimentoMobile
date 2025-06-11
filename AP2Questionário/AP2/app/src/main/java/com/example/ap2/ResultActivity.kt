package com.example.ap2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log // Mantenha este import para os logs de depuração
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        // 1. Obtenção e normalização dos dados das Activities anteriores
        val nome = intent.getStringExtra("nome") ?: ""
        val estilo = intent.getStringExtra("estiloLuta")?.trim()?.lowercase() ?: ""
        val armas = intent.getStringArrayListExtra("armas")?.map { it.trim().lowercase() } ?: arrayListOf()
        val filosofias = intent.getStringArrayListExtra("filosofias")?.map { it.trim().lowercase() } ?: arrayListOf()
        val ambiente = intent.getStringArrayListExtra("ambiente")?.map { it.trim().lowercase() } ?: arrayListOf()

        // 2. Referências às ImageViews das escolas
        val imgUrso = findViewById<ImageView>(R.id.resultadoUrso)
        val imgVibora = findViewById<ImageView>(R.id.resultadoVibora)
        val imgGrifo = findViewById<ImageView>(R.id.resultadoGrifo)
        val imgLobo = findViewById<ImageView>(R.id.resultadoLobo)
        val imgGato = findViewById<ImageView>(R.id.resultadoGato)
        val imgLince = findViewById<ImageView>(R.id.resultadoLince)

        // Esconde todas as ImageViews inicialmente
        listOf(imgUrso, imgVibora, imgGrifo, imgLobo, imgGato, imgLince).forEach {
            it.visibility = View.GONE
        }

        // 3. Referências aos outros elementos do layout
        val resultadoTextView = findViewById<TextView>(R.id.textResultado)
        val btnMaisInfo = findViewById<Button>(R.id.maisInfo)

        // Log de depuração: Verifica se o botão foi encontrado no layout
        Log.d("ButtonDebug", "Botão btnMaisInfo encontrado? ${btnMaisInfo != null}")

        // 4. Inicialização das pontuações para cada escola
        val pontuacoes = mutableMapOf("Urso" to 0, "Vibora" to 0, "Grifo" to 0, "Lobo" to 0, "Gato" to 0, "Lince" to 0)

        // 5. Mapeamento de respostas para pontos por escola (com opção "indiferente" para Lince)
        val respostaPontosMapa = mapOf(
            // Estilo de Luta
            "força bruta" to listOf("Urso" to 2),
            "agilidade" to listOf("Gato" to 2),
            "magia" to listOf("Vibora" to 2),
            "equilibrio" to listOf("Lobo" to 1, "Grifo" to 1),
            "indiferente" to listOf("Lince" to 2),

            // Armas
            "machado" to listOf("Urso" to 2),
            "adagas" to listOf("Gato" to 2),
            "poções e bombas" to listOf("Vibora" to 2, "Gato" to 1),
            "magia e sinais" to listOf("Grifo" to 2, "Lobo" to 2),
            "espadas" to listOf("Lobo" to 2),
            "indiferente" to listOf("Lince" to 1),

            // Filosofias
            "disciplina acima de tudo" to listOf("Lobo" to 1),
            "astúcia e estratégia" to listOf("Vibora" to 1),
            "coragem e ação imediata" to listOf("Urso" to 1),
            "equilíbrio entre razão e emoção" to listOf("Grifo" to 1),
            "liberdade para seguir o próprio caminho" to listOf("Gato" to 1),
            "indiferente" to listOf("Lince" to 2),

            // Ambiente
            "montanhas geladas" to listOf("Urso" to 1),
            "florestas densas" to listOf("Vibora" to 1, "Lobo" to 1),
            "cidades movimentadas" to listOf("Gato" to 1),
            "regiões místicas/exóticas" to listOf("Grifo" to 1),
            "planicies" to listOf("Lobo" to 1),
            "indiferente" to listOf("Lince" to 2)
        )

        // 6. Aplica os pontos com base nas respostas do usuário
        respostaPontosMapa[estilo]?.forEach { (escola, pontos) ->
            pontuacoes[escola] = pontuacoes[escola]!! + pontos
        }
        armas.forEach { arma ->
            respostaPontosMapa[arma]?.forEach { (escola, pontos) ->
                pontuacoes[escola] = pontuacoes[escola]!! + pontos
            }
        }
        filosofias.forEach { filosofia ->
            respostaPontosMapa[filosofia]?.forEach { (escola, pontos) ->
                pontuacoes[escola] = pontuacoes[escola]!! + pontos
            }
        }
        ambiente.forEach { amb ->
            respostaPontosMapa[amb]?.forEach { (escola, pontos) ->
                pontuacoes[escola] = pontuacoes[escola]!! + pontos
            }
        }

        // 7. Determina a escola vencedora e define o resultado final
        val escolaVencedora = pontuacoes.maxByOrNull { it.value }
        var imagemFinal: ImageView? = null
        var urlInfo: String = "" // Variável para armazenar a URL da escola
        var mensagemResultado: String = "" // Variável para armazenar a mensagem de texto final

        if (escolaVencedora != null && escolaVencedora.value > 0) {
            when (escolaVencedora.key) {
                "Urso" -> {
                    mensagemResultado = "$nome, sua Escola de Bruxo é: Escola do Urso"
                    imagemFinal = imgUrso
                    urlInfo = "https://witcher.fandom.com/pt-br/wiki/Escola_do_Urso"
                }
                "Vibora" -> {
                    mensagemResultado = "$nome, sua Escola de Bruxo é: Escola da Víbora"
                    imagemFinal = imgVibora
                    urlInfo = "https://witcher.fandom.com/pt-br/wiki/Escola_da_V%C3%ADbora"
                }
                "Grifo" -> {
                    mensagemResultado = "$nome, sua Escola de Bruxo é: Escola do Grifo"
                    imagemFinal = imgGrifo
                    urlInfo = "https://witcher.fandom.com/pt-br/wiki/Escola_do_Grifo"
                }
                "Lobo" -> {
                    mensagemResultado = "$nome, sua Escola de Bruxo é: Escola do Lobo"
                    imagemFinal = imgLobo
                    urlInfo = "https://witcher.fandom.com/pt-br/wiki/Escola_do_Lobo"
                }
                "Gato" -> {
                    mensagemResultado = "$nome, sua Escola de Bruxo é: Escola do Gato"
                    imagemFinal = imgGato
                    urlInfo = "https://witcher.fandom.com/pt-br/wiki/Escola_do_Gato"
                }
                "Lince" -> { // Caso o Lince seja a escola com maior pontuação
                    mensagemResultado = "$nome, parece que você tem o espírito da Escola do Lince! Nos vemos em The Witcher 4!"
                    imagemFinal = imgLince
                    urlInfo = "https://witcher.fandom.com/pt-br/wiki/Escola_do_Lince"
                }
            }
        } else { // Este é o ELSE principal (cai aqui se escolaVencedora for null ou pontuação <= 0)
            mensagemResultado = "$nome, parece que você tem o espírito da Escola do Lince! Nos vemos em The Witcher 4!"
            imagemFinal = imgLince
            urlInfo = "https://witcher.fandom.com/pt-br/wiki/Escola_do_Lince"
        }

        // 8. Atribui a mensagem e imagem final ao layout
        resultadoTextView.text = mensagemResultado
        imagemFinal?.visibility = View.VISIBLE

        // 9. Configura o OnClickListener para o botão "Mais Informações" (Fora do if/else)
        // Log de depuração: Mostra a URL que será usada pelo botão
        Log.d("ButtonDebug", "URL final para o botão: $urlInfo")
        btnMaisInfo.setOnClickListener {
            // Logs de depuração: Registram o clique e o disparo da Intent
            Log.d("ButtonDebug", "Botão Mais Informações Clicado! Tentando abrir URL: $urlInfo")
            val intentImplicita = Intent(Intent.ACTION_VIEW, Uri.parse(urlInfo))
            if (intentImplicita.resolveActivity(packageManager) != null) {
                Log.d("ButtonDebug", "Intent Mais Informações disparada com sucesso.")
            } else {
                Log.d("ButtonDebug", "Nenhum aplicativo encontrado para lidar com a Intent (navegador).")
                startActivity(intentImplicita)
            }
        }
    }
}