package rs.dxt.breakout

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.Color

class Ball(var x: Int, var y: Int, var size: Int, var xSpeed: Int, var ySpeed: Int) {
  var colour: Color = Color.WHITE

  def update(): Unit = {
    x += xSpeed
    y += ySpeed
    if (x < size / 2 || x > Gdx.graphics.getWidth - size / 2) xSpeed = -xSpeed
    if (y < size / 2 || y > Gdx.graphics.getHeight - size / 2) ySpeed = -ySpeed
  }

  def draw(shape: ShapeRenderer): Unit = {
    shape.setColor(colour)
    shape.circle(x, y, size)
  }
}
