package ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import di.HomeScreenModelProvider
import model.Destination
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import theme.PrimaryColor
import theme.White
import theme.SecondTextColor
import theme.TextColor
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.arrow_forward
import travelbuddy.composeapp.generated.resources.choose_date
import travelbuddy.composeapp.generated.resources.choose_meeting_point
import travelbuddy.composeapp.generated.resources.ci_location
import travelbuddy.composeapp.generated.resources.estimation
import travelbuddy.composeapp.generated.resources.facilities
import travelbuddy.composeapp.generated.resources.preview
import travelbuddy.composeapp.generated.resources.ratting
import travelbuddy.composeapp.generated.resources.type
import travelbuddy.composeapp.generated.resources.via
import ui.component.DestinationDetailChipItem
import ui.component.DestinationDetailFacilityItem
import ui.component.DestinationDetailPersonQunatityCard
import ui.component.DestinationDetailSubItem
import ui.component.DestinationDetailSubItemDivider
import ui.component.DestinationDetailSubItemRatting
import ui.component.PrimaryButton
import ui.component.destinationDetailHeader
import ui.viewmodel.HomeScreenModel
import util.BOTTOM_NAV_SPACE
import util.ImageItem

data class DestinationDetailScreen(val destination: Destination) : Screen {
    @Composable
    override fun Content() {
        val screenModel = HomeScreenModelProvider.homeScreenModel
        val navigator = LocalNavigator.currentOrThrow
        DestinationDetailScreenView(navigator = navigator, destination = destination, viewModel = screenModel)
    }
}

@Composable
fun DestinationDetailScreenView(
    navigator: Navigator,
    destination: Destination,
    viewModel: HomeScreenModel,
) {
    val rememberThumbnail = remember { mutableStateOf(destination.thumbnail) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        topSection(
            navigator,
            destination,
            rememberThumbnail,
            checkFavorite = {
                viewModel.checkFavorite(it)
            },
            addFavorite = {
                viewModel.addFavorite(it)
            },
            removeFavorite = {
                viewModel.removeFavorite(it)
            },
            updateBottomNavBarVisible = {
                viewModel.setBottomNavBarVisible(true)
            }
        )
        contentSection(destination) {
            rememberThumbnail.value = it
        }
        PrimaryButton(
            title = "Додати в кошик",
            paddingValues = PaddingValues(start = 25.dp, top = 36.dp, end = 25.dp, bottom = 36.dp),
            onClick = { viewModel.addToCart(destination) }
        )

        GeminiRoundButton(
            viewModel = viewModel,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            logo = Res.drawable.arrow_forward,
            destination = destination,
            navigator = navigator
        )
    }
}


