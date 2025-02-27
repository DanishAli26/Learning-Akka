import akka.actor.{Actor, ActorSystem, Props}

case class WhoToGreet(who: String)

class Greeter extends Actor {
  def receive: Receive = {
    case WhoToGreet(who) => println(s"Hello, $who")
  }
}


object HelloAkkaScala extends App {
  // Create the 'hello akka' actor system
  private val system = ActorSystem("Hello-Akka")

  // Send WhoToGreet Message to actor
  private val greeter = system.actorOf(Props[Greeter](), "greeter")

  // Send WhoToGreet Message to actor
  greeter ! WhoToGreet("Akka")

  // Shutdown actor system
  system.terminate()

}
