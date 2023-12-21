package com.example.sideeffectstraining.rememberUpdatedState

import android.widget.Toast
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

@Composable
fun ParentComponent() {

            // A surface container using the 'background' color from the theme
            Surface(color = MaterialTheme.colorScheme.background) {
                var dynamicData by remember { mutableStateOf("") }
                val context = LocalContext.current

                LaunchedEffect(Unit) {
                    delay(3000L)
                    dynamicData = "New Data"
                    Toast.makeText(context,"LaunchedEffect 1 Executed",Toast.LENGTH_SHORT).show()
                }
                MyComponent(title = dynamicData)
            }
}


@Composable
fun MyComponent(title: String) {
    var data by remember { mutableStateOf("") }

    val updatedData by rememberUpdatedState(title)

    val context = LocalContext.current

    LaunchedEffect(key1 = updatedData) {
        delay(5000L)
        data = updatedData
        Toast.makeText(context,"LaunchedEffect 2 Executed",Toast.LENGTH_SHORT).show()
    }

    Text(text = data)
}

@Preview(showBackground = true)
@Composable
fun PreviewRememberCoroutineScope(){
    ParentComponent()
}