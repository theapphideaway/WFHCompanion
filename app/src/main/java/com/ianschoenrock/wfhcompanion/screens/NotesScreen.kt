package com.ianschoenrock.wfhcompanion.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NotesScreen(){
    val notes = remember{mutableStateOf(ArrayList<String>())}
    if(notes.value.size < 1){
        notes.value.addAll(listOf("One", "Two", "Three"))
    }
    var selectedNote = remember {mutableStateOf("")}
    if(LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE){
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()){
            Column(
                Modifier
                    .fillMaxSize()
                    .weight(0.5f)) {
                Card(Modifier.padding(16.dp),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(
                        "New Note ",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        style = TextStyle(fontSize = 24.sp, textAlign = TextAlign.Center)
                    )

                }
                LazyColumn(Modifier.padding(bottom = 50.dp)) {
                    items(notes.value.count()) { index ->
                        Card(Modifier.padding(16.dp),
                            shape = RoundedCornerShape(20.dp)
                        ) {
                            Text(
                                notes.value[index],
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                                    .clickable {
                                        selectedNote.value = notes.value[index]
                                    },
                                style = TextStyle(fontSize = 24.sp, textAlign = TextAlign.Center)
                            )

                        }
                    }

                }
            }
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(1f)){
                DetailsScreen(selectedNote.value)
            }
        }
    } else{
        if(selectedNote.value == "") {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Card(
                    Modifier.padding(16.dp),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(
                        "New Note ",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        style = TextStyle(fontSize = 24.sp, textAlign = TextAlign.Center)
                    )

                }
                LazyColumn(Modifier.padding(bottom = 50.dp)) {
                    items(notes.value.count()) { index ->
                        Card(
                            Modifier.padding(16.dp),
                            shape = RoundedCornerShape(20.dp)
                        ) {
                            Text(
                                notes.value[index],
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                                    .clickable {
                                        selectedNote.value = notes.value[index]
                                    },
                                style = TextStyle(fontSize = 24.sp, textAlign = TextAlign.Center)
                            )

                        }
                    }

                }
            }
        }
        else{
            DetailsScreen(content = selectedNote.value)
        }
    }

}

@Composable 
fun DetailsScreen(content: String){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()) {
        Text("Details: $content")
    }
}