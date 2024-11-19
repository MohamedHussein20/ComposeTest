package com.memo.test

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.memo.test.ui.theme.Gym
import com.memo.test.ui.theme.darkerPurple80

@Composable
fun GymScreen() {
    val vm: GymsViewModel = viewModel()
    LazyColumn {
        items(vm.state) { gym ->
            GymItem(gym) {
                vm.toggleFavoriteState(it)
            }
        }
    }
}

@Composable
fun GymItem(gym: Gym, onClick: (Int) -> Unit) {
    var isFavoriteState by remember { mutableStateOf(false) }
    val icon = if (gym.isFavorite) {
        Icons.Filled.Favorite
    } else {
        Icons.Filled.FavoriteBorder
    }
    ElevatedCard(
        modifier = Modifier.padding(all = 8.dp),
        //colors = CardDefaults.elevatedCardColors(containerColor = Color.Blue)
    ) {
        Row(
            Modifier.padding(all = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DefaultIcon(modifier = Modifier.weight(0.15f), Icons.Filled.Place, "Location Icon")
            GymDetails(gym, modifier = Modifier.weight(0.70f))
            DefaultIcon(Modifier.weight(0.15f), icon, "Favorite Gym Icon") {
                onClick(gym.id)
            }
        }
    }
}

@Composable
fun DefaultIcon(
    modifier: Modifier,
    icon: ImageVector,
    contentDescription: String,
    onClick: () -> Unit = {}
) {
    Image(
        imageVector = icon,
        contentDescription = contentDescription,
        modifier = modifier
            .padding(0.dp)
            .clickable {
                onClick()
            },
        colorFilter = ColorFilter.tint(
            Color.DarkGray
        )
    )
}


@Composable
fun GymDetails(gym: Gym, modifier: Modifier) {
    Column(modifier = Modifier) {
        Text(
            fontSize = 24.sp,
            text = gym.name,
            style = MaterialTheme.typography.bodyLarge,
            color = darkerPurple80
        )

        Text(
            text = gym.place,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black

        )
    }
}
