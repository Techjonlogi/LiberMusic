package ClasesServicios

class Usuario {
    val id:String = ""
    val fkIdArtista:Int? = 0
    val nombreDeUsuario:String = ""
    val nombreDelPropietario:String = ""
    val fkidEstatus:Int = 0
    val fkidEstatusNavigation:estatusderegistros? = estatusderegistros()
    val datosdelocalizacion:DatosDeLocalizacion? = DatosDeLocalizacion()
    val contrasena:Contrasena? = Contrasena()


}