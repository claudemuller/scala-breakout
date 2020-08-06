package rs.dxt.game

import com.badlogic.gdx.backends.lwjgl.{LwjglApplication, LwjglApplicationConfiguration}

object Main extends App {
  val config = new LwjglApplicationConfiguration
  config.title = "Game Template"
  config.width = 800
  config.height = 600
  config.forceExit = true
  new LwjglApplication(new EngineTest1, config)
}
