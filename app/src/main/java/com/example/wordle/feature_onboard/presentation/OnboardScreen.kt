package com.example.wordle.feature_onboard.presentation

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.wordle.feature_game.domain.models.CheckCharEnum
import com.example.wordle.feature_game.domain.models.GuessChar
import com.example.wordle.feature_game.presentation.components.CharContainer
import com.example.wordle.navigation.Screens
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun OnboardScreen(
    navController: NavHostController,
    onboardViewModel: OnboardViewModel = hiltViewModel()
) {
    val pagerState = rememberPagerState()

    Scaffold(Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            HorizontalPager(
                modifier = Modifier.weight(10f),
                count = 3,
                state = pagerState,
            ) { position ->
                when (position) {
                    0 -> FirstOnboardScreen()
                    1 -> SecondOnboardScreen()
                    2 -> ThirdOnboardScreen()
                }

            }
            HorizontalPagerIndicator(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .weight(1f),
                pagerState = pagerState
            )
            Column(modifier = Modifier
                .weight(1f)
                .padding(horizontal = 24.dp)) {
                AnimatedVisibility(
                    modifier = Modifier.fillMaxWidth(),
                    visible = pagerState.currentPage == 2,
                    enter = fadeIn() + expandHorizontally(),
                    exit = fadeOut() + shrinkHorizontally()
                ) {
                    Button(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), onClick = {
                        onboardViewModel.setCompleted()
                        navController.popBackStack()
                        navController.navigate(Screens.Game.route)
                    }) {
                        Text(text = "Entendi, quero jogar!")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun FirstOnboardScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Bem vindo!", style = MaterialTheme.typography.h3)
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            for (i in 1..5) {
                CharContainer(
                    guessChar = GuessChar(char = '?'),
                    currentGuess = false,
                    currentChar = false
                )
            }
        }
        Text(
            text = "Este é um jogo que em que você deve encontrar a palavra escondida",
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center
        )

    }
}

@Preview
@Composable
fun SecondOnboardScreen() {
    Column(
        Modifier.padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(64.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            CharContainer(
                guessChar = GuessChar(char = 'c', status = CheckCharEnum.WRONG_CHAR),
                currentGuess = false,
                currentChar = false
            )
            CharContainer(
                guessChar = GuessChar(char = 'o', status = CheckCharEnum.CHAR_IN_PLACE),
                currentGuess = false,
                currentChar = false
            )
            CharContainer(
                guessChar = GuessChar(char = 'b', status = CheckCharEnum.WRONG_CHAR),
                currentGuess = false,
                currentChar = false
            )
            CharContainer(
                guessChar = GuessChar(char = 'r', status = CheckCharEnum.CHAR_OUT_OF_PLACE),
                currentGuess = false,
                currentChar = false
            )
            CharContainer(
                guessChar = GuessChar(char = 'o', status = CheckCharEnum.CHAR_OUT_OF_PLACE),
                currentGuess = false,
                currentChar = false
            )
        }
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text(
                text = "As letras em vermelho não fazem parte da palavra",
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )
            Text(
                text = "As letras em amarelo fazem parte da palavra mas estão na posição errada",
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )
            Text(
                text = "As letras em verde fazem parte da palavra e estão na posição correta",
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun ThirdOnboardScreen() {
    Column(
        Modifier.padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(64.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            for (c in "jogar")
                CharContainer(
                    guessChar = GuessChar(char = c, status = CheckCharEnum.CHAR_IN_PLACE),
                    currentGuess = false,
                    currentChar = false
                )
        }
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text(
                text = "Encontramos a palavra escondida!",
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )
        }
    }
}