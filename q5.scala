object LetterCount extends App {
  def countLetterOccurrences(words: List[String]): Int = {
    words.map(_.length).reduce(_ + _)
  }

  val words = List("apple", "banana", "cherry", "date")
  val totalLetters = countLetterOccurrences(words)
  //question 05
  println(".................Question 05....................\n")
  println(s"Total count of letter occurrences: $totalLetters") 
}