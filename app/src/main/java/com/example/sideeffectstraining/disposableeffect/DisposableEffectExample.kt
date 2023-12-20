package com.example.sideeffectstraining.disposableeffect

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.sideeffectstraining.ui.theme.SideEffectsTrainingTheme

@Composable
fun MyDisposableEffect(name: String, modifier: Modifier = Modifier) {

    var state by remember { mutableStateOf(true) }
    val context = LocalContext.current

    // The DisposableEffect composable is utilized to execute an effect when a Composable function is initially created.
    // It then clears the effect when the Composable is removed from the screen.
    LaunchedEffect(key1 = Unit){
        Toast.makeText(context,"Show Toast", Toast.LENGTH_SHORT).show()
    }

    DisposableEffect(key1 = state){

        onDispose {
            Toast.makeText(context,"onDispose called", Toast.LENGTH_SHORT).show()
        }
    }


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(
            text = "Hello $name! : $state",
            modifier = modifier.clickable {
                state = !state
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyDisposableEffectPreview() {
    SideEffectsTrainingTheme {
        MyDisposableEffect("Android")
    }
}