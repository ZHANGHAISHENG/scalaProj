package learn.clazz

object DoNothingAction extends  UndoableAction ("Do nothing"){
  override def undo(): Unit = {}
  override def redo(): Unit = {}

  def main(args: Array[String]): Unit = {
    val actions = Map("open" -> DoNothingAction , "close" -> DoNothingAction)
  }
}
