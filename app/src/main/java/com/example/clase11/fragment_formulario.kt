package com.example.clase11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class fragment_formulario : Fragment() {
    private lateinit var vista: View
    private lateinit var correo: EditText
    private lateinit var comentario: EditText
    private lateinit var enviar: Button

    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       vista = inflater.inflate(R.layout.fragment_formulario, container, false)

        correo = vista.findViewById(R.id.edtCorreo)
        comentario = vista.findViewById(R.id.edtComentario)
        enviar = vista.findViewById(R.id.btnEnviar)


        return TODO("Provide the return value")
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_formulario().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}