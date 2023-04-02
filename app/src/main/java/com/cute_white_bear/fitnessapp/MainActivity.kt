package com.cute_white_bear.fitnessapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cute_white_bear.fitnessapp.model.DataSource
import com.cute_white_bear.fitnessapp.model.Exercise
import com.cute_white_bear.fitnessapp.ui.theme.FitnessAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FatBurnUI()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun FatBurnUIPreview() {
    FitnessAppTheme {
        FatBurnUI()
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FatBurnUI(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            FatBurnTopAppBar()
        },
    ) {
        Column { FatBurnExerciseList(DataSource.list) }
    }
}

@Composable
fun FatBurnTopAppBar(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .fillMaxWidth()
        .background(MaterialTheme.colors.primary)
    ) {
        Row(modifier = modifier.padding(8.dp),
        ) {
            Image(
                painter = painterResource(R.drawable.fitness_logo),
                contentDescription = null,
            )
            Text(
                text = stringResource(R.string.app_name),
                modifier = modifier.padding(start = 8.dp),
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.h1
            )
        }
    }
}

@Composable
fun FatBurnBottomAppBar(
    modifier: Modifier = Modifier
) {
    // TODO: To add bottom app bar 
}

@Composable
fun FatBurnDescriptionText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.app_desc),
        style = MaterialTheme.typography.h2,
        lineHeight = 24.sp,
        color = MaterialTheme.colors.onPrimary
    )
}

@Composable
fun FatBurnExerciseItem(
    exercise: Exercise,
    modifier: Modifier = Modifier
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val cardBackgroundColor by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colors.secondary else MaterialTheme.colors.surface
    )
    val cardHeadlineColor by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colors.onSurface else MaterialTheme.colors.onSurface
    )
    val cardCornerRadius by animateDpAsState(
        targetValue = if (expanded) 16.dp else 2.dp
    )

    Card(
        elevation = 7.dp,
        modifier = modifier
            .clickable { expanded = !expanded },
        backgroundColor = cardBackgroundColor,
        shape = RoundedCornerShape(cardCornerRadius)
    ) {
        Column(modifier = modifier
            .animateContentSize(animationSpec = spring(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = Spring.StiffnessVeryLow,
            ))
        ) {
            Text(
                text = stringResource(exercise.name),
                style = MaterialTheme.typography.h4,
                color = cardHeadlineColor,
                modifier = modifier.padding(top = 8.dp, start = 16.dp, bottom = 8.dp)
            )
            Image(
                painter = painterResource(exercise.image),
                contentDescription = stringResource(exercise.name),
            )
            if (expanded) FatBurnExerciseDescription(exercise)
        }
    }
}

@Composable
fun FatBurnExerciseList(
    exerciseList: List<Exercise>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        modifier = modifier.padding(16.dp)
    ) {
        item { FatBurnDescriptionText() }
        items(exerciseList) { exercise ->
            FatBurnExerciseItem(exercise)
        }
    }
}

@Composable
fun FatBurnExerciseDescription(
    exercise: Exercise,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.muscles_worked),
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.onSurface,
        )
        exercise.benefits.forEach {
            Text(
                text = "- ${stringResource(it)}",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onSurface,
                modifier = modifier.padding(start = 16.dp),
            )
        }
        Spacer(modifier = modifier.height(8.dp))
        exercise.description.forEach {
            Text(
                text = "• ${stringResource(it)}",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                modifier = modifier.padding(bottom = 4.dp)
            )
        }
    }
}