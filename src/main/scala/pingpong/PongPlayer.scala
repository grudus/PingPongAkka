package pingpong

class PongPlayer(maxGames: Int) extends Player(maxGames) {
  var counter = 0

  override def receive(): PartialFunction[Any, Unit] = {
    case StartGameMessage | ContinueGameMessage =>
      counter += 1
      if (counter > maxGames) {
        sender ! EndGameMessage
        self ! EndGameMessage
      }
      else {
        println("pong")
        sender ! ContinueGameMessage
      }

    case EndGameMessage => context.stop(self)
    case _ => println("Nie mozna odczytac wiadomosci")
  }

}
