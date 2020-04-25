package com.jelondoca.musicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jelondoca.musicapp.models.UserModel
import com.jelondoca.musicapp.repositories.UserRepository
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        button.setOnClickListener {
            val userModel = UserModel("Juan", "jelondoca", "jelondoca@gmail.com", "123456")
            createThreadToCreateUser(userModel)
        }

    }

    private fun createThreadToCreateUser(user: UserModel) {
        val thread = Thread(Runnable {
            createUserFromRepository(user)
        })
        thread.start()
    }

    private fun createUserFromRepository(user: UserModel) {
        try {
            val repository = UserRepository()
            val result = repository.createUser(user)
            showUser(result)
        }catch (e: Exception){
            runOnUiThread {
                Toast.makeText(this, e.message ?: "Error", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun showUser(user: UserModel) {
        runOnUiThread {
            Toast.makeText(this, "${user.name} ${user._id}", Toast.LENGTH_LONG).show()
        }
    }


}
