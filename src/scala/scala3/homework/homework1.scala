package homework

class BallsExperiment {

  def isFirstBlackSecondWhite: Boolean = {
    val firstBall = scala.util.Random.nextInt(2) // выбор первого шарика
    val secondBall = scala.util.Random.nextInt(2) // выбор второго шарика
    if (firstBall == 0 && secondBall == 1) true // проверка что первый шарик будет черыным, а второй белым
    else false
  }
}

object BallsTest {
  def main(args: Array[String]): Unit = {
    val count = 10000
    val listOfExperiments: List[BallsExperiment] = List.fill(count)(new BallsExperiment) // создание списка экспериментов
    val countOfExperiments = listOfExperiments.map(_.isFirstBlackSecondWhite) // маппинг списка экспериментов
    val countOfPositiveExperiments: Float = countOfExperiments.count(_ == true) // подсчет положительных экспериментов
    println(countOfPositiveExperiments / count)
  }
}