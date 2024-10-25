package dwi.polbeng.ac.id.androiddkotlinaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import dwi.polbeng.ac.id.menghitungvolumedanluas.R
import dwi.polbeng.ac.id.menghitungvolumedanluas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur listener untuk tombol hitung
        binding.btnCalculate.setOnClickListener {
            calculateCube()
        }
    }

    private fun calculateCube() {
        val sideStr = binding.etSide.text.toString()
        if (sideStr.isNotEmpty()) {
            val side = sideStr.toDouble()
            val volume = Math.pow(side, 3.0) // Volume = s^3
            val area = 6 * Math.pow(side, 2.0) // Luas = 6 * s^2

            // Menampilkan hasil
            val result = String.format(getString(R.string.result_volume), volume) + "\n" +
                    String.format(getString(R.string.result_area), area)
            binding.tvResult.text = result
        } else {
            // Menampilkan pesan kesalahan jika input kosong
            Toast.makeText(this, R.string.error_empty_input, Toast.LENGTH_SHORT).show()
        }
    }
}
