package pingpong

import akka.actor.ActorRef


case class StartGameMessage(opponent: ActorRef)
case class ContinueGameMessage(count: Int)
object EndGameMessage