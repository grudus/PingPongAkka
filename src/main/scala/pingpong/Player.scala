package pingpong

import akka.actor.{Actor, ActorRef}

class Player(val maxGames: Int, val text: String) extends Actor {

  override def receive(): PartialFunction[Any, Unit] = {
    case StartGameMessage(opponent) => play(0, opponent)

    case ContinueGameMessage(count) =>
      if (count < maxGames)
        play(count, sender)
      else {
        sender ! EndGameMessage
        self ! EndGameMessage
      }

    case EndGameMessage => context.stop(self)
    case _ => println("Nie mozna odczytac wiadomosci")
  }

  def play(count: Int, opponent: ActorRef): Unit = {
    Thread.sleep(300)
    println(text)
    opponent ! ContinueGameMessage(count + 1)
  }
}
