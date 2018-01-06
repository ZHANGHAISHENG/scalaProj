package learn.trait4

trait LoggerException extends Exception with  Logged{
  def log() {
      log(getMessage)
  }
}
