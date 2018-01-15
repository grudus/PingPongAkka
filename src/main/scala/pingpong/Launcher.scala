package pingpong

import akka.actor.{ActorRef, ActorSystem, Props}

object Launcher {
  def main(args: Array[String]){
    // ActorSystem is a heavy object: create only one per application
    val ourSystem = ActorSystem("Ping-Pong_game")
    val games = 2
    val player1: ActorRef = ourSystem.actorOf(Props(classOf[PongPlayer], games))
    val player2: ActorRef = ourSystem.actorOf(Props(classOf[PingPlayer], player1, games))

    player2 ! StartGameMessage
  }
}
