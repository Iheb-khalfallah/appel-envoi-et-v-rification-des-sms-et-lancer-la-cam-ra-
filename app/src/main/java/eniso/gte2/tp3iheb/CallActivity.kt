package eniso.gte2.tp3iheb

import android.Manifest.permission.CALL_PHONE
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import eniso.gte2.tp3iheb.databinding.ActivityCallBinding

class CallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_call)
        val binding = ActivityCallBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // ou bien binding.e1.text.toString()
        binding.btn.setOnClickListener {
            val uri = Uri.parse("tel: ${binding.e1.text}")
            val i = Intent(Intent.ACTION_DIAL,uri)
            startActivity(i)

        }
    }
}