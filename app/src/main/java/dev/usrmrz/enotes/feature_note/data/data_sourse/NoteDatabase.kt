package dev.usrmrz.enotes.feature_note.data.data_sourse

//import android.content.Context
import androidx.room.Database
//import androidx.room.Room
import androidx.room.RoomDatabase
import dev.usrmrz.enotes.NoteApp
import dev.usrmrz.enotes.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}