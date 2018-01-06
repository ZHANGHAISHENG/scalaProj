package learn.clazz

abstract class UndoableAction(val des:String){
  def undo():Unit
  def redo():Unit
}
