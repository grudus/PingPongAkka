package pingpong

import akka.actor.{ActorRef, ActorSystem, Props}

object Launcher {
  def main(args: Array[String]){
    // ActorSystem is a heavy object: create only one per application
    val ourSystem = ActorSystem("Ping-Pong_game")
    val games = 10
    val player1: ActorRef = ourSystem.actorOf(Props(classOf[Player], games, "ping"))
    val player2: ActorRef = ourSystem.actorOf(Props(classOf[Player], games, "pong"))

    player1 ! StartGameMessage(player2)
  }
}
