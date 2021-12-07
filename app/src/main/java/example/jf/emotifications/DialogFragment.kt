package example.jf.emotifications

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DialogFragment : Fragment() {
    lateinit var floatingActionButton: FloatingActionButton
    private lateinit var editTextView: EditText
    lateinit var binding: DialogFragment
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dialog, container, false)
        editTextView = view.findViewById(R.id.edit_text_view)
//        val otherView = inflater.inflate(R.layout.fragment_feed,container,false)
//        floatingActionButton = otherView.findViewById(R.id.add_fab)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        editTextView.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                dataModel.message.value = editTextView.text.toString()
            }
        })
    }

}