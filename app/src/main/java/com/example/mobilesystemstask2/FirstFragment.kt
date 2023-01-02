package com.example.mobilesystemstask2

import android.app.ActionBar.LayoutParams
import android.app.AlertDialog
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobilesystemstask2.databinding.FragmentFirstBinding
import com.google.android.material.textfield.TextInputEditText
import de.hdodenhof.circleimageview.CircleImageView
import org.w3c.dom.Text

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listener = View.OnClickListener {   view ->


            Toast.makeText(context, view.id.toString(), Toast.LENGTH_SHORT).show()
        }

        binding.addButton.setOnClickListener {
            val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)
            val customLayout = layoutInflater.inflate(R.layout.dialog, null)



            alertDialogBuilder.setView(customLayout)
            val alertDialog: AlertDialog = alertDialogBuilder.create()
            alertDialog.show()
            val button = customLayout.findViewById<Button>(R.id.addShoppingListButton)

            val width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 70f,
                view.resources.displayMetrics).toInt()
            val margin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20f,
                view.resources.displayMetrics).toInt()


            button.setOnClickListener {
                alertDialog.dismiss()


                val textFromDialog = customLayout.findViewById<TextInputEditText>(R.id.username).text
                val text = TextView(context)
                val image = CircleImageView(context)
                val imageParams = GridLayout.LayoutParams()
                val textParams = GridLayout.LayoutParams()
                imageParams.width = width
                imageParams.height = width
                imageParams.marginStart = margin
                imageParams.topMargin = margin
                image.setImageResource(R.drawable.male)
                image.layoutParams = imageParams

                textParams.marginStart = margin
                textParams.topMargin = margin * 2
                text.layoutParams = textParams
                text.text = textFromDialog
                text.text = textFromDialog
                text.textSize = 20f
                text.id = View.generateViewId()
                text.setOnClickListener(listener)


                binding.shoppingListing.addView(image)
                binding.shoppingListing.addView(text)


                
//                val text = TextView(context)
//                text.text = R.string.test.toString()
//                binding.shoppingListing.addView(text)
//                val text = TextView(binding.root.context)
//                val image = CircleImageView(context)
//                val imageParams = LayoutParams(1)
//
//
//                imageParams.width = width
//                imageParams.height = width
//                imageParams.marginStart = margin
//                imageParams.topMargin = margin
//                image.setImageResource(R.drawable.male)
//                image.layoutParams = imageParams
//
//
//                val text1 = TextView(binding.root.context)
//                text1.text = textFromDialog
//
//                binding.shoppingListing.addView(image)
//                binding.shoppingListing.addView(text)
//                binding.shoppingListing.addView(text1)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}