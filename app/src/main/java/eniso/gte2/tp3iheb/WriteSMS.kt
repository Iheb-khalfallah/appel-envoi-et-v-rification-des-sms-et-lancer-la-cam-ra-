package eniso.gte2.tp3iheb

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import eniso.gte2.tp3iheb.databinding.ActivityWriteSmsBinding

class WriteSMS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_sms)
        val binding = ActivityWriteSmsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val theLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_CANCELED){
                Toast.makeText(this,"You have canceled the transmission",Toast.LENGTH_LONG).show()
            }
        }
        binding.btn.setOnClickListener{
            val i = Intent(this,ConfirmSMS::class.java)
            i.putExtra("num",binding.e1.text.toString())
            i.putExtra("msg",binding.e2.text.toString())
            theLauncher.launch(i)
        }



    }
}