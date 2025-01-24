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
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.baisctextfieldexample.ui.theme.BaiscTextFieldExampleTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaiscTextFieldExampleTheme {
                val stateOne = rememberTextFieldState()
                val stateOTwo = rememberTextFieldState()
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
                        decorator = {
                            TextFieldDefaults.DecorationBox(
                                value = stateOne.text.toString(),
                                innerTextField = it,
                                enabled = true,
                                singleLine = true,
                                visualTransformation = VisualTransformation.None,
                                label = {
                                    Text("Username")
                                },
                                placeholder = {
                                    Text("Username Placeholder")
                                },
                                interactionSource = remember { MutableInteractionSource() }
                            )
                        }
                    )
                    BasicSecureTextField(
                        state = stateOTwo,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        decorator = {
                            TextFieldDefaults.DecorationBox(
                                value = stateOTwo.text.toString(),
                                innerTextField = it,
                                enabled = true,
                                singleLine = true,
                                visualTransformation = VisualTransformation.None,
                                label = {
                                    Text("Password")
                                },
                                placeholder = {
                                    Text("Password Placeholder")
                                },
                                interactionSource = remember { MutableInteractionSource() }
                            )
                        }
                    )
                }
            }
        }
    }
}