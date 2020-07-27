package com.example.testapplication.viewmodelcourse.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.example.testapplication.R

import com.example.testapplication.databinding.FragmentGameNewBinding
import timber.log.Timber

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameNewBinding


    private lateinit var viewModel: GameViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_game_new,
            container,
            false
        )

        Log.i("GameFragment", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        // Set the viewmodel for databinding - this allows the bound layout access
        // to all the data in the ViewModel
        binding.gameViewModel = viewModel
        // Specify the fragment view as the lifecycle owner of the binding.
        // This is used so that the binding can observe LiveData updates
        binding.lifecycleOwner = viewLifecycleOwner

        /** Setting up LiveData observation relationship **/
        /*viewModel.score.observe(viewLifecycleOwner, Observer { newScore ->
            binding.scoreText.text = newScore.toString()
        })*/

        /** Setting up LiveData observation relationship **/
       /* viewModel.word.observe(viewLifecycleOwner, Observer { newWord ->
            binding.wordText.text = newWord
        })*/

        // Observer for the Game finished event
        viewModel.eventGameFinish.observe(viewLifecycleOwner, Observer { hasFinished ->
            if (hasFinished) gameFinished()
        })

       /* binding.correctButton.setOnClickListener { onCorrect() }
        binding.skipButton.setOnClickListener { onSkip() }
        binding.endGameButton.setOnClickListener { onEndGame()  }*/
        //updateScoreText()
        //updateWordText()
        return binding.root

    }

    private fun onEndGame(){
        gameFinished()
    }

    /**
     * Called when the game is finished
     */
    private fun gameFinished() {
        Toast.makeText(activity, "Game has just finished", Toast.LENGTH_SHORT).show()
        val action = GameFragmentDirections.actionGameToScore()
        action.score = viewModel.score.value?:0
        NavHostFragment.findNavController(this).navigate(action)
        viewModel.onGameFinishComplete()
    }

    /** Methods for button click handlers **/

    /*private fun onSkip() {
        viewModel.onSkip()
        //updateWordText()
        //updateScoreText()
    }
    private fun onCorrect() {
        viewModel.onCorrect()
        //updateScoreText()
        //updateWordText()
    }*/


    /** Methods for updating the UI **/

   /* private fun updateWordText() {
        binding.wordText.text = viewModel.word.value
    }

    private fun updateScoreText() {
        binding.scoreText.text = viewModel.score.value.toString()
    }*/
}