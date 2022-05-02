package com.example.bloodweiser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.ms.square.android.expandabletextview.ExpandableTextView
import java.util.*

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val kickOffData: Hashtable<Int, String> = Hashtable<Int, String>()
        kickOffData.put(2, "2 - Ref of Khorne\n" +
                "For the duration of the drive, players from both teams cannot be Sent-off for committing a Foul action.")
        kickOffData.put(3, "3 - Horrifying Howls\n" +
                "Both coaches roll a D6. The team that scored the lowest (or both in the case of a tie) randomly selects one of their players on the pitch. " +
                "During each player's next turn, that player is frozen by fear and may not move, perform actions, and does not have a Tackle Zone.")
        kickOffData.put(4, "4 - Frenzied Crowd\n" +
                "For the duration of the drive, whenever a player is pushed into the crowd apply a +1 modifier to the injury roll.")
        kickOffData.put(5, "5 - High Kick\nOne Open player on the receiving team may be moved any number of squares, " +
                "regardless of their MA, and placed in the same square the ball will land in.")
        kickOffData.put(6, "6 - Cheering Fans\nBoth coaches roll a D6 and add the number of cheerleaders on their Team Draft list." +
                "The coach with the highest total may immediately roll once on the Prayers to Nuffle table. " +
                "In the case of a tie neither player rolls on the table")
        kickOffData.put(7, "7 - Brilliant Coaching\nBoth coaches roll a D6 and add the number of assistant coaches on their Team Draft list. " +
                "The coach with the highest total gains one extra team re-roll for the drive ahead. If this team re-roll is not used before the end of the drive, it is lost. " +
                "In the case of a tie, neither player gains the extra team re-roll")
        kickOffData.put(8, "8 - Changing Weather\nMake a new roll on the Weather Table below, and apply that result. " +
                "If the result is 'All is Calm', the ball will scatter before landing.")
        kickOffData.put(9, "9 - Quick Snap\nD3+3 Open players on the receiving team may immediately move one square in any direction.")
        kickOffData.put(10, "10 - Khorne Cares Not\n" +
                "For the duration of the drive, if a player causes a Casualty as the result of a Secret Weapon, Foul action, or pushing an opposition player into the crowd, " +
                "that player will receive 2 Star Player points, exactly as if they had caused a Casualty by performing a Block action.")
        kickOffData.put(11, "11 - Blood-crazed Fan\n" +
                "Both coaches rolls a D6. The team that scored the lowest (or both teams in the case of a tie) randomly selects one of their players on the pitch. " +
                "That player has been attacked by the blood-crazed fan and is immediately KO'd.")
        kickOffData.put(12, "12 - Blood Rage\n" +
                "Starting with the active team, coaches randomly select one player on their team that is Marking an opposition player. " +
                "The chosen player must immediately make a Block action against an opposition player. This will not cause a turnover.")

        val weatherTable: Hashtable<Int, String> = Hashtable<Int, String>()
        weatherTable.put(1, "4-10 - All is Calm\nKhorne is content to simply watch the game without intervening, making it perfect Blood Bowl weather.")
        weatherTable.put(2, "2 - Khorne's Fury\n" +
                "Randomly select two players from each team. " +
                "Those players gain +1 Strength, and Frenzy until a different result is rolled on the Weather Table. " +
                "When a different result is rolled, these players immediately roll on the injury table.")
        weatherTable.put(3, "3 - Losing Patience\n" +
                "At the end of each drive, randomly select one player on the pitch. " +
                "Immediately make an Armour roll, and an injury roll if necessary, for that player.")
        weatherTable.put(11, "11 - Red Mist\n" +
                "Players making a Pass action may not perform a Long pass or a Long bomb.")
        weatherTable.put(12, "12 - Crimson Downpour\n" +
                "Players attempting to Rush will fall on the roll of a 1 or a 2. " +
                "Additionally, if a player suffers a Push Back result from a Block, roll a D6. " +
                "On the roll of a 1, the player is KO'd after the push is made.")

        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val home: Button = view.findViewById(R.id.homeButton2) as Button
        val button1: Button = view.findViewById(R.id.kickOffBtn) as Button
        val button2: Button = view.findViewById(R.id.weatherBtn) as Button

        button1.setOnClickListener {
            val dice1 = rollDice()
            val dice2 = rollDice()
            val diceResult: Int = dice1 + dice2
            val diceImage1: ImageView = view.findViewById(R.id.kickOffDice1)
            val diceImage2: ImageView = view.findViewById(R.id.kickOffDice2)
            diceImage1.setImageResource(getDice(dice1))
            diceImage1.contentDescription = dice1.toString()
            diceImage2.setImageResource(getDice(dice2))
            diceImage2.contentDescription = dice2.toString()

            val exText: ExpandableTextView = view.findViewById(R.id.expand_text_view1)
            val myString = kickOffData.get(diceResult)
            exText.text = myString
        }

        button2.setOnClickListener {
            val dice1 = rollDice()
            val dice2 = rollDice()
            var diceResult: Int = dice1 + dice2
            if (diceResult in 4..10) { diceResult = 1 }
            val diceImage1: ImageView = view.findViewById(R.id.weatherDice1)
            val diceImage2: ImageView = view.findViewById(R.id.weatherDice2)
            diceImage1.setImageResource(getDice(dice1))
            diceImage1.contentDescription = dice1.toString()
            diceImage2.setImageResource(getDice(dice2))
            diceImage2.contentDescription = dice2.toString()

            val exText: ExpandableTextView = view.findViewById(R.id.expand_text_view2)
            val myString = weatherTable.get(diceResult)
            exText.text = myString
        }

        home.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_firstFragment)
        }

        return view
    }

    private fun rollDice(): Int {
        val dice = Dice(6)
        return dice.roll()
    }

    private fun getDice(diceRoll: Int): Int {
        val drawDice = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return drawDice
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}