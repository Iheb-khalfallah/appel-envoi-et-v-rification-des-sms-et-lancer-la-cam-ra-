package eniso.gte2.tp3iheb
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import eniso.gte2.tp3iheb.databinding.ActivityConfirmSmsBinding


class ConfirmSMS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_confirm_sms)
        val binding = ActivityConfirmSmsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val a = intent.getStringExtra("num")
        val b = intent.getStringExtra("msg")
        binding.e1.setText(a)
        binding.e2.setText(b)
        binding.btn1.setOnClickListener{
            val uri = Uri.parse(
                "smsto:${binding.e1.text}?body=${binding.e2.text}"
            )
            val i = Intent(Intent.ACTION_SENDTO, uri)
            startActivity(i)
        }
        binding.btn2.setOnClickListener{
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}