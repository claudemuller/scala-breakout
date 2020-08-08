package rs.dxt.breakout

import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.{Game, Gdx}

class Engine extends Game {
  val rad = 20
  var shape: ShapeRenderer = _
  var ball: Ball = _
  var paddle: Paddle = _
  var blocks: Seq[Block] = Seq[Block]()

  override def create(): Unit = {
    shape = new ShapeRenderer
    ball = new Ball(Gdx.graphics.getWidth / 2, Gdx.graphics.getHeight / 2, rad, 3, 3)
    paddle = new Paddle

    val blockWidth = 63
    val blockHeight = 20
    for (y <- Gdx.graphics.getWidth / 2 to Gdx.graphics.getHeight by blockHeight + 10) {
      for (x <- 0 to Gdx.graphics.getWidth by blockWidth + 10)
        blocks = blocks :+ Block(x, y, blockWidth, blockHeight)
    }
  }

  def update(): Unit = {
    paddle.update()
    ball.update()
    paddle.checkCollision(ball)
    for (b <- blocks) b.checkCollision(ball)
  }

  override def render(): Unit = {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    shape.begin(ShapeRenderer.ShapeType.Filled)

    update()

    for (b <- blocks) b.draw(shape)
    paddle.draw(shape)
    ball.draw(shape)

    shape.end()
  }
}
