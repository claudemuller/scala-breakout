package rs.dxt.breakout

trait Collision {
  def x: Int

  def y: Int

  def w: Int

  def h: Int

  def collidesWith(ball: Ball): Boolean = {
    y + h > ball.y - ball.size && y < ball.y + ball.size &&
      x + w > ball.x - ball.size && x < ball.x + ball.size
  }
}
