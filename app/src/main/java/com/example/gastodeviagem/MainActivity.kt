package com.example.gastodeviagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gastodeviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_calcular) {
            if (binding.editDistance.length() == 0){
                binding.editDistance.error = "O campo não pode ficar vazio"
            }else if (binding.editPrice.length() == 0){
                binding.editPrice.error = "O campo não pode ficar vazio"
            }else if (binding.editAutonomy.length() == 0){
                binding.editAutonomy.error = "O campo não pode ficar vazio"
            }else {
                calcular()
                binding.editDistance.setText("")
                binding.editPrice.setText("")
                binding.editAutonomy.setText("")

            }
        }
    }

    private fun calcular() {
        val distance = binding.editDistance.text.toString().toDouble()
        val price = binding.editPrice.text.toString().toDouble()
        val autonomy = binding.editAutonomy.text.toString().toDouble()

        val totalValue = (distance * price) / autonomy
        val totalValueStr = "R$" + "%.2f".format(totalValue)
        binding.textTotalValue.text = totalValueStr
        Toast.makeText(this, "Calculo realizado com sucesso",Toast.LENGTH_SHORT).show()

    }

}