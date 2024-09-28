package dev.usrmrz.enotes.feature_note.presentation.util

sealed class Screen(
    val route: String
) {
    data object NotesScreen: Screen(route = "notes_screen")
    data object AddEditNoteScreen: Screen(route = "add_edit_note_screen")

}