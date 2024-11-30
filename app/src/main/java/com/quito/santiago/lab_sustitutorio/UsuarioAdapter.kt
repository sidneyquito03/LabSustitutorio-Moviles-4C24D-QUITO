package com.quito.santiago.lab_sustitutorio
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.quito.santiago.lab_sustitutorio.databinding.ItemUsuarioBinding

class UsuarioAdapter(
    private val usuarios: List<Usuario>
) : RecyclerView.Adapter<UsuarioAdapter.TeacherViewHolder>() {

    inner class TeacherViewHolder(val binding: ItemUsuarioBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(usuario: Usuario) {
            binding.userId.text = "ID de usuario: ${usuario.userId}"
            binding.id.text = "ID: ${usuario.id}"
            binding.title.text = usuario.title
            binding.body.text = usuario.body

            binding.root.setOnClickListener {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("sms:+51925137361")
                    putExtra("sms_body", usuario.title)
                }
                binding.root.context.startActivity(intent)
            }

            binding.root.setOnLongClickListener {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:victor.saico@tecsup.edu.pe")
                    putExtra(Intent.EXTRA_SUBJECT, "Cuerpo del post")
                    putExtra(Intent.EXTRA_TEXT, usuario.body)
                }
                binding.root.context.startActivity(intent)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val binding = ItemUsuarioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeacherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.bind(usuario)
    }

    override fun getItemCount(): Int = usuarios.size
}
