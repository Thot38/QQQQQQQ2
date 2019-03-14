package DALC

import java.sql.*
import java.time.LocalDateTime
import java.util.*

public class DataAccessLayer
{
    internal var conn: Connection? = null
    internal var username = "kt-user" // provide the username
    internal var password = "P4ssw0rd!337"

    public fun connect () {
        val connectionProps = Properties()
        connectionProps.put("user", username)
        connectionProps.put("password", password)
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            conn = DriverManager.getConnection(
                    "jdbc:" + "mysql" + "://" +
                            "127.0.0.1" +
                            ":" + "3306" + "/" +
                            "",
                    connectionProps)
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
        }
    }

    public fun insertRow(schema : String, table : String, id : Int, name : String, firstname : String, email : String, lastAmountOfBTC : Int)
    {
        val now = LocalDateTime.now()
        val sqlNow = java.sql.Date.valueOf(now.toLocalDate())
        val sql = "INSERT INTO customer.customertable (name, forename, email, lastTransaction, amountOfBtc) VALUES ('$name', '$firstname', '$email', '$sqlNow', '$lastAmountOfBTC')"
        if(conn != null){
            with(conn!!) {
                createStatement().execute(sql)
            }
        }
    }

//    public fun selectAllAndPrint(schema : String, table : String, id : Int, name : String, firstname : String, email : String, lastAmountOfBTC : Int)
//    {
//        val sql = "SELECT * FROM customer.customertable"
//
//        if(conn != null) {
//            with(conn!!)
//            {
//                val reader = createStatement().execute(sql);
//                while (reader.)
//
//            }
//        }
//    }
    public fun executeMySQLQuery() {
            var stmt: Statement? = null
            var resultset: ResultSet? = null
            try {
                stmt = conn!!.createStatement()
                resultset = stmt!!.executeQuery("SHOW DATABASES;")
                if (stmt.execute("SHOW DATABASES;")) {
                    resultset = stmt.resultSet
                }
                while (resultset!!.next()) {
                    println(resultset.getString("Database"))
                }
            } catch (ex: SQLException) {
                // handle any errors
                ex.printStackTrace()
            } finally {
                // release resources
                if (resultset != null) {
                    try {
                        resultset.close()
                    } catch (sqlEx: SQLException) {
                    }
                    resultset = null
                }
                if (stmt != null) {
                    try {
                        stmt.close()
                    } catch (sqlEx: SQLException) {
                    }
                    stmt = null
                }
                if (conn != null) {
                    try {
                        conn!!.close()
                    } catch (sqlEx: SQLException) {
                    }
                    conn = null
                }
            }
        }
    }