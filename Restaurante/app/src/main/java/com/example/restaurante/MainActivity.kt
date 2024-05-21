package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Ja explicada no Login, nao vou mais comentar sobre isso
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
   
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
       
        setContentView(binding.root)

       // Pega o nome do username do intent
        val username = intent.extras?.getString("username")

        // Exibe uma mensagem de Olá
        if(!username.isNullOrEmpty()){
            binding.textOla.setText("Olá $username")
        }
        //botão de clique para o botão "Fechar" que termina todas as atividades
        binding.buttonFechar.setOnClickListener {
            finishAffinity()
        }
        // botão de clique para o botão de "Pedir".
        binding.buttonPedir.setOnClickListener {
            // Cria um intent para iniciar o SplashActivity
            val i = Intent(this, SplashActivity::class.java)
           // Adiciona a quantidade de pizza, salada e hambúrguer para o intent
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
            // Inicia o Splash e finaliza o MainActivity
            startActivity(i)
            finish()
        }

        // Define um botão de clique para o checkbox (caixa de seleção) da pizza.
        binding.checkPizza.setOnClickListener {
                // Se o checkbox estiver marcado
            if(binding.checkPizza.isChecked()){
                // Define a quantidade de pizza para "1".
                binding.editQuantidadePizza.setText("1")
                // Torna o preço da pizza visível.
                binding.textPrecoPizza.visibility = View.VISIBLE
            }else{
                // Se o checkbox não estiver marcado, define a quantidade de pizzas para 0 e oculta o preço
                binding.editQuantidadePizza.setText("0")
                binding.textPrecoPizza.visibility = View.GONE
            }
        }
        // isso vale para todos abaixo
        binding.checkSalada.setOnClickListener {
            if(binding.checkSalada.isChecked()){
                binding.editQuantidadeSalada.setText("1")
            }else{
                binding.editQuantidadeSalada.setText("0")
                binding.textPrecoSalada.visibility = View.GONE
            }
        }
       
        binding.checkHamburger.setOnClickListener {
            if(binding.checkHamburger.isChecked()){
                binding.editQuantidadeHamburguer.setText("1")
            }else{
                binding.editQuantidadeHamburguer.setText("0")
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }

    }
}
