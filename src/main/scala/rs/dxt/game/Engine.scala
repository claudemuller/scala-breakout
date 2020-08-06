package rs.dxt.game

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.{Game, Gdx}

class EngineTest1 extends Game {
  lazy val sprite = new Texture("assets/libgdxlogo.png")
  lazy val batch = new SpriteBatch

  override def create(): Unit = {}

  override def render(): Unit = {
    batch.begin()
    batch.draw(sprite, (Gdx.graphics.getWidth - sprite.getWidth) / 2f, (Gdx.graphics.getHeight - sprite.getHeight) / 2f)
    batch.end()
  }
}
