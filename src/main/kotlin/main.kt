import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.request.get
import io.ktor.http.cio.Response
import jdk.nashorn.internal.codegen.CompilerConstants
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

fun main(args: Array<String>)
{
    println("ahllo")
    val t = test()
}

//suspend fun test1()
//{
//    return suspendCoroutine { cont ->
//        val client = HttpClient(Apache)
//        val htmlContent = client.get<String>("wss://stream.binance.com:9443/ws/@aggTrade")
//
//        println(htmlContent)
//    }
//}