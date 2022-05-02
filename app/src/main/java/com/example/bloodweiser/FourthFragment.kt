package com.example.bloodweiser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import java.util.*

class FourthFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rosterData: Hashtable<Int, String> = Hashtable<Int, String>()
        val linemen = listOf(16, "Linemen", 50, 6, 3, "3+", "4+", "8+")
        val khorngor = listOf(4, "Khorngor", 70, 6, 3, "3+", "4+", "9+")
        val bloodseeker = listOf(4, "Bloodseeker", 110, 5, 4, "4+", "6+", "10+")
        val bloodspawn = listOf(1, "Bloodspawn", 160, 5, 5, "4+", "-", "9+")

        var totalCost: Int = 0
        var reRolls: Int = 0
        var clicks: Int = 0
        var linemenSize: Int = 0
        var khorngorSize: Int = 0
        var bloodseekerSize: Int = 0
        var bloodspawnSize: Int = 0

        val view = inflater.inflate(R.layout.fragment_fourth, container, false)
        val homeButton: Button = view.findViewById(R.id.homeButton4)
        val button1: Button = view.findViewById(R.id.linemenBtn)
        val button2: Button = view.findViewById(R.id.khorngorBtn)
        val button3: Button = view.findViewById(R.id.bloodseekerBtn)
        val button4: Button = view.findViewById(R.id.bloodspawnBtn)
        val button5: Button = view.findViewById(R.id.rerollBtn)

        homeButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fourthFragment_to_firstFragment)
        }

        button1.setOnClickListener {
            if (linemenSize + 1 <= linemen[0] as Int) {
                linemenSize++
                clicks++
                totalCost += linemen[2] as Int
                rosterData.put(clicks, "Bloodborn Marauder")
                createRow(view, linemen)
                increaseTotal(view, totalCost)
            } else {
                val toast = Toast.makeText(requireActivity(),
                    "Can only have 16 Linemen on a roster!", Toast.LENGTH_SHORT).show()
            }

        }

        button2.setOnClickListener {
            if (khorngorSize + 1 <= khorngor[0] as Int) {
                khorngorSize++
                clicks++
                totalCost += khorngor[2] as Int
                rosterData.put(clicks, "Khorngor")
                createRow(view, khorngor)
                increaseTotal(view, totalCost)
            } else {
                val toast = Toast.makeText(requireActivity(),
                    "Can only have 4 Khorngors on a roster!", Toast.LENGTH_SHORT).show()
            }
        }

        button3.setOnClickListener {
            if (bloodseekerSize + 1 <= bloodseeker[0] as Int) {
                bloodseekerSize++
                clicks++
                totalCost += bloodseeker[2] as Int
                rosterData.put(clicks, "Bloodseeker")
                createRow(view, bloodseeker)
                increaseTotal(view, totalCost)
            } else {
                val toast = Toast.makeText(requireActivity(),
                    "Can only have 4 Bloodseekers on a roster!", Toast.LENGTH_SHORT).show()
            }
        }

        button4.setOnClickListener {
            if (bloodspawnSize + 1 <= bloodspawn[0] as Int) {
                bloodspawnSize++
                clicks++
                totalCost += bloodspawn[2] as Int
                rosterData.put(clicks, "Bloodspawn")
                createRow(view, bloodspawn)
                increaseTotal(view, totalCost)
            } else {
                val toast = Toast.makeText(requireActivity(),
                    "Can only have 1 Bloodspawn on a roster!", Toast.LENGTH_SHORT).show()
            }
        }

        button5.setOnClickListener {
            if (reRolls < 8) {
                totalCost += 60
                reRolls += 1
                increaseTotal(view, totalCost)
                val rollString = "Re-rolls ($reRolls)"
                button5.text = rollString
            } else {
                val toast = Toast.makeText(requireActivity(),
                    "Can only have 8 re-rolls maximum", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    private fun createRow(view: View, player: List<Any>) {
        val table: TableLayout = view.findViewById(R.id.rosterTable)
        val tr: TableRow = TableRow(requireActivity())

        val tv1 = TextView(requireActivity())
        tv1.text = player[1].toString()
        tr.addView(tv1)

        val tv2 = TextView(requireActivity())
        tv2.text = player[3].toString()
        tr.addView(tv2)

        val tv3 = TextView(requireActivity())
        tv3.text = player[4].toString()
        tr.addView(tv3)

        val tv4 = TextView(requireActivity())
        tv4.text = player[5].toString()
        tr.addView(tv4)

        val tv5 = TextView(requireActivity())
        tv5.text = player[6].toString()
        tr.addView(tv5)

        val tv6 = TextView(requireActivity())
        tv6.text = player[7].toString()
        tr.addView(tv6)

        val tv7 = TextView(requireActivity())
        val myString: String = player[2].toString() + "k"
        tv7.text = myString
        tr.addView(tv7)

        table.addView(tr)
    }

    private fun increaseTotal(view: View, total: Int) {
        val totalView: TextView = view.findViewById(R.id.totalTxt)
        val myString: String = "$total'000"
        totalView.text = myString
    }
}