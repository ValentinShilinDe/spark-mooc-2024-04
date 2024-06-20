package homework

import scala.util.Random


class BallsExperiment {
  var urn = List(0, 0, 0, 1, 1, 1)
  val r = new Random()

  def isFirstBlackSecondWhite: Boolean = {
    val attemptOne = this.getBallFromUrn
    val attemptTwo = this.getBallFromUrn
    if (attemptOne == 0 && attemptTwo == 1) true else false
  }

  def getBallFromUrn: Int = {
    val ballIndex = r.nextInt(urn.length)
    val res = urn(ballIndex)
    urn = urn.patch(ballIndex, Nil, 1)
    res
  }
}

object BallsTest {
  def main(args: Array[String]): Unit = {
    val count = 10000
    val listOfExperiments: List[BallsExperiment] = List.fill(count)(new BallsExperiment)
    val countOfPositiveExperiments: Float = listOfExperiments.map(_.isFirstBlackSecondWhite).count(_ == true)
    println(countOfPositiveExperiments / count)
  }
}