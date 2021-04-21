package com.example.freemovers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_create_account.*
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        signup.setOnClickListener {
            startActivity(Intent(this,CreateAccount::class.java))
//            onBackPressed()
        }

        loginbtn.setOnClickListener {
            progressBar2.isVisible=true
            when{
                TextUtils.isEmpty(tvemail.text.toString().trim(){ it <= ' '})->{
                    Toast.makeText(
                        this@Login,
                        "Please enter email.",
                        Toast.LENGTH_SHORT
                    ).show()
//                    progressBar2.isVisible=false
                }
                TextUtils.isEmpty(tvpass.text.toString().trim(){ it <= ' '})->{
                    Toast.makeText(
                        this@Login,
                        "Please enter password.",
                        Toast.LENGTH_SHORT
                    ).show()
//                    progressBar2.isVisible=false
                }
                else->{
                    val email:String = tvemail.text.toString().trim(){ it <= ' '}
                    val password:String = tvpass.text.toString().trim(){ it <= ' '}
                    // Create an  instance and create a register a user with email and password.
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(
                            OnCompleteListener<AuthResult> { task->
                                //If the registration is Successfully done
                                if(task.isSuccessful){
                                    //Firebase registered user
                                    val firebaseUser: FirebaseUser = task.result!!.user!!
                                    Toast.makeText(this,"You are registered Successfully.", Toast.LENGTH_SHORT).show()

                                    val intent= Intent(this,FirstPage::class.java)
                                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("user_id",firebaseUser.uid)
                                    intent.putExtra("email_id",firebaseUser.email)
//                                    intent.putExtra("name",names)
                                    startActivity(intent)
                                    finish()
                                }else{
                                    //If the registration is not successfull then show error message.
                                    Toast.makeText(this,task.exception!!.message.toString(), Toast.LENGTH_SHORT).show()
                                    progressBar2.isVisible=false

                                }

                            }
                        )
                }
            }
        }
    }
}