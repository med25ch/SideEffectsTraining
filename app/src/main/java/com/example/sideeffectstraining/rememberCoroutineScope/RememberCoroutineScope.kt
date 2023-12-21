package com.example.sideeffectstraining.rememberCoroutineScope

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.sideeffectstraining.ui.theme.SideEffectsTrainingTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MyComposable(name: String, modifier: Modifier = Modifier, coroutineScope: CoroutineScope) {

    var state by remember { mutableStateOf(true) }
    val context = LocalContext.current

    // Used to obtain a composition-aware scope to launch coroutine outside composable.
    // It is a composable function that returns a coroutine scope bound to the point of Composable where its called.
    //val coroutineScope = rememberCoroutineScope()

    coroutineScope.launch {
        delay(8000)
        state = false
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(
            text = "Hello $name!  rememberCoroutineScope Test: $state",
            modifier = modifier.clickable {
                state = !state
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RememberCoroutineScopePreview() {
    val coroutineScope = rememberCoroutineScope()
    SideEffectsTrainingTheme {
        MyComposable("Android", coroutineScope = coroutineScope)
    }
}