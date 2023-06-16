package com.hka.bloodrecommendationapp.Database

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.hka.bloodrecommendationapp.Model.ProductList

class DatabaseHelper(context: Context):SQLiteOpenHelper(context, db_name,null, db_version) {

    companion object{


        private val db_name="Bloodrecommendation"
        private val db_version=1

        //Table Values for Product Table
        private val table_name1="Lebensmittel"
        private val ID="Lebensmittel_Id"
        private val name="Lebensmittelname"
        private val war="Warnung"
        private val pos1="Positive Wirkung1"
        private val cat="Lebensmittelkategorie"
        private val her="Hersteller"
        private val vege="Vegetarisch"
        private val veg="Vegan"
        private val prot="Proteinreich"
        private val fet="Fettarm"
        private val kal="Kaloriearm"
        private val pr="Preis"

        //Table Values for Producteffekt Table
        private val table_name2="Produkteffekt"
        private val lebensmittelID="ID"
        private val Blutwert_ID="Blutwert_ID"
        private val erh="Erhöhung"
        private val senk="Senkung"

        //Table Values for Referenz Table
        private val table_name3="Blutwert-Referenztabelle"
        private val b_id="Blutwert-ID"
        private val blutwert_Name="Name des Blutwertes"
        private val mas="Maßeinheit"
        private val ref_m="Referenzwerte Männer"
        private val ref_w="Referenzwerte Frauen"


    }


    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE="CREATE TABLE IF NOT EXISTS $table_name1 ($ID INTEGER PRIMARY KEY, $name TEXT,$war TEXT,$pos1 ,$cat TEXT,$her TEXT,$vege BOOLEAN,$veg BOOLEAN,$prot BOOLEAN,$fet BOOLEAN,$kal BOOLEAN,$pr REAL)"
        val CREATE_TABLE2="CREATE TABLE IF NOT EXISTS $table_name2 ($lebensmittelID INTEGER,$Blutwert_ID INTEGER,$erh BOOLEAN,$senk BOOLEAN, FOREIGN KEY($lebensmittelID)REFERENCES $table_name1($ID),FOREIGN KEY($Blutwert_ID)REFERENCES $table_name3($b_id))"
        val CREATE_TABLE3="CREATE TABLE IF NOT EXISTS $table_name3 ($b_id INTEGER PRIMARY KEY, $blutwert_Name TEXT,$mas TEXT,$ref_m REAL,$ref_w REAL)"

        db?.execSQL(CREATE_TABLE)
        db?.execSQL(CREATE_TABLE2)
        db?.execSQL(CREATE_TABLE3)

        val INSERT_TABLE= "INSERT INTO $table_name1 VALUES(1,'Erdbeere','Enthält Fructose','Reich an Vitamin C','Früchte','Johns Biobauernhof',1,1,0,1,1,2.10)"
        val INSERT_TABLE2= "INSERT INTO $table_name1 VALUES(2,'Linsen','Enthält Oligosaccharide','Reich an Eisen','Hülsenfrüchte','REWE',1,1,1,1,1,1.99)"
        val INSERT_TABLE3= "INSERT INTO $table_name3 VALUES(1,'Eisengehalt','µg/dl',120,110)"
        val INSERT_TABLE4= "INSERT INTO $table_name2 VALUES(2,1,1,0)"

        db?.execSQL(INSERT_TABLE)
        db?.execSQL(INSERT_TABLE2)
        db?.execSQL(INSERT_TABLE3)
        db?.execSQL(INSERT_TABLE4)
    }
//Update Funktion
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val DROP_TABLE="DROP TABLE IF EXISTS $table_name1"
        val DROP_TABLE2="DROP TABLE IF EXISTS $table_name2"
        val DROP_TABLE3="DROP TABLE IF EXISTS $table_name3"
        db?.execSQL(DROP_TABLE)
        db?.execSQL(DROP_TABLE2)
        db?.execSQL(DROP_TABLE3)
        onCreate(db)
    }
    //HelperFunction
    private fun intToBool(value: Int): Boolean {
        return value == 1
    }