@Composable
fun topSection(
    navigator: Navigator,
    destination: Destination,
    thumbnail: MutableState<String>,
    checkFavorite: (Destination) -> Boolean,
    addFavorite: (Destination) -> Unit,
    removeFavorite: (Destination) -> Unit,
    updateBottomNavBarVisible: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxWidth().height(350.dp)
    ) {
        Box {
            ImageItem(
                data = thumbnail.value,
                modifier = Modifier
                    .drawWithCache {
                        onDrawWithContent {
                            drawContent()
                            drawRect(
                                Brush.verticalGradient(
                                    0.4f to Color.Black.copy(alpha = 0F),
                                    1F to Color.Black
                                )
                            )
                        }
                    }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, bottom = 60.dp, end = 16.dp)
                    .align(Alignment.BottomStart),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column {
                    Text(
                        text = destination.title,
                        color = White,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Row(
                        modifier = Modifier.padding(top = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.size(18.dp),
                            painter = painterResource(Res.drawable.ci_location),
                            contentDescription = null,
                            tint = White
                        )
                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            text = destination.location,
                            color = White,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }

                Column(
                    modifier = Modifier.padding(top = 4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = destination.price,
                        color = White,
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = TextUnit(24f, TextUnitType.Sp)
                    )
                    Text(
                        text = "/${destination.type}",
                        color = White,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
        destinationDetailHeader(
            navigator,
            destination,
            checkFavorite,
            addFavorite,
            removeFavorite,
            updateBottomNavBarVisible
        )
    }
}


@Composable
fun contentSection(destination: Destination, onImageClicked: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .offset(y = -40.dp)
            .background(
                color = White,
                shape = RoundedCornerShape(26.dp, 26.dp, 0.dp, 0.dp)
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 25.dp, top = 36.dp, end = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DestinationDetailSubItemRatting(
                stringResource(Res.string.ratting),
                destination.rating.toString()
            )
            DestinationDetailSubItemDivider()
            DestinationDetailSubItem(
                stringResource(Res.string.type),
                destination.type.toUpperCase(Locale.current)
            )
            DestinationDetailSubItemDivider()
            DestinationDetailSubItem(
                stringResource(Res.string.estimation),
                destination.estimation.toUpperCase(Locale.current)
            )
            DestinationDetailSubItemDivider()
            DestinationDetailSubItem(
                stringResource(Res.string.via),
                destination.via.toUpperCase(Locale.current)
            )
        }

        Text(
            modifier = Modifier.padding(start = 25.dp, top = 18.dp, end = 25.dp),
            text = destination.description,
            color = SecondTextColor,
            style = MaterialTheme.typography.labelSmall,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Justify
        )

        Text(
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 36.dp, end = 16.dp),
            text = stringResource(Res.string.preview),
            color = TextColor,
            style = MaterialTheme.typography.bodySmall
        )

        LazyRow(
            modifier = Modifier.padding(start = 25.dp, top = 18.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(items = destination.image) { index, item ->
                ImageItem(
                    data = item,
                    modifier = Modifier.size(90.dp).clickable {
                        onImageClicked.invoke(item)
                    }
                )
            }
        }

        Text(
            modifier = Modifier.padding(start = 16.dp, top = 30.dp),
            text = stringResource(Res.string.choose_date),
            color = TextColor,
            style = MaterialTheme.typography.bodyMedium
        )

        DestinationDetailChipItem(destination.dates)

        Text(
            modifier = Modifier.padding(start = 16.dp, top = 30.dp),
            text = stringResource(Res.string.choose_meeting_point),
            color = TextColor,
            style = MaterialTheme.typography.bodyMedium
        )

        DestinationDetailChipItem(destination.meetingPoints)

        DestinationDetailPersonQunatityCard(destination)

        Text(
            modifier = Modifier.padding(start = 16.dp, top = 30.dp),
            text = stringResource(Res.string.facilities),
            color = TextColor,
            style = MaterialTheme.typography.bodyMedium
        )

        DestinationDetailFacilityItem(destination.facilities)
    }
}

@Composable
fun GeminiRoundButton(
    viewModel: HomeScreenModel,
    modifier: Modifier = Modifier,
    logo: DrawableResource,
    destination: Destination,
    navigator: Navigator
) {
    var isExpanded by remember { mutableStateOf(true) }
    val navigateToGemini by viewModel.navigateToGemini.collectAsState()
    if (navigateToGemini.first) {
        LocalNavigator.current?.pop()
        LocalTabNavigator.current.current = GeminiTab
    }

    // Animate width change
    val buttonWidth by animateDpAsState(
        targetValue = if (isExpanded) 220.dp else 100.dp,
        animationSpec = tween(durationMillis = 300)
    )

    BoxWithConstraints(
        modifier = modifier
            .padding(end = 16.dp, bottom = 36.dp)
            .width(buttonWidth)
            .background(color = PrimaryColor, shape = RoundedCornerShape(8.dp))
            .clickable {
                if (isExpanded) {
                    viewModel.navigateToGimini(Pair(true, destination))
                }
                isExpanded = !isExpanded
            },
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                painter = painterResource(logo),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            AnimatedVisibility(
                visible = isExpanded,
                enter = fadeIn() + expandIn(),
                exit = fadeOut() + shrinkOut()
            ) {
                Text(
                    text = "Дізнатись більше",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 16.sp
                )
            }
        }
    }
}
