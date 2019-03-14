import io.ktor.*
import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.websocket.WebSockets
import io.ktor.client.features.websocket.ws
import io.ktor.client.request.get
import io.ktor.http.HttpMethod
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.readText
import kotlinx.coroutines.channels.filterNotNull
import kotlinx.coroutines.channels.map
import org.apache.http.client.methods.HttpGet
import kotlin.coroutines.suspendCoroutine

class test(){
  //  val client = HttpClient(CIO).config {install(WebSockets)}
//
  //  client.ws(HttpMethod.Get, "127.0.0.1", 8080, "/route/path/to/ws")
  //  {
  //      for (message in incoming.map { it as? Frame.Text }.filterNotNull()) {
  //          println(message.readText())
  //      }
  //  }
  suspend fun test1()
  {
          val client = HttpClient(CIO).config { install(WebSockets) }
      client.ws(method = HttpMethod.Get, host="wss://stream.binance.com/", port = 9443, path = "ws/@aggTrade"){
          for (message in incoming.map { it as? Frame.Text }.filterNotNull()) {
              println(message.readText())
          }
      }
          val htmlContent = client.get<String>("wss://stream.binance.com:9443/ws/@aggTrade")

          println(htmlContent)
  }
}