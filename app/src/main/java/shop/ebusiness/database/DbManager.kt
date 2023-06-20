import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import com.hka.bloodrecommendationapp.Database.DatabaseHelper

class DbManager(c: Context) {
    private lateinit var dbHelper: DatabaseHelper
    private var context: Context = c
    private lateinit var  database: SQLiteDatabase


    @Throws(SQLException::class)
    fun open(): DbManager? {
        dbHelper = DatabaseHelper(context)
        database = dbHelper.writableDatabase
        return this
    }
    fun close() {
        dbHelper.close()
    }

}