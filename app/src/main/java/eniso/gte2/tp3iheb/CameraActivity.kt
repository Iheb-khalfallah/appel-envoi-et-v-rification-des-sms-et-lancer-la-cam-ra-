package eniso.gte2.tp3iheb

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import eniso.gte2.tp3iheb.databinding.ActivityCameraBinding

class CameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_camera)
        val binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val thelauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val imageBitmap = it.data?.extras?.get("data") as Bitmap
                binding.img.setImageBitmap(imageBitmap)
            }
        }
        binding.btn.setOnClickListener{
            val picture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            thelauncher.launch(picture)
        }
    }
}