package com.skein_of_heart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SimpleAdapter
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 로그인 설정
    private val RC_SIGN_IN = 9999
    private var googleSigninClient: GoogleSignInClient? = null
    private var firebaseAuth: FirebaseAuth? = null
    //라이브러리 설정
    var libraryImg = intArrayOf(R.drawable.library_img1,R.drawable.library_img2)
    var librarydata = arrayOf("나의 일기", "내일 일기")
    var library = ArrayList<HashMap<String, Any>>()


    var TAG = "test"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //로그인
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSigninClient = GoogleSignIn.getClient(this, gso)
        firebaseAuth = FirebaseAuth.getInstance();

        var loginBtn: SignInButton = findViewById(R.id.googleLogin)

        loginBtn.setOnClickListener {
            val signInIntent = googleSigninClient!!.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

        // 라이브러리 리스트 구성
        // 라이브러리 예제
        var idx = 0
        while(idx < librarydata.size){
            var map = HashMap<String, Any>()    // 리스트 예제
            map.put("libraryImg", libraryImg[idx])
            map.put("libraryname",librarydata[idx])
            library.add(map)
            idx++
        }
        var keys = arrayOf("libraryImg","libraryname")
        var ids = intArrayOf(R.id.libraryImg, R.id.libraryName)

        var libraryAdapter = SimpleAdapter(this, library, R.layout.mylibrary, keys, ids)
        libraryList.adapter = libraryAdapter
    }

    //로그인 fun
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)
            } catch (e: ApiException) {
                Log.w(TAG, "Google sign in failed", e)

            }
        }
    }
    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        firebaseAuth!!.signInWithCredential(credential)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    val user = firebaseAuth?.currentUser
                } else {
                }
            }
    }

}
