package com.example.baisctextfieldexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val stateOne = rememberTextFieldState()
            val stateTwo = rememberTextFieldState()
            BasicTextFieldExamples(
                stateOne,
                remember { MutableInteractionSource() },
                stateTwo,
                remember { MutableInteractionSource() },
            )
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun BasicTextFieldExamples(
        stateOne: TextFieldState,
        firstInteractionSource: MutableInteractionSource,
        stateOTwo: TextFieldState,
        secondInteractionSource: MutableInteractionSource,
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(50.dp)
        ) {
            BasicTextField(
                state = stateOne,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                interactionSource = firstInteractionSource,
                decorator =
                TextFieldDefaults.decorator(
                    state = stateOne,
                    enabled = true,
                    label = {
                        Text("Username")
                    },
                    placeholder = {
                        Text("Username Placeholder")
                    },
                    lineLimits = TextFieldLineLimits.Default,
                    interactionSource = firstInteractionSource,
                    outputTransformation = null
                )
            )
            SecureTextField(
                state = stateOTwo,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                interactionSource = secondInteractionSource,
                label = {
                    Text("Password")
                },
                placeholder = {
                    Text("Password Placeholder")
                },
            )
        }
    }
}