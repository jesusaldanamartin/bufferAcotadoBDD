# bufferAcotadoBDD

A diferencia de lo que he hecho en calculadoraBDD para este proyecto he optado por hacer
todos los tests en un único feature ya que todos estaban estrechamente relacionados entres sí.
He creado scenarios para comprobar cada opción que el buffer permitía capturando las excepciones al añadir u eliminar elementos al estar
el buffer lleno o vacío. También compruebo si al eliminar un elemento la capacidad se reduce en 1 y si una vez el buffer es rellenado
al máximo este tiene la misma capacidad que la capacidad máxima que se indica por parámetro.