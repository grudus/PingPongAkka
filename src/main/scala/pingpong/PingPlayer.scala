package pingpong

import akka.actor.{Actor, ActorRef}

class PingPlayer(val opponent: ActorRef, maxGames: Int) extends Player(maxGames) {
  var counter = 0

  override def receive(): PartialFunction[Any, Unit] = {
    case StartGameMessage | ContinueGameMessage =>
      counter += 1

      if (counter > maxGames) {
        opponent ! EndGameMessage
        self ! EndGameMessage
      }
      else {
        println("ping")
        opponent ! ContinueGameMessage
      }
    case EndGameMessage => context.stop(self)
    case _ => println("Nie mozna odczytac wiadomosci")
  }

}
