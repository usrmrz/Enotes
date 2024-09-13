package dev.usrmrz.enotes.feature_note.data.data_sourse

//import android.content.Context
import androidx.room.Database
//import androidx.room.Room
import androidx.room.RoomDatabase
import dev.usrmrz.enotes.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao

//    companion object{
//        fun createNoteDatabase(context: Context): NoteDatabase {
//            return Room.databaseBuilder(
//                context,
//                NoteDatabase::class.java,
//                "note.db"
//            ).build()
//        }
//    }
}