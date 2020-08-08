package rs.dxt.breakout

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

class Paddle extends Collision {
  var x = 0
  var y = 20
  var w = 100
  var h = 10

  this.x = Gdx.input.getX() - w / 2

  def update(): Unit = {
    x = Gdx.input.getX() - w / 2

    if (Debug.debug) y = -Gdx.input.getY() + Gdx.graphics.getHeight

    if (x < 0) x = 0 else if (x > Gdx.graphics.getWidth - w) x = Gdx.graphics.getWidth - w
  }

  def draw(shape: ShapeRenderer): Unit = shape.rect(x, y, w, h)

  def checkCollision(ball: Ball): Unit = {
    if (collidesWith(ball)) {
      ball.ySpeed = -ball.ySpeed
    }

    if (Debug.debug) {
      if (collidesWith(ball)) ball.colour = Color.GREEN
      else ball.colour = Color.WHITE
    }
  }
}
