package jimmy.noteapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jimmy.noteapp.R
import jimmy.noteapp.db.NoteDao
import jimmy.noteapp.db.NoteDatabase
import kotlinx.android.synthetic.main.activity_notes.*

class NotesActivity : AppCompatActivity() {

    private lateinit var noteDAO: NoteDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        noteDAO = NoteDatabase.getInstance(this).getNoteDao()
        addNote.setOnClickListener {
            startActivity(Intent(this, NoteDetailsActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        notesRecycler.adapter = NotesAdapter(noteDAO.getAllNotes())
    }
}