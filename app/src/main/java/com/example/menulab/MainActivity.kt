package com.example.menulab

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mainLayout: LinearLayout
    private lateinit var figuresContainer: LinearLayout
    private lateinit var btnAddFigure: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainLayout = findViewById(R.id.mainLayout)
        figuresContainer = findViewById(R.id.figuresContainer)
        btnAddFigure = findViewById(R.id.btnAddFigure)

        // Регистрируем контекстное меню на кнопке
        registerForContextMenu(btnAddFigure)
    }

    //OPTIONS MENU
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_red -> {
                mainLayout.setBackgroundColor(Color.RED)
                Toast.makeText(this, "Фон изменён на красный", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_green -> {
                mainLayout.setBackgroundColor(Color.GREEN)
                Toast.makeText(this, "Фон изменён на зелёный", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_blue -> {
                mainLayout.setBackgroundColor(Color.BLUE)
                Toast.makeText(this, "Фон изменён на синий", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_reset -> {
                mainLayout.setBackgroundColor(Color.WHITE)
                Toast.makeText(this, "Фон сброшен", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //СONTEXT MENU
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu.setHeaderTitle("Добавить фигуру")

        menu.add(0, 1, 0, "Квадрат")
        menu.add(0, 2, 1, "Круг")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            1 -> { // Квадрат
                addSquare()
                return true
            }
            2 -> { // Круг
                addCircle()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

    //ДОБАВЛЕНИЕ ФИГУР
    private fun addSquare() {
        val square = Button(this).apply {
            layoutParams = LinearLayout.LayoutParams(180, 180)
            setBackgroundColor(Color.DKGRAY)
            text = ""
            textSize = 40f
        }
        figuresContainer.addView(square)
        Toast.makeText(this, "Добавлен квадрат", Toast.LENGTH_SHORT).show()
    }

    private fun addCircle() {
        val circle = Button(this).apply {
            layoutParams = LinearLayout.LayoutParams(180, 180)
            setBackgroundResource(android.R.drawable.btn_star_big_on) // круглая кнопка
            text = ""
            textSize = 40f
        }
        figuresContainer.addView(circle)
        Toast.makeText(this, "Добавлен круг", Toast.LENGTH_SHORT).show()
    }
}