package com.example.sideeffectstraining.sideeffect

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
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
fun MyComposable(name: String, modifier: Modifier = Modifier) {

    var state by remember { mutableStateOf(true) }
    val context = LocalContext.current

    //SideEffect is used to publish compose state to non-compose code.
    // The SideEffect is triggered on every recomposition and it is not a coroutine scope,
    // so suspend functions cannot be used within it.
    SideEffect(){
        Toast.makeText(context,"Show Toast With SideEffect", Toast.LENGTH_SHORT).show()
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
fun MyComposablePreview() {
    SideEffectsTrainingTheme {
        MyComposable("Android")
    }
}