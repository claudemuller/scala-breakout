package rs.dxt.breakout

import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.{Game, Gdx}

class Engine extends Game {
  val rad = 20
  var shape: ShapeRenderer = _
  var ball: Ball = _
  var paddle: Paddle = _

  override def create(): Unit = {
    shape = new ShapeRenderer
    ball = new Ball(Gdx.graphics.getWidth / 2, Gdx.graphics.getHeight / 2, rad, 0, 0)
    paddle = new Paddle
  }

  override def render(): Unit = {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    shape.begin(ShapeRenderer.ShapeType.Filled)

    paddle.update()
    paddle.draw(shape)
    ball.update()
    ball.checkCollision(paddle)
    ball.draw(shape)

    shape.end()
  }
}
