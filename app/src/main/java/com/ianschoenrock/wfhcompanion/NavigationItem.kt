package com.ianschoenrock.wfhcompanion

sealed class NavigationItem(var route: String, var icon: Int, var title: String ){
    object ToDo : NavigationItem("todo", R.drawable.ic_baseline_checklist_24, "To-do")
    object Notes : NavigationItem("notes", R.drawable.ic_baseline_edit_24, "Notes")
}
