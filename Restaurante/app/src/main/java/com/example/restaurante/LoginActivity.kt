package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
// Cria a variável binding que serve para manipular a tela.
    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // A variável binding recebe o valor do layout
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Define uma função para o botão "Entrar".
        binding.buttonEntrar.setOnClickListener {

            // cria a variável Username e a Senha inserida pelo usuário, converte para String.
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            // Caso de "SE" para o username e a senha inserido pelo usuário estão corretos.
            if (username.equals("Pedro henrique Chaves") && password.equals("21")) {
                // Cria um Intent para iniciar o MainActivity
                val i = Intent(this, MainActivity::class.java)
                // Adiciona o username como extra para a intent 
                i.putExtra("username", username)
              // Inicia o MainActivity
                startActivity(i)
               // Finaliza o LoginActivity
                finish()
            } else {
                // Se o usuário e a senha estiverem incorretos, exibe uma mensagem de erro.
                Toast.makeText(applicationContext, "Errou!!!", Toast.LENGTH_LONG).show()
            }
        }

    }
}
