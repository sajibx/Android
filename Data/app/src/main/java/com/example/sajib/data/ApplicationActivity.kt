package smartfreez.mm.com.realm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.sajib.data.R
import com.example.sajib.data.User
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_application.*


open class ApplicationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application)
        val realm = Realm.getDefaultInstance()


        delB2.setOnClickListener {
            delData(realm)
        }
    }

    fun delData(realm: Realm) {
        try {
            realm.executeTransaction {
                val p: String = user2.text.toString()
                it.where(User::class.java).equalTo("names", p).findFirst()!!.deleteFromRealm()

                Toast.makeText(this, "${it.where(User::class.java).findAll().size}",Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}