package com.cap481.meso.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.cap481.meso.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.squareup.picasso.Picasso


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        val user = auth.currentUser

        if (user != null){
            if (user.photoUrl != null){
                Picasso.get().load(user.photoUrl).into(binding.ivProfile)
            }else{
                Picasso.get().load("https://picsum.photos/id/1/200/300").into(binding.ivProfile)
            }
            binding.etName.setText(user.displayName)
            binding.etEmail.setText(user.email)
        }

        binding.btnUpdate.setOnClickListener{
            val name = binding.etName.text.toString().trim()
            if (name.isEmpty()){
                binding.etName.error = "Input your name"
                binding.etName.requestFocus()
                return@setOnClickListener
            }

            UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .build().also {
                    user?.updateProfile(it)?.addOnCompleteListener{
                        if (it.isSuccessful){
                            Toast.makeText(activity,"Profile Updated",Toast.LENGTH_SHORT).show()
                        } else{
                            Toast.makeText(activity,"${it.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
        }
    }
}