//Read all Products of type
    fun getAllFruits():List<ProductList>{
        val productList=ArrayList<ProductList>()
        val db:SQLiteDatabase=writableDatabase
        val selectQuery="SELECT * FROM $table_name1 WHERE $cat='Früchte' "
        val cursor:Cursor=db.rawQuery(selectQuery,null)
        if(cursor.moveToFirst()){
            do{
                val products=ProductList()
                products.ID=cursor.getColumnIndex(ID)
                products.name=cursor.getColumnIndex(name).toString()
                products.war=cursor.getColumnIndex(war).toString()
                products.pos1=cursor.getColumnIndex(pos1).toString()
                products.cat=cursor.getColumnIndex(cat).toString()
                products.her=cursor.getColumnIndex(her).toString()
                products.vege=intToBool(cursor.getColumnIndex(vege))
                products.veg=intToBool(cursor.getColumnIndex(veg))
                products.prot=intToBool(cursor.getColumnIndex(prot))
                products.fet=intToBool(cursor.getColumnIndex(fet))
                products.kal=intToBool(cursor.getColumnIndex(kal))
                products.pr=cursor.getColumnIndex(kal).toDouble()
                productList.add(products)

            }while (cursor.moveToNext())
        }
        cursor.close()
        return productList

    }
    fun getAllVegetables():List<ProductList>{ val productList=ArrayList<ProductList>()
        val db:SQLiteDatabase=writableDatabase
        val selectQuery="SELECT * FROM $table_name1 WHERE $cat='Gemüse' "
        val cursor:Cursor=db.rawQuery(selectQuery,null)
        if(cursor.moveToFirst()){
            do{
                val products=ProductList()
                products.ID=cursor.getColumnIndex(ID)
                products.name=cursor.getColumnIndex(name).toString()
                products.war=cursor.getColumnIndex(war).toString()
                products.pos1=cursor.getColumnIndex(pos1).toString()
                products.cat=cursor.getColumnIndex(cat).toString()
                products.her=cursor.getColumnIndex(her).toString()
                products.vege=intToBool(cursor.getColumnIndex(vege))
                products.veg=intToBool(cursor.getColumnIndex(veg))
                products.prot=intToBool(cursor.getColumnIndex(prot))
                products.fet=intToBool(cursor.getColumnIndex(fet))
                products.kal=intToBool(cursor.getColumnIndex(kal))
                products.pr=cursor.getColumnIndex(kal).toDouble()
                productList.add(products)

            }while (cursor.moveToNext())
        }
        cursor.close()
        return productList
    }

    fun getAllProducts():List<ProductList>{ val productList=ArrayList<ProductList>()
        val db:SQLiteDatabase=writableDatabase
        val selectQuery="SELECT * FROM $table_name1"
        val cursor:Cursor=db.rawQuery(selectQuery,null)
        if(cursor.moveToFirst()){
            do{
                val products=ProductList()
                products.ID=cursor.getColumnIndex(ID)
                products.name=cursor.getColumnIndex(name).toString()
                products.war=cursor.getColumnIndex(war).toString()
                products.pos1=cursor.getColumnIndex(pos1).toString()
                products.cat=cursor.getColumnIndex(cat).toString()
                products.her=cursor.getColumnIndex(her).toString()
                products.vege=intToBool(cursor.getColumnIndex(vege))
                products.veg=intToBool(cursor.getColumnIndex(veg))
                products.prot=intToBool(cursor.getColumnIndex(prot))
                products.fet=intToBool(cursor.getColumnIndex(fet))
                products.kal=intToBool(cursor.getColumnIndex(kal))
                products.pr=cursor.getColumnIndex(kal).toDouble()
                productList.add(products)

            }while (cursor.moveToNext())
        }
        cursor.close()
        return productList
    }

    fun getBySearchQuery(query:String):List<ProductList> {

        val productList=ArrayList<ProductList>()
        val db:SQLiteDatabase= writableDatabase
        val selectQuery="SELECT * FROM $table_name1 WHERE $name=$query"
        val cursor:Cursor=db.rawQuery(selectQuery,null)
        if(cursor.moveToFirst()){
            do{
                val products=ProductList()
                products.ID=cursor.getColumnIndex(ID)
                products.name=cursor.getColumnIndex(name).toString()
                products.war=cursor.getColumnIndex(war).toString()
                products.pos1=cursor.getColumnIndex(pos1).toString()
                products.cat=cursor.getColumnIndex(cat).toString()
                products.her=cursor.getColumnIndex(her).toString()
                products.vege=intToBool(cursor.getColumnIndex(vege))
                products.veg=intToBool(cursor.getColumnIndex(veg))
                products.prot=intToBool(cursor.getColumnIndex(prot))
                products.fet=intToBool(cursor.getColumnIndex(fet))
                products.kal=intToBool(cursor.getColumnIndex(kal))
                products.pr=cursor.getColumnIndex(kal).toDouble()
                productList.add(products)

            }while (cursor.moveToNext())
        }
        cursor.close()
        return productList
    }

    //TODO:IMPLEMENTATION
    /*
    fun getAllRecommendations():List<ProductList>{}
    fun getAllLastOrdered():List<ProductList>{}

    */

}