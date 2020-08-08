package rs.dxt.breakout

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

case class Block(x: Int, y: Int, w: Int, h: Int, c: Color) extends Collision {
  var destroyed: Boolean = false

  def draw(shape: ShapeRenderer): Unit = if (!destroyed) {
    shape.setColor(c)
    shape.rect(x, y, w, h)
  }

  def checkCollision(ball: Ball): Unit = {
    if (collidesWith(ball) && !destroyed) {
      destroyed = true
      ball.ySpeed = -ball.ySpeed
    }
  }
}
