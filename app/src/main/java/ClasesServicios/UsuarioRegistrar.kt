package ClasesServicios

class UsuarioRegistrar(
        var nombreDeUsuario:String ="",
        var nombreDelPropietario:String = "",
        var FKIdEstatus:Int = 1,
        var contrasena:Contrasena = Contrasena(),
        var DatosDeLocalizacion: DatosDeLocalizacion = DatosDeLocalizacion()


)