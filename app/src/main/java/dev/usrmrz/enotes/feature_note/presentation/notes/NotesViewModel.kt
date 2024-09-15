package dev.usrmrz.enotes.feature_note.presentation.notes

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.usrmrz.enotes.feature_note.domain.use_case.NoteUseCases
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() { }