// MainActivity.kt
package com.example.lab1

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var editTextStudentID: EditText
    private lateinit var editTextName: EditText
    private lateinit var editTextAge: EditText
    private lateinit var editTextAddress: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextStudentID = findViewById(R.id.editTextStudentID)
        editTextName = findViewById(R.id.editTextName)
        editTextAge = findViewById(R.id.editTextAge)
        editTextAddress = findViewById(R.id.editTextAddress)
        editTextEmail = findViewById(R.id.editTextEmail)

        // Initialize Firebase Database
        databaseReference = FirebaseDatabase.getInstance().reference
    }

    fun registerStudent(view: View) {
        val studentID = editTextStudentID.text.toString()
        val studentName = editTextName.text.toString()
        val studentAge = editTextAge.text.toString().toIntOrNull() ?: 0 // Default value if conversion fails
        val studentAddress = editTextAddress.text.toString()
        val studentEmail = editTextEmail.text.toString()

        // Create Student object
        val student = Student(studentName, studentAge, studentAddress, studentEmail)

        // Store Student data in Firebase Database
        databaseReference.child("Students").child(studentID).setValue(student)
    }
}
