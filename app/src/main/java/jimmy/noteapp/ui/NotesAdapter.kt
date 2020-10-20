package jimmy.noteapp.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jimmy.noteapp.R
import jimmy.noteapp.db.Note
import kotlinx.android.synthetic.main.note_item_layout.view.*

class NotesAdapter(private val notes: List<Note>) :
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NoteViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.note_item_layout, parent, false)
    )

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.view.title.text = notes[position].title
        holder.view.description.text = notes[position].description
        holder.view.setOnClickListener {
            openNoteDetails(notes[position], holder.view.context)
        }
    }

    private fun openNoteDetails(note: Note, context: Context) {
        val intent = Intent(context, NoteDetailsActivity::class.java)
        intent.putExtra("note", note)
        context.startActivity(intent)
    }

    class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}