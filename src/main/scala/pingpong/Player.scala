package pingpong

import akka.actor.Actor

abstract class Player(val maxGames: Int) extends Actor {}
