package hr.ferit.shopsmart

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import hr.ferit.shopsmart.ScreenRobot.Companion.withRobot
import org.hamcrest.Matchers.*
import org.junit.Test
import org.junit.runner.RunWith

class MainActivityTest {

    @Test
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun onLaunchCheckAmountInputIsDisplayed() {

        ActivityScenario.launch(MainActivity::class.java)

        withRobot(MainActivityScreenRobot::class.java)
                .checkIsDisplayed(R.id.etLimit)
    }

    @Test
    fun whenLimitInputIsEmptyTotalIsZero() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(MainActivityScreenRobot::class.java)
                .inputLimitAmount("")
                .checkTotal("0")
    }

    @Test
    fun whenLimitInputIsZeroTotalIsZero() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(MainActivityScreenRobot::class.java)
                .inputLimitAmount("0")
                .checkTotal("0")
    }

    @Test
    fun whenLimitInputIsZeroAllItemsAreDisabled() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(MainActivityScreenRobot::class.java)
                .inputLimitAmount("0")
                .checkIsDisabled(R.id.cbBall)
                .checkIsDisabled(R.id.cbShirt)
                .checkIsDisabled(R.id.cbPants)
                .checkIsDisabled(R.id.cbBackPack)
                .checkIsDisabled(R.id.cbPiano)
                .checkIsDisabled(R.id.cbCar)
    }

    @Test
    fun whenLimitInputIsEmptyAllItemsAreDisabled() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(MainActivityScreenRobot::class.java)
                .inputLimitAmount("")
                .checkIsDisabled(R.id.cbBall)
                .checkIsDisabled(R.id.cbShirt)
                .checkIsDisabled(R.id.cbPants)
                .checkIsDisabled(R.id.cbBackPack)
                .checkIsDisabled(R.id.cbPiano)
                .checkIsDisabled(R.id.cbCar)
    }

    @Test
    fun whenLimitInputIs5AllItemsAreDisabled() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(MainActivityScreenRobot::class.java)
                .inputLimitAmount("5")
                .checkIsDisabled(R.id.cbBall)
                .checkIsDisabled(R.id.cbShirt)
                .checkIsDisabled(R.id.cbPants)
                .checkIsDisabled(R.id.cbBackPack)
                .checkIsDisabled(R.id.cbPiano)
                .checkIsDisabled(R.id.cbCar)
    }

    @Test
    fun whenLimitInputIs9AllItemsAreDisabled() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(MainActivityScreenRobot::class.java)
                .inputLimitAmount("9")
                .checkIsDisabled(R.id.cbBall)
                .checkIsDisabled(R.id.cbShirt)
                .checkIsDisabled(R.id.cbPants)
                .checkIsDisabled(R.id.cbBackPack)
                .checkIsDisabled(R.id.cbPiano)
                .checkIsDisabled(R.id.cbCar)
    }

    @Test
    fun whenLimitInputIs10OnlyBallIsEnabled() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(MainActivityScreenRobot::class.java)
                .inputLimitAmount("10")
                .checkIsEnabled(R.id.cbBall)
                .checkIsDisabled(R.id.cbShirt)
                .checkIsDisabled(R.id.cbPants)
                .checkIsDisabled(R.id.cbBackPack)
                .checkIsDisabled(R.id.cbPiano)
                .checkIsDisabled(R.id.cbCar)
    }

    @Test
    fun whenLimitInputIs12BallAndShirtAreEnabled() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(MainActivityScreenRobot::class.java)
                .inputLimitAmount("12")
                .checkIsEnabled(R.id.cbBall)
                .checkIsEnabled(R.id.cbShirt)
                .checkIsDisabled(R.id.cbPants)
                .checkIsDisabled(R.id.cbBackPack)
                .checkIsDisabled(R.id.cbPiano)
                .checkIsDisabled(R.id.cbCar)
    }

    @Test
    fun whenLimitInputIs18BallShirtAndPantsAreEnabled() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(MainActivityScreenRobot::class.java)
                .inputLimitAmount("18")
                .checkIsEnabled(R.id.cbBall)
                .checkIsEnabled(R.id.cbShirt)
                .checkIsEnabled(R.id.cbPants)
                .checkIsDisabled(R.id.cbBackPack)
                .checkIsDisabled(R.id.cbPiano)
                .checkIsDisabled(R.id.cbCar)
    }

    @Test
    fun whenLimitInputIs24BallShirtPantsAndBackpackAreEnabled() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(MainActivityScreenRobot::class.java)
                .inputLimitAmount("24")
                .checkIsEnabled(R.id.cbBall)
                .checkIsEnabled(R.id.cbShirt)
                .checkIsEnabled(R.id.cbPants)
                .checkIsEnabled(R.id.cbBackPack)
                .checkIsDisabled(R.id.cbPiano)
                .checkIsDisabled(R.id.cbCar)
    }

    @Test
    fun whenLimitInputIs220BallShirtPantsBackpackAndPianoAreEnabled() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(MainActivityScreenRobot::class.java)
                .inputLimitAmount("220")
                .checkIsEnabled(R.id.cbBall)
                .checkIsEnabled(R.id.cbShirt)
                .checkIsEnabled(R.id.cbPants)
                .checkIsEnabled(R.id.cbBackPack)
                .checkIsEnabled(R.id.cbPiano)
                .checkIsDisabled(R.id.cbCar)
    }

    @Test
    fun whenLimitInputIs28000AllItemsAreEnabled() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(MainActivityScreenRobot::class.java)
                .inputLimitAmount("28000")
                .checkIsEnabled(R.id.cbBackPack)
                .checkIsEnabled(R.id.cbPants)
                .checkIsEnabled(R.id.cbShirt)
                .checkIsEnabled(R.id.cbBall)
                .checkIsEnabled(R.id.cbPiano)
                .checkIsEnabled(R.id.cbCar)
    }

    @Test
    fun  whenLimitInputIs10AndBallIsSelectedTotalIs10() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(MainActivityScreenRobot::class.java)
                .inputLimitAmount("10")
                .selectItem(R.id.cbBall)
                .checkTotal("10")
    }

    @Test
    fun  whenLimitInputIs18AndPantsAreSelectedOtherItemsAreDisabledAndTotalIs18() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(MainActivityScreenRobot::class.java)
                .inputLimitAmount("18")
                .selectItem(R.id.cbPants)
                .checkIsDisabled(R.id.cbBackPack)
                .checkIsDisabled(R.id.cbShirt)
                .checkIsDisabled(R.id.cbBall)
                .checkIsDisabled(R.id.cbPiano)
                .checkIsDisabled(R.id.cbCar)
                .checkTotal( "18")
    }


    @Test
    fun  whenLimitInputIs25AndBallAndShirtAreSelectedOtherItemsAreDisabledAndTotalIs22() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(MainActivityScreenRobot::class.java)
                .inputLimitAmount("25")
                .selectItem(R.id.cbBall)
                .selectItem(R.id.cbShirt)
                .checkIsDisabled(R.id.cbBackPack)
                .checkIsDisabled(R.id.cbPants)
                .checkIsDisabled(R.id.cbPiano)
                .checkIsDisabled(R.id.cbCar)
                .checkTotal( "22")
    }

    class MainActivityScreenRobot : ScreenRobot<MainActivityScreenRobot>() {


        fun inputLimitAmount(input: String): MainActivityScreenRobot {
            return enterTextIntoView(R.id.etLimit, input)
                    .clickDoneOnKeyboard(R.id.etLimit)
        }

        fun checkTotal(output: String) : MainActivityScreenRobot {
            return checkViewHasText(R.id.tvTotal, output)
        }

    }
}