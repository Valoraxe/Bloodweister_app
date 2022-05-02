package com.example.bloodweiser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.ms.square.android.expandabletextview.ExpandableTextView

class ThirdFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)
        val button: Button = view.findViewById(R.id.homeButton3)

        button.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_thirdFragment_to_firstFragment)
        }

        val exText1: ExpandableTextView = view.findViewById(R.id.expand_text_view1)
        exText1.text = "Claws (Bloodspawn)\nWhen you make an Armour roll against an opposition player that was Knocked Down as the result " +
                "of a Block action performed by this player, a roll of 8+ before applying any modifiers will break their armour, regardless of their actual Armour Value"

        val exText2: ExpandableTextView = view.findViewById(R.id.expand_text_view2)
        exText2.text = "Frenzy (Bloodseeker/spawn, Linemen)\nEvery time this player performs a Block action (on its own or as part of a Blitz) they must follow-up if the target is pushed back and if they are able. " +
                "If the target is still Standing after being pushed back, and if this player was able to follow-up, this player must then perform a second Block action " +
                "against the same target, again following-up if the target is pushed back.\n\n" +
                "If this player is performing a Blitz action, performing a second Block action will also cost them one square of their Movement Allowance. " +
                "If this player has no Movement Allowance left to perform a second Block action, they must Rush to do so. If they cannot Rush, they cannot perform a second Block action.\n\n" +
                "Note that if an opposition player in possession of the ball is pushed back into your End Zone and is still Standing, a touchdown will be scored, ending the drive. " +
                "In this case, the second Block action is not performed. A player with this Skill cannot also have the Grab skill."

        val exText3: ExpandableTextView = view.findViewById(R.id.expand_text_view3)
        exText3.text = "Horns (Khorngor)\nWhen this player performs a Block action as part of a Blitz action (but not on its own), " +
                "you may apply +1 Strength to that player. This modifier is applied before counting assists, before applying other Strength modifiers, " +
                "and before using any other Skills or Traits"

        val exText4: ExpandableTextView = view.findViewById(R.id.expand_text_view4)
        exText4.text = "Juggernaut (Bloodspawn, Khorngor)\nWhen this player performs a Block action as part of a Blitz action (but not on its own), " +
                "they may choose to treat a Both Down result as a Push Back result. In addition, when this player performs a Block action " +
                "as part of a Blitz action, the target of the Block action may not use the Fend, Stand Firm, or Wrestle skills."

        val exText5: ExpandableTextView = view.findViewById(R.id.expand_text_view5)
        exText5.text = "Loner (4+) (Bloodspawn)\nIf this player wishes to use a team re-roll, roll a D6. If you roll equal to or higher than the target number shown in brackets, " +
                "this player may use the team re-roll as normal. Otherwise, the original result stands without being re-rolled but the team re-roll is lost just as if it had been used.\n\n" +
                "This Trait must still be used if the player is Prone or has lost their Tackcle Zone"

        val exText6: ExpandableTextView = view.findViewById(R.id.expand_text_view6)
        exText6.text = "Mighty Blow (+1) (Bloodspawn)\nWhen an opposition player is Knocked Down as the result of a Block action performed by this player " +
                "(on its own or as part of a Blitz action), you may modify either the Armour roll or Injury roll by the amount shown in brackets. " +
                "This modifier may be applied after the roll has been made. This Skill cannot be used with the Stab or Chainsaw traits."

        val exText7: ExpandableTextView = view.findViewById(R.id.expand_text_view7)
        exText7.text = "Unchanneled Fury (Bloodspawn)\nWhen this player is activated, even if they are Prone or have lost their Tackle Zone, " +
                "immediately after declaring the action they will perform but before performing the action, roll a D6 applying a +2 modifier " +
                "to the roll if you declared a Block or Blitz action (or a Special action granted by a Skill or Trait that can be performed instead of a Block action).\n" +
                "* On a roll of 1-3, this player rages incoherently at others but achieves little else. Their activation ends immediately.\n" +
                "* On a roll of 4+, this player continues their activation as normal and completes their declared action.\n\n" +
                "If you declared that this player would perform an action which can only be performed once per team turn and this player's activation ended " +
                "before the action could be completed, the action is considered to have been performed and no other player on your team may perform the same action this team turn."

        return view
    }
}
